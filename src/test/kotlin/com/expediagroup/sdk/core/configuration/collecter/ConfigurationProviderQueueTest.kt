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
package com.expediagroup.sdk.core.configuration.collecter

import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.sdk.core.configuration.provider.ClientConfiguration
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException

internal class ConfigurationProviderQueueTest {
    companion object {
        private val clientConfiguration = ClientConfiguration.Builder()
            .key(CLIENT_KEY_TEST_CREDENTIAL)
            .secret(CLIENT_SECRET_TEST_CREDENTIAL)
            .endpoint(TEST_URL)
            .build()

        private val emptyConfigurationProviderQueue = ConfigurationProviderQueue.from(
            listOf(ClientConfiguration.EMPTY)
        )

        private val configurationProviderQueue = ConfigurationProviderQueue.from(
            listOf(clientConfiguration)
        )
    }

    @Test
    fun `test a provider queue with only an empty provider`() {
        emptyConfigurationProviderQueue.first() === ClientConfiguration.EMPTY
        emptyConfigurationProviderQueue.first { it.key != null } === ClientConfiguration.EMPTY

        assertThrows<NullPointerException> {
            emptyConfigurationProviderQueue.firstOf { it.key }
            Unit
        }
    }

    @Test
    fun `test a provider queue with at least a non-empty provider`() {
        assertThat(configurationProviderQueue.first()).isSameAs(clientConfiguration)
        assertThat(configurationProviderQueue.first { it.key != null }).isSameAs(clientConfiguration)
        assertThat(configurationProviderQueue.first { it.key !== EMPTY_STRING }).isSameAs(clientConfiguration)

        assertEquals(configurationProviderQueue.firstOf { it.key }, CLIENT_KEY_TEST_CREDENTIAL)
        assertEquals(configurationProviderQueue.firstOf { it.secret }, CLIENT_SECRET_TEST_CREDENTIAL)
        assertEquals(configurationProviderQueue.firstOf { it.endpoint }, TEST_URL)
    }
}
