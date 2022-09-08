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
import com.expediagroup.sdk.core.config.Configuration
import com.expediagroup.sdk.core.config.Credentials
import com.expediagroup.sdk.core.config.EnvironmentConfigs
import com.expediagroup.sdk.core.config.EnvironmentConfigurationProvider
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_AUTH_ENDPOINT
import io.ktor.client.HttpClient
import io.mockk.every
import io.mockk.mockkConstructor

internal object ClientFactory {

    private fun mockConfigurationProvider() {
        mockkConstructor(EnvironmentConfigurationProvider::class)
        every { constructedWith<EnvironmentConfigurationProvider>().clientEnvironmentConfigs }
        every { constructedWith<EnvironmentConfigurationProvider>().configuration }
        every { EnvironmentConfigurationProvider.configuration } returns Configuration(
            Credentials(
                key = CLIENT_KEY_TEST_CREDENTIAL,
                secret = CLIENT_SECRET_TEST_CREDENTIAL
            )
        )
        every { EnvironmentConfigurationProvider.clientEnvironmentConfigs } returns EnvironmentConfigs(
            TEST_URL,
            DEFAULT_AUTH_ENDPOINT
        )
    }

    fun createClient(): HttpClient {
        mockConfigurationProvider()
        return Client.from(MockEnginFactory.createDefaultEngin()).httpClient
    }
}
