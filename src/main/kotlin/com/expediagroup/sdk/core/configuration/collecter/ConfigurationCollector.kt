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
package com.expediagroup.sdk.core.configuration.collecter

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider.Companion.DEFAULT_PROVIDERS

/**
 * Configuration collector that collects configuration from all available providers.
 */
internal class ConfigurationCollector private constructor(providers: ConfigurationProviderQueue) : ConfigurationProvider {

    companion object Factory {
        /**
         * Creates a new [ConfigurationCollector] with the given [providerQueue].
         *
         * @param providerQueue the [ConfigurationProviderQueue] to use.
         * @return a new [ConfigurationCollector] with the given [providerQueue].
         */
        fun collect(providerQueue: ConfigurationProviderQueue): ConfigurationCollector = ConfigurationCollector(providerQueue)

        /**
         * Creates a new [ConfigurationCollector] with the given [providers] and the default [DEFAULT_PROVIDERS].
         *
         * @param providers the [ConfigurationProvider]s to use.
         * @return a new [ConfigurationCollector] with the given [providers] merged with the default [DEFAULT_PROVIDERS].
         */
        fun collect(vararg providers: ConfigurationProvider): ConfigurationCollector {
            return collect(ConfigurationProviderQueue.from(providers.asList() + DEFAULT_PROVIDERS))
        }
    }

    override val key: String = providers.firstOf { it.key }
    override val secret: String = providers.firstOf { it.secret }
    override val endpoint: String = providers.firstOf { it.endpoint }
}
