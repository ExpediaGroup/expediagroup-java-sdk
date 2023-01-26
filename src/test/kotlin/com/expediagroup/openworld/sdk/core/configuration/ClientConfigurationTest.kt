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
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ClientConfigurationTest {

    @Test
    fun `verify that the EMPTY instance has no properties`() {
        ClientConfiguration.EMPTY.let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
        }
    }

    @Nested
    inner class ClientConfigurationBuilderTest {

        @Test
        fun `verify that the builder can be used to create a ClientConfiguration instance`() {
            ClientConfiguration.Builder()
                .key("key")
                .secret("secret")
                .endpoint("endpoint")
                .authEndpoint("authEndpoint")
                .build()
                .let {
                    assertEquals("key", it.key)
                    assertEquals("secret", it.secret)
                    assertEquals("endpoint/", it.endpoint)
                    assertEquals("authEndpoint", it.authEndpoint)
                }
        }

        @Test
        fun `Verify a builder with null values`() {
            ClientConfiguration.Builder()
                .build()
                .let {
                    assertNull(it.key)
                    assertNull(it.secret)
                    assertNull(it.endpoint)
                    assertNull(it.authEndpoint)
                }
        }
    }

    @Nested
    inner class ExtensionFunctionsTest {

        @Test
        fun `verify toProvider() reruns a valid runtime configuration provider`() {
            ClientConfiguration.Builder()
                .key("key")
                .secret("secret")
                .endpoint("endpoint")
                .authEndpoint("authEndpoint")
                .build()
                .toProvider()
                .let {
                    assertEquals("key", it.key)
                    assertEquals("secret", it.secret)
                    assertEquals("endpoint/", it.endpoint)
                    assertEquals("authEndpoint", it.authEndpoint)
                }
        }
    }
}
