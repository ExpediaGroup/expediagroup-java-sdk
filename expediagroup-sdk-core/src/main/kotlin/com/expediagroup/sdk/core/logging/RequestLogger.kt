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

package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.Constant.DEFAULT_MAX_BODY_SIZE
import okio.Buffer
import java.io.IOException
import java.nio.charset.Charset

internal object RequestLogger {
    fun log(
        logger: LoggerDecorator,
        request: Request,
        vararg tags: String,
        maxBodyLogSize: Long? = null,
        maskBody: (String) -> String = { it },
        maskHeaders: (Headers) -> Headers = { it },
        loggableContentTypes: List<MediaType>? = null
    ) {
        try {
            var logString =
                buildString {
                    append("URL=${request.url}, Method=${request.method}, Headers=[${maskHeaders(request.headers)}]")
                }

            if (logger.isDebugEnabled) {
                val requestBodyString =
                    request.body?.let {
                        maskBody(
                            it.readLoggableBody(
                                maxBodyLogSize = maxBodyLogSize,
                                charset = it.mediaType()?.charset,
                                loggableContentTypes = loggableContentTypes
                            )
                        )
                    }

                logString += ", Body=$requestBodyString"
                logger.debug(logString, "Outgoing", *tags)
            } else {
                logger.info(logString, "Outgoing", *tags)
            }
        } catch (_: Exception) {
            logger.error("Failed to log request")
        }
    }

    @Throws(IOException::class)
    private fun RequestBody.readLoggableBody(
        maxBodyLogSize: Long?,
        charset: Charset?,
        loggableContentTypes: List<MediaType>?
    ): String {
        this.mediaType().also {
            if (it === null) {
                return "Request body of unknown media type cannot be logged"
            }

            if (!isLoggable(it, loggableContentTypes ?: emptyList())) {
                return "Request body of type ${it.fullType} cannot be logged"
            }
        }

        val buffer = Buffer().apply { use { writeTo(this) } }
        val bytesToRead = minOf(maxBodyLogSize ?: DEFAULT_MAX_BODY_SIZE, buffer.size)

        return buffer.readString(bytesToRead, charset ?: Charsets.UTF_8)
    }
}
