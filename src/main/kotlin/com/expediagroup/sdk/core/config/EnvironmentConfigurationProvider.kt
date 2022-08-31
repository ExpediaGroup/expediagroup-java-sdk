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
package com.expediagroup.sdk.core.config

import com.expediagroup.sdk.core.config.provider.FileConfigurationProvider
import com.expediagroup.sdk.core.constants.ClientConstants.BASE_URL
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_CONFIGS_FILE_PATH
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_KEY
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_SECRET
import com.expediagroup.sdk.core.constants.ClientConstants.CREDENTIALS_FILE_PATH
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_BASE_URL
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import com.expediagroup.sdk.core.plugin.authentication.IdentityUrl

object EnvironmentConfigurationProvider {
    val configuration: Configuration = prepareConfiguration()
    val clientEnvironmentConfigs: EnvironmentConfigs = prepareClientEnvironmentConfigs()

    private fun prepareConfiguration(): Configuration {
        val configurationData = FileConfigurationProvider()[CREDENTIALS_FILE_PATH]
        val clientKey = configurationData.data()[CLIENT_KEY] ?: EMPTY_STRING
        val clientSecret = configurationData.data()[CLIENT_SECRET] ?: EMPTY_STRING

        return Configuration(ClientConfiguration(ClientCredentials(clientKey, clientSecret)))
    }

    private fun prepareClientEnvironmentConfigs(): EnvironmentConfigs {
        val clientEnvironmentConfigsData = FileConfigurationProvider()[CLIENT_CONFIGS_FILE_PATH, true].data()
        val baseUrl = clientEnvironmentConfigsData[BASE_URL] ?: DEFAULT_BASE_URL
        val identityUrl = IdentityUrl.from(baseUrl)

        return EnvironmentConfigs(baseUrl, identityUrl)
    }
}
