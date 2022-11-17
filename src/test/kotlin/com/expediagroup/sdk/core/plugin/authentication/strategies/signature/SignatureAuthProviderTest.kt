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
package com.expediagroup.sdk.core.plugin.authentication.strategies.signature

import com.expediagroup.sdk.core.commons.TestConstants.SIGNATURE
import com.expediagroup.sdk.core.commons.TestConstants.TEST_VALUE
import com.expediagroup.sdk.core.constant.Constant.BEARER
import com.expediagroup.sdk.core.constant.Constant.EAN
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.http.HttpHeaders.Authorization
import io.ktor.http.auth.HttpAuthHeader
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SignatureAuthProviderTest {
    @Test
    fun `given request with auth when addRequestHeaders then replace current auth`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }
            val request = request {
                headers {
                    append(Authorization, "value")
                }
            }

            signatureAuthProvider.addRequestHeaders(request, null)
            assertThat(request.headers[Authorization]).isEqualTo("$EAN $TEST_VALUE")
        }
    }

    @Test
    fun `given request without auth when addRequestHeaders then return new auth`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }
            val request = request {}

            signatureAuthProvider.addRequestHeaders(request, null)
            assertThat(request.headers[Authorization]).isEqualTo("$EAN $TEST_VALUE")
        }
    }

    @Test
    fun `when sendWithoutRequest then return false`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }
            val request = request {}

            assertThat(signatureAuthProvider.sendWithoutRequest(request)).isFalse
        }
    }

    @Test
    fun `when sendWithoutRequest variable then throw error`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }

            assertThrows<IllegalStateException> {
                @Suppress("DEPRECATION")
                signatureAuthProvider.sendWithoutRequest
            }
        }
    }

    @Test
    fun `given auth scheme not EAN when isApplicable then return false`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }
            val httpAuthHeader = HttpAuthHeader.Parameterized(BEARER, emptyList())

            assertThat(signatureAuthProvider.isApplicable(httpAuthHeader)).isFalse
        }
    }

    @Test
    fun `given auth scheme EAN when isApplicable then return false`() {
        runBlocking {
            val signatureAuthProvider = SignatureAuthProvider { TEST_VALUE }
            val httpAuthHeader = HttpAuthHeader.Single(EAN, SIGNATURE)

            assertThat(signatureAuthProvider.isApplicable(httpAuthHeader)).isTrue
        }
    }
}
