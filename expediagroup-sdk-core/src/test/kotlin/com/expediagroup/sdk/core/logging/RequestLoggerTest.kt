package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okio.Buffer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException
import java.net.URL

class RequestLoggerTest {
    private lateinit var mockLogger: LoggerDecorator

    @BeforeEach
    fun setUp() {
        mockLogger = mockk<LoggerDecorator>(relaxed = true)
    }

    @Test
    fun `should log basic details at info level`() {
        // Given
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.GET)
                .addHeader("Content-Type", "application/json")
                .build()

        every { mockLogger.isDebugEnabled } returns false

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage = "URL=https://example.com, Method=GET, Headers=[{content-type=[application/json]}]"
        verify { mockLogger.info(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
        verify(exactly = 0) { mockLogger.debug(any<String>(), *anyVararg()) }
    }

    @Test
    fun `should include request body at debug level`() {
        // Given
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

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Method=POST, Headers=[{content-type=[application/json]}], Body={"key":"value"}
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
    }

    @Test
    fun `should read request body string with the expected charset`() {
        // Given
        val bodyContent = """{"key":"value"}"""
        val buffer = Buffer().write(bodyContent.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(buffer, mediaType = MediaType.parse("application/json; charset=UTF-16")))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Method=POST, Headers=[{content-type=[application/json]}], Body=笢步礢㨢癡汵攢�
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
    }

    @Test
    fun `should handle null request body`() {
        // Given
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.GET)
                .addHeader("Content-Type", "application/json")
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Method=GET, Headers=[{content-type=[application/json]}], Body=null
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
    }

    @Test
    fun `should log error if exception occurs`() {
        // Given
        val mockRequest = mockk<Request>()

        every { mockRequest.url } returns URL("https://example.com")
        every { mockRequest.method } returns Method.POST
        every { mockRequest.headers } returns Headers.builder().build()
        every { mockRequest.body } throws IOException("Failed to read body")

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, mockRequest)

        // Expect
        verify { mockLogger.error("Failed to log request") }
        verify(exactly = 0) { mockLogger.debug(any<String>(), any(), *anyVararg()) }
    }

    @Test
    fun `should not log requests with unknown media type`() {
        // Given
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.GET)
                .body(RequestBody.create(Buffer(), mediaType = null))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Method=GET, Headers=[{}], Body=Request body of unknown media type cannot be logged
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
    }

    @Test
    fun `should handle request body with non-loggable media type`() {
        // Given
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.GET)
                .body(RequestBody.create(Buffer(), mediaType = CommonMediaTypes.APPLICATION_OCTET_STREAM))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        // When
        RequestLogger.log(mockLogger, testRequest)

        // Expect
        val expectedLogMessage =
            """
            URL=https://example.com, Method=GET, Headers=[{}], Body=Request body of type application/octet-stream cannot be logged
            """.trimIndent()

        verify { mockLogger.debug(expectedLogMessage, "Outgoing", *anyVararg<String>()) }
    }

    @Test
    fun `should log request body with custom media type when configured`() {
        val json = """something"""
        val bodyContent = Buffer().write(json.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json+custom")
                .body(RequestBody.create(bodyContent, mediaType = MediaType.parse("application/json+custom")))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        RequestLogger.log(
            mockLogger,
            testRequest,
            loggableContentTypes = listOf(MediaType.parse("application/json+custom"))
        )

        verify(exactly = 1) {
            mockLogger.debug(
                "URL=https://example.com, Method=POST, Headers=[{content-type=[application/json+custom]}], Body=something",
                "Outgoing",
                *anyVararg()
            )
        }
    }

    @Test
    fun `should call masker with each log on debug level`() {
        val json = """{"username":"john", "apiKey":"secret123", "email":"john@example.com", "password":"p@ssw0rd"}"""
        val bodyContent = Buffer().write(json.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(bodyContent, mediaType = CommonMediaTypes.APPLICATION_JSON))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        val mockMasker = mockk<(String) -> String>(relaxed = true)

        // When
        RequestLogger.log(mockLogger, testRequest, maskBody = mockMasker)

        // Expect
        verify(exactly = 1) {
            mockMasker.invoke(any<String>())
        }
    }

    @Test
    fun `should not call body masker when debug level is not enabled`() {
        val json = """{"username":"john", "apiKey":"secret123", "email":"john@example.com", "password":"p@ssw0rd"}"""
        val bodyContent = Buffer().write(json.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(bodyContent, mediaType = CommonMediaTypes.APPLICATION_JSON))
                .build()

        every { mockLogger.isDebugEnabled } returns false

        val mockMasker = mockk<(String) -> String>(relaxed = true)

        // When
        RequestLogger.log(mockLogger, testRequest, maskBody = mockMasker)

        // Expect
        verify(exactly = 0) {
            mockMasker.invoke(any<String>())
        }
    }

    @Test
    fun `should apply body masker to logged messages`() {
        val json = """{"username":"john", "apiKey":"secret123", "email":"john@example.com", "password":"p@ssw0rd"}"""
        val bodyContent = Buffer().write(json.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(bodyContent, mediaType = CommonMediaTypes.APPLICATION_JSON))
                .build()

        every { mockLogger.isDebugEnabled } returns true

        val mockMasker: (String) -> String = {
            "something"
        }

        // When
        RequestLogger.log(mockLogger, testRequest, maskBody = mockMasker)

        // Expect
        verify(exactly = 1) {
            mockLogger.debug(
                "URL=https://example.com, Method=POST, Headers=[{content-type=[application/json]}], Body=something",
                "Outgoing",
                *anyVararg()
            )
        }
    }

    @Test
    fun `should apply headers masker to logged messages`() {
        val json = """something"""
        val bodyContent = Buffer().write(json.toByteArray())

        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .addHeader("Content-Type", "application/json")
                .body(RequestBody.create(bodyContent, mediaType = CommonMediaTypes.APPLICATION_JSON))
                .build()

        every { mockLogger.isDebugEnabled } returns false

        val mockMasker: (Headers) -> Headers = {
            Headers.builder().add("Content-Type", "application/json").build()
        }

        // When
        RequestLogger.log(mockLogger, testRequest, maskHeaders = mockMasker)

        // Expect
        verify(exactly = 1) {
            mockLogger.info(
                "URL=https://example.com, Method=POST, Headers=[{content-type=[application/json]}]",
                "Outgoing",
                *anyVararg()
            )

            mockMasker.invoke(testRequest.headers)
        }
    }
}
