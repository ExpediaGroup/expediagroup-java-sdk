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
package com.expediagroup.sdk.core.configuration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ExpediaGroupClientConfigurationTest {
    @Test
    fun `verify default behaviour`() {
        ExpediaGroupClientConfiguration().let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
            assertNull(it.requestTimeout)
            assertNull(it.connectionTimeout)
            assertNull(it.socketTimeout)
            assertNull(it.maskedLoggingHeaders)
            assertNull(it.okHttpClient)
        }
    }

    @Test
    fun `verify typical use`() {
        ExpediaGroupClientConfiguration(
            key = "key",
            secret = "secret",
            endpoint = "endpoint",
            authEndpoint = "authEndpoint",
            requestTimeout = 10_000,
            connectionTimeout = 5_000,
            socketTimeout = 15_000,
            maskedLoggingHeaders = setOf("header1", "header2")
        ).let {
            assertEquals("key", it.key)
            assertEquals("secret", it.secret)
            assertEquals("endpoint", it.endpoint)
            assertEquals("authEndpoint", it.authEndpoint)
            assertEquals(10_000, it.requestTimeout)
            assertEquals(5_000, it.connectionTimeout)
            assertEquals(15_000, it.socketTimeout)
            assertEquals(setOf("header1", "header2"), it.maskedLoggingHeaders)
        }
    }

    @Test
    fun `verify toProvider with default behaviour`() {
        ExpediaGroupClientConfiguration().toProvider().let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
            assertNull(it.requestTimeout)
            assertNull(it.connectionTimeout)
            assertNull(it.socketTimeout)
            assertNull(it.maskedLoggingHeaders)
            assertNull(it.okHttpClient)
        }
    }

    @Test
    fun `verify toProvider with values`() {
        ExpediaGroupClientConfiguration(
            key = "key",
            secret = "secret",
            endpoint = "endpoint",
            authEndpoint = "authEndpoint",
            requestTimeout = 10_000,
            connectionTimeout = 5_000,
            socketTimeout = 15_000,
            maskedLoggingHeaders = setOf("header1", "header2"),
        ).toProvider().let {
            assertEquals("key", it.key)
            assertEquals("secret", it.secret)
            assertEquals("endpoint", it.endpoint)
            assertEquals("authEndpoint", it.authEndpoint)
            assertEquals(10_000, it.requestTimeout)
            assertEquals(5_000, it.connectionTimeout)
            assertEquals(15_000, it.socketTimeout)
            assertEquals(setOf("header1", "header2"), it.maskedLoggingHeaders)
        }
    }
}
