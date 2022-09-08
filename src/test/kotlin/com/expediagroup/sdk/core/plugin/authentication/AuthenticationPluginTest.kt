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
import com.expediagroup.sdk.core.config.Credentials
import com.expediagroup.sdk.core.constants.ClientConstants.DEFAULT_AUTH_ENDPOINT
import com.expediagroup.sdk.core.exceptions.ClientException
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.mockk.coVerify
import io.mockk.mockkObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

internal class AuthenticationPluginTest {

    @Test
    fun `making any http call should invoke the authorized token`(): Unit = runBlocking {
        val httpClient = ClientFactory.createClient().httpClient
        val testRequest = httpClient.get("http://any-url")

        assertThat(testRequest.request.headers["Authorization"]).isEqualTo(
            "Bearer $ACCESS_TOKEN"
        )
    }

    @Test
    fun `refresh auth token should throw client exception if the the credentials are invalid`(): Unit =
        runBlocking {
            val httpClient = ClientFactory.createClient().httpClient

            assertThrows<ClientException> {
                AuthenticationPlugin.refreshToken(
                    httpClient,
                    AuthenticationConfigs.from(
                        HttpClientConfig(),
                        Credentials(
                            CLIENT_KEY_TEST_CREDENTIAL + "invalid",
                            CLIENT_SECRET_TEST_CREDENTIAL + "invalid"
                        ),
                        DEFAULT_AUTH_ENDPOINT
                    )
                )
            }
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
                AuthenticationPlugin.refreshToken(httpClient, any())
            }
        }

    private fun clearAuthorizationTokens(client: HttpClient) = AuthenticationPlugin::class.declaredMemberFunctions
        .firstOrNull { it.name == "clearTokens" }
        ?.apply { isAccessible = true }
        ?.call(AuthenticationPlugin, client)
}
