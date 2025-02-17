package com.expediagroup.sdk.core.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ExtensionsTest {
    @Test
    fun `getOrThrow should return value when not null`() {
        // Given
        val value = "Hello, World!"

        // When
        val result = value.getOrThrow { IllegalStateException("Value should not be null") }

        // Expect
        assertEquals("Hello, World!", result)
    }

    @Test
    fun `getOrThrow should throw exception when value is null`() {
        // Given
        val value: String? = null

        // When & Expect
        val exception =
            assertThrows(IllegalStateException::class.java) {
                value.getOrThrow { IllegalStateException("Value should not be null") }
            }

        assertEquals("Value should not be null", exception.message)
    }
}
