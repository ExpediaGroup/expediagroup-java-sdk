package com.expediagroup.sdk.core.logging.masking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class MaskingRegexFactoryTest {
    @Test
    fun `createRegexFor should create pattern that matches specified fields in JSON`() {
        // Given
        val fields = setOf("apiKey", "password")
        val json = """{"username":"john", "apiKey":"secret123", "email":"john@example.com", "password":"p@ssw0rd"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[1] }.toList()
        assertEquals(2, matches.size)
        assertTrue(matches.contains("apiKey"))
        assertTrue(matches.contains("password"))
    }

    @Test
    fun `createRegexFor should match fields with custom value pattern`() {
        // Given
        val fields = setOf("email")
        val customPattern = "[^\"]+@[^\"]+\\.[^\"]+" // Simple email pattern
        val json = """{"username":"john", "email":"john@example.com"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields, customPattern)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[0] }.toList()
        assertEquals(1, matches.size)
        assertTrue(matches[0].contains("john@example.com"))
    }

    @Test
    fun `createRegexFor should handle escaped quotes in JSON`() {
        // Given
        val fields = setOf("message")
        val json = """{"message":"This is a \"quoted\" message"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[1] }.toList()
        assertEquals(1, matches.size)
        assertEquals("message", matches[0])
    }

    @Test
    fun `createRegexFor should handle whitespace in JSON`() {
        // Given
        val fields = setOf("apiKey")
        val json = """{"apiKey"   :   "secret123"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[0] }.toList()
        assertEquals(1, matches.size)
        assertTrue(matches[0].contains("secret123"))
    }

    @Test
    fun `createRegexFor should throw exception for invalid field names`() {
        // Given
        val invalidFields = setOf("valid-name", "invalid.name")

        // When/Then
        val exception =
            assertThrows<IllegalArgumentException> {
                MaskingRegexFactory.createRegexFor(invalidFields)
            }

        assertTrue(exception.message!!.contains("Invalid field name"))
    }

    @Test
    fun `createRegexFor should validate all field names`() {
        // Given - multiple sets of field names to test validation behavior

        // Valid field names
        val validFields = setOf("apiKey", "user_name", "password123", "api-key")

        // Should not throw exception
        assertDoesNotThrow {
            MaskingRegexFactory.createRegexFor(validFields)
        }

        // Testing each invalid field individually
        val invalidFieldNames = listOf("api.key", "user name", "password#123", "api:key")

        for (invalidField in invalidFieldNames) {
            val fieldsWithOneInvalid = setOf("valid_field", invalidField)

            // Should throw exception
            val exception =
                assertThrows<IllegalArgumentException> {
                    MaskingRegexFactory.createRegexFor(fieldsWithOneInvalid)
                }

            assertTrue(exception.message!!.contains("Invalid field name"))
        }
    }

    @Test
    fun `createRegexFor should match fields at different positions in JSON`() {
        // Given
        val fields = setOf("first", "middle", "last")
        val json =
            """{"first":"value1", "other":"something", "middle":"value2", "another":"something else", "last":"value3"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[1] }.toList()
        assertEquals(3, matches.size)
        assertTrue(matches.containsAll(listOf("first", "middle", "last")))
    }

    @Test
    fun `createRegexFor should work with empty fields set`() {
        // Given
        val fields = emptySet<String>()
        val json = """{"username":"john", "password":"secret"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).toList()
        assertTrue(matches.isEmpty())
    }

    @Test
    fun `createRegexFor should match multi-word values in JSON`() {
        // Given
        val fields = setOf("description")
        val json = """{"id":123, "description":"This is a longer description with multiple words"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[0] }.toList()
        assertEquals(1, matches.size)
        assertTrue(matches[0].contains("This is a longer description with multiple words"))
    }

    @Test
    fun `createRegexFor should match numeric values in JSON`() {
        // Given
        val fields = setOf("amount")
        val json = """{"id":123, "amount":"1000.50"}"""

        // When
        val regex = MaskingRegexFactory.createRegexFor(fields)

        // Then
        val matches = regex.findAll(json).map { it.groupValues[0] }.toList()
        assertEquals(1, matches.size)
        assertTrue(matches[0].contains("1000.50"))
    }
}
