package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okio.Buffer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

class ResponseLoggerTest {
    private lateinit var mockLogger: LoggerDecorator

    @BeforeEach
    fun setUp() {
        mockLogger = mockk<LoggerDecorator>(relaxed = true)
    }

    @Test
    fun `should log basic details at info level`() {
        // Given
        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.GET)
                        .build()
                ).addHeader("Content-Type", "application/json")
                .build()

        every { mockLogger.isDebugEnabled } returns false

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage = "URL=https://example.com, Code=200, Headers=[{content-type=[application/json]}]"
        verify { mockLogger.info(expectedLogMessage, "Incoming", *anyVararg<String>()) }
        verify(exactly = 0) { mockLogger.debug(any<String>(), *anyVararg()) }
    }

    @Test
    fun `should include response body at debug level`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).addHeader("Content-Type", "application/json")
                .body(
                    ResponseBody.create(
                        buffer,
                        mediaType = MediaType.parse("application/json"),
                        contentLength = buffer.size
                    )
                ).build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{content-type=[application/json]}], Body={"key":"value"}
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should read response body string with the expected charset`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).addHeader("Content-Type", "application/json")
                .body(
                    ResponseBody.create(
                        buffer,
                        mediaType = MediaType.parse("application/json; charset=UTF-16"),
                        contentLength = buffer.size
                    )
                ).build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{content-type=[application/json]}], Body=笢步礢㨢癡汵攢�
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should handle null response body`() {
        // Given
        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).addHeader("Content-Type", "application/json")
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{content-type=[application/json]}], Body=null
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should log error if exception occurs`() {
        // Given
        val mockResponse = mockk<Response>()

        every { mockResponse.status } returns Status.OK
        every { mockResponse.protocol } returns Protocol.HTTP_1_1
        every { mockResponse.request } returns mockk<Request>()
        every { mockResponse.body } throws IOException("Failed to read body")

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, mockResponse)

        // Expect
        verify { mockLogger.error("Failed to log response") }
        verify(exactly = 0) { mockLogger.debug(any<String>(), any(), *anyVararg()) }
    }

    @Test
    fun `should not log responses with unknown media type`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).body(
                    ResponseBody.create(
                        buffer,
                        mediaType = null,
                        contentLength = buffer.size
                    )
                ).build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{}], Body=Response body of unknown media type cannot be logged
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should not log responses with unknown content length`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).body(
                    ResponseBody.create(
                        buffer,
                        mediaType = CommonMediaTypes.APPLICATION_JSON,
                        contentLength = -1
                    )
                ).build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{}], Body=Response body with unknown content length cannot be logged
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should handle response body with non-loggable media type`() {
        // Given
        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).body(ResponseBody.create(Buffer(), mediaType = CommonMediaTypes.APPLICATION_OCTET_STREAM))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{}], Body=Response body of type application/octet-stream cannot be logged
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }

    @Test
    fun `should respect max log size for response body`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        // Given
        val testResponse =
            Response
                .builder()
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .request(
                    Request
                        .builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()
                ).body(ResponseBody.create(buffer, mediaType = MediaType.parse("application/json"), contentLength = buffer.size))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        ResponseLogger.log(mockLogger, testResponse, maxBodyLogSize = 1L)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Code=200, Headers=[{}], Body={
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Incoming", *anyVararg<String>()) }
    }
}
