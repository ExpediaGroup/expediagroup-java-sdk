package com.expediagroup.sdk.rest.exception.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PropertyConstraintViolationExceptionTest {
    @Test
    fun `formats error message with multiple constraint violations`() {
        val violations = listOf("Field A must not be null", "Field B must be a positive number")
        val exception = PropertyConstraintViolationException(constraintViolations = violations)

        assertEquals(
            "Some field constraints have been violated [\n\t- Field A must not be null,\n\t- Field B must be a positive number\n]",
            exception.message
        )
    }

    @Test
    fun `formats error message with empty constraint violations list`() {
        val violations = emptyList<String>()
        val exception = PropertyConstraintViolationException(constraintViolations = violations)

        assertEquals(
            "Some field constraints have been violated [\n\t- \n]",
            exception.message
        )
    }

    @Test
    fun `formats error message with custom message and constraints`() {
        val violations = listOf("Field A must not be null")
        val customMessage = "Custom error message"
        val exception = PropertyConstraintViolationException(message = customMessage, constraintViolations = violations)

        assertEquals(
            "Custom error message [\n\t- Field A must not be null\n]",
            exception.message
        )
    }
}
