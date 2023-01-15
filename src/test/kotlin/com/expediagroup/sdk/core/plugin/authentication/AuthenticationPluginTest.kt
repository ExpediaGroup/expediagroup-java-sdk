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

import com.expediagroup.sdk.core.commons.ClientFactory
import com.expediagroup.sdk.core.commons.MockEngineFactory.createMockEngineExpiresInPerCall
import com.expediagroup.sdk.core.commons.MockEngineFactory.createTokenMockEngineWithStatusCode
import com.expediagroup.sdk.core.commons.MockEngineFactory.createUnauthorizedMockEngineWithStatusCode
import com.expediagroup.sdk.core.commons.TestConstants.ACCESS_TOKEN
import com.expediagroup.sdk.core.commons.TestConstants.ANY_URL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.SIGNATURE_VALUE
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
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.mockk.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
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

                assertThat(firstRequest.request.headers[HeaderKey.AUTHORIZATION]).isNotEqualTo(
                    secondRequest.request.headers[HeaderKey.AUTHORIZATION]
                )
            }
        }

        @Test
        fun `given multiple requests then no requests should be unauthorized`() {
            runBlocking {
                mockkObject(AuthenticationPlugin)
                val httpClient = ClientFactory.createRapidClient().httpClient

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
                    AuthenticationPlugin.renewToken(httpClient, any())
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
                val httpClient = ClientFactory.createClient(createUnauthorizedMockEngineWithStatusCode(httpStatusCode)).httpClient

                val exception = assertThrows<OpenWorldAuthException> {
                    AuthenticationPlugin.renewToken(
                        httpClient,
                        AuthenticationConfiguration.from(
                            HttpClientConfig(),
                            Credentials(
                                CLIENT_KEY_TEST_CREDENTIAL + "invalid",
                                CLIENT_SECRET_TEST_CREDENTIAL + "invalid"
                            ),
                            DefaultConfigurationProvider.authEndpoint
                        )
                    )
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
                val httpClient = ClientFactory.createClient(createTokenMockEngineWithStatusCode(httpStatusCode)).httpClient

                assertDoesNotThrow {
                    AuthenticationPlugin.renewToken(
                        httpClient,
                        AuthenticationConfiguration.from(
                            HttpClientConfig(),
                            Credentials(
                                CLIENT_KEY_TEST_CREDENTIAL,
                                CLIENT_SECRET_TEST_CREDENTIAL
                            ),
                            DefaultConfigurationProvider.authEndpoint
                        )
                    )
                }

            }
        }

        @Test
        fun `make parallel should run the single refresh token only`() {
            runBlocking {
                mockkObject(AuthenticationPlugin)
                val httpClient = ClientFactory.createClient().httpClient

                launch {
                    httpClient.get(ANY_URL)
                }
                launch {
                    httpClient.get(ANY_URL)
                }

                delay(1000)
                coVerify(exactly = 1) {
                    AuthenticationPlugin.renewToken(httpClient, any())
                }

            }
        }

        @ParameterizedTest
        @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        fun `given request when token almost or is expired then should renew token`(expiresIn: Int) {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(expiresIn, 1000)
                val httpClient = ClientFactory.createClient(mockEngine).httpClient
                renewToken(httpClient)

                mockkObject(AuthenticationPlugin)
                httpClient.get(ANY_URL)

                coVerify(exactly = 1) {
                    AuthenticationPlugin.renewToken(httpClient, any())
                }

            }
        }

        @Test
        fun `given request when token not almost and not expired then should not renew token`() {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(1000)
                val httpClient = ClientFactory.createClient(mockEngine).httpClient
                renewToken(httpClient)

                mockkObject(AuthenticationPlugin)
                httpClient.get(ANY_URL)

                coVerify(exactly = 0) {
                    AuthenticationPlugin.renewToken(httpClient, any())
                }

            }
        }

        @Test
        fun `given identity request when token almost expired then should not renew token`() {
            runBlocking {
                val mockEngine = createMockEngineExpiresInPerCall(6, 1000)
                val httpClient = ClientFactory.createClient(mockEngine).httpClient
                mockkObject(AuthenticationPlugin)

                val configs = getAuthenticationConfiguration()
                httpClient.request {
                    method = HttpMethod.Post
                    url(configs.authUrl)
                }

                coVerify(exactly = 0) {
                    AuthenticationPlugin.renewToken(httpClient, any())
                }
            }
        }

        @Test
        fun `given multiple requests when token expired then no requests should be unauthorized`() {
            runBlocking {
                mockkObject(AuthenticationPlugin)
                val httpClient = ClientFactory.createClient().httpClient

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
                    AuthenticationPlugin.renewToken(httpClient, any())
                }
            }
        }

        private suspend fun renewToken(httpClient: HttpClient) {
            AuthenticationPlugin.renewToken(httpClient, getAuthenticationConfiguration())
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
