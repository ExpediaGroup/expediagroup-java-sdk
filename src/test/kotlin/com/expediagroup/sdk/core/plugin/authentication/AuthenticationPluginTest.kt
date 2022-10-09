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
import com.expediagroup.sdk.core.commons.TestConstants.ACCESS_TOKEN
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.configuration.Credentials
import com.expediagroup.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.sdk.core.model.exception.ClientException
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.request
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.mockkObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

internal class AuthenticationPluginTest {

    @BeforeEach
    internal fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    internal fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `making any http call should invoke the authorized token`(): Unit = runBlocking {
        val httpClient = ClientFactory.createClient().httpClient
        val testRequest = httpClient.get("http://any-url")

        assertThat(testRequest.request.headers["Authorization"]).isEqualTo(
            "Bearer $ACCESS_TOKEN"
        )

        clearAuthorizationTokens(httpClient)
    }

    @Test
    fun `refresh auth token should throw client exception if the the credentials are invalid`(): Unit =
        runBlocking {
            val httpClient = ClientFactory.createClient().httpClient

            assertThrows<ClientException> {
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

            clearAuthorizationTokens(httpClient)
        }

    @Test
    fun `make parallel should run the single refresh token only`(): Unit =
        runBlocking {
            mockkObject(AuthenticationPlugin)
            val httpClient = ClientFactory.createClient().httpClient
            clearAuthorizationTokens(httpClient)

            println(AuthenticationPlugin.getToken().accessToken)
            launch {
                httpClient.get("http://any-url")
            }
            launch {
                httpClient.get("http://any-url")
            }

            delay(1000)
            coVerify(exactly = 1) {
                AuthenticationPlugin.renewToken(httpClient, any())
            }

            clearAuthorizationTokens(httpClient)
        }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun `given request when token almost or is expired then should renew token`(expiresIn: Int): Unit = runBlocking {
        val mockEngine = createMockEngineExpiresInPerCall(expiresIn, 1000)
        val httpClient = ClientFactory.createClient(mockEngine).httpClient
        renewToken(httpClient)

        mockkObject(AuthenticationPlugin)
        httpClient.get("http://any-url-test")

        coVerify(exactly = 1) {
            AuthenticationPlugin.renewToken(httpClient, any())
        }

        clearAuthorizationTokens(httpClient)
    }

    @Test
    fun `given request when token not almost and not expired then should not renew token`(): Unit = runBlocking {
        val mockEngine = createMockEngineExpiresInPerCall(1000)
        val httpClient = ClientFactory.createClient(mockEngine).httpClient
        renewToken(httpClient)

        mockkObject(AuthenticationPlugin)
        httpClient.get("http://any-url")

        coVerify(exactly = 0) {
            AuthenticationPlugin.renewToken(httpClient, any())
        }

        clearAuthorizationTokens(httpClient)
    }

    @Test
    fun `given identity request when token almost expired then should not renew token`(): Unit = runBlocking {
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

        clearAuthorizationTokens(httpClient)
    }

    @Test
    fun `given multiple requests when token expired then no requests should be unauthorized`(): Unit = runBlocking {
        mockkObject(AuthenticationPlugin)
        val httpClient = ClientFactory.createClient().httpClient

        launch {
            val request = httpClient.get("http://any-url")
            assertThat(request.status != HttpStatusCode.Unauthorized)
        }
        launch {
            val request = httpClient.get("http://any-url")
            assertThat(request.status != HttpStatusCode.Unauthorized)
        }
        launch {
            val request = httpClient.get("http://any-url")
            assertThat(request.status != HttpStatusCode.Unauthorized)
        }

        delay(1000)
        coVerify(exactly = 1) {
            AuthenticationPlugin.renewToken(httpClient, any())
        }

        clearAuthorizationTokens(httpClient)
    }

    /*
    * AuthorizationTokens need to be cleared after each test due to problems with clearing mocked Singletons
    * https://stackoverflow.com/a/28028662
    * */
    private fun clearAuthorizationTokens(client: HttpClient) = AuthenticationPlugin::class.declaredMemberFunctions
        .firstOrNull { it.name == "clearTokens" }
        ?.apply { isAccessible = true }
        ?.call(AuthenticationPlugin, client)

    private fun MockRequestHandleScope.createTokenResponse(expiresIn: Int) = respond(
        content = ByteReadChannel(
            """
                    {
                        "access_token": $ACCESS_TOKEN,
                        "token_type": "bearer",
                        "expires_in": $expiresIn,
                        "scope": "any-scope"
                    }
                    """
        ),
        status = HttpStatusCode.OK,
        headers = headersOf(HttpHeaders.ContentType, "application/json")
    )

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

    private fun createMockEngineExpiresInPerCall(vararg expiresIn: Int): MockEngine {
        var timesCalled = -1
        val mockEngine = MockEngine {
            timesCalled++
            if (timesCalled in expiresIn.indices) {
                createTokenResponse(expiresIn[timesCalled])
            } else {
                createTokenResponse(1000)
            }
        }
        return mockEngine
    }
}
