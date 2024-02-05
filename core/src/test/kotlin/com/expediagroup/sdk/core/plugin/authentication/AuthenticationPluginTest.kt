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
package com.expediagroup.sdk.core.plugin.authentication

import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.test.ClientFactory
import com.expediagroup.sdk.core.test.MockEngineFactory
import com.expediagroup.sdk.core.test.TestConstants.ACCESS_TOKEN
import com.expediagroup.sdk.core.test.TestConstants.ANY_URL
import com.expediagroup.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.mockk.clearAllMocks
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal open class AuthenticationPluginTest {
    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Nested
    inner class MultiInstancesTest {
        @Test
        fun `given two different-auth instances then each functions independently`() {
            runBlocking {
                val signatureHttpClient = ClientFactory.createRapidClient().httpClient
                val bearerHttpClient = ClientFactory.createExpediaGroupClient().httpClient

                val signatureRequest = signatureHttpClient.get(ANY_URL)
                val bearerRequest = bearerHttpClient.get(ANY_URL)

                assertThat(bearerRequest.request.headers[HttpHeaders.Authorization]).isEqualTo(
                    "$BEARER $ACCESS_TOKEN"
                )

                assertThat(
                    signatureRequest.request.headers[HttpHeaders.Authorization]!!.startsWith("$EAN apikey=$CLIENT_KEY_TEST_CREDENTIAL,signature=")
                )
            }
        }

        @Test
        fun `given two similar-auth instances then each functions independently`() {
            runBlocking {
                val firstClient = ClientFactory.createExpediaGroupClient()
                val firstHttpClient = firstClient.httpClient
                val firstAuth = firstClient.getAuthenticationStrategy()
                mockkObject(firstAuth)

                val secondClient = ClientFactory.createExpediaGroupClient()
                val secondHttpClient = secondClient.httpClient
                val secondAuth = secondClient.getAuthenticationStrategy()
                mockkObject(secondAuth)

                firstHttpClient.get(ANY_URL)
                secondHttpClient.get(ANY_URL)

                verify(exactly = 1) {
                    firstAuth.renewToken()
                }
                verify(exactly = 1) {
                    secondAuth.renewToken()
                }
            }
        }
    }

    @Nested
    inner class LockTest {
        @Test
        fun `given two requests when authentication fails then renew token should be called for both of them`() {
            runBlocking {
                val client =
                    ClientFactory.createExpediaGroupClient(
                        MockEngineFactory.createUnauthorizedMockEngineWithStatusCode(HttpStatusCode.Unauthorized),
                        ClientFactory.expediaGroupConfiguration
                    )
                val httpClient = client.httpClient
                val auth = client.getAuthenticationStrategy()
                mockkObject(auth)

                assertThrows<ExpediaGroupAuthException> {
                    httpClient.get(ANY_URL)
                }
                assertThrows<ExpediaGroupAuthException> {
                    httpClient.get(ANY_URL)
                }

                verify(exactly = 2) {
                    auth.renewToken()
                }
            }
        }
    }
}
