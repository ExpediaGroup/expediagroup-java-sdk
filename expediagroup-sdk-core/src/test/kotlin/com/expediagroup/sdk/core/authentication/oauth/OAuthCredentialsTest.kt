package com.expediagroup.sdk.core.authentication.oauth

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OAuthCredentialsTest {
    @Test
    fun `toString should not print sensitive data`() {
        val credentials = OAuthCredentials(key = "key", secret = "secret")

        assertEquals("OAuthCredentials(key=***, secret=***)", credentials.toString())
    }
}
