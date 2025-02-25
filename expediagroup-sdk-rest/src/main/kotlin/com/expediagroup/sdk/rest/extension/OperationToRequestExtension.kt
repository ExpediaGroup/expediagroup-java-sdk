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

import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.HeadersTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.expediagroup.sdk.rest.trait.operation.UrlPathTrait
import com.expediagroup.sdk.rest.trait.operation.UrlQueryParamsTrait
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

/**
 * Extension function to parse an operation request into an SDK request.
 *
 * This function takes an operation request and converts it into an SDK request
 * by setting the HTTP method, headers, body, and URL based on the traits of the operation.
 *
 * @param url the base server URL
 * @param mapper Jackson object mapper used to serialize the request body
 * @return the constructed SDK request
 * @throws IllegalArgumentException if the request body is invalid
 * @throws IllegalStateException if the HTTP method or URL is not set
 * @throws IOException if an I/O error occurs
 */
internal fun OperationRequestTrait.parseRequest(
    url: URL,
    mapper: ObjectMapper
): Request {
    val builder = Request.builder().method(this.parseMethod())

    if (this is HeadersTrait && this.getHeaders().entries().isNotEmpty()) {
        builder.headers(this.getHeaders())
    }

    if (this is OperationRequestBodyTrait<*>) {
        builder.body(this.parseRequestBody(mapper))
    }

    builder.url(
        if (this is UrlPathTrait && this.getUrlPath().isNotBlank()) {
            this.parseURL(url)
        } else {
            url
        }
    )

    return builder.build()
}

/**
 * Extension function to parse the URL of an operation request.
 *
 * This function constructs the full URL by combining the base URL with the path and query parameters
 * from the operation request.
 *
 * @param base the base URL
 * @return the constructed URL
 * @throws MalformedURLException if the constructed URL is invalid
 */
internal fun UrlPathTrait.parseURL(base: URL): URL =
    URL(
        StringBuilder().apply {
            append(base.toString().trim('/'))

            if (this@parseURL.getUrlPath().isNotBlank()) {
                append(this@parseURL.getUrlPath())
            }

            if (this@parseURL is UrlQueryParamsTrait && this@parseURL.getUrlQueryParams().isNotEmpty()) {
                append("?")
                append(this@parseURL.getUrlQueryParams().joinToString("&"))
            }
        }.toString()
    )

/**
 * Extension function to parse the HTTP method of an operation request.
 *
 * This function converts the HTTP method from the operation request into the Method enum.
 *
 * @return the HTTP method
 * @throws IllegalArgumentException if the HTTP method is invalid
 */
internal fun OperationRequestTrait.parseMethod(): Method = Method.valueOf(getHttpMethod().uppercase())

/**
 * Extension function to parse the media type of operation request.
 *
 * This function converts the content type from the operation request into the MediaType object.
 *
 * @return the media type
 * @throws IllegalArgumentException if the content type is invalid
 */
internal fun ContentTypeTrait.parseMediaType(): MediaType = MediaType.parse(getContentType())

/**
 * Extension function to parse the request body of an operation request.
 *
 * This function serializes the request body and constructs the RequestBody object.
 *
 * @param mapper Jackson object mapper used to serialize the request body
 * @return the constructed request body
 * @throws IllegalStateException if the request body cannot be serialized
 * @throws IOException if an I/O error occurs
 */
internal fun OperationRequestBodyTrait<*>.parseRequestBody(mapper: ObjectMapper): RequestBody {
    val inputStream = mapper.writeValueAsBytes(this.getRequestBody()).inputStream()

    return RequestBody.create(
        inputStream = inputStream,
        mediaType = parseMediaType(),
        contentLength = inputStream.available().toLong()
    )
}
