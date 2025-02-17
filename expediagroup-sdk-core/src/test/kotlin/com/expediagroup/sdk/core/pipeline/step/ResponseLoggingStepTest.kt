package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.logging.ResponseLogger
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ResponseLoggingStepTest {
    private lateinit var mockLogger: LoggerDecorator
    private lateinit var loggingStep: ResponseLoggingStep

    @BeforeEach
    fun setUp() {
        mockLogger = mockk(relaxed = true)
        loggingStep = ResponseLoggingStep(logger = mockLogger)
    }

    @Test
    fun `invoke should log response and return the same response`() {
        // Arrange
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
                ).build()

        every { ResponseLogger.log(mockLogger, testResponse) } just Runs

        // Act
        val result = loggingStep.invoke(testResponse)

        // Assert
        verify { ResponseLogger.log(mockLogger, testResponse) }
        assertEquals(testResponse, result)
    }
}
