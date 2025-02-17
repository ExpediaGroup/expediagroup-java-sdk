package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.HeadersTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.expediagroup.sdk.rest.trait.operation.UrlPathTrait
import com.expediagroup.sdk.rest.trait.operation.UrlQueryParamsTrait
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.net.URL

class OperationToRequestExtensionTest {
    @Nested
    inner class ParseRequestTest {
        @Test
        fun `throws exception when method is empty`() {
            val operation =
                object : UrlPathTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = ""
                }

            assertThrows<IllegalArgumentException> {
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )
            }
        }

        @Test
        fun `parses url path when UrlPathTrait is implemented`() {
            val operation =
                object : UrlPathTrait, OperationRequestTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = "GET"
                }

            val request =
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )

            val actual = request.url.toString()
            val expected = "https://example.com/test"

            assertEquals(expected, actual)
        }

        @Test
        fun `ignores url path and returns base url when path is blank`() {
            val operation =
                object : OperationRequestTrait, UrlPathTrait {
                    override fun getHttpMethod(): String = "GET"

                    override fun getUrlPath(): String = ""
                }

            val request =
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )

            val actual = request.url.toString()
            val expected = "https://example.com"

            assertEquals(expected, actual)
        }

        @Test
        fun `parses headers when HeadersTrait is implemented`() {
            val operation =
                object : OperationRequestTrait, HeadersTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getHeaders(): Headers =
                        Headers.builder()
                            .add("key1", "value1")
                            .add("key2", "value2")
                            .build()
                }

            val request =
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )

            val actual = request.headers
            val expected =
                Headers.builder()
                    .add("key1", "value1")
                    .add("key2", "value2")
                    .build()

            assertEquals(expected, actual)
            assertEquals(request.url, URL("https://example.com"))
        }

        @Test
        fun `headers are empty when operation headers are empty`() {
            val operation =
                object : OperationRequestTrait, HeadersTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getHeaders(): Headers = Headers.builder().build()
                }

            val request =
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )

            val actual = request.headers
            val expected =
                Headers.builder()
                    .build()

            assertEquals(expected, actual)
            assertEquals(request.url, URL("https://example.com"))
        }

        @Test
        fun `parses request body when RequestBodyTrait is implemented`() {
            val operation =
                object : OperationRequestTrait, OperationRequestBodyTrait<List<String>> {
                    override fun getHttpMethod(): String = "POST"

                    override fun getRequestBody(): List<String> = listOf("test1", "test2")

                    override fun getContentType(): String = "application/json"
                }

            val request =
                operation.parseRequest(
                    mapper = jacksonObjectMapper(),
                    url = URL("https://example.com")
                )

            val actual =
                Buffer().apply {
                    request.body!!.writeTo(this)
                }.readUtf8()

            val expected =
                Buffer().apply {
                    RequestBody.create(
                        inputStream = """["test1","test2"]""".byteInputStream(),
                        mediaType = MediaType.parse("application/json"),
                        contentLength = """["test1","test2"]""".byteInputStream().available().toLong()
                    ).writeTo(this)
                }.readUtf8()

            assertEquals(expected, actual)
            assertEquals(MediaType.parse("application/json"), request.body!!.mediaType())
            assertEquals(request.url, URL("https://example.com"))
        }
    }

    @Nested
    inner class ParseUrlTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com:1234/v2/htmx",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com:443/anime",
                "ftp://ftp.example.com:21",
                "file://servername:32234"
            ]
        )
        fun `parses url with different ports`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = "POST"
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `respects base url path`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = "POST"
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `adds query parameters`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlQueryParams(): Map<String, List<String>> =
                        mapOf(
                            "key1" to listOf("value1"),
                            "key2" to listOf("value2", "value3")
                        )
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test?key1=value1&key2=value2&key2=value3")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `ignores empty query parameters when UrlPathTrait is implemented`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getUrlPath(): String = "/test"

                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlQueryParams(): Map<String, List<String>> = emptyMap()
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `adds query parameters and ignores empty values`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlPath(): String = "/test"

                    override fun getUrlQueryParams(): Map<String, List<String>> =
                        mapOf(
                            "key1" to emptyList(),
                            "key2" to listOf("value2", "value3")
                        )
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test?key2=value2&key2=value3")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `adds query parameters and ignores empty keys`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlPath(): String = "/test"

                    override fun getUrlQueryParams(): Map<String, List<String>> =
                        mapOf(
                            "key1" to emptyList(),
                            "" to listOf("value2", "value3")
                        )
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "https://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api"
            ]
        )
        fun `adds query parameters and ignores empty keys and values`(base: String) {
            val baseUrl = URL(base)
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlPath(): String = "/test"

                    override fun getUrlQueryParams(): Map<String, List<String>> =
                        mapOf(
                            "key1" to emptyList(),
                            "" to emptyList()
                        )
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @Test
        fun `ignores empty operation path`() {
            val baseUrl = URL("https://example.com/v1/api")
            val operation =
                object : UrlPathTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlPath(): String = ""
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("https://example.com/v1/api")

            assertEquals(expected, actual)
        }

        @Test
        fun `adds query parameters with empty path`() {
            val baseUrl = URL("https://example.com")
            val operation =
                object : UrlPathTrait, UrlQueryParamsTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getUrlPath(): String = ""

                    override fun getUrlQueryParams(): Map<String, List<String>> =
                        mapOf(
                            "key1" to listOf("value1"),
                            "key2" to listOf("value2", "value3")
                        )
                }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("https://example.com?key1=value1&key2=value2&key2=value3")

            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class ParseMethodTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "get",
                "pOst",
                "POST",
                "pUT",
                "DeLEtE",
                "PAtCh",
                "HEAd",
                "OPTIONS",
                "TrAcE",
                "Connect"
            ]
        )
        fun `parses valid http methods case insensitive`(method: String) {
            val operation =
                object : OperationRequestTrait {
                    override fun getHttpMethod(): String = method
                }

            val actual = operation.parseMethod()
            val expected = Method.valueOf(method.uppercase())

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "Omar",
                "Jordan",
                "Nasser",
                "Dwairi",
                "Noor",
                "Dana"
            ]
        )
        fun `throws exception for invalid http methods`(method: String) {
            val operation =
                object : OperationRequestTrait {
                    override fun getHttpMethod(): String = method
                }

            assertThrows<IllegalArgumentException> {
                operation.parseMethod()
            }
        }
    }

    @Nested
    inner class ParseMediaTypeTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "application/json",
                "Application/Json",
                "application/xml",
                "APPLICATION/XML",
                "application/Yaml",
                "applicatioN/x-WWW-form-urlencoded",
                "application/OCTET-stream",
                "application/pDF",
                "application/ZiP",
                "application/GZIP",
                "application/X-tar",
                "application/x-RAR-compressed"
            ]
        )
        fun `parses valid media types cases insensitive`(mediaType: String) {
            val operation =
                object : ContentTypeTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getContentType(): String = mediaType
                }

            val actual = operation.parseMediaType()
            val expected = MediaType.parse(mediaType)

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "application Omar",
                "Jordan The Guy",
                "JSML"
            ]
        )
        fun `throws exception for invalid media types`(mediaType: String) {
            val operation =
                object : ContentTypeTrait {
                    override fun getHttpMethod(): String = "POST"

                    override fun getContentType(): String = mediaType
                }

            assertThrows<IllegalArgumentException> {
                operation.parseMediaType()
            }
        }
    }

    @Nested
    inner class ParseRequestBodyTest {
        private val mapper = jacksonObjectMapper()

        @Test
        fun `parses request body`() {
            val operation =
                object : OperationRequestBodyTrait<List<String>> {
                    override fun getHttpMethod(): String = "POST"

                    override fun getRequestBody(): List<String> = listOf("test1", "test2")

                    override fun getContentType(): String = "application/json"
                }

            val actual = operation.parseRequestBody(mapper)
            val expected =
                RequestBody.create(
                    inputStream = """["test1","test2"]""".byteInputStream(),
                    mediaType = MediaType.parse("application/json"),
                    contentLength = """["test1","test2"]""".byteInputStream().available().toLong()
                )

            val actualStream =
                Buffer().apply {
                    actual.writeTo(this)
                }.readUtf8()
            val expectedStream =
                Buffer().apply {
                    expected.writeTo(this)
                }.readUtf8()

            assertAll(
                { assertEquals(expected.contentLength(), actual.contentLength()) },
                { assertEquals(expected.mediaType(), actual.mediaType()) },
                { assertEquals(expectedStream, actualStream) }
            )
        }

        @Test
        fun `throws exception for invalid media type`() {
            val operation =
                object : OperationRequestBodyTrait<List<String>> {
                    override fun getHttpMethod(): String = "POST"

                    override fun getRequestBody(): List<String> = listOf("test1", "test2")

                    override fun getContentType(): String = "hi ;)"
                }

            assertThrows<IllegalArgumentException> {
                operation.parseRequestBody(mapper)
            }
        }
    }
}
