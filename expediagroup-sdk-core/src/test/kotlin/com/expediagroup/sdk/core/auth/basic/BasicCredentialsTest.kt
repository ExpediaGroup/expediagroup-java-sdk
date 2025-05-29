package com.expediagroup.sdk.core.auth.basic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCredentialsTest {
    @Test
    fun `toString should not print secret`() {
        val credentials = BasicAuthCredentials(username = "username", password = "password")

        assertEquals("BasicAuthCredentials(username=***, password=***)", credentials.toString())
    }
}
