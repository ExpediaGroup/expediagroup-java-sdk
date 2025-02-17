package com.expediagroup.sdk.core.authentication.basic

import com.expediagroup.sdk.core.authentication.common.Credentials
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicAuthenticationManagerTest {
    @Test
    fun `should encode the provided credentials`() {
        // Given
        val credentials = Credentials("key", "secret")
        val basicAuthenticationManager = BasicAuthenticationManager(credentials)

        // When
        basicAuthenticationManager.authenticate()

        // Expect
        assertEquals("Basic a2V5OnNlY3JldA==", basicAuthenticationManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should clear the cached encoded credentials`() {
        // Given
        val credentials = Credentials("key", "secret")
        val basicAuthenticationManager = BasicAuthenticationManager(credentials)

        // When & Expect
        basicAuthenticationManager.authenticate()
        assertEquals("Basic a2V5OnNlY3JldA==", basicAuthenticationManager.getAuthorizationHeaderValue())
        basicAuthenticationManager.clearAuthentication()
        assertEquals("", basicAuthenticationManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should not re-encode the credentials once cached`() {
        // Given
        val mockCredentials = mockk<Credentials>()
        val basicAuthenticationManager = BasicAuthenticationManager(mockCredentials)

        every { mockCredentials.encodeBasic() } returns "Basic encoded"

        // When
        basicAuthenticationManager.authenticate()
        basicAuthenticationManager.authenticate()

        // Expect
        verify(exactly = 1) { mockCredentials.encodeBasic() }
    }
}
