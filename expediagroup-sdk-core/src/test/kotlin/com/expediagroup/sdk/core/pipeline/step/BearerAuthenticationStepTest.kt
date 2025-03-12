package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.authentication.bearer.AbstractBearerAuthenticationManager
import com.expediagroup.sdk.core.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.http.Request
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException
import java.net.URL
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class BearerAuthenticationStepTest {
    private lateinit var mockAuthenticationManager: AbstractBearerAuthenticationManager
    private lateinit var mockRequest: Request
    private lateinit var mockRequestBuilder: Request.Builder
    private lateinit var authenticationStep: BearerAuthenticationStep

    @BeforeEach
    fun setUp() {
        mockAuthenticationManager = mockk()
        mockRequest = mockk(relaxed = true)
        mockRequestBuilder = mockk(relaxed = true)

        every { mockRequest.newBuilder() } returns mockRequestBuilder

        authenticationStep = BearerAuthenticationStep(mockAuthenticationManager)
    }

    @Test
    fun `should add Authorization header to request without reauthenticate when token is valid`() {
        // Arrange
        val authHeaderValue = "Bearer valid_token"
        every { mockAuthenticationManager.isTokenAboutToExpire() } returns false
        every { mockAuthenticationManager.getAuthorizationHeaderValue() } returns authHeaderValue
        every { mockRequestBuilder.addHeader("Authorization", authHeaderValue) } returns mockRequestBuilder
        every { mockRequestBuilder.build() } returns mockRequest

        // Act
        val result = authenticationStep.invoke(mockRequest)

        // Assert
        verify(exactly = 0) { mockAuthenticationManager.authenticate() }
        verify { mockAuthenticationManager.getAuthorizationHeaderValue() }
        verify { mockRequestBuilder.addHeader("Authorization", authHeaderValue) }
        verify { mockRequestBuilder.build() }
        assertEquals(mockRequest, result)
    }

    @Test
    fun `should reauthenticate if token is about to expire`() {
        // Arrange
        val authHeaderValue = "Bearer new_token"
        every { mockAuthenticationManager.isTokenAboutToExpire() } returns true
        every { mockAuthenticationManager.authenticate() } just Runs
        every { mockAuthenticationManager.getAuthorizationHeaderValue() } returns authHeaderValue
        every { mockRequestBuilder.addHeader("Authorization", authHeaderValue) } returns mockRequestBuilder
        every { mockRequestBuilder.build() } returns mockRequest

        // Act
        val result = authenticationStep.invoke(mockRequest)

        // Assert
        verifyOrder {
            mockAuthenticationManager.isTokenAboutToExpire()
            mockAuthenticationManager.authenticate()
            mockAuthenticationManager.getAuthorizationHeaderValue()
        }
        verify(exactly = 1) { mockAuthenticationManager.authenticate() }
        verify { mockRequestBuilder.addHeader("Authorization", authHeaderValue) }
        verify { mockRequestBuilder.build() }
        assertEquals(mockRequest, result)
    }

    @Test
    fun `should throw ExpediaGroupAuthException if authentication fails`() {
        // Arrange
        every { mockAuthenticationManager.isTokenAboutToExpire() } returns true
        every { mockAuthenticationManager.authenticate() } throws IOException("Mocked authentication failure")

        // Act & Assert
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                authenticationStep.invoke(mockRequest)
            }

        assertEquals("Failed to authenticate", exception.message)
        assert(exception.cause is IOException)
    }

    @Test
    fun `should have requestId when cause is ExpediaGroupServiceException`() {
        // Given
        val requestId = UUID.randomUUID()

        // Arrange
        every { mockAuthenticationManager.isTokenAboutToExpire() } returns true
        every { mockAuthenticationManager.authenticate() } throws ExpediaGroupServiceException(requestId = requestId)

        // Act & Assert
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                authenticationStep.invoke(mockRequest)
            }

        assertEquals("Failed to authenticate", exception.message)
        assertEquals(requestId, exception.requestId)
        assert(exception.cause is ExpediaGroupServiceException)
    }

    @Test
    fun `should not reauthenticate if token is valid`() {
        // Arrange
        val authHeaderValue = "Bearer valid_token"
        every { mockAuthenticationManager.isTokenAboutToExpire() } returns false
        every { mockAuthenticationManager.getAuthorizationHeaderValue() } returns authHeaderValue
        every { mockRequestBuilder.addHeader("Authorization", authHeaderValue) } returns mockRequestBuilder
        every { mockRequestBuilder.build() } returns mockRequest

        // Act
        val result = authenticationStep.invoke(mockRequest)

        // Assert
        verify(exactly = 0) { mockAuthenticationManager.authenticate() }
        verify { mockAuthenticationManager.getAuthorizationHeaderValue() }
        verify { mockRequestBuilder.addHeader("Authorization", authHeaderValue) }
        verify { mockRequestBuilder.build() }
        assertEquals(mockRequest, result)
    }

    @Test
    fun `should authenticate only once when multiple threads detect token expiration`() {
        // Arrange
        val authManager = mockk<AbstractBearerAuthenticationManager>(relaxed = true)
        val authenticationStep = BearerAuthenticationStep(authManager)
        val numberOfThreads = 5
        val latch = CountDownLatch(numberOfThreads)
        val executor = Executors.newFixedThreadPool(numberOfThreads)

        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest

        // Use AtomicBoolean to simulate token expiration
        val tokenExpired = AtomicBoolean(true)

        every { authManager.isTokenAboutToExpire() } answers {
            tokenExpired.get()
        }

        every { authManager.authenticate() } answers {
            // Simulate some delay in authentication
            Thread.sleep(100)
            tokenExpired.set(false)
        }

        every { authManager.getAuthorizationHeaderValue() } returns "Bearer refreshed_token"

        // Act
        repeat(numberOfThreads) {
            executor.submit {
                try {
                    authenticationStep.invoke(originalRequest)
                } finally {
                    latch.countDown()
                }
            }
        }

        // Wait for all threads to complete
        val completed = latch.await(3, TimeUnit.SECONDS)
        executor.shutdown()

        // Assert
        assertTrue(completed)
        verify(exactly = 1) { authManager.authenticate() }
        verify(atLeast = numberOfThreads) { authManager.isTokenAboutToExpire() }
        verify(exactly = numberOfThreads) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = numberOfThreads) { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") }
    }
}
