/**
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
package com.expediagroup.sdk.exemplar.core.executor

import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.RequestPipelineStep
import com.expediagroup.sdk.core.pipeline.ResponsePipelineStep
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.transport.AsyncTransport
import org.slf4j.LoggerFactory

class AsyncRequestExecutor
    @JvmOverloads
    constructor(
        asyncTransport: AsyncTransport? = null
    ) : AbstractAsyncRequestExecutor(asyncTransport) {
        override val executionPipeline =
            ExecutionPipeline(
                requestPipeline = getRequestPipeline(),
                responsePipeline = getResponsePipeline()
            )

        private fun getRequestPipeline(): List<RequestPipelineStep> =
            listOf(
                RequestHeadersStep(),
                RequestLoggingStep(logger)
            )

        private fun getResponsePipeline(): List<ResponsePipelineStep> =
            listOf(
                ResponseLoggingStep(logger)
            )

        companion object {
            private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
        }
    }
