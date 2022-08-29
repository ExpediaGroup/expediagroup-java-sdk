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

/**
 * Provides runtime configurations to override any other configured values.
 *
 * @property authentication the authentication configuration to use.
 * @property environment the environment configuration to use.
 */
class RuntimeConfiguration private constructor(
    val authentication: AuthenticationConfiguration? = null,
    val environment: EnvironmentConfiguration? = null
) {
    companion object RuntimeConfigurationsFactory {
        /**
         * A runtime configuration that does not override any other configured values.
         */
        @JvmField
        val NONE = RuntimeConfiguration()

        /**
         * Creates a new instance of [RuntimeConfiguration] with the provided values.
         *
         * @param authentication the authentication configuration to use.
         * @param environment the environment configuration to use.
         * @return a new instance of [RuntimeConfiguration] with the provided values.
         */
        @JvmStatic
        @JvmOverloads
        fun from(
            authentication: AuthenticationConfiguration? = null,
            environment: EnvironmentConfiguration? = null
        ): RuntimeConfiguration = RuntimeConfiguration(
            authentication = authentication,
            environment = environment
        )
    }
}
