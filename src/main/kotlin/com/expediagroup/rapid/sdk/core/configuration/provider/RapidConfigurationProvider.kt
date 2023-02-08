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
package com.expediagroup.rapid.sdk.core.configuration.provider

import com.expediagroup.common.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.rapid.sdk.core.configuration.provider.RapidConfigurationProvider.endpoint
import com.expediagroup.rapid.sdk.core.configuration.provider.RapidConfigurationProvider.name

/**
 * Default configuration provider for Rapid.
 *
 * @property name The name of the provider.
 * @property endpoint The API endpoint to use for requests.
 */
internal object RapidConfigurationProvider : ConfigurationProvider {
    override val name: String = "Rapid Configuration Provider"
    override val endpoint: String = "https://api.ean.com/v3"
}
