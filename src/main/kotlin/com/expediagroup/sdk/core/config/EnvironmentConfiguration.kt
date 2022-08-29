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

import com.expediagroup.sdk.core.exceptions.ConfigurationException
import com.expediagroup.sdk.core.plugin.authentication.IdentityUrl

data class EnvironmentConfiguration(val baseUrl: String, val identityUrl: String) {
    companion object EnvironmentConfigurationsFactory {

        /**
         * Creates an instance of [EnvironmentConfiguration] based on baseUrl.
         *
         * @param baseUrl base url of the environment.
         * @return an instance of [EnvironmentConfiguration].
         */
        @JvmStatic
        fun from(baseUrl: String): EnvironmentConfiguration {
            return EnvironmentConfiguration(baseUrl, IdentityUrl.from(baseUrl))
        }

        /**
         * Build an [EnvironmentConfiguration] object from the provided [RuntimeConfiguration].
         *
         * @param runtimeConfiguration the runtime configurations to use to build the [EnvironmentConfiguration] object.
         * @return an instance of [EnvironmentConfiguration].
         * @throws ConfigurationException if the [RuntimeConfiguration.environment] is null.
         */
        @JvmStatic
        fun from(runtimeConfiguration: RuntimeConfiguration): EnvironmentConfiguration {
            return runtimeConfiguration.environment
                ?: throw ConfigurationException("No environment configurations found!")
        }

        /**
         * Check if [EnvironmentConfiguration] can be built from a [RuntimeConfiguration] object.
         *
         * @param runtimeConfiguration [RuntimeConfiguration] object to check.
         * @return true if [EnvironmentConfiguration] can be built from [RuntimeConfiguration] object.
         */
        fun canBeCreatedFrom(runtimeConfiguration: RuntimeConfiguration): Boolean = runtimeConfiguration.environment != null
    }
}
