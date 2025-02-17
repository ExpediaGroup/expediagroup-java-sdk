package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProtocolTest {
    @Test
    fun `should return correct string representation for each Protocol`() {
        assertEquals("http/1.0", Protocol.HTTP_1_0.toString())
        assertEquals("http/1.1", Protocol.HTTP_1_1.toString())
        assertEquals("http/2", Protocol.HTTP_2.toString())
        assertEquals("h2_prior_knowledge", Protocol.H2_PRIOR_KNOWLEDGE.toString())
        assertEquals("quic", Protocol.QUIC.toString())
    }

    @Test
    fun `should return correct Protocol for valid strings`() {
        assertEquals(Protocol.HTTP_1_0, Protocol.get("HTTP/1.0"))
        assertEquals(Protocol.HTTP_1_1, Protocol.get("HTTP/1.1"))
        assertEquals(Protocol.HTTP_2, Protocol.get("HTTP/2"))
        assertEquals(Protocol.HTTP_2, Protocol.get("HTTP/2.0"))
        assertEquals(Protocol.H2_PRIOR_KNOWLEDGE, Protocol.get("H2_PRIOR_KNOWLEDGE"))
        assertEquals(Protocol.QUIC, Protocol.get("QUIC"))
    }

    @Test
    fun `should throw IllegalArgumentException for invalid protocol strings`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Protocol.get("INVALID_PROTOCOL")
            }
        assertEquals("Unexpected protocol: INVALID_PROTOCOL", exception.message)
    }

    @Test
    fun `should ignore case when parsing protocol strings`() {
        assertEquals(Protocol.HTTP_1_0, Protocol.get("http/1.0"))
        assertEquals(Protocol.HTTP_2, Protocol.get("HTTP/2.0"))
        assertEquals(Protocol.QUIC, Protocol.get("quic"))
        assertEquals(Protocol.H2_PRIOR_KNOWLEDGE, Protocol.get("H2_prior_knowledge"))
    }
}
