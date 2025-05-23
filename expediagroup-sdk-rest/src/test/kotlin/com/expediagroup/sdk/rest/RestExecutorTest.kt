package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.InputStream
import java.util.UUID
import com.expediagroup.sdk.core.http.Response as SDKCoreResponse

class RestExecutorTest {
    private lateinit var mockMapper: ObjectMapper
    private lateinit var mockRequestExecutor: AbstractRequestExecutor
    private lateinit var restExecutor: RestExecutor
    private val serverUrl = "https://test.com"

    @BeforeEach
    fun setup() {
        mockMapper = mockk(relaxed = true)
        mockRequestExecutor = mockk(relaxed = true)
        restExecutor = RestExecutor(mockMapper, mockRequestExecutor, serverUrl)
    }

    class Operation500Exception(
        code: Int,
        requestId: UUID?,
        message: String?
    ) : ExpediaGroupApiException(code = code, requestId = requestId, message = message)

    open class DefaultOperationRequest(
        private val operationId: String = "testOperation",
        private val method: String = "GET"
    ) : OperationRequestTrait {
        override fun getHttpMethod(): String = method

        override fun getOperationId(): String = operationId

        override fun getExceptionForCode(
            code: Int,
            errorResponseStr: String?,
            requestId: UUID?,
            message: String?,
            cause: Throwable?
        ): ExpediaGroupApiException =
            when (code) {
                500 -> Operation500Exception(code = code, requestId = requestId, message = message)
                else -> ExpediaGroupApiException(code, UUID.randomUUID(), message = message)
            }
    }

    @Test
    fun `execute no response body operation delegates to abstract executor and closes response`() {
        // Given
        val testOperation =
            object : OperationNoResponseBodyTrait {
                override fun getRequestInfo(): OperationRequestTrait = DefaultOperationRequest()
            }

        val mockResponse =
            mockk<SDKCoreResponse>(relaxed = true) {
                every { isSuccessful } returns true
            }

        val requestExecutor =
            mockk<AbstractRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns mockResponse
            }

        val executor = RestExecutor(mockMapper, requestExecutor, serverUrl)

        // When
        val response = executor.execute(testOperation)

        // Then
        verify(exactly = 1) { requestExecutor.execute(any()) }
        verify(exactly = 1) { mockResponse.close() }
        assertEquals(Response(data = null, headers = mockResponse.headers), response)
    }

    @Test
    fun `throws an exception when response is not successful`() {
        // Given
        val testOperation =
            object : OperationNoResponseBodyTrait {
                override fun getRequestInfo(): OperationRequestTrait = DefaultOperationRequest()
            }

        val mockResponse =
            mockk<SDKCoreResponse>(relaxed = true) {
                every { isSuccessful } returns false
                every { status } returns Status.INTERNAL_SERVER_ERROR
                every { request.id } returns UUID.randomUUID()
            }

        val requestExecutor =
            mockk<AbstractRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns mockResponse
            }

        val executor = RestExecutor(mockMapper, requestExecutor, serverUrl)

        // When
        val exception = assertThrows<Operation500Exception> { executor.execute(testOperation) }

        // Then
        verify(exactly = 1) { requestExecutor.execute(any()) }
        verify(exactly = 1) { mockResponse.close() }

        assertEquals(
            "Received unsuccessful response [${mockResponse.status.code}] for requestId [${mockResponse.request.id}]",
            exception.message
        )
    }

    @Test
    fun `throws exceptions of abstract executor when operation is executed`() {
        // Given
        val testOperationWithNoBody =
            object : OperationNoResponseBodyTrait {
                override fun getRequestInfo(): OperationRequestTrait = DefaultOperationRequest()
            }

        val testOperationWithBody =
            object : JacksonModelOperationResponseBodyTrait<List<String>> {
                override fun getRequestInfo(): OperationRequestTrait = DefaultOperationRequest()

                override fun getTypeIdentifier(): TypeReference<List<String>> = jacksonTypeRef()
            }

        val requestExecutor =
            mockk<AbstractRequestExecutor>(relaxed = true) {
                every { execute(any()) } throws Exception("test")
            }

        val executor = RestExecutor(mockMapper, requestExecutor, serverUrl)

        // WHEN & EXPECT
        assertThrows<Exception>("test") { executor.execute(testOperationWithNoBody) }
        assertThrows<Exception>("test") { executor.execute(testOperationWithBody) }
    }

    @Test
    fun `execute response body operation delegates to abstract executor and deserializes and closes response`() {
        // Given
        val testOperation =
            object : JacksonModelOperationResponseBodyTrait<List<String>> {
                override fun getTypeIdentifier(): TypeReference<List<String>> = jacksonTypeRef()

                override fun getRequestInfo(): OperationRequestTrait = DefaultOperationRequest()
            }

        val mockResponse =
            mockk<SDKCoreResponse>(relaxed = true) {
                every { body } returns
                    ResponseBody.create(
                        mediaType = CommonMediaTypes.APPLICATION_JSON,
                        inputStream = "[\"test\"]".byteInputStream(),
                        contentLength = "[\"test\"]".byteInputStream().available().toLong()
                    )
                every { isSuccessful } returns true
            }

        val requestExecutor =
            mockk<AbstractRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns mockResponse
            }

        val executor = RestExecutor(mockMapper, requestExecutor, serverUrl)

        // When
        val response = executor.execute(testOperation)

        // Then
        verify(exactly = 1) { requestExecutor.execute(any()) }
        verify(exactly = 1) { mockResponse.close() }
        verify(exactly = 1) { mockMapper.readValue(any<InputStream>(), any<TypeReference<*>>()) }

        assertNotNull(response.data)
        assertEquals(mockResponse.headers, response.headers)
    }

    @Test
    fun `dispose - verifies delegation`() {
        // Given
        every { mockRequestExecutor.dispose() } just Runs

        // When
        restExecutor.dispose()

        // Then
        verify { mockRequestExecutor.dispose() }
    }
}
