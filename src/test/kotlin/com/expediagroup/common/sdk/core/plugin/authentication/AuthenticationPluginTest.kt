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
package com.expediagroup.common.sdk.core.plugin.authentication

import com.expediagroup.common.sdk.core.constant.Authentication.BEARER
import com.expediagroup.common.sdk.core.constant.Authentication.EAN
import com.expediagroup.common.sdk.core.constant.HeaderKey
import com.expediagroup.common.sdk.core.test.ClientFactory
import com.expediagroup.common.sdk.core.test.TestConstants.ACCESS_TOKEN
import com.expediagroup.common.sdk.core.test.TestConstants.ANY_URL
import com.expediagroup.common.sdk.core.test.TestConstants.SIGNATURE_VALUE
import com.expediagroup.rapid.sdk.core.plugin.authentication.strategy.calculateSignature
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

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
                mockSignatureCalculator()

                val signatureHttpClient = ClientFactory.createRapidClient().httpClient
                val bearerHttpClient = ClientFactory.createOpenWorldClient().httpClient

                val signatureRequest = signatureHttpClient.get(ANY_URL)
                val bearerRequest = bearerHttpClient.get(ANY_URL)

                assertThat(bearerRequest.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                    "$BEARER $ACCESS_TOKEN"
                )

                assertThat(signatureRequest.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                    "$EAN $SIGNATURE_VALUE"
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

    protected fun mockSignatureCalculator() {
        mockkStatic("com.expediagroup.rapid.sdk.core.plugin.authentication.strategy.SignatureCalculatorKt")
        every { calculateSignature(any(), any(), any()) } returns SIGNATURE_VALUE
    }
}
