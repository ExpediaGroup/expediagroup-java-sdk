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

package com.expediagroup.sdk.core.auth.basic

import com.expediagroup.sdk.core.auth.common.AuthManager
import com.expediagroup.sdk.core.auth.common.encodeBasic

/**
 * Manages Basic Authentication by encoding the given [BasicAuthCredentials] and providing
 * an authorization header value for requests.
 *
 * @property credentials The user's credentials that will be encoded for authentication.
 */
class BasicAuthManager(
    private val credentials: BasicAuthCredentials
) : AuthManager {
    /**
     * A cached version of the encoded credentials, or `null` if not yet encoded.
     */
    private var encodedCredentials: String? = null

    /**
     * Encodes the [credentials] into a Basic Authorization header if they have not already been encoded.
     * Calling this method multiple times will only encode once; subsequent calls will use the cached value.
     */
    override fun authenticate() {
        if (encodedCredentials == null) {
            encodeBasic(credentials.username, credentials.password).also { encodedCredentials = it }
        }
    }

    /**
     * Clears the cached encoded credentials, effectively removing any existing authentication state.
     */
    override fun clearAuthentication() {
        encodedCredentials = null
    }

    /**
     * Retrieves the current Basic Authorization header value.
     *
     * @return The Basic Authorization header value if authentication is set, or an empty string otherwise.
     */
    fun getAuthorizationHeaderValue(): String = encodedCredentials ?: ""
}
