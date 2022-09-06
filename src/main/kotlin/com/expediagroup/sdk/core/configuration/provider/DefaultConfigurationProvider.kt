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

import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_AUTH_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING

/**
 * Default implementation of [ConfigurationProvider].
 */
internal object DefaultConfigurationProvider : ConfigurationProvider {
    override val key: String = EMPTY_STRING
    override val secret: String = EMPTY_STRING
    override val endpoint: String = DEFAULT_ENDPOINT
    override val authEndpoint: String = DEFAULT_AUTH_ENDPOINT
}
