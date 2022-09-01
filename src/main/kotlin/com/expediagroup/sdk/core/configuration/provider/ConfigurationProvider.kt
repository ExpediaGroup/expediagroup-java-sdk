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
package com.expediagroup.sdk.core.configuration.provider

/**
 * A configuration provider that can be used to provide configuration values.
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 */
internal interface ConfigurationProvider {

    /* AuthenticationConfiguration */
    val key: String?
    val secret: String?

    /* NetworkConfiguration */
    val endpoint: String?
    val authEndpoint: String?

    companion object {
        /** A list of the default configuration providers. */
        val DEFAULT_PROVIDERS: List<ConfigurationProvider> = listOf(
            SystemConfigurationProvider,
            FallbackConfigurationProvider
        )
    }
}
