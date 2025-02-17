package com.expediagroup.sdk.core.http

import okio.Buffer
import okio.BufferedSink
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

class RequestBodyTest {
    @Test
    fun `should create a request body from InputStream with valid data`() {
        // Given
        val content = "Hello World"
        val inputStream = ByteArrayInputStream(content.toByteArray(StandardCharsets.UTF_8))
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val contentLength = content.toByteArray().size.toLong()
        val requestBody = RequestBody.create(inputStream, mediaType, contentLength)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(contentLength, requestBody.contentLength())
        assertEquals(content, buffer.readUtf8())
    }

    @Test
    fun `should create a request body from InputStream with empty data`() {
        // Given
        val inputStream = ByteArrayInputStream(byteArrayOf())
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val requestBody = RequestBody.create(inputStream, mediaType, 0L)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(0L, requestBody.contentLength())
        assertTrue(buffer.size == 0L)
    }

    @Test
    fun `should create RequestBody from Source with valid data`() {
        // Given
        val content = "Hello World"
        val source = Buffer().writeUtf8(content)
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val contentLength = content.toByteArray().size.toLong()
        val requestBody = RequestBody.create(source, mediaType, contentLength)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(contentLength, requestBody.contentLength())
        assertEquals(content, buffer.readUtf8())
    }

    @Test
    fun `should create RequestBody from Source with empty data`() {
        // Given
        val source = Buffer()
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val requestBody = RequestBody.create(source, mediaType, 0L)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(0L, requestBody.contentLength())
        assertTrue(buffer.size == 0L)
    }

    @Test
    fun `should create RequestBody from ByteString with valid data`() {
        // Given
        val content = "Hello World"
        val source = Buffer().writeUtf8(content)
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val contentLength = content.toByteArray().size.toLong()
        val requestBody = RequestBody.create(source.snapshot(), mediaType, contentLength)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(contentLength, requestBody.contentLength())
        assertEquals(content, buffer.readUtf8())
    }

    @Test
    fun `should create RequestBody from ByteString with empty data`() {
        // Given
        val source = Buffer()
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        val requestBody = RequestBody.create(source.snapshot(), mediaType, 0L)

        // When
        val buffer = Buffer()
        requestBody.writeTo(buffer)

        // Expect
        assertEquals(mediaType, requestBody.mediaType())
        assertEquals(0L, requestBody.contentLength())
        assertTrue(buffer.size == 0L)
    }

    @Test
    fun `should be extendable for custom usages`() {
        val requestBody =
            object : RequestBody() {
                val source = Buffer()

                override fun mediaType(): MediaType = CommonMediaTypes.TEXT_PLAIN

                override fun writeTo(sink: BufferedSink) {
                    source.use { src ->
                        sink.writeAll(src)
                    }
                }
            }

        assertEquals(requestBody.contentLength(), -1)
        assertEquals(requestBody.mediaType(), CommonMediaTypes.TEXT_PLAIN)
    }
}
