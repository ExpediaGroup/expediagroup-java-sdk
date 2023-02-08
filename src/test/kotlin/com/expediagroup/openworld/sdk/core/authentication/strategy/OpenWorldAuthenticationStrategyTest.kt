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
package com.expediagroup.openworld.sdk.core.authentication.strategy

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.configuration.Credentials
import com.expediagroup.common.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.common.sdk.core.constant.Authentication.BEARER
import com.expediagroup.common.sdk.core.constant.ExceptionMessage
import com.expediagroup.common.sdk.core.constant.HeaderKey
import com.expediagroup.common.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.common.sdk.core.plugin.authentication.AuthenticationPluginTest
import com.expediagroup.common.sdk.core.plugin.authentication.getAuthenticationStrategy
import com.expediagroup.common.sdk.core.plugin.authentication.helper.SuccessfulStatusCodesArgumentProvider
import com.expediagroup.common.sdk.core.plugin.authentication.helper.UnsuccessfulStatusCodesArgumentProvider
import com.expediagroup.common.sdk.core.test.ClientFactory
import com.expediagroup.common.sdk.core.test.MockEngineFactory.createMockEngineExpiresInPerCall
import com.expediagroup.common.sdk.core.test.MockEngineFactory.createTokenMockEngineWithStatusCode
import com.expediagroup.common.sdk.core.test.MockEngineFactory.createUnauthorizedMockEngineWithStatusCode
import com.expediagroup.common.sdk.core.test.TestConstants.ACCESS_TOKEN
import com.expediagroup.common.sdk.core.test.TestConstants.ANY_URL
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldAuthException
import io.ktor.client.HttpClientConfig
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.request
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource

internal class OpenWorldAuthenticationStrategyTest : AuthenticationPluginTest() {

    @Test
    fun `making any http call should invoke the authorized token`() {
        runBlocking {
            val httpClient = ClientFactory.createOpenWorldClient().httpClient
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
            val configuration = OpenWorldClientConfiguration(
                key = CLIENT_KEY_TEST_CREDENTIAL + "invalid",
                secret = CLIENT_SECRET_TEST_CREDENTIAL + "invalid",
                endpoint = DefaultConfigurationProvider.endpoint,
                authEndpoint = DefaultConfigurationProvider.authEndpoint
            )
            val client = ClientFactory.createOpenWorldClient(
                createUnauthorizedMockEngineWithStatusCode(httpStatusCode),
                configuration
            )
            val authentication = client.getAuthenticationStrategy()

            val exception = assertThrows<OpenWorldAuthException> {
                authentication.renewToken()
            }
            assertThat(exception.message).isEqualTo("[${httpStatusCode.value}] ${ExceptionMessage.AUTHENTICATION_FAILURE}")
            assertThat(exception.cause).isNull()
        }
    }

    @ParameterizedTest
    @ArgumentsSource(SuccessfulStatusCodesArgumentProvider::class)
    fun `refresh auth token should not throw client exception if the the credentials are valid`(httpStatusCode: HttpStatusCode) {
        runBlocking {
            val client = ClientFactory.createOpenWorldClient(createTokenMockEngineWithStatusCode(httpStatusCode), ClientFactory.openWorldConfiguration)
            val authentication = client.getAuthenticationStrategy()

            assertDoesNotThrow {
                authentication.renewToken()
            }
        }
    }

    @Test
    fun `make parallel should run the single refresh token only`() {
        runBlocking {
            val client = ClientFactory.createOpenWorldClient()
            val httpClient = client.httpClient
            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)

            launch {
                httpClient.get(ANY_URL)
            }
            launch {
                httpClient.get(ANY_URL)
            }

            delay(1000)
            verify(exactly = 1) {
                authentication.renewToken()
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun `given request when token almost or is expired then should renew token`(expiresIn: Int) {
        runBlocking {
            val mockEngine = createMockEngineExpiresInPerCall(expiresIn, 1000)
            val client = ClientFactory.createOpenWorldClient(mockEngine)
            val httpClient = client.httpClient
            renewToken(client)

            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)
            httpClient.get(ANY_URL)

            verify(exactly = 1) {
                authentication.renewToken()
            }
        }
    }

    @Test
    fun `given request when token not almost and not expired then should not renew token`() {
        runBlocking {
            val mockEngine = createMockEngineExpiresInPerCall(1000)
            val client = ClientFactory.createOpenWorldClient(mockEngine)
            val httpClient = client.httpClient
            renewToken(client)

            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)
            httpClient.get(ANY_URL)

            verify(exactly = 0) {
                authentication.renewToken()
            }
        }
    }

    @Test
    fun `given identity request when token almost expired then should not renew token`() {
        runBlocking {
            val mockEngine = createMockEngineExpiresInPerCall(6, 1000)
            val client = ClientFactory.createOpenWorldClient(mockEngine)
            val httpClient = client.httpClient
            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)

            val configs = getAuthenticationConfiguration()
            httpClient.request {
                method = HttpMethod.Post
                url(configs.authUrl)
            }

            verify(exactly = 0) {
                authentication.renewToken()
            }
        }
    }

    @Test
    fun `given multiple requests when token expired then no requests should be unauthorized`() {
        runBlocking {
            val client = ClientFactory.createOpenWorldClient()
            val httpClient = client.httpClient
            val authentication = client.getAuthenticationStrategy()

            mockkObject(authentication)

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
            verify(exactly = 1) {
                authentication.renewToken()
            }
        }
    }

    private fun <T : Client> renewToken(client: T) = client.getAuthenticationStrategy().renewToken()

    private fun getAuthenticationConfiguration() = AuthenticationConfiguration.from(
        HttpClientConfig(),
        Credentials(
            CLIENT_KEY_TEST_CREDENTIAL,
            CLIENT_SECRET_TEST_CREDENTIAL
        ),
        DefaultConfigurationProvider.authEndpoint
    )
}
