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
package com.expediagroup.sdk.core.config.provider

import com.expediagroup.sdk.core.commons.TestConstants
import com.expediagroup.sdk.core.config.ClientCredentials
import com.expediagroup.sdk.core.config.EnvironmentConfiguration
import com.expediagroup.sdk.core.config.RuntimeConfiguration
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class RuntimeConfigurationTest {

    @Test
    fun `should have null fields when using the NONE instance`() {
        RuntimeConfiguration.NONE.let {
            assertNull(it.authentication)
            assertNull(it.environment)
        }
    }

    @Test
    fun `should have null fields when no configurations are provided`() {
        RuntimeConfiguration.from().let {
            assertNull(it.authentication)
            assertNull(it.environment)
        }
    }

    @Test
    fun `test the factory method`() {
        RuntimeConfiguration.from(
            authentication = ClientCredentials("key", "secret"),
            environment = EnvironmentConfiguration.from(TestConstants.TEST_URL)
        ).let {
            assertNotNull(it.authentication)
            assertNotNull(it.environment)
        }
    }
}
