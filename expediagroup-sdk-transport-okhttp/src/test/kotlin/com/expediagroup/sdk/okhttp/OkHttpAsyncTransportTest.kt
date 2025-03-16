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
import io.mockk.slot
import io.mockk.unmockkObject
import io.mockk.verify
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException
import java.util.concurrent.ExecutionException

class OkHttpAsyncTransportTest {
    private lateinit var mockOkHttpClient: OkHttpClient
    private lateinit var mockCall: Call

    @BeforeEach
    fun setUp() {
        mockOkHttpClient = mockk()
        mockCall = mockk()
    }

    @Test
    fun `should complete successfully on valid response`() {
        // Given
        val sdkRequest =
            Request.builder()
                .url("https://example.com/")
                .method(Method.GET)
                .build()

        val sdkResponse =
            Response.builder()
                .request(sdkRequest)
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .message("OK")
                .build()

        val okHttpResponse = sdkResponse.toOkHttpResponse()

        every { mockOkHttpClient.newCall(any()) } returns mockCall

        val callbackSlot = slot<Callback>()

        every { mockCall.enqueue(capture(callbackSlot)) } answers {
            callbackSlot.captured.onResponse(mockCall, okHttpResponse)
        }

        val asyncTransport = OkHttpAsyncTransport(mockOkHttpClient)

        // When
        val future = asyncTransport.execute(sdkRequest)

        // Expect
        val result = future.get()
        assertEquals(sdkResponse.status, result.status)
        assertEquals(sdkResponse.protocol, result.protocol)
        assertEquals(sdkResponse.message, result.message)
        assertEquals(sdkResponse.headers.entries(), result.headers.entries())
        assertEquals(sdkResponse.request.url, result.request.url)
        assertEquals(sdkResponse.request.headers.entries(), result.request.headers.entries())
        assertEquals(sdkResponse.request.method, result.request.method)
        assertEquals(sdkResponse.request.body, result.request.body)
        assertEquals(sdkResponse.body, result.body)

        verify { mockCall.enqueue(capture(callbackSlot)) }
    }

    @Test
    fun `should complete exceptionally on failure`() {
        // Given
        val sdkRequest =
            Request.builder()
                .url("https://example.com/")
                .method(Method.GET)
                .build()

        every { mockOkHttpClient.newCall(any()) } returns mockCall

        val callbackSlot = slot<Callback>()

        every { mockCall.enqueue(capture(callbackSlot)) } answers {
            callbackSlot.captured.onFailure(mockCall, IOException("Mocked exception"))
        }

        val asyncTransport = OkHttpAsyncTransport(mockOkHttpClient)

        // When
        val future = asyncTransport.execute(sdkRequest)

        // Expect
        val exception = assertThrows<ExecutionException> { future.get() }
        assertInstanceOf(ExpediaGroupNetworkException::class.java, exception.cause)
        assertEquals("Failed to execute the request", exception.cause?.message)
        assertNotNull((exception.cause as ExpediaGroupNetworkException).requestId)
    }

    @Test
    fun `should close the underlying resources on dispose call`() {
        // Given
        val mockOkHttpClient = mockk<OkHttpClient>(relaxed = true)
        val asyncTransport = OkHttpAsyncTransport(mockOkHttpClient)

        // When
        asyncTransport.dispose()

        // Expect
        verify { mockOkHttpClient.dispatcher.executorService.shutdown() }
        verify { mockOkHttpClient.connectionPool.evictAll() }
    }

    @Test
    fun `default constructor uses the base OkHttp instance`() {
        // Given
        mockkObject(BaseOkHttpClient)
        every { BaseOkHttpClient.getInstance() } returns mockOkHttpClient

        // When
        OkHttpAsyncTransport()

        // Expect
        verify(exactly = 1) { BaseOkHttpClient.getInstance() }

        unmockkObject(BaseOkHttpClient)
    }

    @Test
    fun `constructor with configuration parameter initializes a new configured OkHttp instance`() {
        // Given
        val mockConfig = mockk<OkHttpClientConfiguration>()
        mockkObject(BaseOkHttpClient)
        every { BaseOkHttpClient.getConfiguredInstance(mockConfig) } returns mockOkHttpClient

        // When
        OkHttpAsyncTransport(mockConfig)

        // Expect
        verify(exactly = 1) { BaseOkHttpClient.getConfiguredInstance(mockConfig) }
        verify(exactly = 0) { BaseOkHttpClient.getInstance() }

        unmockkObject(BaseOkHttpClient)
    }
}
