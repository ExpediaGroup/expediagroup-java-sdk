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
package com.expediagroup.sdk.exemplar.rest.core.executor.demo

import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport
import org.slf4j.LoggerFactory

/**
 * **Demo Request Executor: Custom Loggable Media Types**
 *
 * This demo RequestExecutor showcases how to configure the request logging pipeline
 * to recognize and log custom media types beyond the default JSON/Text types.
 *
 * ## Use Case
 * When your API uses custom media types (e.g., vendor-specific content types),
 * you may want to include them in request/response logging for debugging and monitoring.
 *
 * @see RequestLoggingStep
 * @see MediaType
 */
class RequestExecutorWithAdditionalLoggableTypes @JvmOverloads constructor(
    transport: Transport? = null
) : AbstractRequestExecutor(transport) {

    override val executionPipeline: ExecutionPipeline = ExecutionPipeline(
        requestPipeline = listOf(
            RequestLoggingStep(
                logger = logger,
                loggableContentTypes = listOf(
                    MediaType.parse("application/vnd.exp-activity.v3+json"),
                    MediaType.parse("application/vnd.exp-hotel.v3+json"),
                    MediaType.parse("application/vnd.exp-lodging.v3+json"),
                )
            ),
        ),
        responsePipeline = listOf()
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
