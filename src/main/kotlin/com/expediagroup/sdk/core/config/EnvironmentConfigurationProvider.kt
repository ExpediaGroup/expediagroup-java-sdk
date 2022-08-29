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
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import com.expediagroup.sdk.core.plugin.authentication.IdentityUrl

// TODO: Split into 2 providers!
object EnvironmentConfigurationProvider {

    /**
     * Reads and gets the configuration from the provided [RuntimeConfiguration] if provided; or from the system files otherwise.
     **
     * @param runtimeConfiguration - An optional configurations to read the configuration from.
     * @return The configuration read from the provided [RuntimeConfiguration] if provided; or from the system files otherwise.
     */
    fun getConfigurations(runtimeConfiguration: RuntimeConfiguration = RuntimeConfiguration.NONE): Configuration {
        return if (Configuration.canBeCreatedFrom(runtimeConfiguration)) {
            Configuration.from(runtimeConfiguration)
        } else {
            readSystemFileConfigurations()
        }
    }

    /**
     * Reads and gets the client environment configurations from the provided [RuntimeConfiguration] if provided; or from the system files otherwise.
     *
     * @param runtimeConfiguration - An optional configurations to read the configuration from.
     * @return The client environment configurations read from the provided [RuntimeConfiguration] if provided; or from the system files otherwise.
     */
    fun getEnvironmentConfigurations(runtimeConfiguration: RuntimeConfiguration = RuntimeConfiguration.NONE): EnvironmentConfiguration {
        return if (EnvironmentConfiguration.canBeCreatedFrom(runtimeConfiguration)) {
            EnvironmentConfiguration.from(runtimeConfiguration)
        } else {
            readSystemFileEnvironmentConfigs()
        }
    }

    private fun readSystemFileConfigurations(): Configuration {
        val configurationData = FileConfigurationProvider()[CREDENTIALS_FILE_PATH]
        val data = configurationData.data()
        val clientId = data[CLIENT_KEY] ?: EMPTY_STRING
        val clientSecret = data[CLIENT_SECRET] ?: EMPTY_STRING

        return Configuration(ClientConfiguration(ClientCredentials(clientId, clientSecret)))
    }

    private fun readSystemFileEnvironmentConfigs(): EnvironmentConfiguration {
        val clientEnvironmentConfigsData = FileConfigurationProvider()[CLIENT_CONFIGS_FILE_PATH]
        val data = clientEnvironmentConfigsData.data()
        val baseUrl = data[BASE_URL] ?: EMPTY_STRING
        val identityUrl = IdentityUrl.from(baseUrl)

        return EnvironmentConfiguration(baseUrl, identityUrl)
    }
}
