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

import com.expediagroup.sdk.core.plugin.Plugin
import com.expediagroup.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.request.HttpRequestBuilder

internal object AuthenticationPlugin : Plugin<AuthenticationConfiguration> {
    @Suppress("LateinitUsage")
    private lateinit var strategy: AuthenticationStrategy

    override fun install(configurations: AuthenticationConfiguration) {
        strategy = AuthenticationStrategy.from(configurations.authType)
        configurations.httpClientConfiguration.install(Auth) {
            strategy.loadAuth(configurations, this)
        }
    }

    fun isNotIdentityRequest(request: HttpRequestBuilder, configs: AuthenticationConfiguration): Boolean = strategy.isNotIdentityRequest(request, configs)

    suspend fun renewToken(client: HttpClient, configs: AuthenticationConfiguration) = strategy.renewToken(client, configs)

    fun isTokenAboutToExpire(): Boolean = strategy.isTokenAboutToExpire()
    fun getAuthorizationHeader(): String = strategy.getAuthorizationHeader()
}
