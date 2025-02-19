package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
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
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import com.expediagroup.sdk.core.http.Response as SDKCoreResponse

class AsyncRestExecutorTest {
    private lateinit var mockMapper: ObjectMapper
    private lateinit var mockAsyncRequestExecutor: AbstractAsyncRequestExecutor
    private lateinit var asyncRestExecutor: AsyncRestExecutor
    private val serverUrl = "https://test.com"

    @BeforeEach
    fun setup() {
        mockMapper = mockk(relaxed = true)
        mockAsyncRequestExecutor = mockk(relaxed = true)
        asyncRestExecutor = AsyncRestExecutor(mockMapper, mockAsyncRequestExecutor, serverUrl)
    }

    @Test
    fun `execute no response body operation delegates to abstract executor and closes response`() {
        // Given
        val testOperation =
            object : OperationNoResponseBodyTrait {
                override fun getRequestInfo(): OperationRequestTrait =
                    object : OperationRequestTrait {
                        override fun getHttpMethod(): String = "POST"
                    }
            }
        val mockResponse = mockk<SDKCoreResponse>(relaxed = true)
        val requestExecutor =
            mockk<AbstractAsyncRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns
                    CompletableFuture<SDKCoreResponse>().apply {
                        complete(mockResponse)
                    }
            }
        val executor = AsyncRestExecutor(mockMapper, requestExecutor, serverUrl)

        // When
        val future = executor.execute(testOperation)
        val response = future.get()

        // Then
        verify(exactly = 1) { requestExecutor.execute(any()) }
        verify(exactly = 1) { mockResponse.close() }
        assertEquals(Response(data = null, headers = mockResponse.headers), response)
    }

    @Test
    fun `execute response body operation delegates to abstract executor and deserializes and closes response`() {
        // Given
        val testOperation =
            object : JacksonModelOperationResponseBodyTrait<List<String>> {
                override fun getRequestInfo(): OperationRequestTrait =
                    object : OperationRequestTrait {
                        override fun getHttpMethod(): String = "POST"
                    }

                override fun getTypeIdentifier(): TypeReference<List<String>> = jacksonTypeRef()
            }
        val mockResponse =
            mockk<SDKCoreResponse>(relaxed = true) {
                every { body } returns
                    ResponseBody.create(
                        mediaType = CommonMediaTypes.APPLICATION_JSON,
                        inputStream = "[\"test\"]".byteInputStream(),
                        contentLength = "[\"test\"]".byteInputStream().available().toLong()
                    )
            }

        val requestExecutor =
            mockk<AbstractAsyncRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns
                    CompletableFuture<SDKCoreResponse>().apply {
                        complete(mockResponse)
                    }
            }
        val executor = AsyncRestExecutor(mockMapper, requestExecutor, serverUrl)

        // When
        val future = executor.execute(testOperation)
        val response = future.get()

        // Then
        verify(exactly = 1) { requestExecutor.execute(any()) }
        verify(exactly = 1) { mockResponse.close() }
        verify(exactly = 1) { mockMapper.readValue(any<InputStream>(), any<TypeReference<*>>()) }

        assertNotNull(response.data)
        assertEquals(mockResponse.headers, response.headers)
    }

    @Test
    fun `throws ExecutionExceptions of abstract executor when operation is executed`() {
        // Given
        val testOperationWithNoBody =
            object : OperationNoResponseBodyTrait {
                override fun getRequestInfo(): OperationRequestTrait =
                    object : OperationRequestTrait {
                        override fun getHttpMethod(): String = "POST"
                    }
            }
        val testOperationWithBody =
            object : JacksonModelOperationResponseBodyTrait<List<String>> {
                override fun getRequestInfo(): OperationRequestTrait =
                    object : OperationRequestTrait {
                        override fun getHttpMethod(): String = "POST"
                    }

                override fun getTypeIdentifier(): TypeReference<List<String>> = jacksonTypeRef()
            }

        val requestExecutor =
            mockk<AbstractAsyncRequestExecutor>(relaxed = true) {
                every { execute(any()) } returns
                    CompletableFuture<SDKCoreResponse>().apply {
                        completeExceptionally(Exception("test"))
                    }
            }

        val executor = AsyncRestExecutor(mockMapper, requestExecutor, serverUrl)

        assertThrows<ExecutionException>("test") { executor.execute(testOperationWithNoBody).get() }.also { ex ->
            assertNotNull(ex.cause)
            assertEquals(ex.cause!!.message, "test")
        }
        assertThrows<ExecutionException>("test") { executor.execute(testOperationWithBody).get() }.also {
            assertNotNull(it.cause)
            assertEquals(it.cause!!.message, "test")
        }
    }

    @Test
    fun `dispose - verifies delegation`() {
        // Given
        every { mockAsyncRequestExecutor.dispose() } just Runs

        // When
        asyncRestExecutor.dispose()

        // Then
        verify { mockAsyncRequestExecutor.dispose() }
    }
}
