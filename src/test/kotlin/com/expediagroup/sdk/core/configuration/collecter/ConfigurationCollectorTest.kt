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
import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.sdk.core.configuration.toProvider
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_AUTH_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_ENDPOINT
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException

internal class ConfigurationCollectorTest {

    @Test
    fun `verify configuration collector with no providers`() {
        assertThrows<NullPointerException> {
            ConfigurationCollector.create()
        }
    }

    @Test
    fun `verify configuration collector with default configuration only`() {
        val collector = ConfigurationCollector.create(DefaultConfigurationProvider)

        assertEquals(EMPTY_STRING, collector.key)
        assertEquals(EMPTY_STRING, collector.secret)
        assertEquals(DEFAULT_ENDPOINT, collector.endpoint)
        assertEquals(DEFAULT_AUTH_ENDPOINT, collector.authEndpoint)
    }

    @Test
    fun `verify configuration collector with client configuration only`() {
        val clientConfiguration = ClientConfiguration.Builder()
            .key(CLIENT_KEY_TEST_CREDENTIAL)
            .secret(CLIENT_SECRET_TEST_CREDENTIAL)
            .endpoint(DEFAULT_ENDPOINT)
            .authEndpoint(DEFAULT_AUTH_ENDPOINT)
            .build()

        val collector = ConfigurationCollector.create(
            clientConfiguration.toProvider()
        )

        assertEquals(CLIENT_KEY_TEST_CREDENTIAL, collector.key)
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, collector.secret)
        assertEquals(DEFAULT_ENDPOINT, collector.endpoint)
        assertEquals(DEFAULT_AUTH_ENDPOINT, collector.authEndpoint)
    }

    @Test
    fun `verify configuration collector with incomplete client configuration only`() {
        val clientConfiguration = ClientConfiguration.Builder()
            .key(CLIENT_KEY_TEST_CREDENTIAL)
            .secret(CLIENT_SECRET_TEST_CREDENTIAL)
            .endpoint(DEFAULT_ENDPOINT)
            .build()

        assertThrows<NullPointerException> {
            val collector = ConfigurationCollector.create(
                clientConfiguration.toProvider()
            )
        }
    }

    @Test
    fun `verify configuration collector with client configuration and default provider`() {
        val clientConfiguration = ClientConfiguration.Builder()
            .secret(CLIENT_SECRET_TEST_CREDENTIAL)
            .endpoint(DEFAULT_ENDPOINT)
            .build()

        val collector = ConfigurationCollector.create(
            clientConfiguration.toProvider(),
            DefaultConfigurationProvider
        )

        assertEquals(EMPTY_STRING, collector.key) // from default provider
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, collector.secret) // from client configuration
        assertEquals(DEFAULT_ENDPOINT, collector.endpoint) // from client configuration
        assertEquals(DEFAULT_AUTH_ENDPOINT, collector.authEndpoint) // from default provider
    }
}
