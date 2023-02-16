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
package com.expediagroup.openworld.sdk.core.plugin.authentication

import com.expediagroup.openworld.sdk.core.constant.Authentication.BEARER
import com.expediagroup.openworld.sdk.core.constant.Authentication.EAN
import com.expediagroup.openworld.sdk.core.constant.HeaderKey
import com.expediagroup.openworld.sdk.core.test.ClientFactory
import com.expediagroup.openworld.sdk.core.test.TestConstants.ACCESS_TOKEN
import com.expediagroup.openworld.sdk.core.test.TestConstants.ANY_URL
import com.expediagroup.openworld.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.mockk.clearAllMocks
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal open class AuthenticationPluginTest {

    @BeforeEach
    open fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    open fun tearDown() {
        clearAllMocks()
    }

    @Nested
    inner class MultiInstancesTest {
        @Test
        fun `given two different-auth instances then each functions independently`() {
            runBlocking {
                val signatureHttpClient = ClientFactory.createRapidClient().httpClient
                val bearerHttpClient = ClientFactory.createOpenWorldClient().httpClient

                val signatureRequest = signatureHttpClient.get(ANY_URL)
                val bearerRequest = bearerHttpClient.get(ANY_URL)

                assertThat(bearerRequest.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                    "$BEARER $ACCESS_TOKEN"
                )

                assertThat(
                    signatureRequest.request.headers[HeaderKey.AUTHORIZATION]!!.startsWith("$EAN apikey=$CLIENT_KEY_TEST_CREDENTIAL,signature=")
                )
            }
        }

        @Test
        fun `given two similar-auth instances then each functions independently`() {
            runBlocking {
                val firstClient = ClientFactory.createOpenWorldClient()
                val firstHttpClient = firstClient.httpClient
                val firstAuth = firstClient.getAuthenticationStrategy()
                mockkObject(firstAuth)

                val secondClient = ClientFactory.createOpenWorldClient()
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
}
