package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.logging.Constant
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaskJsonTest {
    @Test
    fun `invoke should mask single field in JSON`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret123"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
    }

    @Test
    fun `invoke should mask multiple fields in JSON`() {
        // Given
        val fields = setOf("password", "apiKey", "token")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret123", "apiKey":"key123", "email":"john@example.com", "token":"abc123"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"apiKey\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"token\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
        assertTrue(maskedJson.contains("\"email\":\"john@example.com\""))
    }

    @Test
    fun `invoke should handle empty fields set`() {
        // Given
        val fields = emptySet<String>()
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret123"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertEquals(json, maskedJson, "JSON should remain unchanged when no fields are specified")
    }

    @Test
    fun `invoke should handle empty JSON string`() {
        // Given
        val fields = setOf("password", "apiKey")
        val maskJson = MaskJson(fields)
        val json = ""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertEquals(json, maskedJson, "Empty JSON string should remain unchanged")
    }

    @Test
    fun `invoke should handle JSON with missing specified fields`() {
        // Given
        val fields = setOf("password", "apiKey")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "email":"john@example.com"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertEquals(json, maskedJson, "JSON should remain unchanged when specified fields are not present")
    }

    @Test
    fun `invoke should handle JSON with fields containing special characters in values`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret!@#$%^&*()"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
    }

    @Test
    fun `invoke should handle nested JSON objects`() {
        // Given
        val fields = setOf("password", "secret")
        val maskJson = MaskJson(fields)
        val json = """{"user":{"username":"john", "password":"secret123"}, "auth":{"secret":"key456"}}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"secret\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
    }

    @Test
    fun `invoke should be case-sensitive when masking fields`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret123", "Password":"DifferentSecret"}"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"Password\":\"DifferentSecret\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
    }

    @Test
    fun `invoke should handle JSON arrays`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val json = """[{"username":"john", "password":"secret1"}, {"username":"jane", "password":"secret2"}]"""

        // When
        val maskedJson = maskJson.invoke(json)

        // Then
        assertFalse(maskedJson.contains("\"password\":\"secret1\""))
        assertFalse(maskedJson.contains("\"password\":\"secret2\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
        assertTrue(maskedJson.contains("\"username\":\"jane\""))
        assertEquals(
            2,
            maskedJson.split(Constant.OMITTED).size - 1,
            "Both password fields should be masked"
        )
    }

    @Test
    fun `invoke should handle invalid JSON`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val invalidJson = "{username:john, password:secret123}" // Missing quotes

        // When
        val maskedJson = maskJson.invoke(invalidJson)

        // Then
        assertEquals(
            invalidJson,
            maskedJson,
            "Invalid JSON should remain unchanged as regex patterns expect valid JSON format"
        )
    }

    @Test
    fun `invoke can be used as a function reference`() {
        // Given
        val fields = setOf("password")
        val maskJson = MaskJson(fields)
        val json = """{"username":"john", "password":"secret123"}"""

        // When
        val maskerFunction: (String) -> String = maskJson
        val maskedJson = maskerFunction(json)

        // Then
        assertTrue(maskedJson.contains("\"password\":\"${Constant.OMITTED}\""))
        assertTrue(maskedJson.contains("\"username\":\"john\""))
    }
}
