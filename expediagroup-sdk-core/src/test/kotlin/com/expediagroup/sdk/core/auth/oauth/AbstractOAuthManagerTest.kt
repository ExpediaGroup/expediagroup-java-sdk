package com.expediagroup.sdk.core.auth.oauth

import com.expediagroup.sdk.core.auth.common.encodeBasic
import com.expediagroup.sdk.core.http.Method
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestOAuthManager(
    authUrl: String,
    credentials: OAuthCredentials
) : AbstractOAuthManager(authUrl, credentials) {
    override fun authenticate() {}
}

class AbstractOAuthManagerTest {
    private val authUrl = "https://example.com/auth"
    private val credentials = mockk<OAuthCredentials>(relaxed = true)
    private lateinit var authManager: AbstractOAuthManager

    @BeforeEach
    fun setUp() {
        authManager = TestOAuthManager(authUrl, credentials)
    }

    @Test
    fun `should store and retrieve token correctly`() {
        // Given
        val oauthTokenResponse = OAuthTokenResponse("dummyToken", 3600)
        authManager.storeToken(oauthTokenResponse)

        // When
        val header = authManager.getAuthorizationHeaderValue()

        // Expect
        assertEquals("Bearer dummyToken", header)
    }

    @Test
    fun `should detect token about to expire`() {
        // Given
        authManager = TestOAuthManager(authUrl, credentials)
        val oauthTokenResponse = OAuthTokenResponse("dummyToken", 10)
        authManager.storeToken(oauthTokenResponse)

        // When
        val isAboutToExpire = authManager.isTokenAboutToExpire()

        // Expect
        assertTrue(isAboutToExpire)
    }

    @Test
    fun `should clear authentication`() {
        val oauthTokenResponse = OAuthTokenResponse("dummyToken", 3600)
        authManager.storeToken(oauthTokenResponse)

        // When
        authManager.clearAuthentication()

        // Expect
        assertEquals("Bearer ", authManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should build authentication request with correct headers`() {
        // Given
        mockkStatic("com.expediagroup.sdk.core.auth.common.AuthUtilsKt")
        every { encodeBasic(any(), any()) } returns "Basic encodedCredentials"

        // When
        val request = authManager.buildAuthenticationRequest()

        // Expect
        assertEquals(authUrl, request.url.toString())
        assertEquals(Method.POST, request.method)
        assertEquals("Basic encodedCredentials", request.headers.get("Authorization"))
        assertEquals("application/x-www-form-urlencoded", request.headers.get("Content-Type"))
    }
}
