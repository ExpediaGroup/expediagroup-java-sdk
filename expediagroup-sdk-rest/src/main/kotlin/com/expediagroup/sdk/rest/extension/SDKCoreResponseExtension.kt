package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
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
    require(body!!.source().isOpen ) { "Response body is closed!" }
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
 */
internal fun <T : Any> SDKCoreResponse.toRestResponse(
    operation: JacksonModelOperationResponseBodyTrait<T>,
    mapper: ObjectMapper
): Response<T> {
    return Response(
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
internal fun SDKCoreResponse.toRestResponse(operation: OperationNoResponseBodyTrait): Response<Nothing?> {
    return Response(
        data = null,
        headers = headers
    )
}
