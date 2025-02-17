package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.transport.AsyncTransport
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import java.util.concurrent.CompletableFuture

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BearerAuthenticationAsyncManagerTest {
    private lateinit var asyncTransport: AsyncTransport
    private lateinit var credentials: Credentials
    private lateinit var asyncAuthenticationManager: BearerAuthenticationAsyncManager
    private val authUrl = "https://auth.example.com/token"

    @BeforeAll
    fun setup() {
        asyncTransport = mockk()
        credentials = Credentials("client_key", "client_secret")
        asyncAuthenticationManager = BearerAuthenticationAsyncManager(authUrl, credentials, asyncTransport)
    }

    @AfterEach
    fun tearDown() {
        clearMocks(asyncTransport)
        asyncAuthenticationManager.clearAuthentication()
    }

    @Test
    fun `should authenticate and store access token on successful response`() {
        // Given
        val responseString = """{ "access_token": "first_token", "expires_in": 360 }"""
        val response =
            Response
                .builder()
                .body(ResponseBody.create(responseString.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        // When
        asyncAuthenticationManager.authenticate()

        // Expect
        assertEquals("Bearer first_token", asyncAuthenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { asyncTransport.execute(any()) }
    }

    @Test
    fun `should throw ExpediaGroupAuthException on unsuccessful response`() {
        // Given
        val request =
            Request
                .builder()
                .url("http://localhost")
                .method(Method.POST)
                .build()

        val response =
            Response
                .builder()
                .request(request)
                .status(Status.FORBIDDEN)
                .protocol(Protocol.HTTP_1_1)
                .message(Status.FORBIDDEN.name)
                .build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                asyncAuthenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        verify(exactly = 1) { asyncTransport.execute(any()) }
    }

    @Test
    fun `should wrap unexpected exceptions with ExpediaGroupAuthException`() {
        // Given
        every { asyncTransport.execute(any()) } throws ExpediaGroupNetworkException("Network error")

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                asyncAuthenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        assertInstanceOf<ExpediaGroupAuthException>(exception)
        assertInstanceOf<ExpediaGroupNetworkException>(exception.cause)
        verify(exactly = 1) { asyncTransport.execute(any()) }
    }

    @Test
    fun `should wrap token parsing exception with ExpediaGroupAuthException`() {
        // Given
        val invalidAuthResponseBodyString = """{ "id": 1 }"""
        val response =
            Response
                .builder()
                .body(ResponseBody.create(invalidAuthResponseBodyString.toByteArray().inputStream()))
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                asyncAuthenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        assertInstanceOf<ExpediaGroupAuthException>(exception)
        assertInstanceOf<ExpediaGroupResponseParsingException>(exception.cause?.cause)
        verify(exactly = 1) { asyncTransport.execute(any()) }
    }

    @Test
    fun `should treat the stored token as a valid token when not expired`() {
        // Given
        val authResponseString = """{ "access_token": "accessToken", "expires_in": 360 }"""
        val response =
            Response
                .builder()
                .body(ResponseBody.create(authResponseString.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        // When
        asyncAuthenticationManager.authenticate()

        // Expect
        assertFalse(asyncAuthenticationManager.isTokenAboutToExpire())
    }

    @Test
    fun `should treat the stored token as invalid token if about to expire`() {
        // Given
        val authResponseString = """{ "access_token": "accessToken", "expires_in": 1 }"""
        val response =
            Response
                .builder()
                .body(ResponseBody.create(authResponseString.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        // When
        asyncAuthenticationManager.authenticate()

        // Expect
        assertTrue(asyncAuthenticationManager.isTokenAboutToExpire())
    }

    @Test
    fun `should handle token clearance`() {
        // Given
        val authResponseString = """{ "access_token": "accessToken", "expires_in": 360 }"""
        val response =
            Response
                .builder()
                .body(ResponseBody.create(authResponseString.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .message("Accepted")
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returns CompletableFuture.completedFuture(response)

        asyncAuthenticationManager.authenticate()
        assertEquals("Bearer accessToken", asyncAuthenticationManager.getAuthorizationHeaderValue())

        // When
        asyncAuthenticationManager.clearAuthentication()

        // Expect
        assertEquals("Bearer ", asyncAuthenticationManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should execute authentication request and update token each time authenticate is called`() {
        // Given
        val authResponseString1 = """{ "access_token": "accessToken1", "expires_in": 360 }"""
        val response1 =
            Response
                .builder()
                .body(ResponseBody.create(authResponseString1.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        val authResponseString2 = """{ "access_token": "accessToken2", "expires_in": 360 }"""
        val response2 =
            Response
                .builder()
                .body(ResponseBody.create(authResponseString2.toByteArray().inputStream()))
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .request(
                    Request
                        .builder()
                        .url("http://localhost")
                        .method(Method.POST)
                        .build()
                ).build()

        every { asyncTransport.execute(any()) } returnsMany
            listOf(
                CompletableFuture.completedFuture(response1),
                CompletableFuture.completedFuture(response2)
            )

        // When
        asyncAuthenticationManager.authenticate()
        val firstAuthHeader = asyncAuthenticationManager.getAuthorizationHeaderValue()

        asyncAuthenticationManager.authenticate()
        val secondAuthHeader = asyncAuthenticationManager.getAuthorizationHeaderValue()

        // Expect
        assertEquals("Bearer accessToken1", firstAuthHeader)
        assertEquals("Bearer accessToken2", secondAuthHeader)
        verify(exactly = 2) { asyncTransport.execute(any()) }
    }
}
