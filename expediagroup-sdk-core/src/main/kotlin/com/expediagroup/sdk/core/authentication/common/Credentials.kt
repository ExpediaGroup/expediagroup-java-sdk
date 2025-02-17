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

package com.expediagroup.sdk.core.authentication.common

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.ISO_8859_1
import java.util.Base64

/**
 * Represents a set of credentials consisting of a key and a secret.
 *
 * The `Credentials` class encapsulates authentication details required for accessing secure resources.
 * It provides functionality to encode the credentials into a `Basic` authentication header value.
 *
 * @param key The client key or username for authentication.
 * @param secret The client secret or password for authentication.
 */
data class Credentials(
    private val key: String,
    private val secret: String
) {
    /**
     * Encodes the credentials into a `Basic` authentication header value.
     *
     * This method combines the `key` and `secret` into a single string in the format `key:secret`,
     * encodes it using Base64, and prefixes it with `Basic`. The resulting string is suitable for use
     * in the `Authorization` header of HTTP requests.
     *
     * @param charset The character set to use for encoding the credentials. Defaults to [ISO_8859_1].
     * @return The `Basic` authentication header value as a string.
     */
    fun encodeBasic(charset: Charset = ISO_8859_1): String {
        val keyAndSecret = "$key:$secret"
        val bytes = keyAndSecret.toByteArray(charset)
        val encoded = Base64.getEncoder().encodeToString(bytes)
        return "Basic $encoded"
    }

    override fun toString(): String = "Credentials(key=$key)"
}
