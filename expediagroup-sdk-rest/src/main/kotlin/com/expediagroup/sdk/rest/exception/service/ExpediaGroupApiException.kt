package com.expediagroup.sdk.rest.exception.service

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.http.Response
import java.util.UUID

/**
 * Exception class representing an API error response from the Expedia Group services.
 *
 * @param message the detail message of the exception
 * @param cause the cause of the exception
 * @param requestId the ID associated with the API request
 */
class ExpediaGroupApiException(
    requestId: UUID,
    message: String? = null,
    cause: Throwable? = null
) : ExpediaGroupServiceException(
        message = message,
        cause = cause,
        requestId = requestId
    ) {
    companion object {
        /**
         * Factory method to create an `ExpediaGroupApiException` from an unsuccessful `Response`.
         *
         * @param response the `Response` object representing the API response
         * @return an instance of `ExpediaGroupApiException`
         * @throws IllegalArgumentException if the response is successful
         */
        fun forResponse(response: Response): ExpediaGroupApiException {
            require(!response.isSuccessful) { "Response is successful!" }

            val id = response.request.id
            val message = "Unsuccessful response code [${response.status.code}] for request-id [$id]"

            val cause: ExpediaGroupApiException? =
                response.body?.let {
                    ExpediaGroupApiException(
                        requestId = id,
                        message = it.source().readUtf8()
                    )
                }

            return ExpediaGroupApiException(
                requestId = id,
                message = message,
                cause = cause
            )
        }
    }
}
