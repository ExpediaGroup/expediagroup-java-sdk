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
package com.expediagroup.sdk.core.plugin.authentication.strategies.signature

import com.expediagroup.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.sdk.core.plugin.authentication.strategies.AuthenticationStrategy
import com.expediagroup.sdk.core.plugin.authentication.strategies.signature.SignatureAuthProvider.Companion.createAuthorizationHeader
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.request.HttpRequestBuilder
import java.time.Instant

internal object SignatureStrategy : AuthenticationStrategy {
    private var signatureHolder: SignatureHolder = SignatureHolder.emptySignatureHolder
    private val loadSignatureBlock: () -> String? = {
        getSignature()
    }

    override fun loadAuth(configurations: AuthenticationConfiguration, auth: Auth) {
        auth.signature {
            loadSignature(loadSignatureBlock)
        }
    }

    override fun isTokenAboutToExpire() = signatureHolder.isAboutToExpire()

    override suspend fun renewToken(client: HttpClient, configs: AuthenticationConfiguration) {
        val now = Instant.now()
        val credentials = configs.credentials
        val signature = calculateSignature(credentials.key, credentials.secret, now.epochSecond)
        signatureHolder = SignatureHolder(signature, now)
    }

    override fun isNotIdentityRequest(request: HttpRequestBuilder, configs: AuthenticationConfiguration) = true

    override fun getAuthorizationHeader() = createAuthorizationHeader(getSignature())

    private fun getSignature() = signatureHolder.signature
}
