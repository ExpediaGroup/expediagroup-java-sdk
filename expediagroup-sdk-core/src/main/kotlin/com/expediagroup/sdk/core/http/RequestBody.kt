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

import okio.BufferedSink
import okio.ByteString
import okio.Source
import okio.source
import java.io.IOException
import java.io.InputStream
import java.net.URLEncoder
import java.nio.charset.Charset

/**
 * Represents an HTTP request body.
 */
abstract class RequestBody {
    /**
     * Returns the media type of the request body.
     */
    abstract fun mediaType(): MediaType?

    /**
     * Returns the number of bytes that will be written to [writeTo], or -1 if unknown.
     */
    open fun contentLength(): Long = -1

    /**
     * Writes the request body to the given [sink].
     *
     * @param sink the sink to write to.
     * @throws IOException if an I/O error occurs.
     */
    @Throws(IOException::class)
    abstract fun writeTo(sink: BufferedSink)

    companion object {
        /**
         * Creates a new request body that reads from the given [inputStream].
         *
         * @param mediaType the media type, or null if unknown.
         * @param contentLength the length of the content, or -1 if unknown.
         * @param inputStream the input stream to read from.
         * @return a new [RequestBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(
            inputStream: InputStream,
            mediaType: MediaType? = null,
            contentLength: Long = -1
        ): RequestBody =
            object : RequestBody() {
                override fun mediaType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) {
                    inputStream.use {
                        sink.writeAll(it.source())
                    }
                }
            }

        /**
         * Creates a new request body that reads from the given [source].
         *
         * @param mediaType the media type, or null if unknown.
         * @param contentLength the length of the content, or -1 if unknown.
         * @param source the source to read from.
         * @return a new [RequestBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(
            source: Source,
            mediaType: MediaType? = null,
            contentLength: Long = -1
        ): RequestBody =
            object : RequestBody() {
                override fun mediaType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) {
                    source.use { src ->
                        sink.writeAll(src)
                    }
                }
            }

        /**
         * Creates a new request body that reads from the given [byteString].
         *
         * RequestBody from [byteString] is reusable.
         *
         * @param byteString the byteString object to read from.
         * @param mediaType the media type, or null if unknown.
         * @param contentLength the length of the content, or -1 if unknown.
         * @return a new [RequestBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(
            byteString: ByteString,
            mediaType: MediaType? = null,
            contentLength: Long = -1
        ): RequestBody =
            object : RequestBody() {
                override fun mediaType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) {
                    sink.write(byteString)
                }
            }

        /**
         * Creates a new request body for form data with content type "application/x-www-form-urlencoded".
         *
         * @param formData The form data as a map of parameter names and values.
         * @param charset The character set to use; defaults to UTF-8.
         * @return A new [RequestBody] instance.
         */
        @JvmStatic
        @JvmOverloads
        fun create(
            formData: Map<String, String>,
            charset: Charset = Charsets.UTF_8
        ): RequestBody {
            val encodedForm =
                formData
                    .map { (key, value) ->
                        "${URLEncoder.encode(key, charset.name())}=${URLEncoder.encode(value, charset.name())}"
                    }.joinToString("&")

            val contentBytes = encodedForm.toByteArray(charset)

            return create(contentBytes.inputStream(), CommonMediaTypes.APPLICATION_FORM_URLENCODED)
        }
    }
}
