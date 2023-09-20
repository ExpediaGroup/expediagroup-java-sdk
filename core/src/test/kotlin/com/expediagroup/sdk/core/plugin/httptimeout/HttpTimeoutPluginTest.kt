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
package com.expediagroup.sdk.core.plugin.httptimeout

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.test.ClientFactory
import com.expediagroup.sdk.core.test.MockEngineFactory
import com.expediagroup.sdk.core.test.TestConstants
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.mockk.clearAllMocks
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class HttpTimeoutPluginTest {
    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    private val expediaGroupConfiguration = ExpediaGroupClientConfiguration(
        key = TestConstants.CLIENT_KEY_TEST_CREDENTIAL,
        secret = TestConstants.CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = ExpediaGroupConfigurationProvider.endpoint,
        authEndpoint = ExpediaGroupConfigurationProvider.authEndpoint,
        requestTimeout = 3_000
    )

    @Test
    fun `get a response with timeout`() {
        val client = ClientFactory.createExpediaGroupClient(
            mockEngine = MockEngineFactory.createMockEngineDelayedResponse(5_000),
            configuration = expediaGroupConfiguration
        )

        assertThrows<HttpRequestTimeoutException> {
            runBlocking { client.httpClient.get("/any-url") }
        }
    }

    @Test
    fun `get a response without timeout`() {
        val client = ClientFactory.createExpediaGroupClient(
            mockEngine = MockEngineFactory.createMockEngineDelayedResponse(250),
            configuration = expediaGroupConfiguration
        )

        runBlocking {
            val request = client.httpClient.get("/any-url")
            Assertions.assertThat(request.status).isEqualTo(HttpStatusCode.OK)
        }
    }
}
