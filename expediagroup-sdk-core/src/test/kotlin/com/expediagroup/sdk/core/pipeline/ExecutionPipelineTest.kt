package com.expediagroup.sdk.core.pipeline

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExecutionPipelineTest {
    private lateinit var mockRequestStep1: RequestPipelineStep
    private lateinit var mockRequestStep2: RequestPipelineStep
    private lateinit var mockResponseStep1: ResponsePipelineStep
    private lateinit var mockResponseStep2: ResponsePipelineStep

    @BeforeEach
    fun setUp() {
        mockRequestStep1 = mockk()
        mockRequestStep2 = mockk()
        mockResponseStep1 = mockk()
        mockResponseStep2 = mockk()
    }

    @Test
    fun `should apply all request pipeline steps`() {
        // Arrange
        val initialRequest = mockk<Request>()
        val intermediateRequest = mockk<Request>()
        val finalRequest = mockk<Request>()

        every { mockRequestStep1.invoke(initialRequest) } returns intermediateRequest
        every { mockRequestStep2.invoke(intermediateRequest) } returns finalRequest

        val executionPipeline =
            ExecutionPipeline(
                requestPipeline = listOf(mockRequestStep1, mockRequestStep2),
                responsePipeline = emptyList()
            )

        // Act
        val result = executionPipeline.startRequestPipeline(initialRequest)

        // Assert
        assertEquals(finalRequest, result)
        verifyOrder {
            mockRequestStep1.invoke(initialRequest)
            mockRequestStep2.invoke(intermediateRequest)
        }
    }

    @Test
    fun `should return initial request if request pipeline is empty`() {
        // Arrange
        val initialRequest = mockk<Request>()

        val executionPipeline =
            ExecutionPipeline(
                requestPipeline = emptyList(),
                responsePipeline = emptyList()
            )

        // Act
        val result = executionPipeline.startRequestPipeline(initialRequest)

        // Assert
        assertEquals(initialRequest, result)
    }

    @Test
    fun `should apply all response pipeline steps`() {
        // Arrange
        val initialResponse = mockk<Response>()
        val intermediateResponse = mockk<Response>()
        val finalResponse = mockk<Response>()

        every { mockResponseStep1.invoke(initialResponse) } returns intermediateResponse
        every { mockResponseStep2.invoke(intermediateResponse) } returns finalResponse

        val executionPipeline =
            ExecutionPipeline(
                requestPipeline = emptyList(),
                responsePipeline = listOf(mockResponseStep1, mockResponseStep2)
            )

        // Act
        val result = executionPipeline.startResponsePipeline(initialResponse)

        // Assert
        assertEquals(finalResponse, result)
        verifyOrder {
            mockResponseStep1.invoke(initialResponse)
            mockResponseStep2.invoke(intermediateResponse)
        }
    }

    @Test
    fun `should return initial response if response pipeline is empty`() {
        // Arrange
        val initialResponse = mockk<Response>()

        val executionPipeline =
            ExecutionPipeline(
                requestPipeline = emptyList(),
                responsePipeline = emptyList()
            )

        // Act
        val result = executionPipeline.startResponsePipeline(initialResponse)

        // Assert
        assertEquals(initialResponse, result)
    }
}
