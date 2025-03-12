package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.net.MalformedURLException
import java.net.URL

class RequestTest {
    @Test
    fun `should build request instance with all properties`() {
        // Given
        val method = Method.POST
        val url = URL("https://example.com")
        val headers = Headers.Builder().add("Authorization", "Bearer token").build()
        val body = RequestBody.create("Sample body".byteInputStream())

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .headers(headers)
                .body(body)
                .build()

        // Expect
        assertEquals(method, request.method)
        assertEquals(url, request.url)
        assertEquals("Bearer token", request.headers.get("Authorization"))
        assertEquals(body, request.body)
    }

    @Test
    fun `should build a new request based on previous instance`() {
        // Given
        val originalRequest =
            Request
                .builder()
                .method(Method.GET)
                .url("https://example.com")
                .addHeader("Content-Type", "application/json")
                .build()

        // When
        val newRequest =
            originalRequest
                .newBuilder()
                .addHeader("Accept", "text/plain")
                .build()

        // Expect
        assertEquals(Method.GET, newRequest.method)
        assertEquals(originalRequest.url, newRequest.url)

        assertEquals("application/json", originalRequest.headers.get("Content-Type"))
        assertNull(originalRequest.headers.get("Accept"))

        assertEquals("application/json", newRequest.headers.get("Content-Type"))
        assertEquals("text/plain", newRequest.headers.get("Accept"))
    }

    @Test
    fun `request id changes when request is built based on another request instance`() {
        // Given
        val firstRequest =
            Request
                .builder()
                .method(Method.GET)
                .url("https://example.com")
                .addHeader("Content-Type", "application/json")
                .build()

        val secondRequest = firstRequest.newBuilder().build()

        // Expect
        assertNotNull(firstRequest.id)
        assertNotNull(secondRequest.id)
        assertNotEquals(firstRequest.id, secondRequest.id)
    }

    @Test
    fun `should build a request with valid method and url string`() {
        // Given
        val urlString = "https://example.com"

        // When
        val request =
            Request
                .builder()
                .method(Method.GET)
                .url(urlString)
                .build()

        // Expect
        assertEquals(URL(urlString), request.url)
    }

    @Test
    fun `should add single header`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue = "application/json"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .addHeader(headerName, headerValue)
                .build()

        // Expect
        assertEquals(headerValue, request.headers.get(headerName))
    }

    @Test
    fun `should add multiple values for one header`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .addHeader(headerName, headerValue1)
                .addHeader(headerName, headerValue2)
                .build()

        // Expect
        assertEquals(listOf(headerValue1, headerValue2), request.headers.values(headerName))
    }

    @Test
    fun `should set one single header`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue = "application/json"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .setHeader(headerName, headerValue)
                .build()

        // Expect
        assertEquals(headerValue, request.headers.get(headerName))
    }

    @Test
    fun `should set multiple values for one header`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .setHeader(headerName, headerValue1)
                .setHeader(headerName, headerValue2)
                .build()

        // Expect
        assertEquals(listOf(headerValue2), request.headers.values(headerName))
    }

    @Test
    fun `should add multiple values for one header as a list`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .addHeader(headerName, listOf(headerValue1, headerValue2))
                .build()

        // Expect
        assertEquals(listOf(headerValue1, headerValue2), request.headers.values(headerName))
    }

    @Test
    fun `should set multiple values for one header as a list`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName = "content-type"
        val headerValue1 = "application/json"
        val headerValue2 = "text/plain"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .setHeader(headerName, listOf(headerValue1, headerValue2))
                .setHeader(headerName, listOf(headerValue2))
                .build()

        // Expect
        assertEquals(listOf(headerValue2), request.headers.values(headerName))
    }

    @Test
    fun `should handle adding and setting headers as expected`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName1 = "Header1"
        val headerName2 = "Header2"
        val headerName3 = "Header3"
        val headerValue1 = "Value1"
        val headerValue2 = "Value2"
        val headerValue3 = "Value3"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .addHeader(headerName1, headerValue1)
                .setHeader(headerName2, headerValue2)
                .setHeader(headerName1, headerValue3)
                .addHeader(headerName3, listOf(headerValue1, headerValue2))
                .build()

        // Expect
        assertEquals(headerValue3, request.headers.get(headerName1))
        assertEquals(headerValue2, request.headers.get(headerName2))
        assertEquals(listOf(headerValue1, headerValue2), request.headers.values(headerName3))
    }

    @Test
    fun `should remove headers as expected`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"
        val headerName1 = "Header1"
        val headerName2 = "Header2"
        val headerValue1 = "Value1"
        val headerValue2 = "Value2"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .addHeader(headerName1, headerValue1)
                .addHeader(headerName2, headerValue2)
                .removeHeader(headerName1)
                .build()

        // Expect
        assertNull(request.headers.get(headerName1))
        assertEquals(headerValue2, request.headers.get(headerName2))
    }

    @Test
    fun `should build a request without a body`() {
        // Given
        val method = Method.GET
        val url = "https://example.com"

        // When
        val request =
            Request
                .builder()
                .method(method)
                .url(url)
                .build()

        // Expect
        assertNull(request.body)
    }

    @Test
    fun `should throw an exception if the URL string is invalid`() {
        // Given
        val invalidUrl = "invalid_url"

        // When
        val exception =
            assertThrows<MalformedURLException> {
                Request
                    .builder()
                    .method(Method.GET)
                    .url(invalidUrl)
                    .build()
            }

        // Expect
        assertEquals("no protocol: invalid_url", exception.message)
    }

    @Test
    fun `should throw an exception if the method is missing`() {
        val exception =
            assertThrows<IllegalStateException> {
                Request.builder().url("https://example.com").build()
            }

        assertEquals("Method is required.", exception.message)
    }

    @Test
    fun `should throw an exception if the URL is missing`() {
        val exception =
            assertThrows<IllegalStateException> {
                Request.builder().method(Method.GET).build()
            }

        assertEquals("URL is required.", exception.message)
    }
}
