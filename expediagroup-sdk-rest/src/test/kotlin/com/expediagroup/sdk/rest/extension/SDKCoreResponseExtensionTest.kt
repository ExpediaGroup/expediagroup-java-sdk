package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.util.UUID

class SDKCoreResponseExtensionTest {
    private val mapper = jacksonObjectMapper()

    @Nested
    inner class ToRestResponseOperationResponseBodyTraitTest {
        @Test
        fun `throws ExpediaGroupApiException on unsuccessful response`() {
            val requestId = UUID.randomUUID()
            val inputStream = """{"error": "internal server error"}""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )
            val request = Request.builder().id(requestId).url("http://localhost:8080").method(Method.POST).build()
            val response =
                Response.builder().status(Status.INTERNAL_SERVER_ERROR).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build()
            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val exception =
                assertThrows<ExpediaGroupApiException> {
                    response.toRestResponse(operation, mapper)
                }

            assertEquals(requestId, exception.requestId)
            assertEquals("Unsuccessful response code [500] for request-id [$requestId]", exception.message)
            assertNotNull(exception.cause)
            assertEquals("""{"error": "internal server error"}""", exception.cause?.message)
            assertNull(exception.cause?.cause)
        }

        @Test
        fun `parses response body and headers when OperationResponseBodyTrait is implemented`() {
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build()

            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val restResponse = response.toRestResponse(operation, mapper)

            assertNotNull(restResponse.data)
            assertNotNull(restResponse.headers)
            assertEquals(restResponse.data, listOf("first", "second"))
            assertEquals(1, restResponse.headers.entries().size)
            assertEquals("value", restResponse.headers.get("header"))
        }
    }

    @Nested
    inner class ToRestResponseOperationNoResponseBodyTraitTest {
        @Test
        fun `throws ExpediaGroupApiException on unsuccessful response`() {
            val requestId = UUID.randomUUID()
            val inputStream = """{"error": "internal server error"}""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )
            val request = Request.builder().id(requestId).url("http://localhost:8080").method(Method.POST).build()
            val response =
                Response.builder().status(Status.INTERNAL_SERVER_ERROR).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build()
            val operation =
                object : OperationNoResponseBodyTrait {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait {
                            override fun getHttpMethod(): String = "POST"
                        }
                }

            val exception =
                assertThrows<ExpediaGroupApiException> {
                    response.toRestResponse(operation)
                }

            assertEquals(requestId, exception.requestId)
            assertEquals("Unsuccessful response code [500] for request-id [$requestId]", exception.message)
            assertNotNull(exception.cause)
            assertEquals("""{"error": "internal server error"}""", exception.cause?.message)
            assertNull(exception.cause?.cause)
        }

        @Test
        fun `parses response headers and ignores body values when OperationNoResponseBodyTrait is implemented`() {
            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(
                        Request.builder().url("http://localhost:8080").method(Method.POST).build()
                    ).build()

            val restResponse =
                response.toRestResponse(
                    object : OperationNoResponseBodyTrait {
                        override fun getRequestInfo(): OperationRequestTrait =
                            object : OperationRequestTrait {
                                override fun getHttpMethod(): String = "POST"
                            }
                    }
                )

            assertNull(restResponse.data)
            assertNotNull(restResponse.headers)
            assertEquals(1, restResponse.headers.entries().size)
            assertEquals("value", restResponse.headers.get("header"))
        }
    }

    @Nested
    inner class ParseBodyAsTypeTest {
        @Test
        fun `parses response body as specific type`() {
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build()

            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val parsedBody = response.parseBodyAs(operation, mapper)

            assertNotNull(parsedBody)
            assertEquals(listOf("first", "second"), parsedBody)
        }

        @Test
        fun `throws exception when response content length is 0`() {
            val inputStream = ByteArrayInputStream(ByteArray(0))
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build()

            // when
            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(operation, mapper)
                }
            assertEquals(exception.message, "Response body is empty!")
        }

        @Test
        fun `throws exception when response body is closed`() {
            val inputStream = ByteArrayInputStream(ByteArray(0))
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build().also {
                        it.close()
                    }

            // when
            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(operation, mapper)
                }
            assertEquals(exception.message, "Response body is closed!")
        }

        @Test
        fun `throws exception when response body input stream is exhausted`() {
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).body(responseBody).build().also {
                        it.body!!.source().readAll(Buffer())
                    }

            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(operation, mapper)
                }
            assertEquals(exception.message, "Response body is exhausted!")
        }

        @Test
        fun `throws exception when response body is null`() {
            val request = Request.builder().url("http://localhost:8080").method(Method.POST).build()

            val response =
                Response.builder().addHeader("header", "value").status(Status.ACCEPTED).protocol(Protocol.HTTP_1_1)
                    .request(request).build()

            val operation =
                object : JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
                    override fun getRequestInfo(): OperationRequestTrait =
                        object : OperationRequestTrait, ContentTypeTrait {
                            override fun getHttpMethod(): String = "POST"

                            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                        }

                    override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
                }

            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(operation, mapper)
                }
            assertEquals(exception.message, "Response body is null!")
        }
    }
}
