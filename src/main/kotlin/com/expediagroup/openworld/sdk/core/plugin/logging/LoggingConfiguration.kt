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
package com.expediagroup.openworld.sdk.core.plugin.logging

import com.expediagroup.openworld.sdk.core.plugin.KtorPluginConfiguration
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger

internal data class LoggingConfiguration(
    override val httpClientConfiguration: HttpClientConfig<out HttpClientEngineConfig>,
    val logger: Logger = Logger.CUSTOM,
    val level: LogLevel = LogLevel.ALL
) : KtorPluginConfiguration(httpClientConfiguration) {
    companion object {
        fun from(httpClientConfig: HttpClientConfig<out HttpClientEngineConfig>) =
            LoggingConfiguration(httpClientConfig)
    }
}

internal val Logger.Companion.CUSTOM: Logger
    get() = object : Logger {
        private val delegate = OpenWorldLoggerFactory.getLogger(HttpClient::class.java)
        override fun log(message: String) = delegate.info(message)
    }
