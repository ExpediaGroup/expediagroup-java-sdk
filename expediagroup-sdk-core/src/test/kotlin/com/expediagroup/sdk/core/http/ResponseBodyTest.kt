package com.expediagroup.sdk.core.http

import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class ResponseBodyTest {
    @Test
    fun `should return correct media type when using input stream`() {
        // Given
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val responseBody = ResponseBody.create(ByteArrayInputStream("content".toByteArray()), mediaType)

        // When & Expect
        assertEquals(mediaType, responseBody.mediaType())
    }

    @Test
    fun `should return correct media type when using buffered source`() {
        // Given
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val responseBody = ResponseBody.create(Buffer().writeUtf8("content"), mediaType)

        // When & Expect
        assertEquals(mediaType, responseBody.mediaType())
    }

    @Test
    fun `should return null for unknown media type`() {
        // Given
        val responseBody = ResponseBody.create(ByteArrayInputStream("content".toByteArray()))

        // When & Expect
        assertNull(responseBody.mediaType())
    }

    @Test
    fun `should return correct content length when using input stream`() {
        // Given
        val content = "content"
        val responseBody =
            ResponseBody.create(
                ByteArrayInputStream(content.toByteArray()),
                contentLength = content.length.toLong()
            )

        // When & Expect
        assertEquals(content.length.toLong(), responseBody.contentLength())
    }

    @Test
    fun `should return correct content length when using buffered source`() {
        // Given
        val content = "content"
        val responseBody =
            ResponseBody.create(
                Buffer().writeUtf8("content"),
                contentLength = content.length.toLong()
            )

        // When & Expect
        assertEquals(content.length.toLong(), responseBody.contentLength())
    }

    @Test
    fun `should return -1 for unknown content length`() {
        // Given
        val responseBody = ResponseBody.create(ByteArrayInputStream("content".toByteArray()))

        // When & Expect
        assertEquals(-1, responseBody.contentLength())
    }

    @Test
    fun `should return the expected buffered source content when using input stream`() {
        // Given
        val content = "content"
        val responseBody = ResponseBody.create(ByteArrayInputStream(content.toByteArray()))

        // When
        val source = responseBody.source()

        // Expect
        assertEquals(content, source.readUtf8())
    }

    @Test
    fun `should return the expected buffered source content when using source`() {
        // Given
        val content = "content"
        val buffer = Buffer().writeUtf8(content)
        val responseBody = ResponseBody.create(buffer)

        // When
        val source = responseBody.source()

        // Expect
        assertEquals(content, source.readUtf8())
    }

    @Test
    fun `should return empty content after source is fully read`() {
        // Given
        val content = "Hello, world!"
        val responseBody = ResponseBody.create(ByteArrayInputStream(content.toByteArray()))

        // When
        val source = responseBody.source()

        // Read the content fully
        assertEquals(content, source.readUtf8())

        // Attempt to read again
        assertEquals("", source.readUtf8()) // Subsequent reads return empty data
    }

    @Test
    fun `should close response body source when close() is called`() {
        // Given
        val content = "Hello, world!"
        val responseBody = ResponseBody.create(ByteArrayInputStream(content.toByteArray()))

        // When
        responseBody.close()

        // Expect
        assertFalse(responseBody.source().isOpen)
    }
}
