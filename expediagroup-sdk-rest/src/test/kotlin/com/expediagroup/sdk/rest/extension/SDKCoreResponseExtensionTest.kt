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
import io.mockk.every
import io.mockk.mockk
import okio.Buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.net.URL
import java.util.UUID

class SDKCoreResponseExtensionTest {
    private val mapper = jacksonObjectMapper()

    class Operation500Exception(
        code: Int,
        requestId: UUID,
        message: String?
    ) : ExpediaGroupApiException(code = code, requestId = requestId, message = message)

    class TestOperationWithResponseBody(private val response: Response) :
        JacksonModelOperationResponseBodyTrait<ArrayList<String>> {
        override fun getRequestInfo(): OperationRequestTrait = object : OperationRequestTrait, ContentTypeTrait {
            override fun getHttpMethod(): String = "GET"

            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()

            override fun getOperationId(): String = "testOperation"

            override fun getExceptionForCode(
                code: Int,
                errorResponseStr: String?,
                requestId: UUID?,
                message: String?,
                cause: Throwable?
            ): ExpediaGroupApiException = when (code) {
                500 -> Operation500Exception(code = code, requestId = response.request.id, message = message)
                else -> ExpediaGroupApiException(code = code, requestId = response.request.id, message = message)
            }
        }

        override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
    }

    class TestOperationNoResponseBody(private val response: Response) : OperationNoResponseBodyTrait {
        override fun getRequestInfo(): OperationRequestTrait = object : OperationRequestTrait, ContentTypeTrait {
            override fun getHttpMethod(): String = "GET"

            override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()

            override fun getOperationId(): String = "testOperation"

            override fun getExceptionForCode(
                code: Int,
                errorResponseStr: String?,
                requestId: UUID?,
                message: String?,
                cause: Throwable?
            ): ExpediaGroupApiException = when (code) {
                500 -> Operation500Exception(code = code, requestId = response.request.id, message = message)
                else -> ExpediaGroupApiException(code = code, requestId = response.request.id, message = message)
            }
        }
    }

    @Nested
    inner class ToRestResponseOperationResponseBodyTraitTest {
        @Test
        fun `throws the corresponding exception for the received unsuccessful response`() {
            // GIVEN
            val responseBodyString = """{"error": "internal server error"}"""
            val responseBodyStream = responseBodyString.byteInputStream()

            val responseBody =
                ResponseBody.create(
                    inputStream = responseBodyStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = responseBodyStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.POST)
                    .build()

            val response =
                Response.builder()
                    .body(responseBody)
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<Operation500Exception> {
                    response.toRestResponse(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(request.id, exception.requestId)
            assertEquals(Status.INTERNAL_SERVER_ERROR.code, exception.code)
            assertEquals(
                "Received unsuccessful response [${response.status.code}] for requestId [${request.id}], Response={\"error\": \"internal server error\"}",
                exception.message
            )
        }

        @Test
        fun `throws the default ExpediaGroupApiException if the error code does not have corresponding exception`() {
            // GIVEN
            val responseBodyString = """{"error": "internal server error"}"""
            val responseBodyStream = responseBodyString.byteInputStream()

            val responseBody =
                ResponseBody.create(
                    inputStream = responseBodyStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = responseBodyStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.POST)
                    .build()

            val response =
                Response.builder()
                    .body(responseBody)
                    .status(Status.CONFLICT)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<ExpediaGroupApiException> {
                    response.toRestResponse(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(request.id, exception.requestId)
            assertEquals(Status.CONFLICT.code, exception.code)
            assertEquals(
                "Received unsuccessful response [${response.status.code}] for requestId [${request.id}], Response={\"error\": \"internal server error\"}",
                exception.message
            )
        }

        @Test
        fun `throws the expected exception when the response source is null`() {
            // GIVEN
            val responseBodyString = """{"error": "internal server error"}"""
            val responseBodyStream = responseBodyString.byteInputStream()

            val responseBody =
                ResponseBody.create(
                    inputStream = responseBodyStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = responseBodyStream.available().toLong()
                )

            val mockRequest =
                mockk<Request>(relaxed = true) {
                    every { id } returns UUID.randomUUID()
                    every { url } returns URL("http://localhost:8080")
                    every { method } returns Method.POST
                }

            val response =
                mockk<Response>(relaxed = true) {
                    every { status } returns Status.CONFLICT
                    every { protocol } returns Protocol.HTTP_1_1
                    every { request } returns mockRequest
                    every { body } returns responseBody
                    every { body?.source() } returns null
                }

            // WHEN & EXPECT
            val exception =
                assertThrows<ExpediaGroupApiException> {
                    response.toRestResponse(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(mockRequest.id, exception.requestId)
            assertEquals(Status.CONFLICT.code, exception.code)
            assertEquals(
                "Received unsuccessful response [${response.status.code}] for requestId [${mockRequest.id}]",
                exception.message
            )
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

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .body(responseBody)
                    .build()

            val restResponse = response.toRestResponse(TestOperationWithResponseBody(response), mapper)

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
        fun `throws the corresponding exception for the received unsuccessful response`() {
            // GIVEN
            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<Operation500Exception> {
                    response.toRestResponse(TestOperationNoResponseBody(response))
                }

            assertEquals(request.id, exception.requestId)
            assertEquals(Status.INTERNAL_SERVER_ERROR.code, exception.code)
            assertEquals(
                "Received unsuccessful response [${response.status.code}] for requestId [${request.id}]",
                exception.message
            )
        }

        @Test
        fun `throws the default ExpediaGroupAPiException if the error code does not have corresponding exception`() {
            // GIVEN
            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .status(Status.CONFLICT)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<ExpediaGroupApiException> {
                    response.toRestResponse(TestOperationNoResponseBody(response))
                }

            assertEquals(request.id, exception.requestId)
            assertEquals(Status.CONFLICT.code, exception.code)
            assertEquals(
                "Received unsuccessful response [${response.status.code}] for requestId [${request.id}]",
                exception.message
            )
        }

        @Test
        fun `parses response headers and ignores body values when OperationNoResponseBodyTrait is implemented`() {
            // GIVEN
            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            val restResponse = response.toRestResponse(TestOperationNoResponseBody(response))

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
            // GIVEN
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .body(responseBody)
                    .build()

            // WHEN
            val parsedBody = response.parseBodyAs(TestOperationWithResponseBody(response), mapper)

            // EXPECT
            assertNotNull(parsedBody)
            assertEquals(listOf("first", "second"), parsedBody)
        }

        @Test
        fun `throws exception when response content length is 0`() {
            // GIVEN
            val inputStream = ByteArrayInputStream(ByteArray(0))
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .body(responseBody)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(exception.message, "Response body is empty!")
        }

        @Test
        fun `throws exception when response body is closed`() {
            // GIVEN
            val inputStream = ByteArrayInputStream(ByteArray(0))
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.POST)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .body(responseBody)
                    .build()
                    .also { it.close() }

            // WHEN & EXPECT
            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(exception.message, "Response body is closed!")
        }

        @Test
        fun `throws exception when response body input stream is exhausted`() {
            // GIVEN
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody =
                ResponseBody.create(
                    inputStream = inputStream,
                    mediaType = CommonMediaTypes.APPLICATION_JSON,
                    contentLength = inputStream.available().toLong()
                )

            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .body(responseBody)
                    .build()
                    .also {
                        it.body!!.source().readAll(Buffer())
                    }

            // WHEN & EXPECT
            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(exception.message, "Response body is exhausted!")
        }

        @Test
        fun `throws exception when response body is null`() {
            // GIVEN
            val request =
                Request.builder()
                    .url("http://localhost:8080")
                    .method(Method.GET)
                    .build()

            val response =
                Response.builder()
                    .addHeader("header", "value")
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            // WHEN & EXPECT
            val exception =
                assertThrows<IllegalArgumentException> {
                    response.parseBodyAs(TestOperationWithResponseBody(response), mapper)
                }

            assertEquals(exception.message, "Response body is null!")
        }
    }
}
