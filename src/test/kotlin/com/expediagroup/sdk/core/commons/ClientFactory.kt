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
package com.expediagroup.sdk.core.commons

import com.expediagroup.sdk.core.client.Client
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.sdk.core.config.ClientConfiguration
import com.expediagroup.sdk.core.config.ClientCredentials
import com.expediagroup.sdk.core.config.Configuration
import com.expediagroup.sdk.core.config.EnvironmentConfiguration
import com.expediagroup.sdk.core.config.EnvironmentConfigurationProvider
import io.ktor.client.HttpClient
import io.mockk.every
import io.mockk.mockkObject

object ClientFactory {

    private fun mockConfigurationProvider() {
        mockkObject(EnvironmentConfigurationProvider)
        every { EnvironmentConfigurationProvider.getConfigurations() } returns Configuration(
            ClientConfiguration(
                ClientCredentials(
                    clientKey = CLIENT_KEY_TEST_CREDENTIAL,
                    clientSecret = CLIENT_SECRET_TEST_CREDENTIAL
                )
            )
        )
        every { EnvironmentConfigurationProvider.getEnvironmentConfigurations() } returns EnvironmentConfiguration.from(TEST_URL)
    }

    fun createClient(): HttpClient {
        mockConfigurationProvider()
        return Client.from(MockEnginFactory.createDefaultEngin()).httpClient
    }
}
