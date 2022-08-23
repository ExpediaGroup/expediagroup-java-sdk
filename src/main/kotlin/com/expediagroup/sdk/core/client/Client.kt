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

import com.expediagroup.sdk.core.config.Configuration
import com.expediagroup.sdk.core.config.EnvironmentConfigs
import com.expediagroup.sdk.core.config.EnvironmentConfigurationProvider
import com.expediagroup.sdk.core.plugin.Hooks
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationConfigs
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationHook
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationPlugin
import com.expediagroup.sdk.core.plugin.defaultRequests.DefaultRequestsConfigs
import com.expediagroup.sdk.core.plugin.defaultRequests.DefaultRequestsPlugin
import com.expediagroup.sdk.core.plugin.hooks
import com.expediagroup.sdk.core.plugin.logging.LoggingConfigs
import com.expediagroup.sdk.core.plugin.logging.LoggingPlugin
import com.expediagroup.sdk.core.plugin.plugins
import com.expediagroup.sdk.core.plugin.serialization.SerializationConfigs
import com.expediagroup.sdk.core.plugin.serialization.SerializationPlugin
import com.expediagroup.sdk.core.plugin.use
import com.expediagroup.sdk.core.plugin.with
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

class Client private constructor(
    httpClientEngine: HttpClientEngine
) {
    val httpClient: HttpClient
    private val environmentConfigs: EnvironmentConfigs = EnvironmentConfigurationProvider.clientEnvironmentConfigs
    private val configuration: Configuration = EnvironmentConfigurationProvider.configuration

    init {
        httpClient = HttpClient(httpClientEngine) {
            val authenticationConfigs =
                AuthenticationConfigs.from(this, configuration.clientConfiguration, environmentConfigs.identityUrl)

            plugins {
                use(LoggingPlugin).with(LoggingConfigs.from(this))
                use(SerializationPlugin).with(SerializationConfigs.from(this))
                use(AuthenticationPlugin).with(authenticationConfigs)
                use(DefaultRequestsPlugin).with(DefaultRequestsConfigs.from(this, environmentConfigs))
            }

            hooks {
                use(AuthenticationHook.with(authenticationConfigs))
            }
        }

        finalize()
    }

    companion object {
        /**
         * Create a Client.
         */
        fun from(
            httpClientEngine: HttpClientEngine
        ): Client = Client(httpClientEngine)
    }
}

/**
 * Finalize creating the client.
 */
private fun Client.finalize() = Hooks.execute(this)
