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
package com.expediagroup.sdk.core.plugin.authentication.strategy.signature

import com.expediagroup.sdk.core.constant.Authentication
import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import java.time.Instant

internal class SignatureStrategy : AuthenticationStrategy {
    private var signature: String = Constant.EMPTY_STRING
    override fun isTokenAboutToExpire(): Boolean = true

    override suspend fun renewToken(client: HttpClient, configs: AuthenticationConfiguration) {
        val credentials = configs.credentials
        signature = calculateSignature(credentials.key, credentials.secret, Instant.now().epochSecond)
    }

    override fun isNotIdentityRequest(request: HttpRequestBuilder, configs: AuthenticationConfiguration) = true

    override fun getAuthorizationHeader() = createAuthorizationHeader(signature)

    private fun createAuthorizationHeader(signature: String?): String = "${Authentication.EAN} $signature"
}
