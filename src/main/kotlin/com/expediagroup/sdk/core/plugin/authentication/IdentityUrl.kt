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

object IdentityUrl {
    private const val IDENTITY_SUFFIX = "/identity/oauth2/v2/token"

    /**
     * Builds the identity URL for the given [baseUrl], removing any extra slashes.
     *
     * @param baseUrl The base URL of the service.
     * @return The identity URL.
     */
    fun from(baseUrl: String): String {
        return "$baseUrl$IDENTITY_SUFFIX".replace("(?<=[^:\\s])(\\/+\\/)", "/")
    }
}
