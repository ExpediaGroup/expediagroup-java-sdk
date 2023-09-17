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
package com.expediagroup.sdk.core.plugin.authentication.strategy

import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.constant.HeaderKey
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationPluginTest
import com.expediagroup.sdk.core.plugin.authentication.getAuthenticationStrategy
import com.expediagroup.sdk.core.test.ClientFactory
import com.expediagroup.sdk.core.test.TestConstants
import com.expediagroup.sdk.core.test.TestConstants.ANY_URL
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RapidAuthenticationStrategyTest : AuthenticationPluginTest() {

    @Test
    fun `making any http call should invoke the authorized signature`() {
        runBlocking {
            val httpClient = ClientFactory.createRapidClient().httpClient
            val request = httpClient.get(ANY_URL)

            assertThat(
                request.request.headers[HeaderKey.AUTHORIZATION]!!.startsWith("$EAN apikey=${TestConstants.CLIENT_KEY_TEST_CREDENTIAL},signature=")
            )
        }
    }

    @Test
    fun `given new request then should renew token`() {
        runBlocking {
            val httpClient = ClientFactory.createRapidClient().httpClient

            val firstRequest = httpClient.get(ANY_URL)
            delay(1000)
            val secondRequest = httpClient.get(ANY_URL)

            val firstRequestAuth = firstRequest.request.headers[HeaderKey.AUTHORIZATION]
            val secondRequestAuth = secondRequest.request.headers[HeaderKey.AUTHORIZATION]

            assertThat(firstRequestAuth).isNotNull
            assertThat(secondRequestAuth).isNotNull
            assertThat(firstRequestAuth).isNotEqualTo(secondRequestAuth)
        }
    }

    @Test
    fun `given multiple requests then no requests should be unauthorized`() {
        runBlocking {
            val client = ClientFactory.createRapidClient()
            val httpClient = client.httpClient
            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)

            launch {
                httpClient.get(ANY_URL)
            }
            launch {
                httpClient.get(ANY_URL)
            }
            launch {
                httpClient.get(ANY_URL)
            }

            delay(1000)
            verify(exactly = 3) {
                authentication.renewToken()
            }
        }
    }
}
