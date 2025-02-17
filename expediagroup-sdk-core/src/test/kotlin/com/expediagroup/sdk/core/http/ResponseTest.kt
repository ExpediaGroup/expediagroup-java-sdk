package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ResponseTest {
    @Test
    fun `should build response instance with all properties`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()

        val protocol = Protocol.HTTP_1_1
        val status = Status.OK
        val headers = Headers.Builder().add("Content-Type", "application/json").build()
        val body = ResponseBody.create("Response body".byteInputStream())

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(protocol)
                .status(status)
                .message("OK")
                .headers(headers)
                .body(body)
                .build()

        // Expect
        assertEquals(request, response.request)
        assertEquals(protocol, response.protocol)
        assertEquals(status, response.status)
        assertEquals("OK", response.message)
        assertEquals("application/json", response.headers.get("Content-Type"))
        assertEquals(body, response.body)
    }

    @Test
    fun `should build a new response based on previous instance`() {
        // Given
        val originalResponse =
            Response
                .Builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .addHeader("Accept", "application/json")
                .body(ResponseBody.create("Original body".byteInputStream()))
                .build()

        // When
        val newResponse =
            originalResponse
                .newBuilder()
                .addHeader("Content-Type", "text/plain")
                .message("Updated OK")
                .build()

        // Expect
        assertEquals("application/json", originalResponse.headers.get("accept"))
        assertNull(originalResponse.headers.get("content-type"))

        assertEquals("text/plain", newResponse.headers.get("content-type"))
        assertEquals("application/json", newResponse.headers.get("accept"))

        assertEquals("OK", originalResponse.message)
        assertEquals("Updated OK", newResponse.message)
    }

    @Test
    fun `should add single header`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue = "application/json"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .addHeader(headerName, headerValue)
                .build()

        // Expect
        assertEquals(headerValue, response.headers.get(headerName))
    }

    @Test
    fun `should add multiple values for one header`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .addHeader(headerName, headerValue1)
                .addHeader(headerName, headerValue2)
                .build()

        // Expect
        assertEquals(listOf(headerValue1, headerValue2), response.headers.values(headerName))
    }

    @Test
    fun `should set one single header`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue = "application/json"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .setHeader(headerName, headerValue)
                .build()

        // Expect
        assertEquals(headerValue, response.headers.get(headerName))
    }

    @Test
    fun `should set multiple values for one header`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .setHeader(headerName, headerValue1)
                .setHeader(headerName, headerValue2)
                .build()

        // Expect
        assertEquals(listOf(headerValue2), response.headers.values(headerName))
    }

    @Test
    fun `should add multiple values for one header as a list`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .addHeader(headerName, listOf(headerValue1, headerValue2))
                .build()

        // Expect
        assertEquals(listOf(headerValue1, headerValue2), response.headers.values(headerName))
    }

    @Test
    fun `should set multiple values for one header as a list`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val response =
            Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("OK")
                .status(Status.OK)
                .setHeader(headerName, listOf(headerValue1, headerValue2))
                .setHeader(headerName, listOf(headerValue2, headerValue1))
                .build()

        // When
        assertEquals(listOf(headerValue2, headerValue1), response.headers.values(headerName))
    }

    @Test
    fun `should remove headers when removeHeader is called on an existing header`() {
        // Given
        val request =
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        val responseBuilder =
            Response
                .builder()
                .request(request)
                .status(Status.OK)
                .message("OK")
                .protocol(Protocol.HTTP_1_1)
                .addHeader("Header1", "Value1")
                .addHeader("Header2", "Value2")

        // When
        val response = responseBuilder.removeHeader("Header1").build()

        // Expect
        assertNull(response.headers.get("Header1"))
        assertEquals("Value2", response.headers.get("Header2"))
    }

    @Test
    fun `should return true if the response is successful or false otherwise`() {
        // Given
        val responseStatus200 =
            Response
                .builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .build()

        val responseStatus100 =
            Response
                .builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.CONTINUE)
                .message("OK")
                .build()

        val responseStatus400 =
            Response
                .builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.NOT_FOUND)
                .message("Not Found")
                .build()

        // When & Expect
        assertTrue(responseStatus200.isSuccessful)
        assertFalse(responseStatus400.isSuccessful)
        assertFalse(responseStatus100.isSuccessful)
    }

    @Test
    fun `should throw exception when required fields are missing`() {
        // Given
        val builder = Response.builder()

        // When & Expect
        assertThrows<IllegalStateException> { builder.build() }.also {
            assertEquals("request is required", it.message)
        }

        builder.request(
            Request
                .Builder()
                .method(Method.GET)
                .url("https://example.com")
                .build()
        )
        assertThrows<IllegalStateException> { builder.build() }.also {
            assertEquals("protocol is required", it.message)
        }

        builder.protocol(Protocol.HTTP_1_1)
        assertThrows<IllegalStateException> { builder.build() }.also {
            assertEquals("status is required", it.message)
        }

        builder.status(Status.OK)
        assertDoesNotThrow { builder.build() }
    }

    @Test
    fun `should close response body`() {
        // Given
        val body = ResponseBody.create("Test body".byteInputStream())
        val response =
            Response
                .Builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .body(body)
                .build()

        // When
        response.close()

        // Expect
        assertFalse(response.body?.source()?.isOpen == true)
    }

    @Test
    fun `should not throw an exception if attempted to close null response body`() {
        // Given
        val response =
            Response
                .Builder()
                .request(
                    Request
                        .Builder()
                        .method(Method.GET)
                        .url("https://example.com")
                        .build()
                ).protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .build()

        // When & Expect
        assertDoesNotThrow { response.close() }
    }
}
