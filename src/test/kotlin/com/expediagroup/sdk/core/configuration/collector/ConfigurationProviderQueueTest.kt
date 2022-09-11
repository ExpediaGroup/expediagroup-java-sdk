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
package com.expediagroup.sdk.core.configuration.collector

import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.RuntimeConfigurationProvider
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_AUTH_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConfigurationProviderQueueTest {

    @Test
    fun `test a provider queue with only a default provider`() {
        val configurationProviderQueue = ConfigurationProviderQueue.from(listOf(DefaultConfigurationProvider))
        assertEquals(EMPTY_STRING, configurationProviderQueue.firstOf { it.key })
        assertEquals(EMPTY_STRING, configurationProviderQueue.firstOf { it.secret })
        assertEquals(DEFAULT_ENDPOINT, configurationProviderQueue.firstOf { it.endpoint })
        assertEquals(DEFAULT_AUTH_ENDPOINT, configurationProviderQueue.firstOf { it.authEndpoint })
    }

    @Test
    fun `test a provider queue with at least a non-empty provider`() {
        val runtimeConfigurationProvider = RuntimeConfigurationProvider(
            key = CLIENT_KEY_TEST_CREDENTIAL,
            secret = CLIENT_SECRET_TEST_CREDENTIAL,
            endpoint = DEFAULT_ENDPOINT,
            authEndpoint = DEFAULT_AUTH_ENDPOINT
        )
        val configurationProviderQueue = ConfigurationProviderQueue.from(
            listOf(runtimeConfigurationProvider)
        )

        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first())
        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first { it.key != null })
        assertEquals(runtimeConfigurationProvider, configurationProviderQueue.first { it.key != EMPTY_STRING })

        assertEquals(configurationProviderQueue.firstOf { it.key }, CLIENT_KEY_TEST_CREDENTIAL)
        assertEquals(configurationProviderQueue.firstOf { it.secret }, CLIENT_SECRET_TEST_CREDENTIAL)
        assertEquals(configurationProviderQueue.firstOf { it.endpoint }, DEFAULT_ENDPOINT)
        assertEquals(configurationProviderQueue.firstOf { it.authEndpoint }, DEFAULT_AUTH_ENDPOINT)
    }
}
