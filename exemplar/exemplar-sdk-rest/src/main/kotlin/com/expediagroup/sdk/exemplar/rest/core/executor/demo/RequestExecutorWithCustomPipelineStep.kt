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

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
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
 * **Demo Request Executor: Custom Pipeline Steps**
 *
 * This demo RequestExecutor showcases how to implement and integrate custom pipeline steps
 * for request/response processing. Pipeline steps allow you to modify requests before they're sent
 * and process responses before they're returned to the client.
 *
 * ## Use Cases
 * - **Request Modification**: Add custom headers, modify request bodies, or implement custom validation
 * - **Response Processing**: Transform response data, cache responses, or extract metadata
 * - **Cross-Cutting Concerns**: Implement logging, metrics collection, or request tracing
 *
 * ## Pipeline Execution Order
 * **Request Pipeline** (executed before HTTP request):
 * 1. `RequestHeadersStep` - Adds default headers
 * 2. `RequestLoggingStep` - Logs outgoing requests
 * 3. `CustomRequestPipelineStep` - Your custom request logic
 *
 * **Response Pipeline** (executed after HTTP response):
 * 1. `ResponseLoggingStep` - Logs incoming responses
 * 2. `CustomResponsePipelineStep` - Your custom response logic
 *
 * @see RequestPipelineStep
 * @see ResponsePipelineStep
 * @see ExecutionPipeline
 */
class RequestExecutorWithCustomPipelineStep @JvmOverloads constructor(
    transport: Transport? = null
) : AbstractRequestExecutor(transport) {
    override val executionPipeline: ExecutionPipeline = ExecutionPipeline(
        requestPipeline = listOf(
            RequestHeadersStep(),
            RequestLoggingStep(logger = logger),
            CustomRequestPipelineStep()
        ),
        responsePipeline = listOf(
            ResponseLoggingStep(logger = logger),
            CustomResponsePipelineStep()
        )
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}

/**
 * **Custom Request Pipeline Step**
 *
 * Example implementation of a custom request pipeline step. This step is executed
 * for every outgoing request and can modify the request before it's sent.
 *
 * ## Common Use Cases
 * - Add custom headers (correlation IDs, client versions, etc.)
 * - Modify request bodies (add metadata, transform payloads)
 * - Implement request validation
 * - Add request timing or metrics collection
 *
 * ## Implementation Notes
 * - Must return a `Request` object (can be the same instance or a modified copy)
 * - Use `request.newBuilder()` to create modified copies
 * - Keep processing lightweight to avoid performance impact
 *
 */
internal class CustomRequestPipelineStep : RequestPipelineStep {
    override fun invoke(req: Request): Request {
        // Example: Add a custom header to all requests
        // return req.newBuilder()
        //     .addHeader("X-Custom-Header", "custom-value")
        //     .build()

        // For demo purposes, return request unchanged
        // Replace with your custom logic as needed
        return req
    }
}

/**
 * **Custom Response Pipeline Step**
 *
 * Example implementation of a custom response pipeline step. This step is executed
 * for every incoming response and can process or modify the response before it's returned.
 *
 * ## Common Use Cases
 * - Extract and store response metadata (timing, headers, etc.)
 * - Implement response caching logic
 * - Transform response bodies or headers
 * - Collect metrics or analytics data
 *
 * ## Implementation Notes
 * - Must return a `Response` object (can be the same instance or a modified copy)
 * - Use `response.newBuilder()` to create modified copies
 * - Consider performance impact of response processing
 * - Be careful with response body streams (they can only be read once)
 *
 * @see Response.newBuilder
 */
internal class CustomResponsePipelineStep : ResponsePipelineStep {
    override fun invoke(res: Response): Response {
        // Example: Log response metadata
        // logger.info("Response received: status={}, contentType={}",
        //     res.status.code, res.headers.get("content-type"))

        // Example: Cache successful responses
        // if (res.status.code in 200..299) {
        //     cacheResponse(res)
        // }

        // For demo purposes, return response unchanged
        // Replace with your custom logic as needed
        return res
    }
}
