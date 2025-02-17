package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.core.http.Headers

/**
 * A generic response model that contains the data and headers of an HTTP response.
 *
 * @param T the type of the response data
 * @property data the response data
 * @property headers the response headers
 */
data class Response<T>(
    val data: T,
    val headers: Headers
)
