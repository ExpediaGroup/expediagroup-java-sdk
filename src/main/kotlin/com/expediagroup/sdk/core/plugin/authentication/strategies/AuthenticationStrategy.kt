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
package com.expediagroup.sdk.core.plugin.authentication.strategies

import com.expediagroup.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.sdk.core.plugin.authentication.strategies.AuthenticationStrategy.AuthenticationType.BEARER
import com.expediagroup.sdk.core.plugin.authentication.strategies.AuthenticationStrategy.AuthenticationType.SIGNATURE
import com.expediagroup.sdk.core.plugin.authentication.strategies.bearer.BearerStrategy
import com.expediagroup.sdk.core.plugin.authentication.strategies.signature.SignatureStrategy
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.request.HttpRequestBuilder

internal interface AuthenticationStrategy {
    fun loadAuth(configurations: AuthenticationConfiguration, auth: Auth) {}

    fun isTokenAboutToExpire(): Boolean

    suspend fun renewToken(client: HttpClient, configs: AuthenticationConfiguration)

    fun isNotIdentityRequest(request: HttpRequestBuilder, configs: AuthenticationConfiguration): Boolean

    fun getAuthorizationHeader(): String

    companion object {
        fun from(authType: AuthenticationType): AuthenticationStrategy = when (authType) {
            BEARER -> BearerStrategy
            SIGNATURE -> SignatureStrategy
        }
    }

    enum class AuthenticationType {
        BEARER,
        SIGNATURE;

        companion object {
            fun from(isRapid: Boolean) = if (isRapid) SIGNATURE else BEARER
        }
    }
}
