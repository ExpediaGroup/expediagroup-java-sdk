package com.expediagroup.sdk.core.authentication.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Base64

class CredentialsTest {
    @Test
    fun `toString should not print secret`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)

        assertFalse(credentials.toString().contains("secret"))
        assertFalse(credentials.toString().contains(secret))
    }

    @Test
    fun `toString should print key=$value`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)
        assertTrue(credentials.toString().contains("key=username"))
    }

    @Test
    fun `encodeBasic result should be prefixed with Basic`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)
        assertTrue(credentials.encodeBasic().startsWith("Basic"))
    }

    @Test
    fun `encodeBasic result should contain only one space`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)
        assertEquals(1, credentials.encodeBasic().count { it == ' ' })
    }

    @Test
    fun `encodeBasic result should encode to base64`() {
        val key = "username"
        val secret = "password"
        val iso8859DecodedCredentials = "$key:$secret"
        val iso8859EncodedCredentials = "Basic ${Base64.getEncoder().encodeToString(iso8859DecodedCredentials.toByteArray())}"

        val encoded = Credentials(key = key, secret = secret).encodeBasic()
        assertEquals(encoded, iso8859EncodedCredentials)
    }

    @Test
    fun `encodeBasic result should decode to key double-colon value`() {
        val key = "username"
        val secret = "password"
        val iso8859DecodedCredentials = "$key:$secret"
        val iso8859EncodedCredentials = "Basic ${Base64.getEncoder().encodeToString(iso8859DecodedCredentials.toByteArray())}"

        val encoded = Credentials(key = key, secret = secret).encodeBasic()
        assertEquals(encoded, iso8859EncodedCredentials)
    }

    @Test
    fun `encodeBasic should handle empty key and secret`() {
        val credentials = Credentials(key = "", secret = "")
        val expected = "Basic ${Base64.getEncoder().encodeToString(":".toByteArray(Charsets.ISO_8859_1))}"

        assertEquals(expected, credentials.encodeBasic())
    }

    @Test
    fun `encodeBasic should handle special characters in key and secret`() {
        val specialKey = "user!@#"
        val specialSecret = "pass$%^"

        val credentials = Credentials(key = specialKey, secret = specialSecret)
        val expected =
            "Basic ${Base64.getEncoder().encodeToString("$specialKey:$specialSecret".toByteArray(Charsets.ISO_8859_1))}"

        assertEquals(expected, credentials.encodeBasic())
    }

    @Test
    fun `encodeBasic should handle non-ISO_8859_1 charset`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)
        val expected = "Basic ${Base64.getEncoder().encodeToString("$key:$secret".toByteArray(Charsets.UTF_8))}"

        assertEquals(expected, credentials.encodeBasic(Charsets.UTF_8))
    }

    @Test
    fun `encodeBasic should use ISO_8859_1 as default charset`() {
        val key = "username"
        val secret = "password"

        val credentials = Credentials(key = key, secret = secret)
        val expected = "Basic ${Base64.getEncoder().encodeToString("$key:$secret".toByteArray(Charsets.ISO_8859_1))}"

        assertEquals(expected, credentials.encodeBasic())
    }
}
