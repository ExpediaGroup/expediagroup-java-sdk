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
package com.expediagroup.sdk.core.configuration.collector

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.constant.Constant.AUTH_ENDPOINT
import com.expediagroup.sdk.core.constant.Constant.ENDPOINT
import com.expediagroup.sdk.core.constant.Constant.KEY
import com.expediagroup.sdk.core.constant.Constant.SECRET
import com.expediagroup.sdk.core.constant.provider.LoggingMessageProvider
import com.expediagroup.sdk.core.plugin.logging.OpenWorldLoggerFactory

/**
 * Configuration collector that collects configuration from all available providers.
 *
 * @param providers A configuration providers queue.
 */
internal class ConfigurationCollector private constructor(providers: ConfigurationProviderQueue) {
    private val log = OpenWorldLoggerFactory.getLogger(javaClass)

    companion object Factory {

        /**
         * Creates a new [ConfigurationCollector] with the given [providerQueue].
         *
         * @param providerQueue the [ConfigurationProviderQueue] to use.
         * @return a new [ConfigurationCollector] with the given [providerQueue].
         */
        fun create(providerQueue: ConfigurationProviderQueue): ConfigurationCollector = ConfigurationCollector(providerQueue)

        /**
         * Creates a new [ConfigurationCollector] with the given [providers].
         *
         * @param providers the [ConfigurationProvider]s to use.
         * @return a new [ConfigurationCollector] with the given [providers].
         */
        fun create(vararg providers: ConfigurationProvider): ConfigurationCollector = create(ConfigurationProviderQueue.from(providers.asList()))
    }

    val key: String by lazy { providers.firstOf { provider -> provider.key.also { logConfigurationRetrieval(provider, KEY) } } }
    val secret: String by lazy { providers.firstOf { provider -> provider.secret.also { logConfigurationRetrieval(provider, SECRET) } } }
    val endpoint: String by lazy { providers.firstOf { provider -> provider.endpoint.also { logConfigurationRetrieval(provider, ENDPOINT) } } }
    val authEndpoint: String by lazy { providers.firstOf { provider -> provider.authEndpoint.also { logConfigurationRetrieval(provider, AUTH_ENDPOINT) } } }

    private fun logConfigurationRetrieval(provider: ConfigurationProvider, configurationName: String) {
        log.info(LoggingMessageProvider.getChosenProviderMessage(configurationName, provider.name))
    }
}
