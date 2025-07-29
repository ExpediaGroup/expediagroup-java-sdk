/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.okhttp

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.MediaType.Companion.parse
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.ResponseBody.Companion.create
import com.expediagroup.sdk.core.http.Status
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.asResponseBody
import okio.Buffer
import okio.BufferedSink
import java.io.IOException

/**
 * Converts an [okhttp3.Request] object to the SDK [Request] object.
 *
 * The conversion includes the URL, headers, and optionally the request body,
 * adapting them to the SDK `Request` structure.
 *
 * @receiver The [okhttp3.Request] to convert.
 * @return A new [Request] object representing the same HTTP request in the SDK format.
 */
fun okhttp3.Request.toSDKRequest(): Request {
    val url = url.toUrl()
    val method = Method.valueOf(method)
    val headers = headers.toSDKHeaders()
    val body = body?.toSDKRequestBody()

    return Request
        .builder()
        .url(url)
        .method(method)
        .headers(headers)
        .apply { body?.let { body(body) } }
        .build()
}

/**
 * Converts [okhttp3.Headers] to the SDK [Headers] object.
 *
 * This method maps the key-value pairs of OkHttp's headers to the SDK
 * `Headers` format, preserving the structure.
 *
 * @receiver The [okhttp3.Headers] to convert.
 * @return A new [Headers] object representing the same HTTP headers in the SDK Headers format.
 */
fun okhttp3.Headers.toSDKHeaders(): Headers = Headers
    .builder()
    .apply {
        this@toSDKHeaders.toMultimap().entries.forEach {
            add(it.key, it.value)
        }
    }
    .build()

/**
 * Converts an [okhttp3.RequestBody] to the SDK [RequestBody].
 *
 * This adapter replicates the behavior of the original [RequestBody],
 * including content type, length, and writing logic, for use within the SDK.
 *
 * @receiver The [okhttp3.RequestBody] to convert.
 * @return A new [RequestBody] compatible with the SDK.
 */
fun okhttp3.RequestBody.toSDKRequestBody(): RequestBody = object : RequestBody() {
    override fun mediaType(): MediaType? = this@toSDKRequestBody.contentType()?.let {
        parse(it.toString())
    }

    override fun contentLength() = this@toSDKRequestBody.contentLength()

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) = this@toSDKRequestBody.writeTo(sink)
}

/**
 * Converts the SDK [Request] object to an [okhttp3.Request].
 *
 * This method adapts the SDK [Request] structure, including the URL, method,
 * headers, and body, into a format compatible with OkHttp.
 *
 * @receiver The SDK [Request] to convert.
 * @return A new [okhttp3.Request] representing the same HTTP request in OkHttp's format.
 */
fun Request.toOkHttpRequest(): okhttp3.Request {
    val url = this.url
    val method = this.method.name
    val headers = this.headers.toOkHttpHeaders()
    val body = this.body?.toOkHttpRequestBody()

    return okhttp3.Request.Builder()
        .url(url)
        .headers(headers)
        .method(method, body)
        .build()
}

/**
 * Converts the SDK [Headers] to [okhttp3.Headers].
 *
 * This method maps the SDK [Headers] entries into OkHttp's format, preserving
 * the header names and their associated values.
 *
 * @receiver The SDK [Headers] to convert.
 * @return A new [okhttp3.Headers] object representing the same HTTP headers.
 */
fun Headers.toOkHttpHeaders(): okhttp3.Headers = okhttp3.Headers.Builder()
    .apply {
        this@toOkHttpHeaders.entries().forEach { (name, values) ->
            values.forEach { value -> this.add(name, value) }
        }
    }.build()

/**
 * Converts the SDK [RequestBody] to an [okhttp3.RequestBody].
 *
 * This adapter replicates the behavior of the original SDK [RequestBody],
 * including content type, length, and writing logic, for compatibility with OkHttp.
 *
 * @receiver The SDK [RequestBody] to convert.
 * @return A new [okhttp3.RequestBody] compatible with OkHttp.
 */
fun RequestBody.toOkHttpRequestBody(): okhttp3.RequestBody {
    val contentLength = this.contentLength()
    val mediaType = this.mediaType().toString().toMediaTypeOrNull()

    return object : okhttp3.RequestBody() {
        override fun contentType() = mediaType

        override fun contentLength() = contentLength

        @Throws(IOException::class)
        override fun writeTo(sink: BufferedSink) {
            this@toOkHttpRequestBody.writeTo(sink)
        }
    }
}

/**
 * Converts SDK [Response] to OkHttp [Response].
 *
 * @receiver The SDK [Response] to convert.
 * @return An OkHttp [Response] object equivalent to the SDK [Response].
 */
fun Response.toOkHttpResponse(): okhttp3.Response = okhttp3.Response.Builder()
    .request(request.toOkHttpRequest())
    .headers(headers.toOkHttpHeaders())
    .code(status.code)
    .protocol(okhttp3.Protocol.valueOf(protocol.name))
    .message(message ?: "")
    .body(body?.toOkHttpResponseBody())
    .build()

/**
 * Converts SDK [ResponseBody] to OkHttp [okhttp3.ResponseBody].
 *
 * The original [ResponseBody] is **closed** after mapping.
 *
 * @receiver The SDK [ResponseBody] to convert.
 * @return An OkHttp [ResponseBody] object equivalent to the SDK [ResponseBody].
 */
fun ResponseBody.toOkHttpResponseBody(): okhttp3.ResponseBody = use {
    Buffer().apply {
        source().readAll(this)
    }.asResponseBody(mediaType().toString().toMediaTypeOrNull(), contentLength())
}

/**
 * Converts an [okhttp3.Response] to the SDK `Response`.
 *
 * This method adapts the response data, including headers, body, status, and protocol,
 * to the SDK [Response] structure.
 *
 * @receiver The [okhttp3.Response] to convert.
 * @param request The original SDK [Request] that generated this response.
 * @return A new [Response] object in the SDK format.
 */
fun okhttp3.Response.toSDKResponse(request: Request): Response = Response.builder()
    .headers(this.headers.toSDKHeaders())
    .body(this.body?.toSDKResponseBody())
    .request(request)
    .protocol(Protocol.valueOf(protocol.name))
    .status(Status.fromCode(code))
    .message(message)
    .build()

/**
 * Converts an [okhttp3.ResponseBody] to the SDK [ResponseBody].
 *
 * This adapter replicates the content of the original response body, including its source,
 * content length, and media type, for use within the SDK.
 *
 * The original [okhttp3.ResponseBody] is **closed** after mapping.
 *
 * @receiver The [okhttp3.ResponseBody] to convert.
 * @return A new [ResponseBody] compatible with the SDK.
 */
fun okhttp3.ResponseBody.toSDKResponseBody(): ResponseBody = use {
    create(
        source = Buffer().apply { source().readAll(this) },
        contentLength = contentLength(),
        mediaType = contentType().toSDKMediaType()
    )
}

/**
 * Converts SDK [MediaType] to OkHttp [MediaType].
 *
 * @receiver The SDK [MediaType] to convert.
 * @return An OkHttp [MediaType] object equivalent to the SDK [MediaType].
 */
fun okhttp3.MediaType?.toSDKMediaType(): MediaType? = if (this != null) parse(this@toSDKMediaType.toString()) else null
