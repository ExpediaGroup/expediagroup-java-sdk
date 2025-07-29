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

import okio.BufferedSource
import okio.IOException
import okio.buffer
import okio.source
import java.io.Closeable
import java.io.InputStream

/**
 * Represents the body of an HTTP response.
 */
abstract class ResponseBody : Closeable {
    /**
     * Returns the media type of the response body, or null if unknown.
     */
    abstract fun mediaType(): MediaType?

    /**
     * Returns the content length, or -1 if unknown.
     */
    abstract fun contentLength(): Long

    /**
     * Returns a [BufferedSource] to read the response body.
     *
     * Note: The source can be read only once. Multiple calls will return the same source.
     *
     * @return The buffered source.
     */
    abstract fun source(): BufferedSource

    /**
     * Closes the response body and releases any resources.
     *
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    override fun close() {
        source().close()
    }

    companion object {
        /**
         * Creates a new response body from an [InputStream] and [mediaType].
         *
         * @param inputStream The input stream to read from.
         * @param contentLength The length of the content, or -1 if unknown.
         * @param mediaType The media type, or null if unknown.
         * @return A new [ResponseBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(inputStream: InputStream, mediaType: MediaType? = null, contentLength: Long = -1L): ResponseBody =
            object : ResponseBody() {
                private val source = inputStream.source().buffer()

                override fun mediaType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                override fun source(): BufferedSource = source
            }

        /**
         * Creates a new response body from a [BufferedSource] and [mediaType].
         *
         * @param source The buffered source to read from.
         * @param contentLength The length of the content, or -1 if unknown.
         * @param mediaType The media type, or null if unknown.
         * @return A new [ResponseBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(source: BufferedSource, mediaType: MediaType? = null, contentLength: Long = -1L): ResponseBody =
            object : ResponseBody() {
                override fun mediaType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                override fun source(): BufferedSource = source
            }
    }
}
