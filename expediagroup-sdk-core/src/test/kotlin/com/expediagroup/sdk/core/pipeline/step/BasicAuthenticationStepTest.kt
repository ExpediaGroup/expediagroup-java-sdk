package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.authentication.basic.BasicAuthenticationManager
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicAuthenticationStepTest {
    @Test
    fun `should call authenticate and set Authorization header`() {
        // Given
        val mockManager = mockk<BasicAuthenticationManager>()
        val basicAuthenticationStep = BasicAuthenticationStep(mockManager)
        val originalRequest =
            Request
                .builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()

        every { mockManager.authenticate() } just runs
        every { mockManager.getAuthorizationHeaderValue() } returns "Basic mockValue"

        // When
        val newRequest = basicAuthenticationStep.invoke(originalRequest)

        // Expect
        verify(exactly = 1) { mockManager.authenticate() }
        verify(exactly = 1) { mockManager.getAuthorizationHeaderValue() }
        assertEquals("Basic mockValue", newRequest.headers.get("Authorization"))
    }

    @Test
    fun `should preserve other headers in Request`() {
        // Given
        val mockManager = mockk<BasicAuthenticationManager>()
        every { mockManager.authenticate() } just runs
        every { mockManager.getAuthorizationHeaderValue() } returns "Basic mockValue"

        val originalRequest =
            Request
                .builder()
                .method(Method.GET)
                .url("https://example.com")
                .setHeader("X-Custom-Header", "MyValue")
                .build()

        val testStep = BasicAuthenticationStep(mockManager)

        // When
        val newRequest = testStep.invoke(originalRequest)

        // Expect
        assertEquals("MyValue", newRequest.headers.get("X-Custom-Header"))
        assertEquals("Basic mockValue", newRequest.headers.get("Authorization"))
    }
}
