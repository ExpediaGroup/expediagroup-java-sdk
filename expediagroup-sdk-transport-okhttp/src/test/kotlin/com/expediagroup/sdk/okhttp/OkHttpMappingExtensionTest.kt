package com.expediagroup.sdk.okhttp

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import okio.BufferedSink
import okio.BufferedSource
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.net.URI

class OkHttpMappingExtensionTest {
    @Nested
    inner class FromOkHttpToSDKConversion {
        @Nested
        inner class ToSDKRequestExtensionFunction {
            @Test
            fun `should correctly map OkHttp Request to SDK Request without body`() {
                // Given
                val okHttpRequest =
                    okhttp3.Request.Builder()
                        .url("https://example.com")
                        .method("GET", null)
                        .header("Authorization", "Bearer token")
                        .method("GET", null)
                        .build()

                // When
                val sdkRequest = okHttpRequest.toSDKRequest()

                // Expect
                assertEquals("https://example.com/", sdkRequest.url.toString())
                assertEquals("Bearer token", sdkRequest.headers.get("Authorization"))
                assertNull(sdkRequest.body)
            }

            @Test
            fun `should correctly map OkHttp Request to SDK Request with body`() {
                // Given
                val content = "Hello World"
                val mediaTypeString = "text/plain"

                val okHttpRequestBody =
                    object : okhttp3.RequestBody() {
                        override fun contentType(): okhttp3.MediaType? = mediaTypeString.toMediaTypeOrNull()

                        override fun writeTo(sink: BufferedSink) {
                            sink.writeUtf8(content)
                        }
                    }

                val okHttpRequest =
                    okhttp3.Request.Builder()
                        .url("https://example.com")
                        .method("POST", okHttpRequestBody)
                        .header("Authorization", "Bearer token")
                        .build()

                // When
                val sdkRequest = okHttpRequest.toSDKRequest()

                val okHttpRequestBodyBuffer = Buffer() // Capture the original body data using a Buffer
                okHttpRequest.body?.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                val sdkRequestBodyBuffer = Buffer() // Capture the SDK request body
                sdkRequest.body?.writeTo(sdkRequestBodyBuffer)
                val sdkRequestBodyString = sdkRequestBodyBuffer.readUtf8()

                // Then
                assertEquals("https://example.com/", sdkRequest.url.toString())
                assertEquals("Bearer token", sdkRequest.headers.get("Authorization"))
                assertEquals(okHttpRequestBodyString, sdkRequestBodyString)
                assertNotEquals("", sdkRequestBodyString)
                assertNotEquals("", okHttpRequestBodyString)
            }
        }

        @Nested
        inner class ToSDKHeadersExtensionFunction {
            @Test
            fun `should correctly map OkHttp Headers to SDK Headers`() {
                // Given
                val okHttpHeaders =
                    okhttp3.Headers.Builder()
                        .add("Content-Type", "application/json")
                        .add("Authorization", "Bearer token")
                        .add("Content-Type", "text/plain")
                        .build()

                // When
                val sdkHeaders = okHttpHeaders.toSDKHeaders()

                // Expect
                assertEquals(listOf("application/json", "text/plain"), sdkHeaders.values("Content-Type"))
                assertEquals("Bearer token", sdkHeaders.get("Authorization"))
            }
        }

        @Nested
        inner class ToSDKRequestBodyExtensionFunction {
            @Test
            fun `should correctly map OkHttp RequestBody to SDK RequestBody with media type`() {
                // Given
                val content = "Hello World"
                val mediaTypeString = "text/plain"
                val contentLength = content.length.toLong()

                val okHttpRequestBody =
                    object : okhttp3.RequestBody() {
                        override fun contentLength(): Long = contentLength

                        override fun contentType(): okhttp3.MediaType? = mediaTypeString.toMediaTypeOrNull()

                        override fun writeTo(sink: BufferedSink) {
                            sink.writeUtf8(content)
                        }
                    }

                // When
                val sdkRequestBody = okHttpRequestBody.toSDKRequestBody()

                // Expect
                assertEquals(mediaTypeString, sdkRequestBody.mediaType()?.toString())
                assertEquals(contentLength, sdkRequestBody.contentLength())
                assertDoesNotThrow {
                    sdkRequestBody.writeTo(mockk(relaxed = true)) // Ensure write doesn't throw
                }
            }

            @Test
            fun `should correctly map OkHttp RequestBody to SDK RequestBody without media type`() {
                // Given
                val content = "Hello World"
                val contentLength = content.length.toLong()

                val okHttpRequestBody =
                    object : okhttp3.RequestBody() {
                        override fun contentType(): okhttp3.MediaType? = null

                        override fun contentLength(): Long = contentLength

                        override fun writeTo(sink: BufferedSink) {
                            sink.writeUtf8("Hello World")
                        }
                    }

                // When
                val sdkRequestBody = okHttpRequestBody.toSDKRequestBody()

                // Expect
                assertNull(sdkRequestBody.mediaType())
                assertEquals(contentLength, sdkRequestBody.contentLength())
                assertDoesNotThrow {
                    sdkRequestBody.writeTo(mockk(relaxed = true)) // Ensure write doesn't throw
                }
            }
        }

        @Nested
        inner class ToSDKResponseExtensionFunction {
            @Test
            fun `should correctly map OkHttp Response to SDK Response with response body`() {
                // Given
                val sdkRequest =
                    Request.builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()

                val okHttpResponse =
                    okhttp3.Response.Builder()
                        .request(okhttp3.Request.Builder().url("https://example.com").build())
                        .protocol(okhttp3.Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .header("Content-Type", "application/json")
                        .body("Response body".toResponseBody())
                        .build()

                // When
                val sdkResponse = okHttpResponse.toSDKResponse(sdkRequest)

                // Expect
                assertEquals(Protocol.HTTP_1_1, sdkResponse.protocol)
                assertEquals(200, sdkResponse.status.code)
                assertEquals("OK", sdkResponse.message)
                assertEquals("application/json", sdkResponse.headers.get("Content-Type"))
                assertEquals("Response body", sdkResponse.body?.source().use { source -> source?.readUtf8() })
            }

            @Test
            fun `should correctly map OkHttp Response to SDK Response without response body`() {
                // Given
                val sdkRequest =
                    Request.builder()
                        .url("https://example.com")
                        .method(Method.POST)
                        .build()

                val okHttpResponse =
                    okhttp3.Response.Builder()
                        .request(okhttp3.Request.Builder().url("https://example.com").build())
                        .protocol(okhttp3.Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .header("Content-Type", "application/json")
                        .build()

                // When
                val sdkResponse = okHttpResponse.toSDKResponse(sdkRequest)

                // Expect
                assertEquals(Protocol.HTTP_1_1, sdkResponse.protocol)
                assertEquals(200, sdkResponse.status.code)
                assertEquals("OK", sdkResponse.message)
                assertEquals("application/json", sdkResponse.headers.get("Content-Type"))
                assertNull(sdkResponse.body)
            }

            @Test
            fun `should close the original response body after mapping`() {
                // Given
                val okHttpResponse = mockk<okhttp3.Response>(relaxed = true)
                val okHttpResponseBody = mockk<okhttp3.ResponseBody>(relaxed = true)
                val sdkRequest = mockk<Request>(relaxed = true)

                every { okHttpResponse.body } returns okHttpResponseBody
                every { okHttpResponse.protocol } returns okhttp3.Protocol.HTTP_1_1
                every { okHttpResponse.code } returns 200
                every { okHttpResponseBody.contentType() } returns "text/plain".toMediaTypeOrNull()

                // When
                okHttpResponse.toSDKResponse(sdkRequest)

                // Expect
                verify { okHttpResponseBody.close() }
            }
        }

        @Nested
        inner class ToSDKResponseBodyExtensionFunction {
            @Test
            fun `should correctly map OkHttp ResponseBody to SDK ResponseBody with media type`() {
                // Given
                val okHttpResponseBody = "Response body".toResponseBody("text/plain".toMediaTypeOrNull())

                // When
                val sdkResponseBody = okHttpResponseBody.toSDKResponseBody()

                // Expect
                assertEquals("text/plain;charset=utf-8", sdkResponseBody.mediaType()?.toString())
                assertEquals("Response body", sdkResponseBody.source().use { source -> source.readUtf8() })
            }

            @Test
            fun `should correctly map OkHttp ResponseBody to SDK ResponseBody without media type`() {
                // Given
                val okHttpResponseBody = "Response body".toResponseBody()

                // When
                val sdkResponseBody = okHttpResponseBody.toSDKResponseBody()

                // Expect
                assertEquals("Response body", sdkResponseBody.source().use { source -> source.readUtf8() })
                assertNull(sdkResponseBody.mediaType())
            }

            @Test
            fun `should close the original response body after mapping`() {
                // Given
                val okHttpResponseBody = mockk<okhttp3.ResponseBody>(relaxed = true)
                val mockContent = "Test content"

                every { okHttpResponseBody.contentType() } returns "text/plain".toMediaTypeOrNull()
                every { okHttpResponseBody.contentLength() } returns mockContent.length.toLong()
                every { okHttpResponseBody.source() } returns Buffer().writeUtf8(mockContent)

                // When
                val sdkResponseBody = okHttpResponseBody.toSDKResponseBody()

                // Expect
                verify { okHttpResponseBody.close() }
                assertEquals(mockContent, sdkResponseBody.source().readUtf8())
            }
        }
    }

    @Nested
    inner class FromSDKToOkHttpConversion {
        @Nested
        inner class ToOkHttpRequestExtensionFunction {
            @Test
            fun `should correctly map SDK Request to OkHttp Request with request body and with media type`() {
                // Given
                val originalContent = "Hello World"

                val sdkRequest =
                    Request.builder()
                        .url("https://example.com")
                        .addHeader("Authorization", "Bearer token")
                        .method(Method.POST)
                        .body(RequestBody.create(originalContent.byteInputStream(), CommonMediaTypes.TEXT_PLAIN))
                        .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                val okHttpBodyBuffer = Buffer() // Capture the OkHttp body
                okHttpRequest.body?.writeTo(okHttpBodyBuffer)
                val actualBody = okHttpBodyBuffer.readUtf8()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("POST", okHttpRequest.method)
                assertEquals("text/plain", okHttpRequest.body?.contentType().toString())
                assertEquals(originalContent, actualBody)
            }

            @Test
            fun `should correctly map SDK Request to OkHttp Request with request body and without media type`() {
                // Given
                val originalContent = "Hello World"

                val sdkRequest =
                    Request.builder()
                        .url("https://example.com")
                        .addHeader("Authorization", "Bearer token")
                        .method(Method.POST)
                        .body(RequestBody.create(originalContent.byteInputStream()))
                        .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                // Capture the OkHttp body
                val okHttpBodyBuffer = Buffer()
                okHttpRequest.body?.writeTo(okHttpBodyBuffer)
                val actualBody = okHttpBodyBuffer.readUtf8()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("POST", okHttpRequest.method)
                assertNull(okHttpRequest.body?.contentType())
                assertEquals(originalContent, actualBody)
            }

            @Test
            fun `should correctly map SDK Request to OkHttp Request without request body`() {
                // Given
                val sdkRequest =
                    Request.builder()
                        .url("https://example.com")
                        .addHeader("Authorization", "Bearer token")
                        .method(Method.GET)
                        .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("GET", okHttpRequest.method)
                assertNull(okHttpRequest.body)
            }
        }

        @Nested
        inner class ToOkHttpHeadersExtensionFunction {
            @Test
            fun `should correctly map SDK Headers to OkHttp Headers`() {
                // Given
                val sdkHeaders =
                    Headers.builder()
                        .add("Content-Type", "application/json")
                        .add("Authorization", "Bearer token")
                        .add("Accept", listOf("text/plain", "text/html"))
                        .build()

                // When
                val okHttpHeaders = sdkHeaders.toOkHttpHeaders()

                // Expect
                assertEquals("application/json", okHttpHeaders["Content-Type"])
                assertEquals(listOf("text/plain", "text/html"), okHttpHeaders.values("accept"))
                assertEquals("Bearer token", okHttpHeaders["Authorization"])
            }
        }

        @Nested
        inner class ToOkHttpRequestBodyExtensionFunction {
            @Test
            fun `should correctly map SDK RequestBody to OkHttp RequestBody with media type`() {
                // Given
                val content = "Hello World"
                val sdkRequestBody =
                    RequestBody.create(
                        inputStream = content.byteInputStream(),
                        mediaType = MediaType.parse("text/plain"),
                        contentLength = content.length.toLong()
                    )

                // When
                val okHttpRequestBody = sdkRequestBody.toOkHttpRequestBody()

                val okHttpRequestBodyBuffer = Buffer()
                okHttpRequestBody.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                // Expect
                assertEquals("text/plain", okHttpRequestBody.contentType()?.toString())
                assertEquals(content.length.toLong(), okHttpRequestBody.contentLength())
                assertEquals(content, okHttpRequestBodyString)
                assertDoesNotThrow {
                    okHttpRequestBody.writeTo(mockk(relaxed = true))
                }
            }

            @Test
            fun `should correctly map SDK RequestBody to OkHttp RequestBody without media type`() {
                // Given
                val content = "Hello World"
                val sdkRequestBody =
                    RequestBody.create(
                        inputStream = content.byteInputStream(),
                        contentLength = content.length.toLong()
                    )

                // When
                val okHttpRequestBody = sdkRequestBody.toOkHttpRequestBody()

                val okHttpRequestBodyBuffer = Buffer()
                okHttpRequestBody.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                // Expect
                assertEquals(content.length.toLong(), okHttpRequestBody.contentLength())
                assertEquals(content, okHttpRequestBodyString)
                assertNull(okHttpRequestBody.contentType())
                assertDoesNotThrow {
                    okHttpRequestBody.writeTo(mockk(relaxed = true))
                }
            }
        }

        @Nested
        inner class ToOkHttpResponseExtensionFunction {
            @Test
            fun `should correctly map SDK Response to OkHttp Response`() {
                // Given
                val content = "Response Body"

                val sdkResponseBody =
                    ResponseBody.create(
                        inputStream = content.byteInputStream(),
                        mediaType = CommonMediaTypes.TEXT_PLAIN,
                        contentLength = content.length.toLong()
                    )

                val sdkResponse =
                    Response.builder()
                        .body(sdkResponseBody)
                        .protocol(Protocol.HTTP_1_1)
                        .status(Status.OK)
                        .request(Request.Builder().url("https://example.com").method(Method.GET).build())
                        .build()

                // When
                val okHttpResponse = sdkResponse.toOkHttpResponse()

                // Expect
                assertNotNull(okHttpResponse.body)
                assertEquals(sdkResponse.protocol.name, okHttpResponse.protocol.name)
                assertEquals(sdkResponse.status.code, okHttpResponse.code)
                assertEquals(CommonMediaTypes.TEXT_PLAIN.toString(), okHttpResponse.body?.contentType().toString())
                assertEquals(content.length.toLong(), okHttpResponse.body?.contentLength())
                assertEquals(content, okHttpResponse.body?.source().use { source -> source?.readUtf8() })
            }

            @Test
            fun `should close the original response body after mapping`() {
                // Given
                val sdkResponse = mockk<Response>(relaxed = true)
                val sdkResponseBody = mockk<ResponseBody>(relaxed = true)

                every { sdkResponse.body } returns sdkResponseBody
                every { sdkResponse.body?.source() } returns mockk<BufferedSource>(relaxed = true)
                every { sdkResponse.request } returns mockk<Request>(relaxed = true)
                every { sdkResponse.request.url } returns URI("https://example.com").toURL()
                every { sdkResponse.request.method } returns Method.POST
                every { sdkResponse.protocol } returns Protocol.HTTP_1_1
                every { sdkResponse.status } returns Status.OK

                // When
                sdkResponse.toOkHttpResponse()

                // Expect
                verify { sdkResponse.body?.close() }
            }
        }

        @Nested
        inner class ToOkHttpResponseBodyExtensionFunction {
            @Test
            fun `should correctly map SDK ResponseBody to OkHttp ResponseBody`() {
                // Given
                val content = "Response Body"
                val sdkResponseBody =
                    ResponseBody.create(
                        inputStream = content.byteInputStream(),
                        mediaType = CommonMediaTypes.TEXT_PLAIN,
                        contentLength = content.length.toLong()
                    )

                // When
                val okHttpResponseBody = sdkResponseBody.toOkHttpResponseBody()

                // Expect
                assertEquals(CommonMediaTypes.TEXT_PLAIN.toString(), okHttpResponseBody.contentType().toString())
                assertEquals(content.length.toLong(), okHttpResponseBody.contentLength())
                assertEquals(content, okHttpResponseBody.source().use { source -> source.readUtf8() })
            }

            @Test
            fun `should close the original response body after mapping`() {
                // Given
                val sdkResponseBody = mockk<ResponseBody>(relaxed = true)
                val mockContent = "Test content"

                every { sdkResponseBody.mediaType() } returns MediaType.parse("text/plain")
                every { sdkResponseBody.contentLength() } returns mockContent.length.toLong()
                every { sdkResponseBody.source() } returns Buffer().writeUtf8(mockContent)

                // When
                val okHttpResponseBody = sdkResponseBody.toOkHttpResponseBody()

                // Expect
                verify { sdkResponseBody.close() }
                assertEquals(mockContent, okHttpResponseBody.source().readUtf8())
            }
        }
    }
}
