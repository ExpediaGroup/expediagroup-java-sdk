package com.expediagroup.sdk.okhttp

import com.expediagroup.sdk.core.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkObject
import io.mockk.verify
import okhttp3.Call
import okhttp3.OkHttpClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OkHttpTransportTest {

    @Test
    fun `execute should correctly execute the request and return a response`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>()
        val mockCall = mockk<Call>()

        val sdkRequest = Request.builder()
            .url("https://example.com/")
            .method(Method.GET)
            .build()

        val sdkResponse = Response.builder()
            .request(sdkRequest)
            .status(Status.OK)
            .protocol(Protocol.HTTP_1_1)
            .message("OK")
            .build()

        val okHttpResponse = sdkResponse.toOkHttpResponse()

        every { mockOkHttpClient.newCall(any()) } returns mockCall
        every { mockCall.execute() } returns okHttpResponse

        val transport = OkHttpTransport(mockOkHttpClient)

        // When
        val result = transport.execute(sdkRequest)

        // Then
        assertEquals(sdkResponse.status, result.status)
        assertEquals(sdkResponse.protocol, result.protocol)
        assertEquals(sdkResponse.message, result.message)
        assertEquals(sdkResponse.headers.entries(), result.headers.entries())
        assertEquals(sdkResponse.request.url, result.request.url)
        assertEquals(sdkResponse.request.headers.entries(), result.request.headers.entries())
        assertEquals(sdkResponse.request.method, result.request.method)
        assertEquals(sdkResponse.request.body, result.request.body)
        assertEquals(sdkResponse.body, result.body)

        verify { mockCall.execute() }
    }

    @Test
    fun `should throw ExpediaGroupNetworkException if the request execution fails`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>()
        val mockCall = mockk<Call>()

        val sdkRequest = Request.builder()
            .url("https://example.com/")
            .method(Method.GET)
            .build()

        every { mockOkHttpClient.newCall(any()) } returns mockCall
        every { mockCall.execute() } throws RuntimeException()

        val transport = OkHttpTransport(mockOkHttpClient)

        // When & Expect
        assertThrows<ExpediaGroupNetworkException> {
            transport.execute(sdkRequest)
        }
    }

    @Test
    fun `default constructor uses the base OkHttp instance`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>()
        mockkObject(BaseOkHttpClient)
        every { BaseOkHttpClient.getInstance() } returns mockOkHttpClient

        // When
        OkHttpTransport()

        // Expect
        verify(exactly = 1) { BaseOkHttpClient.getInstance() }

        unmockkObject(BaseOkHttpClient)
    }

    @Test
    fun `constructor with configuration parameter initializes a new configured OkHttp instance`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>()
        val mockConfig = mockk<OkHttpClientConfiguration>()
        mockkObject(BaseOkHttpClient)
        every { BaseOkHttpClient.getConfiguredInstance(mockConfig) } returns mockOkHttpClient

        // When
        OkHttpTransport(mockConfig)

        // Expect
        verify(exactly = 1) { BaseOkHttpClient.getConfiguredInstance(mockConfig) }
        verify(exactly = 0) { BaseOkHttpClient.getInstance() }

        unmockkObject(BaseOkHttpClient)
    }

    @Test
    fun `should close the underlying resources on dispose call`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>(relaxed = true)
        val transport = OkHttpTransport(mockOkHttpClient)

        // When
        transport.dispose()

        // Expect
        verify { mockOkHttpClient.dispatcher.executorService.shutdown() }
        verify { mockOkHttpClient.connectionPool.evictAll() }
    }
}
