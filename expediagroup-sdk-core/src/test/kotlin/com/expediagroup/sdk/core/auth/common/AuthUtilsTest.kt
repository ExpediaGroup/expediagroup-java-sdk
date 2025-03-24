package com.expediagroup.sdk.core.auth.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Base64

class AuthUtilsTest {
    @Test
    fun `encodeBasic result should be prefixed with Basic`() {
        val key = "username"
        val secret = "password"

        assertTrue(encodeBasic(key, secret).startsWith("Basic"))
    }

    @Test
    fun `encodeBasic result should encode to base64`() {
        val key = "username"
        val secret = "password"
        val iso8859DecodedCredentials = "$key:$secret"
        val iso8859EncodedCredentials = "Basic ${Base64.getEncoder().encodeToString(iso8859DecodedCredentials.toByteArray())}"

        val encoded = encodeBasic(key, secret)
        assertEquals(encoded, iso8859EncodedCredentials)
    }

    @Test
    fun `encodeBasic result should decode to key double-colon value`() {
        val key = "username"
        val secret = "password"
        val iso8859DecodedCredentials = "$key:$secret"
        val iso8859EncodedCredentials = "Basic ${Base64.getEncoder().encodeToString(iso8859DecodedCredentials.toByteArray())}"

        val encoded = encodeBasic(key, secret)
        assertEquals(encoded, iso8859EncodedCredentials)
    }

    @Test
    fun `encodeBasic should handle non-ISO_8859_1 charset`() {
        val key = "username"
        val secret = "password"

        val expected = "Basic ${Base64.getEncoder().encodeToString("$key:$secret".toByteArray(Charsets.UTF_8))}"

        assertEquals(expected, encodeBasic(key, secret, Charsets.UTF_8))
    }

    @Test
    fun `encodeBasic should use ISO_8859_1 as default charset`() {
        val key = "username"
        val secret = "password"

        val expected = "Basic ${Base64.getEncoder().encodeToString("$key:$secret".toByteArray(Charsets.ISO_8859_1))}"

        assertEquals(expected, encodeBasic(key, secret))
    }
}
