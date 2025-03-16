package com.expediagroup.sdk.rest.exception.service

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class ExpediaGroupApiExceptionTest {
    @Test
    fun `creates exception from passed params`() {
        val requestId = UUID.randomUUID()
        val message = "test message"
        val cause = RuntimeException("test cause")

        val exception = ExpediaGroupApiException(requestId, message, cause)

        assertEquals(requestId, exception.requestId)
        assertEquals(message, exception.message)
        assertEquals(cause, exception.cause)
    }

    @Test
    fun `creates exception with default message parameter`() {
        val requestId = UUID.randomUUID()
        val cause = RuntimeException("test cause")

        val exception = ExpediaGroupApiException(requestId, cause = cause)

        assertEquals(requestId, exception.requestId)
        assertNull(exception.message)
        assertEquals(cause, exception.cause)
    }

    @Test
    fun `creates exception from unsuccessful response`() {
        val requestId = UUID.randomUUID()
        val apiResponse = """{"error": "internal server error"}""".byteInputStream()
        val mockResponse: Response =
            mockk(relaxed = true) {
                every { isSuccessful } returns false
                every { status } returns Status.INTERNAL_SERVER_ERROR
                every { request } returns
                    mockk {
                        every { id } returns requestId
                    }
                every { body } returns
                    ResponseBody.Companion.create(
                        inputStream = apiResponse,
                        mediaType = CommonMediaTypes.APPLICATION_JSON,
                        contentLength = apiResponse.available().toLong()
                    )
            }

        val exception = ExpediaGroupApiException.forResponse(mockResponse)

        assertEquals(requestId, exception.requestId)
        assertEquals(
            "Unsuccessful response code [${mockResponse.status.code}] for request-id [$requestId]",
            exception.message
        )
        assertInstanceOf(ExpediaGroupApiException::class.java, exception.cause)
        assertEquals("""{"error": "internal server error"}""", exception.cause?.message)
        assertNull(exception.cause?.cause)
    }

    @Test
    fun `throws IllegalArgumentException when response is successful`() {
        val mockResponse: Response =
            mockk(relaxed = true) {
                every { isSuccessful } returns true
            }

        val illegalArgumentException =
            assertThrows<IllegalArgumentException> {
                ExpediaGroupApiException.forResponse(mockResponse)
            }

        assertEquals("Response is successful!", illegalArgumentException.message)
    }

    @Test
    fun `cause is null when the api returns empty response body`() {
        val requestId = UUID.randomUUID()
        val mockResponse: Response =
            mockk(relaxed = true) {
                every { isSuccessful } returns false
                every { status } returns Status.INTERNAL_SERVER_ERROR
                every { request } returns
                    mockk {
                        every { id } returns requestId
                    }
                every { body } returns null
            }

        val exception = ExpediaGroupApiException.forResponse(mockResponse)

        assertNull(exception.cause)
        assertEquals("Unsuccessful response code [500] for request-id [${mockResponse.request.id}]", exception.message)
        assertEquals(requestId, exception.requestId)
    }
}
