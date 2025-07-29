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

package com.expediagroup.sdk.core.http

import java.io.Closeable
import java.io.IOException

/**
 * Represents an immutable HTTP response.
 *
 * Use [Builder] to create an instance.
 */
@ConsistentCopyVisibility
data class Response private constructor(
    val request: Request,
    val protocol: Protocol,
    val status: Status,
    val message: String?,
    val headers: Headers,
    val body: ResponseBody?
) : Closeable {
    /**
     * Returns true if the response code is in the 200-299 range.
     */
    val isSuccessful: Boolean
        get() = status.code in 200..299

    /**
     * Returns a new [Builder] initialized with this response's data.
     *
     * @return A new builder.
     */
    fun newBuilder(): Builder = Builder(this)

    /**
     * Closes the response body and releases any resources.
     *
     * After calling this method, the response body cannot be read.
     *
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    override fun close() {
        body?.close()
    }

    /**
     * Builder class for [Response].
     */
    class Builder {
        private var request: Request? = null
        private var protocol: Protocol? = null
        private var status: Status? = null
        private var message: String? = null
        private var headersBuilder: Headers.Builder = Headers.Builder()
        private var body: ResponseBody? = null

        /**
         * Creates an empty builder.
         */
        constructor()

        /**
         * Creates a builder initialized with the data from [response].
         *
         * @param response The response to copy data from.
         */
        constructor(response: Response) {
            this.request = response.request
            this.protocol = response.protocol
            this.status = response.status
            this.message = response.message
            this.headersBuilder = response.headers.newBuilder()
            this.body = response.body
        }

        /**
         * Sets the request that initiated this response.
         *
         * @param request The originating request.
         * @return This builder.
         */
        fun request(request: Request) = apply {
            this.request = request
        }

        /**
         * Sets the protocol used for the response.
         *
         * @param protocol The protocol (e.g., HTTP/1.1).
         * @return This builder.
         */
        fun protocol(protocol: Protocol) = apply {
            this.protocol = protocol
        }

        /**
         * Sets the HTTP status code.
         *
         * @param status The HTTP status code.
         * @return This builder.
         */
        fun status(status: Status) = apply {
            this.status = status
        }

        /**
         * Sets the HTTP reason phrase.
         *
         * @param message The reason phrase.
         * @return This builder.
         */
        fun message(message: String) = apply {
            this.message = message
        }

        /**
         * Adds a header with the specified name and value.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         */
        fun addHeader(name: String, value: String) = apply {
            headersBuilder.add(name, value)
        }

        /**
         * Adds a header with the specified name and values list.
         *
         * @param name The header name.
         * @param values The header value.
         * @return This builder.
         */
        fun addHeader(name: String, values: List<String>) = apply {
            headersBuilder.add(name, values)
        }

        /**
         * Sets a header with the specified name and value, replacing any existing values.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         */
        fun setHeader(name: String, value: String) = apply {
            headersBuilder.set(name, value)
        }

        /**
         * Sets a header with the specified name and values list, replacing any existing values.
         *
         * @param name The header name.
         * @param values The header values list.
         * @return This builder.
         */
        fun setHeader(name: String, values: List<String>) = apply {
            headersBuilder.set(name, values)
        }

        /**
         * Removes all headers with the specified name.
         *
         * @param name The header name.
         * @return This builder.
         */
        fun removeHeader(name: String) = apply {
            headersBuilder.remove(name)
        }

        /**
         * Sets the response headers.
         *
         * @param headers The response headers.
         * @return This builder.
         */
        fun headers(headers: Headers) = apply {
            headersBuilder = headers.newBuilder()
        }

        /**
         * Sets the response body.
         *
         * @param body The response body, or null if none.
         * @return This builder.
         */
        fun body(body: ResponseBody?) = apply {
            this.body = body
        }

        /**
         * Builds the [Response].
         *
         * @return The built response.
         * @throws IllegalStateException If required fields are missing.
         */
        fun build(): Response {
            val request = this.request ?: throw IllegalStateException("request is required")
            val protocol = this.protocol ?: throw IllegalStateException("protocol is required")
            val code = this.status ?: throw IllegalStateException("status is required")

            return Response(
                request = request,
                protocol = protocol,
                status = code,
                message = message,
                headers = headersBuilder.build(),
                body = body
            )
        }
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}
