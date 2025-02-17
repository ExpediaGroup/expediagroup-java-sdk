package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MethodTest {
    @Test
    fun `should return correct string representation`() {
        // Given
        val method = Method.GET

        // When
        val result = method.toString()

        // Expect
        assertEquals("GET", result)
    }

    @Test
    fun `should have correct mapping for all methods`() {
        // Given
        val expectedMethods =
            mapOf(
                Method.GET to "GET",
                Method.POST to "POST",
                Method.PUT to "PUT",
                Method.DELETE to "DELETE",
                Method.PATCH to "PATCH",
                Method.HEAD to "HEAD",
                Method.OPTIONS to "OPTIONS",
                Method.TRACE to "TRACE",
                Method.CONNECT to "CONNECT"
            )

        // When & Expect
        expectedMethods.forEach { (enum, stringValue) ->
            assertEquals(stringValue, enum.method)
            assertEquals(stringValue, enum.toString())
        }
    }

    @Test
    fun `should handle custom toString consistently`() {
        // Given
        val method = Method.POST

        // When
        val result = method.toString()

        // Expect
        assertEquals(method.method, result)
    }
}
