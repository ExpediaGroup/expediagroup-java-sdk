package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.toResponseJson
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.graphql.exception.NoDataException
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
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

class GraphQLExecutorTest {
    private lateinit var mockRequestExecutor: AbstractRequestExecutor
    private lateinit var graphqlExecutor: GraphQLExecutor
    private val serverUrl = "https://example.com/graphql"

    @BeforeEach
    fun setUp() {
        mockRequestExecutor = mockk(relaxed = true)
        graphqlExecutor = GraphQLExecutor(requestExecutor = mockRequestExecutor, serverUrl = serverUrl)
    }

    @Test
    fun `should return RawResponse on successful execution`() {
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

        every { mockRequestExecutor.execute(any()) } returns testSDKResponse

        // When
        val rawResponse = graphqlExecutor.execute(testOperation)

        // Expect
        verify(exactly = 1) { mockRequestExecutor.execute(any()) }
        assertEquals(testOperationData, rawResponse.data)
        assertNull(rawResponse.errors)
    }

    @Test
    fun `should throw ExpediaGroupServiceException when ApolloResponse has exception`() {
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

        every { mockRequestExecutor.execute(any()) } returns testSDKResponse

        // When & Expect
        val exception = assertThrows<ExpediaGroupServiceException> {
            graphqlExecutor.execute(testOperation)
        }

        assertInstanceOf(ExpediaGroupServiceException::class.java, exception)
    }

    @Test
    fun `should throw NoDataException when ApolloResponse has no data but has errors`() {
        // Given
        val errorResponse = """{"errors": [{ "message": "Some error occurred" }]}"""
        val buffer = Buffer().apply { writeUtf8(errorResponse) }
        val testSDKResponse = Response.builder()
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .request(mockk())
            .body(ResponseBody.create(buffer))
            .build()

        every { mockRequestExecutor.execute(any()) } returns testSDKResponse

        // When & Expect
        val exception = assertThrows<NoDataException> {
            graphqlExecutor.execute(TestQuery())
        }

        assertEquals("No data received from the server", exception.message)
        assertEquals("Some error occurred", exception.errors[0].message)
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

        every { mockRequestExecutor.execute(any()) } returns testSDKResponse

        val rawResponse = graphqlExecutor.execute(TestMutation())

        assertEquals("id-1", rawResponse.data.testMutation.id)
        assertEquals("Some error occurred", rawResponse.errors?.get(0)?.message)
    }
}
