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
package com.expediagroup.common.sdk.core.configuration

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RapidClientConfigurationTest {

    @Test
    fun `verify that the EMPTY instance has no properties`() {
        RapidClientConfiguration.EMPTY.let {
            Assertions.assertNull(it.key)
            Assertions.assertNull(it.secret)
            Assertions.assertNull(it.endpoint)
        }
    }

    @Test
    fun `verify that toClientConfiguration returns ClientConfigurations with null authEndpoint`() {
        RapidClientConfiguration.Builder()
            .key("key")
            .secret("secret")
            .endpoint("endpoint")
            .build()
            .toClientConfiguration()
            .let {
                Assertions.assertEquals("key", it.key)
                Assertions.assertEquals("secret", it.secret)
                Assertions.assertEquals("endpoint", it.endpoint)
                Assertions.assertEquals(null, it.authEndpoint)
            }
    }

    @Nested
    inner class RapidClientConfigurationBuilderTest {

        @Test
        fun `verify that the builder can be used to create a RapidClientConfiguration instance`() {
            RapidClientConfiguration.Builder()
                .key("key")
                .secret("secret")
                .endpoint("endpoint")
                .build()
                .let {
                    Assertions.assertEquals("key", it.key)
                    Assertions.assertEquals("secret", it.secret)
                    Assertions.assertEquals("endpoint", it.endpoint)
                }
        }
    }
}
