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
package com.expediagroup.openworld.sdk.core.client

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.client.DEFAULT_HTTP_CLIENT_ENGINE
import com.expediagroup.common.sdk.core.client.finalize
import com.expediagroup.common.sdk.core.configuration.collector.ConfigurationCollector
import com.expediagroup.common.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.common.sdk.core.constant.provider.ExceptionMessageProvider.getMissingRequiredConfigurationMessage
import com.expediagroup.common.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientBuilder
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.configuration.provider.OpenWorldConfigurationProvider
import com.expediagroup.openworld.sdk.core.model.error.Error
import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldConfigurationException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldAuthException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldServiceException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.toURI

/**
 * The integration point between the SDK Core and the product SDKs.
 *
 * @param httpClientEngine The HTTP client engine to use.
 * @param clientConfiguration The configuration for the client.
 */
open class OpenWorldClient(
    clientConfiguration: OpenWorldClientConfiguration,
    httpClientEngine: HttpClientEngine = DEFAULT_HTTP_CLIENT_ENGINE
) : Client() {
    private val configurationProvider: ConfigurationProvider = ConfigurationCollector.create(
        clientConfiguration.toProvider(),
        OpenWorldConfigurationProvider
    )
    private val _httpClient: HttpClient = buildHttpClient(configurationProvider, AuthenticationStrategy.AuthenticationType.BEARER, httpClientEngine)

    init {
        finalize()
    }

    override val httpClient: HttpClient
        get() = _httpClient

    override fun fireMissingConfigurationIssue(configurationKey: String): Nothing = throw OpenWorldConfigurationException(getMissingRequiredConfigurationMessage(configurationKey))
    override fun fireAuthIssue(message: String): Nothing = throw OpenWorldAuthException(message)

    override suspend fun throwServiceException(response: HttpResponse) {
        runCatching {
            response.body<Error>()
        }.onSuccess {
            throw OpenWorldServiceException(response.status, it)
        }.onFailure {
            throw OpenWorldServiceException(
                response.status,
                Error(response.request.url.toURI(), response.status.description)
            )
        }
    }

    companion object {

        /** Creates a new ClientConfigurations.Builder instance. */
        @JvmStatic
        @Suppress("unused") // Used by the product SDKs.
        fun builder() = OpenWorldClientBuilder()
    }
}
