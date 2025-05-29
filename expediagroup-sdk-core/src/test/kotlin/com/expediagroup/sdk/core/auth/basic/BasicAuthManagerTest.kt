package com.expediagroup.sdk.core.auth.basic

import com.expediagroup.sdk.core.auth.common.encodeBasic
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicAuthManagerTest {
    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `should encode the provided credentials`() {
        // Given
        val credentials = BasicAuthCredentials("key", "secret")
        val basicAuthManager = BasicAuthManager(credentials)

        // When
        basicAuthManager.authenticate()

        // Expect
        assertEquals("Basic a2V5OnNlY3JldA==", basicAuthManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should clear the cached encoded credentials`() {
        // Given
        val credentials = BasicAuthCredentials("key", "secret")
        val basicAuthManager = BasicAuthManager(credentials)

        // When & Expect
        basicAuthManager.authenticate()
        assertEquals("Basic a2V5OnNlY3JldA==", basicAuthManager.getAuthorizationHeaderValue())
        basicAuthManager.clearAuthentication()
        assertEquals("", basicAuthManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should not re-encode the credentials once cached`() {
        // Given
        mockkStatic("com.expediagroup.sdk.core.auth.common.AuthUtilsKt")
        val mockCredentials = mockk<BasicAuthCredentials>(relaxed = true)

        val basicAuthManager = BasicAuthManager(mockCredentials)

        every { encodeBasic(any(), any()) } returns "Basic encoded"

        // When
        basicAuthManager.authenticate()
        basicAuthManager.authenticate()

        // Expect
        verify(exactly = 1) { encodeBasic(any(), any()) }
    }
}
