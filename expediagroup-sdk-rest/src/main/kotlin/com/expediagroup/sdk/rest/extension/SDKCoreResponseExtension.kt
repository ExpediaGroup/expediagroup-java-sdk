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
 */
internal fun <T : Any> SDKCoreResponse.toRestResponse(
    operation: JacksonModelOperationResponseBodyTrait<T>,
    mapper: ObjectMapper
): Response<T> =
    use {
        this.throwOnFailure {
            ExpediaGroupApiException.forResponse(this)
        }

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
            ExpediaGroupApiException.forResponse(this)
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
