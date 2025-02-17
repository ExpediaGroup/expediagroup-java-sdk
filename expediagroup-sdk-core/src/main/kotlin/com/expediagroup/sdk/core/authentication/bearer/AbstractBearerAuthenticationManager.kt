/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody

/**
 * Abstract class that contains common functionalities to store and renew bearer tokens.
 * This class does not handle the bearer token fetching or parsing. Subclasses have to implement the
 * [AuthenticationManager.authenticate] method where the token is fetched and parsed.
 */
abstract class AbstractBearerAuthenticationManager(
    private val authUrl: String,
    protected val credentials: Credentials
) : AuthenticationManager {
    @Volatile
    private var bearerTokenStorage = BearerTokenStorage.empty

    /**
     * Checks if the current bearer token is about to expire and needs renewal.
     *
     * @return `true` if the token is near expiration, `false` otherwise.
     */
    fun isTokenAboutToExpire(): Boolean = bearerTokenStorage.isAboutToExpire()

    /**
     * Clears the stored authentication token.
     *
     * This method resets the internal token storage, effectively invalidating the current session.
     */
    override fun clearAuthentication() {
        bearerTokenStorage = BearerTokenStorage.empty
    }

    /**
     * Retrieves the stored token formatted as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <token>` for use in HTTP headers.
     */
    fun getAuthorizationHeaderValue(): String = bearerTokenStorage.getAuthorizationHeaderValue()

    /**
     * Creates an HTTP request to fetch a new bearer token from the authentication server.
     *
     * @return A [Request] object configured with the necessary headers and parameters.
     */
    fun buildAuthenticationRequest(): Request {
        val body = RequestBody.create(mapOf("grant_type" to "client_credentials"))

        return Request
            .builder()
            .url(authUrl)
            .method(Method.POST)
            .body(body)
            .setHeader("Authorization", credentials.encodeBasic())
            .setHeader("Content-Type", CommonMediaTypes.APPLICATION_FORM_URLENCODED.toString())
            .build()
    }

    /**
     * Stores the retrieved token in internal storage for subsequent use.
     *
     * @param bearerTokenResponse The [BearerTokenResponse] containing the token and its expiration time.
     */
    fun storeToken(bearerTokenResponse: BearerTokenResponse) {
        bearerTokenStorage =
            BearerTokenStorage.create(
                accessToken = bearerTokenResponse.accessToken,
                expiresIn = bearerTokenResponse.expiresIn
            )
    }
}
