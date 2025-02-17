package com.expediagroup.sdk.rest.trait.operation

import com.expediagroup.sdk.core.http.Headers

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
    fun getUrlQueryParams(): Map<String, List<String>>
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
