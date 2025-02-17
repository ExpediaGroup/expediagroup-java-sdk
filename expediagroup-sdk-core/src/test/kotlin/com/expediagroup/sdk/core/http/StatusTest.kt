package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StatusTest {
    @Test
    fun `should return correct Status for valid codes`() {
        // Informational responses
        assertEquals(Status.CONTINUE, Status.fromCode(100))
        assertEquals(Status.SWITCHING_PROTOCOLS, Status.fromCode(101))
        assertEquals(Status.PROCESSING, Status.fromCode(102))
        assertEquals(Status.EARLY_HINTS, Status.fromCode(103))

        // Successful responses
        assertEquals(Status.OK, Status.fromCode(200))
        assertEquals(Status.CREATED, Status.fromCode(201))
        assertEquals(Status.ACCEPTED, Status.fromCode(202))
        assertEquals(Status.NO_CONTENT, Status.fromCode(204))

        // Redirection messages
        assertEquals(Status.MOVED_PERMANENTLY, Status.fromCode(301))
        assertEquals(Status.FOUND, Status.fromCode(302))
        assertEquals(Status.SEE_OTHER, Status.fromCode(303))
        assertEquals(Status.NOT_MODIFIED, Status.fromCode(304))
        assertEquals(Status.TEMPORARY_REDIRECT, Status.fromCode(307))

        // Client error responses
        assertEquals(Status.BAD_REQUEST, Status.fromCode(400))
        assertEquals(Status.UNAUTHORIZED, Status.fromCode(401))
        assertEquals(Status.FORBIDDEN, Status.fromCode(403))
        assertEquals(Status.NOT_FOUND, Status.fromCode(404))
        assertEquals(Status.METHOD_NOT_ALLOWED, Status.fromCode(405))

        // Server error responses
        assertEquals(Status.INTERNAL_SERVER_ERROR, Status.fromCode(500))
        assertEquals(Status.NOT_IMPLEMENTED, Status.fromCode(501))
        assertEquals(Status.BAD_GATEWAY, Status.fromCode(502))
        assertEquals(Status.SERVICE_UNAVAILABLE, Status.fromCode(503))
        assertEquals(Status.GATEWAY_TIMEOUT, Status.fromCode(504))

        // Non-standard status codes
        assertEquals(Status.THIS_IS_FINE, Status.fromCode(218))
    }

    @Test
    fun `should throw IllegalArgumentException for invalid codes`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Status.fromCode(999)
            }
        assertEquals("Invalid status code: 999", exception.message)
    }

    @Test
    fun `should match all enum entries with their codes`() {
        Status.entries.forEach { status ->
            assertEquals(status, Status.fromCode(status.code))
        }
    }
}
