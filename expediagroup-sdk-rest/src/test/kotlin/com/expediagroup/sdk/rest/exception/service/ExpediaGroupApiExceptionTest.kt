package com.expediagroup.sdk.rest.exception.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class ExpediaGroupApiExceptionTest {
    @Test
    fun `creates exception from passed params`() {
        val requestId = UUID.randomUUID()
        val message = "test message"
        val cause = RuntimeException("test cause")

        val exception = ExpediaGroupApiException(code = 500, requestId = requestId, message = message, cause = cause)

        assertEquals(500, exception.code)
        assertEquals(requestId, exception.requestId)
        assertEquals(message, exception.message)
        assertEquals(cause, exception.cause)
    }

    @Test
    fun `creates exception without message and cause`() {
        val requestId = UUID.randomUUID()
        val exception = ExpediaGroupApiException(code = 500, requestId = requestId)

        assertEquals(500, exception.code)
        assertEquals(requestId, exception.requestId)
        assertEquals(null, exception.message)
        assertEquals(null, exception.cause)
    }
}
