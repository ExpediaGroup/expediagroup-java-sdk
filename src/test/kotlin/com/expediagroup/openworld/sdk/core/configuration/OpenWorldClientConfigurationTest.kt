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
package com.expediagroup.openworld.sdk.core.configuration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class OpenWorldClientConfigurationTest {

    @Test
    fun `verify default behaviour`() {
        OpenWorldClientConfiguration().let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
        }
    }

    @Test
    fun `verify typical use`() {
        OpenWorldClientConfiguration(
            key = "key",
            secret = "secret",
            endpoint = "endpoint",
            authEndpoint = "authEndpoint"
        ).let {
            assertEquals("key", it.key)
            assertEquals("secret", it.secret)
            assertEquals("endpoint", it.endpoint)
            assertEquals("authEndpoint", it.authEndpoint)
        }
    }

    @Test
    fun `verify toProvider with default behaviour`() {
        OpenWorldClientConfiguration().toProvider().let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
        }
    }

    @Test
    fun `verify toProvider with values`() {
        OpenWorldClientConfiguration(
            key = "key",
            secret = "secret",
            endpoint = "endpoint",
            authEndpoint = "authEndpoint"
        ).toProvider().let {
            assertEquals("key", it.key)
            assertEquals("secret", it.secret)
            assertEquals("endpoint", it.endpoint)
            assertEquals("authEndpoint", it.authEndpoint)
        }
    }
}
