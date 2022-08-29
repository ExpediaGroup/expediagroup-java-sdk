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

import com.expediagroup.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.sdk.core.exceptions.ConfigurationException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ConfigurationTest {

    @Test
    fun `test Configuration with overloaded constructor`() {
        val credentials = ClientCredentials("key", "secret")

        Configuration(ClientConfiguration(credentials)).let {
            assertThat(it.clientConfiguration.auth).isSameAs(credentials)
            assertThat(it.logging.level).isEqualTo(LoggingConfiguration.LogLevel.WARNING)
        }
    }

    @Test
    fun `test Configuration with network and logging`() {
        val credentials = ClientCredentials("key", "secret")

        Configuration(
            ClientConfiguration(credentials),
            NetworkConfiguration(),
            LoggingConfiguration(LoggingConfiguration.LogLevel.DEBUG)
        ).let {
            assertThat(it.clientConfiguration.auth).isSameAs(credentials)
            assertThat(it.network).isEqualTo(NetworkConfiguration())
            assertThat(it.logging.level).isEqualTo(LoggingConfiguration.LogLevel.DEBUG)
        }
    }

    @Nested
    inner class PartnerConfigurationsFactoryTest {
        @Test
        fun `test ConfigurationFactory with overloaded constructor`() {
            val credentials = ClientCredentials("key", "secret")
            val environmentConfiguration = EnvironmentConfiguration.from(baseUrl = TEST_URL)
            val runtimeConfiguration = RuntimeConfiguration.from(
                authentication = credentials,
                environment = environmentConfiguration
            )

            EnvironmentConfigurationProvider.getConfigurations(runtimeConfiguration).clientConfiguration.auth.let {
                assertThat(it).isSameAs(credentials)
            }
        }

        @Test
        fun `test ConfigurationFactory with null authenticationConfiguration`() {
            assertThrows<ConfigurationException> {
                RuntimeConfiguration.from(
                    environment = EnvironmentConfiguration.from(baseUrl = TEST_URL)
                ).let { Configuration.from(it) }
            }
        }

        @Test
        fun `test canBeCreatedFrom function with NONE runtime configurations`() {
            Configuration.canBeCreatedFrom(
                RuntimeConfiguration.NONE
            ).let { assertThat(it).isFalse }
        }

        @Test
        fun `test canBeCreatedFrom function with authenticationConfiguration runtime configurations only`() {
            Configuration.canBeCreatedFrom(
                RuntimeConfiguration.from(
                    authentication = ClientCredentials("key", "secret")
                )
            ).let { assertThat(it).isTrue }
        }

        @Test
        fun `test canBeCreatedFrom function with environmentConfigurations runtime configurations only`() {
            Configuration.canBeCreatedFrom(
                RuntimeConfiguration.from(
                    environment = EnvironmentConfiguration.from(TEST_URL)
                )
            ).let { assertThat(it).isFalse }
        }
    }
}
