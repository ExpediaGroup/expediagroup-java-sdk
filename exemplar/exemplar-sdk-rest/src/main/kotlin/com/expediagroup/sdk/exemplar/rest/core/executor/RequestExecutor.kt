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
package com.expediagroup.sdk.exemplar.rest.core.executor

import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.RequestPipelineStep
import com.expediagroup.sdk.core.pipeline.ResponsePipelineStep
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport
import org.slf4j.LoggerFactory

/**
 * Acts as the main bridge between the Product SDK and the internal core layers by defining the execution pipeline
 * used to handle outgoing requests and incoming responses.
 *
 * [RequestExecutor] extends [AbstractRequestExecutor] from the core package. To use it, you must override
 * the [executionPipeline] property to configure how requests and responses are processed.
 *
 * It's recommended to pass an optional [Transport] instance to the superclass constructor. This allows users
 * to override the default transport that would otherwise be resolved automatically. If Transport is provided explicitly,
 * it will take precedence over the one discovered via classpath scanning.
 *
 * The [AbstractRequestExecutor] takes care of resolving and wiring the transport as long as the appropriate
 * transport dependency is included in the classpath.
 *
 * @see Transport
 * @see AbstractRequestExecutor
 * @see ExecutionPipeline
 */
class RequestExecutor @JvmOverloads constructor(
    transport: Transport? = null
) : AbstractRequestExecutor(transport) {
    override val executionPipeline = ExecutionPipeline(
        requestPipeline = getRequestPipeline(),
        responsePipeline = getResponsePipeline()
    )

    private fun getRequestPipeline(): List<RequestPipelineStep> = listOf(
        RequestHeadersStep(),
        RequestLoggingStep(logger)
    )

    private fun getResponsePipeline(): List<ResponsePipelineStep> = listOf(
        ResponseLoggingStep(logger)
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
