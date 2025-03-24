package com.expediagroup.sdk.core.authentication.common

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.ISO_8859_1
import java.util.Base64

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
fun encodeBasic(
    username: String,
    password: String,
    charset: Charset = ISO_8859_1
): String {
    val keyAndSecret = "$username:$password"
    val bytes = keyAndSecret.toByteArray(charset)
    val encoded = Base64.getEncoder().encodeToString(bytes)
    return "Basic $encoded"
}
