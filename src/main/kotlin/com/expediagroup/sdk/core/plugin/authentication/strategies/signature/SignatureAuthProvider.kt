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

import com.expediagroup.sdk.core.constant.Constant.EAN
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.AuthProvider
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.auth.HttpAuthHeader
import io.ktor.util.KtorDsl

internal fun Auth.signature(block: SignatureAuthConfig.() -> Unit) {
    with(SignatureAuthConfig().apply(block)) {
        this@signature.providers.add(SignatureAuthProvider(loadSignature))
    }
}

@KtorDsl
internal class SignatureAuthConfig {
    internal var loadSignature: suspend () -> String? = { null }

    fun loadSignature(block: suspend () -> String?) {
        loadSignature = block
    }
}

internal class SignatureAuthProvider(
    private val loadSignature: suspend () -> String?
) : AuthProvider {
    @Suppress("OverridingDeprecatedMember")
    @Deprecated("Please use sendWithoutRequest function instead", ReplaceWith("sendWithoutRequest function"))
    override val sendWithoutRequest: Boolean get() = error("Deprecated")

    override suspend fun addRequestHeaders(request: HttpRequestBuilder, authHeader: HttpAuthHeader?) {
        val signature = loadSignature.invoke()

        request.headers {
            if (contains(HttpHeaders.Authorization)) {
                remove(HttpHeaders.Authorization)
            }
            val authorizationHeader = createAuthorizationHeader(signature)
            append(HttpHeaders.Authorization, authorizationHeader)
        }
    }

    override fun isApplicable(auth: HttpAuthHeader): Boolean = auth.authScheme == EAN

    override fun sendWithoutRequest(request: HttpRequestBuilder): Boolean = false

    companion object {
        fun createAuthorizationHeader(signature: String?): String = "$EAN $signature"
    }
}
