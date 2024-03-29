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

import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.RuntimeConfigurationProvider
import com.expediagroup.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class ConfigurationCollectorTest {
    @Test
    fun `verify configuration collector with no providers`() {
        val collector = ConfigurationCollector.create()

        assertNull(collector.key)
        assertNull(collector.secret)
        assertNull(collector.endpoint)
        assertNull(collector.authEndpoint)
        assertNull(collector.requestTimeout)
        assertNull(collector.connectionTimeout)
        assertNull(collector.socketTimeout)
        assertNull(collector.maskedLoggingHeaders)
        assertNull(collector.maskedLoggingBodyFields)
    }

    @Test
    fun `verify configuration collector with default configuration only`() {
        val collector = ConfigurationCollector.create(ExpediaGroupConfigurationProvider)

        assertEquals(EMPTY_STRING, collector.key)
        assertEquals(EMPTY_STRING, collector.secret)
        assertEquals(ExpediaGroupConfigurationProvider.endpoint, collector.endpoint)
        assertEquals(ExpediaGroupConfigurationProvider.authEndpoint, collector.authEndpoint)
        assertEquals(ExpediaGroupConfigurationProvider.requestTimeout, collector.requestTimeout)
    }

    @Test
    fun `verify configuration collector with runtime configuration provider only`() {
        val runtimeConfigurationProvider =
            RuntimeConfigurationProvider(
                key = CLIENT_KEY_TEST_CREDENTIAL,
                secret = CLIENT_SECRET_TEST_CREDENTIAL,
                endpoint = ExpediaGroupConfigurationProvider.endpoint,
                authEndpoint = ExpediaGroupConfigurationProvider.authEndpoint,
                requestTimeout = ExpediaGroupConfigurationProvider.requestTimeout,
                connectionTimeout = ExpediaGroupConfigurationProvider.connectionTimeout,
                socketTimeout = ExpediaGroupConfigurationProvider.socketTimeout,
                maskedLoggingHeaders = ExpediaGroupConfigurationProvider.maskedLoggingHeaders,
                maskedLoggingBodyFields = ExpediaGroupConfigurationProvider.maskedLoggingBodyFields
            )

        val collector =
            ConfigurationCollector.create(
                runtimeConfigurationProvider
            )

        assertEquals(CLIENT_KEY_TEST_CREDENTIAL, collector.key)
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, collector.secret)
        assertEquals(ExpediaGroupConfigurationProvider.endpoint, collector.endpoint)
        assertEquals(ExpediaGroupConfigurationProvider.authEndpoint, collector.authEndpoint)
        assertEquals(ExpediaGroupConfigurationProvider.requestTimeout, collector.requestTimeout)
        assertEquals(ExpediaGroupConfigurationProvider.connectionTimeout, collector.connectionTimeout)
        assertEquals(ExpediaGroupConfigurationProvider.socketTimeout, collector.socketTimeout)
        assertEquals(ExpediaGroupConfigurationProvider.maskedLoggingHeaders, collector.maskedLoggingHeaders)
        assertEquals(ExpediaGroupConfigurationProvider.maskedLoggingBodyFields, collector.maskedLoggingBodyFields)
    }

    @Test
    fun `verify configuration collector with incomplete client configuration only`() {
        val runtimeConfigurationProvider =
            RuntimeConfigurationProvider(
                key = CLIENT_KEY_TEST_CREDENTIAL,
                secret = CLIENT_SECRET_TEST_CREDENTIAL,
                endpoint = ExpediaGroupConfigurationProvider.endpoint
            )

        val collector =
            ConfigurationCollector.create(
                runtimeConfigurationProvider
            )

        assertEquals(CLIENT_KEY_TEST_CREDENTIAL, collector.key)
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, collector.secret)
        assertEquals(ExpediaGroupConfigurationProvider.endpoint, collector.endpoint)
        assertNull(collector.authEndpoint)
        assertNull(collector.requestTimeout)
        assertNull(collector.connectionTimeout)
        assertNull(collector.socketTimeout)
        assertNull(collector.maskedLoggingHeaders)
        assertNull(collector.maskedLoggingBodyFields)
    }

    @Test
    fun `verify configuration collector with runtime and default providers`() {
        val runtimeConfigurationProvider =
            RuntimeConfigurationProvider(
                secret = CLIENT_SECRET_TEST_CREDENTIAL,
                endpoint = ExpediaGroupConfigurationProvider.endpoint
            )

        val collector =
            ConfigurationCollector.create(
                runtimeConfigurationProvider,
                ExpediaGroupConfigurationProvider
            )

        assertEquals(EMPTY_STRING, collector.key) // from default provider
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, collector.secret) // from client configuration
        assertEquals(ExpediaGroupConfigurationProvider.endpoint, collector.endpoint) // from client configuration
        assertEquals(ExpediaGroupConfigurationProvider.authEndpoint, collector.authEndpoint) // from default provider
        assertEquals(ExpediaGroupConfigurationProvider.requestTimeout, collector.requestTimeout) // from default provider
        assertEquals(ExpediaGroupConfigurationProvider.connectionTimeout, collector.connectionTimeout) // from default provider
        assertEquals(ExpediaGroupConfigurationProvider.socketTimeout, collector.socketTimeout) // from default provider
        assertEquals(ExpediaGroupConfigurationProvider.maskedLoggingHeaders, collector.maskedLoggingHeaders) // from default provider
        assertEquals(ExpediaGroupConfigurationProvider.maskedLoggingBodyFields, collector.maskedLoggingBodyFields) // from default provider
    }
}
