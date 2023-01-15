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

import com.expediagroup.sdk.core.client.Client
import com.expediagroup.sdk.core.commons.ClientFactory
import com.expediagroup.sdk.core.commons.MockEngineFactory.createMockEngineExpiresInPerCall
import com.expediagroup.sdk.core.commons.MockEngineFactory.createTokenMockEngineWithStatusCode
import com.expediagroup.sdk.core.commons.MockEngineFactory.createUnauthorizedMockEngineWithStatusCode
import com.expediagroup.sdk.core.commons.TestConstants.ACCESS_TOKEN
import com.expediagroup.sdk.core.commons.TestConstants.ANY_URL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.SIGNATURE_VALUE
import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.configuration.Credentials
import com.expediagroup.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.constant.ExceptionMessage
import com.expediagroup.sdk.core.constant.HeaderKey
import com.expediagroup.sdk.core.model.exception.service.OpenWorldAuthException
import com.expediagroup.sdk.core.plugin.authentication.helper.SuccessfulStatusCodesArgumentProvider
import com.expediagroup.sdk.core.plugin.authentication.helper.UnsuccessfulStatusCodesArgumentProvider
import com.expediagroup.sdk.core.plugin.authentication.strategy.signature.calculateSignature
import io.ktor.client.HttpClientConfig
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.request
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource

internal class AuthenticationPluginTest {

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Nested
    inner class SignatureStrategyTest {
        @Test
        fun `making any http call should invoke the authorized signature`() {
            runBlocking {
                mockSignatureCalculator()

                val httpClient = ClientFactory.createRapidClient().httpClient
                val request = httpClient.get(ANY_URL)

                assertThat(request.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                    "$EAN $SIGNATURE_VALUE"
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
                mockkObject(AuthenticationPlugin)
                val client = ClientFactory.createRapidClient()
                val httpClient = client.httpClient

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
                coVerify(exactly = 3) {
                    client.authentication().renewToken()
                }
            }
        }
    }

    @Nested
    inner class BearerStrategyTest {
        @Test
        fun `making any http call should invoke the authorized token`() {
            runBlocking {
                val httpClient = ClientFactory.createClient().httpClient
                val testRequest = httpClient.get(ANY_URL)

                assertThat(testRequest.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                    "$BEARER $ACCESS_TOKEN"
                )
            }
        }

        @ParameterizedTest
        @ArgumentsSource(UnsuccessfulStatusCodesArgumentProvider::class)
        fun `refresh auth token should throw client exception if the the credentials are invalid`(httpStatusCode: HttpStatusCode) {
            runBlocking {
                val configuration = ClientConfiguration.Builder()
                    .key(CLIENT_KEY_TEST_CREDENTIAL + "invalid")
                    .secret(CLIENT_SECRET_TEST_CREDENTIAL + "invalid")
                    .endpoint(DefaultConfigurationProvider.endpoint)
                    .authEndpoint(DefaultConfigurationProvider.authEndpoint)
                    .build()

                val client = ClientFactory.createClient(
                    createUnauthorizedMockEngineWithStatusCode(httpStatusCode),
                    configuration
                )

                val exception = assertThrows<OpenWorldAuthException> {
                    client.authentication().renewToken()
                }
                assertThat(exception.message).isEqualTo("[${httpStatusCode.value}] ${ExceptionMessage.AUTHENTICATION_FAILURE}")
                assertThat(exception.cause).isNull()
                assertThat(exception.errorCode).isEqualTo(httpStatusCode)
                assertThat(exception.error).isNull()
            }
        }

        @ParameterizedTest
        @ArgumentsSource(SuccessfulStatusCodesArgumentProvider::class)
        fun `refresh auth token should not throw client exception if the the credentials are valid`(httpStatusCode: HttpStatusCode) {
            runBlocking {
                val configuration = ClientConfiguration.Builder()
                    .key(CLIENT_KEY_TEST_CREDENTIAL)
                    .secret(CLIENT_SECRET_TEST_CREDENTIAL)
                    .endpoint(DefaultConfigurationProvider.endpoint)
                    .authEndpoint(DefaultConfigurationProvider.authEndpoint)
                    .build()

                val client =
                    ClientFactory.createClient(createTokenMockEngineWithStatusCode(httpStatusCode), configuration)

                assertDoesNotThrow {
                    client.authentication().renewToken()
                }
            }
        }

        @Test
        fun `make parallel should run the single refresh token only`() {
            runBlocking {
                mockkObject(AuthenticationPlugin)
                val client = ClientFactory.createClient()
                val httpClient = client.httpClient

                launch {
                    httpClient.get(ANY_URL)
                }
                launch {
                    httpClient.get(ANY_URL)
                }

                delay(1000)
                coVerify(exactly = 1) {
                    client.authentication().renewToken()
                }
            }
        }

        @ParameterizedTest
        @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        fun `given request when token almost or is expired then should renew token`(expiresIn: Int) {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(expiresIn, 1000)
                val client = ClientFactory.createClient(mockEngine)
                val httpClient = client.httpClient
                renewToken(client)

                mockkObject(AuthenticationPlugin)
                httpClient.get(ANY_URL)

                coVerify(exactly = 1) {
                    client.authentication().renewToken()
                }
            }
        }

        @Test
        fun `given request when token not almost and not expired then should not renew token`() {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(1000)
                val client = ClientFactory.createClient(mockEngine)
                val httpClient = client.httpClient
                renewToken(client)

                mockkObject(AuthenticationPlugin)
                httpClient.get(ANY_URL)

                coVerify(exactly = 0) {
                    client.authentication().renewToken()
                }
            }
        }

        @Test
        fun `given identity request when token almost expired then should not renew token`() {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(6, 1000)
                val client = ClientFactory.createClient(mockEngine)
                val httpClient = client.httpClient
                mockkObject(AuthenticationPlugin)

                val configs = getAuthenticationConfiguration()
                httpClient.request {
                    method = HttpMethod.Post
                    url(configs.authUrl)
                }

                coVerify(exactly = 0) {
                    client.authentication().renewToken()
                }
            }
        }

        @Test
        fun `given multiple requests when token expired then no requests should be unauthorized`() {
            runBlocking {
                mockkObject(AuthenticationPlugin)
                val client = ClientFactory.createClient()
                val httpClient = client.httpClient

                launch {
                    val request = httpClient.get(ANY_URL)
                    assertThat(request.status != HttpStatusCode.Unauthorized)
                }
                launch {
                    val request = httpClient.get(ANY_URL)
                    assertThat(request.status != HttpStatusCode.Unauthorized)
                }
                launch {
                    val request = httpClient.get(ANY_URL)
                    assertThat(request.status != HttpStatusCode.Unauthorized)
                }

                delay(1000)
                coVerify(exactly = 1) {
                    client.authentication().renewToken()
                }
            }
        }

        private suspend fun renewToken(client: Client) {
            client.authentication().renewToken()
        }

        private fun getAuthenticationConfiguration() = AuthenticationConfiguration.from(
            HttpClientConfig(),
            Credentials(
                CLIENT_KEY_TEST_CREDENTIAL,
                CLIENT_SECRET_TEST_CREDENTIAL
            ),
            DefaultConfigurationProvider.authEndpoint
        )
    }

    @Nested
    inner class MultiInstancesTest {
        @Test
        fun `given two different-auth instances then each functions independently`() {
            runBlocking {
                mockSignatureCalculator()

                val signatureHttpClient = ClientFactory.createRapidClient().httpClient
                val bearerHttpClient = ClientFactory.createClient().httpClient

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
    }

    private fun mockSignatureCalculator() {
        mockkStatic("com.expediagroup.sdk.core.plugin.authentication.strategy.signature.SignatureCalculatorKt")
        every { calculateSignature(any(), any(), any()) } returns SIGNATURE_VALUE
    }
}
