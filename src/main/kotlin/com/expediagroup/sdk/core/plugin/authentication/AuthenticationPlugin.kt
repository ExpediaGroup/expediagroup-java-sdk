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

import com.expediagroup.sdk.core.configuration.Credentials
import com.expediagroup.sdk.core.constant.Header
import com.expediagroup.sdk.core.constant.Message.UNABLE_TO_AUTHENTICATE
import com.expediagroup.sdk.core.model.exception.ClientException
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

internal object AuthenticationPlugin : Plugin<AuthenticationConfiguration> {
    private var bearerTokenStorage = BearerTokensInfo.emptyBearerTokenInfo
    override fun install(configurations: AuthenticationConfiguration) {
        configurations.httpClientConfiguration.install(Auth) {
            bearer {
                loadTokens {
                    bearerTokenStorage.bearerTokens
                }
                // Auth is always needed to request a token except for identity
                sendWithoutRequest { request ->
                    isNotIdentityRequest(request, configurations)
                }
            }
        }
    }

    fun isNotIdentityRequest(
        request: HttpRequestBuilder,
        configs: AuthenticationConfiguration
    ): Boolean =
        request.url.buildString() != configs.authUrl

    suspend fun renewToken(client: HttpClient, configs: AuthenticationConfiguration) {
        clearTokens(client)
        val renewTokenResponse = client.request {
            method = HttpMethod.Post
            url(configs.authUrl)
            buildTokenRequest()
            basicAuth(configs.credentials)
        }
        if (renewTokenResponse.status != HttpStatusCode.OK) {
            throw ClientException(
                renewTokenResponse.status,
                UNABLE_TO_AUTHENTICATE
            )
        }
        val renewedTokenInfo: TokenResponse = renewTokenResponse.body()
        bearerTokenStorage = BearerTokensInfo(
            BearerTokens(renewedTokenInfo.accessToken, renewedTokenInfo.accessToken),
            renewedTokenInfo.expiresIn
        )
        bearerTokenStorage
    }

    private fun clearTokens(client: HttpClient) {
        client.plugin(Auth).providers.filterIsInstance<BearerAuthProvider>().first().clearToken()
        bearerTokenStorage = BearerTokensInfo.emptyBearerTokenInfo
    }

    fun getToken(): BearerTokens {
        return bearerTokenStorage.bearerTokens
    }

    private fun HttpRequestBuilder.basicAuth(credentials: Credentials) {
        basicAuth(
            credentials.key,
            credentials.secret
        )
    }

    private fun buildTokenRequest(): Parameters {
        return Parameters.build {
            append(Header.GRANT_TYPE, Header.CLIENT_CREDENTIALS)
        }
    }

    fun isTokenAboutToExpire() = bearerTokenStorage.isAboutToExpire()
}
