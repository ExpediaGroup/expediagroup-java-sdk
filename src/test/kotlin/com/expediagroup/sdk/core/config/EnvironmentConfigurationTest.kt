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
import com.expediagroup.sdk.core.plugin.authentication.IdentityUrl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EnvironmentConfigurationTest {

    @Nested
    inner class EnvironmentConfigurationFactoryTest {

        @Test
        fun `test creating EnvironmentConfigurations from baseUrl`() {
            EnvironmentConfiguration.from(TEST_URL).let {
                assertEquals(TEST_URL, it.baseUrl)
                assertEquals(IdentityUrl.from(it.baseUrl), it.identityUrl)
            }
        }

        @Test
        fun `test creating EnvironmentConfigurations from runtimeConfigurations`() {
            val runtimeConfiguration = RuntimeConfiguration.from(
                authentication = ClientCredentials("key", "secret"),
                environment = EnvironmentConfiguration.from(baseUrl = TEST_URL)
            )

            EnvironmentConfiguration.from(runtimeConfiguration).let {
                assertEquals(TEST_URL, it.baseUrl)
                assertEquals(IdentityUrl.from(TEST_URL), it.identityUrl)
            }
        }

        @Test
        fun `test creating EnvironmentConfigurations from runtimeConfigurations with null environmentConfigurations`() {
            assertThrows<ConfigurationException> {
                RuntimeConfiguration.from(
                    authentication = ClientCredentials("key", "secret")
                ).let { EnvironmentConfiguration.from(it) }
            }
        }

        @Test
        fun `test canBeCreatedFrom function with NONE runtime configurations`() {
            EnvironmentConfiguration.canBeCreatedFrom(
                RuntimeConfiguration.NONE
            ).let { assertThat(it).isFalse }
        }

        @Test
        fun `test canBeCreatedFrom function with authenticationConfiguration runtime configurations only`() {
            EnvironmentConfiguration.canBeCreatedFrom(
                RuntimeConfiguration.from(
                    authentication = ClientCredentials("key", "secret")
                )
            ).let { assertThat(it).isFalse }
        }

        @Test
        fun `test canBeCreatedFrom function with environmentConfigurations runtime configurations only`() {
            EnvironmentConfiguration.canBeCreatedFrom(
                RuntimeConfiguration.from(
                    environment = EnvironmentConfiguration.from(TEST_URL)
                )
            ).let { assertThat(it).isTrue }
        }
    }
}
