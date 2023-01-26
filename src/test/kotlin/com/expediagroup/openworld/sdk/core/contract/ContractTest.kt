package com.expediagroup.openworld.sdk.core.contract

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContractTest {

    @Test
    fun `Test adhering to a trailing slash`() {
        val input = "https://api.expediagroup.com"
        val expected = "https://api.expediagroup.com/"
        val actual: String = input.adhereTo(Contract.TRAILING_SLASH)
        assertEquals(expected, actual)
    }
}
