package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.core.http.Headers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResponseTest {
    @Test
    fun `response contains correct data`() {
        val data = "response data"
        val headers = Headers.builder().set("Content-Type", "application/json").build()
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }

    @Test
    fun `response contains correct headers`() {
        val data = "response data"
        val headers = Headers.builder().set("Content-Type", "application/json").build()
        val response = Response(data, headers)
        assertEquals(headers, response.headers)
    }

    @Test
    fun `response handles empty headers`() {
        val data = "response data"
        val headers = Headers.builder().build()
        val response = Response(data, headers)
        assertEquals(headers, response.headers)
    }

    @Test
    fun `response handles null data`() {
        val data: String? = null
        val headers = Headers.builder().set("Content-Type", "application/json").build()
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }

    @Test
    fun `response handles empty data`() {
        val data = ""
        val headers = Headers.builder().set("Content-Type", "application/json").build()
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }
}
