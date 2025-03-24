package com.expediagroup.sdk.core.auth.oauth

import com.expediagroup.sdk.core.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.exception.client.ExpediaGroupTransportException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.transport.Transport
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
import java.util.UUID

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OAuthManagerTest {
    private lateinit var transport: Transport
    private lateinit var credentials: OAuthCredentials
    private lateinit var authenticationManager: OAuthManager
    private val authUrl = "https://auth.example.com/token"

    @BeforeAll
    fun setup() {
        transport = mockk()
        credentials = OAuthCredentials("client_key", "client_secret")
        authenticationManager = OAuthManager(authUrl, credentials, transport)
    }

    @AfterEach
    fun tearDown() {
        clearMocks(transport)
        authenticationManager.clearAuthentication()
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

        every { transport.execute(any()) } returns response

        // When
        authenticationManager.authenticate()

        // Expect
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { transport.execute(any()) }
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

        every { transport.execute(any()) } returns response

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                authenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        assertEquals(request.id, exception.requestId)
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `should wrap unexpected exceptions with ExpediaGroupAuthException`() {
        // Given
        val id = UUID.randomUUID()
        every { transport.execute(any()) } throws ExpediaGroupNetworkException(id, "Network error")

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                authenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        assertInstanceOf<ExpediaGroupAuthException>(exception)
        assertInstanceOf<ExpediaGroupTransportException>(exception.cause)
        assertInstanceOf<ExpediaGroupNetworkException>(exception.cause?.cause)
        verify(exactly = 1) { transport.execute(any()) }
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

        every { transport.execute(any()) } returns response

        // When
        val exception =
            assertThrows<ExpediaGroupAuthException> {
                authenticationManager.authenticate()
            }

        // Expect
        assertEquals("Authentication Failed", exception.message)
        assertInstanceOf<ExpediaGroupAuthException>(exception)
        assertInstanceOf<ExpediaGroupResponseParsingException>(exception.cause)
        verify(exactly = 1) { transport.execute(any()) }
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

        every { transport.execute(any()) } returns response

        // When
        authenticationManager.authenticate()

        // Expect
        assertFalse(authenticationManager.isTokenAboutToExpire())
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

        every { transport.execute(any()) } returns response

        // When
        authenticationManager.authenticate()

        // Expect
        assertTrue(authenticationManager.isTokenAboutToExpire())
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

        every { transport.execute(any()) } returns response

        authenticationManager.authenticate()
        assertEquals("Bearer accessToken", authenticationManager.getAuthorizationHeaderValue())

        // When
        authenticationManager.clearAuthentication()

        // Expect
        assertEquals("Bearer ", authenticationManager.getAuthorizationHeaderValue())
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

        every { transport.execute(any()) } returnsMany listOf(response1, response2)

        // When
        authenticationManager.authenticate()
        val firstAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        authenticationManager.authenticate()
        val secondAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        // Expect
        assertEquals("Bearer accessToken1", firstAuthHeader)
        assertEquals("Bearer accessToken2", secondAuthHeader)
        verify(exactly = 2) { transport.execute(any()) }
    }
}
