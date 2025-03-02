package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.logging.Constant
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaskHeadersTest {
    @Test
    fun `handles empty headers`() {
        val maskHeaders = MaskHeaders(emptyList())
        val headers = maskHeaders(Headers.builder().build())
        assertTrue(headers.entries().isEmpty())
    }

    @Test
    fun `masks targeted headers only`() {
        val maskedHeaders =
            mapOf(
                "authorization" to "Bearer token",
                "key" to "private key"
            )

        val otherHeaders =
            mapOf(
                "content-type" to "application/json",
                "accept" to "application/json"
            )

        MaskHeaders(maskedHeaders.keys.toList()).invoke(
            Headers.builder().apply {
                maskedHeaders.forEach { (key, value) -> add(key, value) }
                otherHeaders.forEach { (key, value) -> add(key, value) }
            }.build()
        ).entries().forEach { (key, value) ->
            when {
                maskedHeaders.containsKey(key) -> assertTrue(value.size == 1 && value.first() == Constant.OMITTED)
                else -> assertTrue(value.size == 1 && value.first() == otherHeaders[key])
            }
        }
    }
}
