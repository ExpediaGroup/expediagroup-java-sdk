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
import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.SystemConfigurationProvider
import com.expediagroup.sdk.core.constants.ClientConstants.EMPTY_STRING
import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal class ConfigurationCollectorTest {

    companion object {
        private val clientConfiguration = ClientConfiguration.Builder()
            .key(CLIENT_KEY_TEST_CREDENTIAL)
            .secret(CLIENT_SECRET_TEST_CREDENTIAL)
            .endpoint(TEST_URL)
            .build()

        private val configurationCollectorWithClientConfiguration = ConfigurationCollector.collect(
            clientConfiguration
        )

        @BeforeAll
        @JvmStatic
        fun setUp() {
            mockkObject(SystemConfigurationProvider)
            every { SystemConfigurationProvider.key } returns EMPTY_STRING
            every { SystemConfigurationProvider.secret } returns EMPTY_STRING
            every { SystemConfigurationProvider.endpoint } returns EMPTY_STRING
        }
    }

    @Test
    fun `verify default configuration collector`() {
        val defaultConfigurationCollector = ConfigurationCollector.collect()
        assertEquals(EMPTY_STRING, defaultConfigurationCollector.key)
        assertEquals(EMPTY_STRING, defaultConfigurationCollector.secret)
        assertEquals(EMPTY_STRING, defaultConfigurationCollector.endpoint)
    }

    @Test
    fun `verify configuration collector with client configuration`() {
        assertEquals(CLIENT_KEY_TEST_CREDENTIAL, configurationCollectorWithClientConfiguration.key)
        assertEquals(CLIENT_SECRET_TEST_CREDENTIAL, configurationCollectorWithClientConfiguration.secret)
        assertEquals(TEST_URL, configurationCollectorWithClientConfiguration.endpoint)
    }
}
