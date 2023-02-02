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
package com.expediagroup.openworld.sdk.core.configuration

import com.expediagroup.common.sdk.core.configuration.ClientConfiguration
import com.expediagroup.common.sdk.core.configuration.provider.RuntimeConfigurationProvider

/**
 * SDK Client Configurations Provider.
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property authEndpoint The API endpoint to use for authentication.
 */
data class OpenWorldClientConfiguration(
    override val key: String? = null,
    override val secret: String? = null,
    override val endpoint: String? = null,
    val authEndpoint: String? = null
) : ClientConfiguration {

    /** Build a [RuntimeConfigurationProvider] from an [OpenWorldClientConfiguration]. */
    override fun toProvider(): RuntimeConfigurationProvider = super.toProvider().copy(authEndpoint = authEndpoint)
}
