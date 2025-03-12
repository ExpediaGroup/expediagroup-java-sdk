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

import java.net.MalformedURLException
import java.net.URL
import java.util.UUID

/**
 * Represents an immutable HTTP request.
 *
 * Use [Request.builder()] to create an instance.
 */
@ConsistentCopyVisibility
data class Request private constructor(
    val id: UUID = UUID.randomUUID(),
    val method: Method,
    val url: URL,
    val headers: Headers,
    val body: RequestBody?
) {
    /**
     * Returns a new [Builder] initialized with this request's data.
     *
     * @return A new builder.
     */
    fun newBuilder(): Builder = Builder(this)

    /**
     * Builder class for [Request].
     */
    class Builder {
        private var method: Method? = null
        private var url: URL? = null
        private var headersBuilder: Headers.Builder = Headers.Builder()
        private var body: RequestBody? = null

        /**
         * Creates a new builder.
         */
        constructor()

        /**
         * Creates a builder initialized with the data from [request].
         *
         * @param request The request to copy data from.
         */
        constructor(request: Request) {
            this.method = request.method
            this.url = request.url
            this.headersBuilder = request.headers.newBuilder()
            this.body = request.body
        }

        /**
         * Sets the HTTP method.
         *
         * @param method HTTP method, e.g., GET, POST.
         * @return This builder.
         */
        fun method(method: Method) =
            apply {
                this.method = method
            }

        /**
         * Sets the request body.
         *
         * @param body The request body.
         * @return This builder.
         */
        fun body(body: RequestBody) =
            apply {
                this.body = body
            }

        /**
         * Sets the URL.
         *
         * @param url The URL as a string.
         * @return This builder.
         * @throws MalformedURLException If [url] is invalid.
         */
        @Throws(MalformedURLException::class)
        fun url(url: String) =
            apply {
                val parsedUrl = URL(url)
                this.url = parsedUrl
            }

        /**
         * Sets the URL.
         *
         * @param url The URL as an [URL] object.
         * @return This builder.
         */
        fun url(url: URL) =
            apply {
                this.url = url
            }

        /**
         * Adds a header with the specified name and value.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         */
        fun addHeader(
            name: String,
            value: String
        ) = apply {
            headersBuilder.add(name, value)
        }

        /**
         * Adds a header with the specified name and values.
         *
         * @param name The header name.
         * @param values The header values list.
         * @return This builder.
         */
        fun addHeader(
            name: String,
            values: List<String>
        ) = apply {
            headersBuilder.add(name, values)
        }

        /**
         * Sets a header with the specified name and value, replacing any existing values.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         */
        fun setHeader(
            name: String,
            value: String
        ) = apply {
            headersBuilder.set(name, value)
        }

        /**
         * Sets a header with the specified name and values list, replacing any existing values.
         *
         * @param name The header name.
         * @param values The header values list.
         * @return This builder.
         */
        fun setHeader(
            name: String,
            values: List<String>
        ) = apply {
            headersBuilder.set(name, values)
        }

        /**
         * Sets a complete Headers instance, replacing all other headers
         *
         * @param headers The [Headers] instance
         * @return This builder.
         */
        fun headers(headers: Headers) =
            apply {
                this.headersBuilder = headers.newBuilder()
            }

        /**
         * Removes all headers with the specified name.
         *
         * @param name The header name.
         * @return This builder.
         */
        fun removeHeader(name: String) =
            apply {
                headersBuilder.remove(name)
            }

        /**
         * Builds the [Request].
         *
         * @return The built request.
         * @throws IllegalStateException If the request is invalid.
         */
        fun build(): Request {
            val method = this.method ?: throw IllegalStateException("Method is required.")
            val url = this.url ?: throw IllegalStateException("URL is required.")

            return Request(
                method = method,
                url = url,
                headers = headersBuilder.build(),
                body = body
            )
        }
    }

    companion object {
        @JvmStatic
        fun builder(): Builder = Builder()
    }
}
