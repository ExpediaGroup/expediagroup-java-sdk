package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.logging.RequestLogger
import io.mockk.mockk
import io.mockk.verify
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.charset.Charset

class RequestLoggingStepTest {
    private lateinit var mockLogger: LoggerDecorator
    private lateinit var loggingStep: RequestLoggingStep

    @BeforeEach
    fun setUp() {
        mockLogger = mockk(relaxed = true)
        loggingStep = RequestLoggingStep(logger = mockLogger, maxRequestBodySize = 1024L)
    }

    @Test
    fun `should log request and return modified a new request with reusable body`() {
        // Arrange
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(buffer, mediaType = MediaType.parse("application/json")))
                .build()

        // Act
        val result = loggingStep.invoke(testRequest)
        val resultRequestStringBody = Buffer().apply { result.body?.writeTo(this) }.readString(Charset.defaultCharset())

        // Assert
        verify { RequestLogger.log(mockLogger, testRequest) }

        assertNotNull(result)
        assertEquals(testRequest.url, result.url)
        assertEquals(testRequest.method, result.method)
        assertEquals(testRequest.headers, result.headers)
        assertEquals(bodyContent, resultRequestStringBody)
    }

    @Test
    fun `should log request without modifying body when body is null`() {
        // Arrange
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .build()

        // Act
        val result = loggingStep.invoke(testRequest)

        // Assert
        verify { RequestLogger.log(mockLogger, testRequest) }
        assertEquals(testRequest, result)
    }
}
