package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.toResponseJson
import com.apollographql.apollo.exception.ApolloHttpException
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import testservice.TestMutation
import testservice.TestQuery
import testservice.type.buildTestData
import java.util.UUID

class ApolloOperationExtensionTest {
    @Test
    fun `toSDKRequest should map Apollo Operation to valid SDK request`() {
        // Given
        val endpoint = "https://www.example.com"
        val testOperation = TestQuery()

        // When
        val sdkRequest = testOperation.toSDKRequest(endpoint)

        // Expect
        val expectRequestBody =
            """{"operationName":"TestQuery","variables":{},"query":"query TestQuery { testQuery { id } }"}"""

        val actualRequestBody = Buffer().apply { sdkRequest.body?.writeTo(this) }.readUtf8()

        assertEquals(expectRequestBody, actualRequestBody)
        assertEquals(endpoint, sdkRequest.url.toString())
        assertEquals(expectRequestBody.length.toLong(), sdkRequest.body?.contentLength())
        assertEquals(CommonMediaTypes.APPLICATION_JSON, sdkRequest.body?.mediaType())
        assertEquals(Method.POST, sdkRequest.method)
    }

    @Test
    fun `toApolloResponse should map SDK response to valid Apollo response`() {
        // Given
        val testOperation = TestMutation()
        val testOperationData = TestMutation.Data { testMutation = buildTestData { id = "1" } }
        val testResponseBody = testOperationData.toResponseJson()

        val buffer = Buffer().apply { writeUtf8(testResponseBody) }

        val testSDKResponse =
            Response.builder()
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .request(mockk())
                .body(ResponseBody.create(buffer))
                .build()

        // When
        val apolloResponse = testSDKResponse.toApolloResponse(testOperation)

        // Expect
        assertEquals(testOperationData, apolloResponse.data)
        assertNull(apolloResponse.errors)
    }

    @Test
    fun `toApolloResponse should return error response if the response body is null`() {
        // Given
        val testSDKResponse =
            Response.builder()
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .request(mockk { every { id } returns UUID.randomUUID() })
                .build()

        // When
        val apolloResponse = testSDKResponse.toApolloResponse(TestMutation())

        // Expect
        assertEquals("Failed to parse response with null body", apolloResponse.errors?.get(0)?.message)
        assertNull(apolloResponse.data)
    }

    @Test
    fun `toApolloResponse should populate exception when the response status is not 200`() {
        // Given
        val testSDKResponse =
            Response.builder()
                .status(Status.INTERNAL_SERVER_ERROR)
                .protocol(Protocol.HTTP_1_1)
                .request(mockk { every { id } returns UUID.randomUUID() })
                .build()

        // When
        val apolloResponse = testSDKResponse.toApolloResponse(TestMutation())

        // Expect
        assertInstanceOf<ApolloHttpException>(apolloResponse.exception)
        assertNull(apolloResponse.data)
        assertNull(apolloResponse.errors)
    }
}
