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
package com.expediagroup.common.sdk.core.configuration.provider

import com.expediagroup.common.sdk.core.constant.ConfigurationName.DEFAULT_CONFIGURATION_PROVIDER
import com.expediagroup.common.sdk.core.constant.Constant.EMPTY_STRING

/**
 * Default implementation of [ConfigurationProvider] to fall back to for any missing configuration.
 *
 * @property name The name of the provider.
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property authEndpoint The API endpoint to use for authentication.
 */
internal object DefaultConfigurationProvider : ConfigurationProvider {
    override val name: String = DEFAULT_CONFIGURATION_PROVIDER
    override val key: String = EMPTY_STRING
    override val secret: String = EMPTY_STRING
    override val endpoint: String = "https://api.expediagroup.com/"
    override val authEndpoint: String = "${endpoint}identity/oauth2/v2/token/"
}
