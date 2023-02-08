/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.common.sdk.core.client

import com.expediagroup.common.sdk.core.configuration.ClientConfiguration
import com.expediagroup.common.sdk.core.configuration.Credentials
import com.expediagroup.common.sdk.core.configuration.collector.ConfigurationCollector
import com.expediagroup.common.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.common.sdk.core.constant.ConfigurationName
import com.expediagroup.common.sdk.core.constant.Constant
import com.expediagroup.common.sdk.core.constant.provider.LoggingMessageProvider
import com.expediagroup.common.sdk.core.plugin.Hooks
import com.expediagroup.common.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.common.sdk.core.plugin.authentication.AuthenticationHookFactory
import com.expediagroup.common.sdk.core.plugin.authentication.AuthenticationPlugin
import com.expediagroup.common.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import com.expediagroup.common.sdk.core.plugin.encoding.EncodingConfiguration
import com.expediagroup.common.sdk.core.plugin.encoding.EncodingPlugin
import com.expediagroup.common.sdk.core.plugin.hooks
import com.expediagroup.common.sdk.core.plugin.logging.LoggingConfiguration
import com.expediagroup.common.sdk.core.plugin.logging.LoggingPlugin
import com.expediagroup.common.sdk.core.plugin.logging.OpenWorldLoggerFactory
import com.expediagroup.common.sdk.core.plugin.plugins
import com.expediagroup.common.sdk.core.plugin.request.DefaultRequestConfiguration
import com.expediagroup.common.sdk.core.plugin.request.DefaultRequestPlugin
import com.expediagroup.common.sdk.core.plugin.serialization.SerializationConfiguration
import com.expediagroup.common.sdk.core.plugin.serialization.SerializationPlugin
import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.rapid.sdk.core.client.RapidClient
import com.expediagroup.rapid.sdk.core.configuration.RapidClientConfiguration
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.statement.HttpResponse

val DEFAULT_HTTP_CLIENT_ENGINE: HttpClientEngine = OkHttp.create()

/**
 * The base integration point between the SDK Core and the product SDKs.
 *
 * @param httpClientEngine The HTTP client engine to use.
 * @param clientConfiguration The configuration for the client.
 */
abstract class Client(
    clientConfiguration: ClientConfiguration,
    private val httpClientEngine: HttpClientEngine = DEFAULT_HTTP_CLIENT_ENGINE
) {

    /**
     * The HTTP client to perform requests with.
     */
    abstract val httpClient: HttpClient

    internal val configurationCollector: ConfigurationCollector = ConfigurationCollector.create(
        clientConfiguration.toProvider(),
        DefaultConfigurationProvider
    )

    private val key: String = configurationCollector.key ?: fireMissingConfigurationIssue(ConfigurationName.KEY)
    private val secret: String = configurationCollector.secret ?: fireMissingConfigurationIssue(ConfigurationName.SECRET)
    private val endpoint: String = configurationCollector.endpoint ?: fireMissingConfigurationIssue(ConfigurationName.ENDPOINT)

    internal fun buildHttpClient(
        authEndpoint: String,
        authenticationType: AuthenticationStrategy.AuthenticationType
    ): HttpClient = HttpClient(httpClientEngine) {
        val httpClientConfig = this

        val authenticationConfiguration = AuthenticationConfiguration.from(
            httpClientConfig,
            Credentials.from(key, secret),
            authEndpoint,
            authenticationType
        )

        plugins {
            use(LoggingPlugin).with(LoggingConfiguration.from(httpClientConfig))
            use(SerializationPlugin).with(SerializationConfiguration.from(httpClientConfig))
            use(AuthenticationPlugin).with(authenticationConfiguration)
            use(DefaultRequestPlugin).with(DefaultRequestConfiguration.from(httpClientConfig, endpoint))
            use(EncodingPlugin).with(EncodingConfiguration.from(httpClientConfig))
        }

        hooks {
            use(AuthenticationHookFactory).with(authenticationConfiguration)
        }
    }

    private fun isNotSuccessfulResponse(response: HttpResponse) = response.status.value !in Constant.SUCCESSFUL_STATUS_CODES_RANGE

    @Suppress("unused") // This is used by the product SDKs.
    suspend fun throwIfError(response: HttpResponse) {
        if (isNotSuccessfulResponse(response)) {
            log.info(LoggingMessageProvider.getResponseUnsuccessfulMessage(response.status))
            throwServiceException(response)
        }
    }

    abstract suspend fun throwServiceException(response: HttpResponse)

    companion object {
        private val log = OpenWorldLoggerFactory.getLogger(this::class.java)

        /**
         * Creates a new instance of the client.
         *
         * @param httpClientEngine The HTTP client engine to use.
         * @param clientConfiguration The configuration for the client.
         * @return The new instance of the client.
         */
        inline fun <reified C : Client, CC : ClientConfiguration> create(
            clientConfiguration: CC,
            httpClientEngine: HttpClientEngine = DEFAULT_HTTP_CLIENT_ENGINE
        ): C = when (C::class) {
            OpenWorldClient::class -> OpenWorldClient(clientConfiguration as OpenWorldClientConfiguration, httpClientEngine) as C
            RapidClient::class -> RapidClient(clientConfiguration as RapidClientConfiguration, httpClientEngine) as C
            else -> throw IllegalArgumentException("Unsupported client type: ${C::class.simpleName}")
        }
    }
}

/** Executes the hooks for the client. */
fun <T : Client> T.finalize() = Hooks.execute(this)
