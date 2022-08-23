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

import com.expediagroup.sdk.core.config.ClientConfiguration
import com.expediagroup.sdk.core.config.ClientCredentials
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_CREDENTIALS_HEADER
import com.expediagroup.sdk.core.constants.ClientConstants.GRANT_TYPE_HEADER
import com.expediagroup.sdk.core.constants.MessagesConstants.UNABLE_TO_AUTHENTICATE
import com.expediagroup.sdk.core.exceptions.ClientException
import com.expediagroup.sdk.core.plugin.Plugin
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerAuthProvider
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.basicAuth
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters

object AuthenticationPlugin : Plugin<AuthenticationConfigs> {
    private var bearerTokenStorage = BearerTokens("", "")
    override fun install(configs: AuthenticationConfigs) {
        configs.httpClientConfig.install(Auth) {
            bearer {
                loadTokens {
                    bearerTokenStorage
                }
                // Auth is always needed to request a token except for identity
                sendWithoutRequest { request ->
                    isIdentityRequest(request, configs)
                }
            }
        }
    }

    fun isIdentityRequest(
        request: HttpRequestBuilder,
        configs: AuthenticationConfigs
    ): Boolean =
        request.url.buildString() != configs.identityUrl

    suspend fun refreshToken(client: HttpClient, configs: AuthenticationConfigs) {
        clearTokens(client)
        val refreshTokenResponse = client.request {
            method = HttpMethod.Post
            url(configs.identityUrl)
            buildTokenRequest()
            basicAuth(configs.clientConfiguration)
        }
        if (refreshTokenResponse.status != HttpStatusCode.OK) {
            throw ClientException(
                refreshTokenResponse.status,
                UNABLE_TO_AUTHENTICATE
            )
        }
        val refreshTokenInfo: TokenResponse = refreshTokenResponse.body()
        bearerTokenStorage = BearerTokens(refreshTokenInfo.accessToken, refreshTokenInfo.accessToken)
        bearerTokenStorage
    }

    private fun clearTokens(client: HttpClient) {
        client.plugin(Auth).providers.filterIsInstance<BearerAuthProvider>().first().clearToken()
        bearerTokenStorage = BearerTokens("", "")
    }

    fun getToken(): BearerTokens {
        return bearerTokenStorage
    }

    private fun HttpRequestBuilder.basicAuth(configs: ClientConfiguration) {
        basicAuth(
            (configs.auth as ClientCredentials).clientId,
            configs.auth.clientSecret
        )
    }

    private fun buildTokenRequest(): Parameters {
        return Parameters.build {
            append(GRANT_TYPE_HEADER, CLIENT_CREDENTIALS_HEADER)
        }
    }
}
