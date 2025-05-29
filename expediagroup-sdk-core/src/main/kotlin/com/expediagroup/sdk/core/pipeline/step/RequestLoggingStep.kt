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

package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.logging.RequestLogger
import com.expediagroup.sdk.core.pipeline.RequestPipelineStep
import okio.Buffer

class RequestLoggingStep(
    private val logger: LoggerDecorator,
    private val maxRequestBodySize: Long? = null,
    private val maskBody: (String) -> String = { it },
    private val maskHeaders: (Headers) -> Headers = { it },
    private val loggableContentTypes: List<MediaType> = emptyList()
) : RequestPipelineStep {
    override fun invoke(request: Request): Request {
        var reusableRequest: Request = request

        request.body?.let {
            reusableRequest =
                reusableRequest
                    .newBuilder()
                    .body(it.snapshot())
                    .build()
        }

        RequestLogger.log(
            logger,
            reusableRequest,
            maxBodyLogSize = maxRequestBodySize,
            maskBody = maskBody,
            maskHeaders = maskHeaders,
            loggableContentTypes = loggableContentTypes
        )

        return reusableRequest
    }

    private fun RequestBody.snapshot(): RequestBody {
        val buffer = Buffer().apply { use { writeTo(this) } }

        return RequestBody.create(
            byteString = buffer.snapshot(),
            mediaType = this.mediaType(),
            contentLength = this.contentLength()
        )
    }
}
