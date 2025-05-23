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

package com.expediagroup.sdk.rest.trait.operation

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.rest.model.UrlQueryParam
import java.util.UUID

/**
 * Marker interface for operation requests.
 */
interface OperationRequestTrait : OperationTrait {
    /**
     * Get the HTTP method of the request.
     *
     * @return the HTTP method as a String
     */
    fun getHttpMethod(): String

    /**
     * Get the operation ID as defined in the source spec file.
     *
     * @return the operation ID as a String
     */
    fun getOperationId(): String

    /**
     * Maps the status code in the response to the suitable exception type. Conventionally, the exception
     * classes consists of the {OperationName}{StatusCode}Exception (e.g. GetFlightsListing404Exception).
     *
     * @param code              HTTP status code returned by the server.
     * @param errorResponseStr  Raw response body (usually JSON or plain text).
     * @param requestId         Correlation ID extracted from response headers
     * @param message           Optional human-readable message
     * @param cause             Optional root cause that triggered this failure
     *
     * @return The operation-specific exception subclass if available, or a plain
     *         [ExpediaGroupApiException] when no mapping is defined.
     */
    fun getExceptionForCode(
        code: Int,
        errorResponseStr: String? = null,
        requestId: UUID? = null,
        message: String? = null,
        cause: Throwable? = null
    ): ExpediaGroupApiException
}

/**
 * Interface for operations that have a content type.
 */
interface ContentTypeTrait : OperationRequestTrait {
    /**
     * Get the content type of the request.
     *
     * @return the content type as a String
     */
    fun getContentType(): String
}

/**
 * Interface for operations that have URL query parameters.
 */
interface UrlQueryParamsTrait : OperationRequestTrait {
    /**
     * Get the URL query parameters of the request.
     *
     * @return a map of query parameters where the key is the parameter name and the value is a list of parameter values
     */
    fun getUrlQueryParams(): List<UrlQueryParam>
}

/**
 * Interface for operations that have a URL path.
 */
interface UrlPathTrait : OperationRequestTrait {
    /**
     * Get the URL path of the request.
     *
     * @return the URL path as a String
     */
    fun getUrlPath(): String
}

/**
 * Interface for operations that have headers.
 */
interface HeadersTrait : OperationRequestTrait {
    /**
     * Get the headers of the request.
     *
     * @return a wrapper object around HTTP headers.
     */
    fun getHeaders(): Headers
}

/**
 * Interface for operations that have a request body.
 *
 * @param T the type of the request body
 */
interface OperationRequestBodyTrait<T : Any> : OperationRequestTrait, ContentTypeTrait {
    /**
     * Get the request body.
     *
     * @return the request body of type T
     */
    fun getRequestBody(): T
}
