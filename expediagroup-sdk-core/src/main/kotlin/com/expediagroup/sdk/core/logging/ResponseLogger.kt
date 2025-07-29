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
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.logging.Constant.DEFAULT_MAX_BODY_SIZE
import okio.Buffer
import okio.BufferedSource
import java.nio.charset.Charset

internal object ResponseLogger {
    fun log(
        logger: LoggerDecorator,
        response: Response,
        vararg tags: String,
        maxBodyLogSize: Long? = null,
        maskBody: (String) -> String = { it },
        maskHeaders: (Headers) -> Headers = { it },
        loggableContentTypes: List<MediaType>? = null
    ) {
        try {
            var logString =
                buildString {
                    append(
                        "URL=${response.request.url}, Code=${response.status.code}, Headers=[${maskHeaders(
                            response.headers
                        )}]"
                    )
                }

            if (logger.isDebugEnabled) {
                val responseBodyString =
                    response.body?.let {
                        maskBody(
                            it.readLoggableBody(
                                maxBodyLogSize = maxBodyLogSize,
                                charset = it.mediaType()?.charset,
                                loggableContentTypes = loggableContentTypes
                            )
                        )
                    }

                logString += ", Body=$responseBodyString"

                logger.debug(logString, "Incoming", *tags)
            } else {
                logger.info(logString, "Incoming", *tags)
            }
        } catch (_: Exception) {
            logger.error("Failed to log response")
        }
    }

    private fun ResponseBody.readLoggableBody(
        maxBodyLogSize: Long?,
        charset: Charset?,
        loggableContentTypes: List<MediaType>?
    ): String {
        val mt = mediaType() ?: return "Response body of unknown media type cannot be logged"

        if (!isLoggable(mt, loggableContentTypes ?: emptyList())) {
            return "Response body of type ${mt.fullType} cannot be logged"
        }

        val maxBytes = maxBodyLogSize ?: DEFAULT_MAX_BODY_SIZE

        val peeked: BufferedSource = source().peek()
        val out = Buffer()

        while (!peeked.exhausted() && out.size < maxBytes) {
            peeked.read(out, maxBytes - out.size)
        }

        return out.readString(charset ?: Charsets.UTF_8)
    }
}
