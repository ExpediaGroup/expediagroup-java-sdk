package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.toResponseJson
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.graphql.exception.NoDataException
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import testservice.TestMutation
import testservice.TestQuery
import testservice.type.buildTestData


class AsyncGraphQLExecutorTest {
    private lateinit var mockAsyncRequestExecutor: AbstractAsyncRequestExecutor
    private lateinit var graphqlExecutor: AsyncGraphQLExecutor
    private val serverUrl = "https://example.com/graphql"

    @BeforeEach
    fun setUp() {
        mockAsyncRequestExecutor = mockk(relaxed = true)
        graphqlExecutor = AsyncGraphQLExecutor(asyncRequestExecutor = mockAsyncRequestExecutor, serverUrl = serverUrl)
    }

    @Test
    fun `should return future of RawResponse on successful execution`() {
        // Given
        val testOperation = TestMutation()
        val testOperationData = TestMutation.Data { testMutation = buildTestData { id = "1" } }

        val buffer = Buffer().apply { writeUtf8(testOperationData.toResponseJson()) }

        val testSDKResponse = Response.builder()
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .request(mockk())
            .body(ResponseBody.create(buffer))
            .build()

        every { mockAsyncRequestExecutor.execute(any()) } returns CompletableFuture.completedFuture(testSDKResponse)

        // When
        val future = graphqlExecutor.execute(testOperation)

        // Expect
        verify(exactly = 1) { mockAsyncRequestExecutor.execute(any()) }
        assertEquals(testOperationData, future.get().data)
        assertNull(future.get().errors)
    }

    @Test
    fun `should throw ExecutionException with ExpediaGroupServiceException as cause when ApolloResponse has exception`() {
        // Given
        val testOperation = TestMutation()
        val testOperationData = """{data: "invalid data"}"""

        val buffer = Buffer().apply { writeUtf8(testOperationData) }

        val testSDKResponse = Response.builder()
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .request(mockk())
            .body(ResponseBody.create(buffer))
            .build()

        every { mockAsyncRequestExecutor.execute(any()) } returns CompletableFuture.completedFuture(testSDKResponse)

        // When & Expect
        val exception = assertThrows<ExecutionException> {
            graphqlExecutor.execute(testOperation).get()
        }

        assertInstanceOf(ExpediaGroupServiceException::class.java, exception.cause)
    }

    @Test
    fun `should throw ExecutionException with NoDataException as cause when ApolloResponse has no data but has errors`() {
        // Given
        val errorResponse = """{"errors": [{ "message": "Some error occurred" }]}"""
        val buffer = Buffer().apply { writeUtf8(errorResponse) }
        val testSDKResponse = Response.builder()
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .request(mockk())
            .body(ResponseBody.create(buffer))
            .build()

        every { mockAsyncRequestExecutor.execute(any()) } returns CompletableFuture.completedFuture(testSDKResponse)

        // When & Expect
        val exception = assertThrows<ExecutionException> {
            graphqlExecutor.execute(TestQuery()).get()
        }

        assertInstanceOf(NoDataException::class.java, exception.cause)
        assertEquals("No data received from the server", exception.cause?.message)
        assertEquals("Some error occurred", (exception.cause as NoDataException).errors[0].message)
    }

    @Test
    fun `should return RawResponse with data and errors when both are present`() {
        // Given
        val partialDataResponse =
            """
                {
                  "data": { "testMutation": { "id": "id-1" } },
                  "errors": [{ "message": "Some error occurred" }]
                }
                """.trimIndent()

        val buffer = Buffer().apply { writeUtf8(partialDataResponse) }

        val testSDKResponse = Response.builder()
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .request(mockk())
            .body(ResponseBody.create(buffer))
            .build()

        every { mockAsyncRequestExecutor.execute(any()) } returns CompletableFuture.completedFuture(testSDKResponse)

        // When
        val future = graphqlExecutor.execute(TestMutation())

        // Expect
        assertEquals("id-1", future.get().data.testMutation.id)
        assertEquals("Some error occurred", future.get().errors?.get(0)?.message)
    }

    @Test
    fun `should complete the future exceptionally on failed response`() {
        // Given
        val future = CompletableFuture<Response>()
        future.completeExceptionally(RuntimeException("Some error occurred"))

        every { mockAsyncRequestExecutor.execute(any()) } returns future

        // When & Expect
        assertThrows<ExecutionException> {
            graphqlExecutor.execute(TestMutation()).get()
        }
    }
}
