package com.expediagroup.sdk.rest.exception.service

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import java.util.UUID

/**
 * Exception class representing an API error response from the Expedia Group services.
 *
 * @param code the HTTP status code for the received response
 * @param requestId the ID associated with the API request
 * @param message the message of the exception
 * @param cause the cause of the exception
 */
open class ExpediaGroupApiException(
    val code: Int,
    requestId: UUID?,
    message: String? = null,
    cause: Throwable? = null
) : ExpediaGroupServiceException(
        message = message,
        cause = cause,
        requestId = requestId
    )
