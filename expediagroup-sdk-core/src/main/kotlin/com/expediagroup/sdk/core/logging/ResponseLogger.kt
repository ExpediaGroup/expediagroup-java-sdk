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

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.logging.Constant.DEFAULT_MAX_BODY_SIZE
import okio.Buffer
import java.nio.charset.Charset

internal object ResponseLogger {
    fun log(
        logger: LoggerDecorator,
        response: Response,
        vararg tags: String,
        maxBodyLogSize: Long? = null
    ) {
        try {
            var logString =
                buildString {
                    append("URL=${response.request.url}, Code=${response.status.code}, Headers=[${response.headers}]")
                }

            if (logger.isDebugEnabled) {
                val responseBodyString =
                    response.body?.let {
                        it.readLoggableBody(maxBodyLogSize, it.mediaType()?.charset)
                    }

                logString += ", Body=$responseBodyString"

                logger.debug(logString, "Incoming", *tags)
            } else {
                logger.info(logString, "Incoming", *tags)
            }
        } catch (e: Exception) {
            logger.error("Failed to log response")
        }
    }

    private fun ResponseBody.readLoggableBody(
        maxBodyLogSize: Long?,
        charset: Charset?
    ): String {
        this.mediaType().also {
            if (it === null) {
                return "Response body of unknown media type cannot be logged"
            }

            if (!isLoggable(it)) {
                return "Response body of type ${it.fullType} cannot be logged"
            }
        }

        if (this.contentLength() == -1L) {
            return "Response body with unknown content length cannot be logged"
        }

        val buffer = Buffer()
        val bytesToRead = minOf(maxBodyLogSize ?: DEFAULT_MAX_BODY_SIZE, contentLength())
        this.source().peek().read(buffer, bytesToRead)
        return buffer.readString(charset ?: Charsets.UTF_8)
    }
}
