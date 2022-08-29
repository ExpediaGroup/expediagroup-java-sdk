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

data class Configuration @JvmOverloads constructor(
    val clientConfiguration: ClientConfiguration,
    val network: NetworkConfiguration = NetworkConfiguration(),
    val logging: LoggingConfiguration = LoggingConfiguration()
) {
    companion object ConfigurationFactory {

        /**
         * Build a [Configuration] object from a [RuntimeConfiguration] object.
         *
         * @param runtimeConfiguration [RuntimeConfiguration] object to use for building the [Configuration] object.
         * @return [Configuration] object.
         * @throws ConfigurationException if the [RuntimeConfiguration.authentication] object is null.
         */
        @JvmStatic
        fun from(runtimeConfiguration: RuntimeConfiguration): Configuration = Configuration(
            ClientConfiguration(
                runtimeConfiguration.authentication
                    ?: throw ConfigurationException("No authentication configuration found!")
            )
        )

        /**
         * Check if [Configuration] can be built from a [RuntimeConfiguration] object.
         *
         * @param runtimeConfiguration [RuntimeConfiguration] object to check.
         * @return true if [Configuration] can be built from [RuntimeConfiguration] object.
         */
        fun canBeCreatedFrom(runtimeConfiguration: RuntimeConfiguration): Boolean = runtimeConfiguration.authentication != null
    }
}
