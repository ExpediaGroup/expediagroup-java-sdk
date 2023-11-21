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
package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.configuration.collector.ConfigurationCollector
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

/**
 * The integration point between the SDK Core and the product SDKs.
 *
 * @param httpClientEngine The HTTP client engine to use.
 * @param clientConfiguration The configuration for the client.
 */
abstract class ExpediaGroupClient(
    clientConfiguration: ExpediaGroupClientConfiguration,
    httpClientEngine: HttpClientEngine = DEFAULT_HTTP_CLIENT_ENGINE
) : Client() {
    private val _configurationProvider: ConfigurationProvider =
        ConfigurationCollector.create(
            clientConfiguration.toProvider(),
            ExpediaGroupConfigurationProvider
        )
    private val _httpClient: HttpClient = buildHttpClient(_configurationProvider, AuthenticationStrategy.AuthenticationType.BEARER, httpClientEngine)

    init {
        finalize()
    }

    override val configurationProvider: ConfigurationProvider
        get() = _configurationProvider

    override val httpClient: HttpClient
        get() = _httpClient

    /**
     * An [ExpediaGroupClient] builder.
     *
     * @property key The API key to use for requests.
     * @property secret The API secret to use for requests.
     * @property endpoint The API endpoint to use for requests.
     * @property authEndpoint The API auth endpoint to use for requests.
     * @property requestTimeout The request timeout to be used.
     * @property maskedLoggingHeaders The headers to be masked in logging.
     * @property maskedLoggingBodyFields The body fields to be masked in logging.
     */
    @Suppress("unused") // This is used by the generated SDK clients.
    abstract class Builder<SELF : Builder<SELF>> : Client.Builder<SELF>() {
        protected var authEndpoint: String? = null

        /** Sets the API auth endpoint to use for requests.
         *
         * @param authEndpoint The API auth endpoint to use for requests.
         * @return The [Builder] instance.
         */
        fun authEndpoint(authEndpoint: String): SELF {
            this.authEndpoint = authEndpoint
            return self()
        }
    }
}
