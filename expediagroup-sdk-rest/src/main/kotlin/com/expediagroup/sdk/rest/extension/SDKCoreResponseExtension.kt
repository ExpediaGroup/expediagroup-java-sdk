/*
 * Copyright (C) 2025 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseTrait
import com.fasterxml.jackson.databind.ObjectMapper
import com.expediagroup.sdk.core.http.Response as SDKCoreResponse

/**
 * Extension function to parse the body of an SDKCoreResponse as a specific type.
 *
 * @param T the type of the response body
 * @param operation the operation that defines the response body type
 * @param mapper Jackson object mapper
 * @return the parsed response body of type T
 */
internal fun <T : Any> SDKCoreResponse.parseBodyAs(
    operation: JacksonModelOperationResponseBodyTrait<T>,
    mapper: ObjectMapper
): T {
    require(body != null) { "Response body is null!" }
    require(body!!.source().isOpen) { "Response body is closed!" }
    require(body!!.contentLength() != 0L) { "Response body is empty!" }
    require(body!!.source().exhausted().not()) { "Response body is exhausted!" }

    return mapper.readValue(body!!.source().inputStream(), operation.getTypeIdentifier())
}

/**
 * Extension function to convert an SDKCoreResponse to a RestResponse.
 *
 * @param T the type of the response body
 * @param operation the operation that defines the response body type
 * @param mapper Jackson object mapper
 * @return a Response object containing the parsed response body and headers
 *
 * requestId: UUID,
 *     val statusCode: Int,
 *     val errorResponse: Any? = null,
 *     message: String? = null,
 *     cause: Throwable? = null
 */
internal fun <T : Any> SDKCoreResponse.toRestResponse(
    operation: JacksonModelOperationResponseBodyTrait<T>,
    mapper: ObjectMapper
): Response<T> =
    use {
        throwOnFailure { mapFailedResponseToException(operation) }

        Response(
            data = parseBodyAs(operation, mapper),
            headers = headers
        )
    }

/**
 * Extension function to convert an SDKCoreResponse to a RestResponse with empty body.
 *
 * @return a Response object containing null data and headers
 */
@Suppress("UNUSED_PARAMETER")
internal fun SDKCoreResponse.toRestResponse(operation: OperationNoResponseBodyTrait): Response<Nothing?> =
    use {
        this.throwOnFailure {
            mapFailedResponseToException(operation)
        }

        Response(
            data = null,
            headers = headers
        )
    }

/**
 * Throws an exception if the response is not successful.
 *
 * @param block a lambda function that takes the response and returns a RuntimeException
 * @return the SDKCoreResponse itself if it is successful
 * @throws RuntimeException if the response is not successful
 */
internal fun SDKCoreResponse.throwOnFailure(block: (SDKCoreResponse) -> RuntimeException): SDKCoreResponse =
    if (isSuccessful) {
        this
    } else {
        throw block(this)
    }

/**
 * Converts a **non-2xx [SDKCoreResponse]** into the most specific exception implementing
 * `ExpediaGroupApiException` the SDK can provide.
 *
 * For an operation called `GetFlightListing` as an example. The SDK generates `GetFlightsListing404Exception` if
 * there's a response model defined in the spec file for the `404` status code. This function attempts to deserialize the response
 * to the specified error model for `404` status code (defined in the spec file).
 *
 * ### Resolution algorithm
 * 1. Reads the raw response body (as UTF-8) into *`errorResponse`*.
 * 2. If the body is **non-blank** it delegates to
 *    [JacksonModelOperationResponseBodyTrait.getExceptionForCode] to obtain an
 *    operation-specific exception (e.g. `GetFlightsListing401Exception`).
 * 3. If the delegate throws **`ExpediaGroupResponseParsingException`**
 *    (body could not be deserialized) *or* the body is blank, the method
 *    falls back to a generic [ExpediaGroupApiException] whose `message`
 *    contains the raw text.
 *
 * @param operation the operation metadata used to map *code* → exception type.
 *
 * @return A typed `ExpediaGroupApiException` when the body can be parsed;
 *         otherwise a generic fallback that still carries the status code,
 *         raw body text, and `request.id`.
 */
internal fun SDKCoreResponse.mapFailedResponseToException(operation: OperationResponseTrait): ExpediaGroupApiException {
    val errorResponse = body?.source()?.readUtf8().orEmpty()

    val message =
        buildString {
            append("Received unsuccessful response [${this@mapFailedResponseToException.status.code}]")
            append(" ")
            append("for requestId [${this@mapFailedResponseToException.request.id}]")
            if (errorResponse.isNotEmpty()) {
                append(", ")
                append("Response=$errorResponse")
            }
        }

    return operation.getRequestInfo().getExceptionForCode(
        code = this.status.code,
        errorResponseStr = errorResponse,
        requestId = this.request.id,
        message = message
    )
}
