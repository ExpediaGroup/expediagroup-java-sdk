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
package com.expediagroup.common.sdk.core.configuration.collector

import com.expediagroup.common.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.common.sdk.core.configuration.provider.RuntimeConfigurationProvider
import com.expediagroup.common.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConfigurationProviderQueueTest {

    @Test
    fun `test a provider queue with only a default provider`() {
        val configurationProviderQueue = ConfigurationProviderQueue.from(listOf(DefaultConfigurationProvider))
        assertEquals(ProvidedConfiguration(EMPTY_STRING, DefaultConfigurationProvider.name), configurationProviderQueue.firstWith { it.key })
        assertEquals(ProvidedConfiguration(EMPTY_STRING, DefaultConfigurationProvider.name), configurationProviderQueue.firstWith { it.secret })
        assertEquals(ProvidedConfiguration(DefaultConfigurationProvider.endpoint, DefaultConfigurationProvider.name), configurationProviderQueue.firstWith { it.endpoint })
        assertEquals(ProvidedConfiguration(DefaultConfigurationProvider.authEndpoint, DefaultConfigurationProvider.name), configurationProviderQueue.firstWith { it.authEndpoint })
    }

    @Test
    fun `test a provider queue with at least a non-empty provider`() {
        val runtimeConfigurationProvider = RuntimeConfigurationProvider(
            key = CLIENT_KEY_TEST_CREDENTIAL,
            secret = CLIENT_SECRET_TEST_CREDENTIAL,
            endpoint = DefaultConfigurationProvider.endpoint,
            authEndpoint = DefaultConfigurationProvider.authEndpoint
        )
        val configurationProviderQueue = ConfigurationProviderQueue.from(
            listOf(runtimeConfigurationProvider)
        )

        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first())
        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first { it.key != null })
        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first { it.key != EMPTY_STRING })

        assertEquals(ProvidedConfiguration(CLIENT_KEY_TEST_CREDENTIAL, runtimeConfigurationProvider.name), configurationProviderQueue.firstWith { it.key })
        assertEquals(ProvidedConfiguration(CLIENT_SECRET_TEST_CREDENTIAL, runtimeConfigurationProvider.name), configurationProviderQueue.firstWith { it.secret })
        assertEquals(ProvidedConfiguration(DefaultConfigurationProvider.endpoint, runtimeConfigurationProvider.name), configurationProviderQueue.firstWith { it.endpoint })
        assertEquals(ProvidedConfiguration(DefaultConfigurationProvider.authEndpoint, runtimeConfigurationProvider.name), configurationProviderQueue.firstWith { it.authEndpoint })
    }
}
