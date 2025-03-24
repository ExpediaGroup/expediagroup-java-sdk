package com.expediagroup.sdk.core.authentication.basic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCredentialsTest {
    @Test
    fun `toString should not print secret`() {
        val credentials = BasicCredentials(username = "username", password = "password")

        assertEquals("BasicCredentials(username=***, password=***)", credentials.toString())
    }
}
