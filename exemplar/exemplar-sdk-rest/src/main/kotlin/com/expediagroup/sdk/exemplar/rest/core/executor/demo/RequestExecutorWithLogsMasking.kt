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

import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.logging.masking.MaskHeaders
import com.expediagroup.sdk.core.logging.masking.MaskJson
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport
import org.slf4j.LoggerFactory

/**
 * **Demo Request Executor: Sensitive Data Masking**
 *
 * This demo RequestExecutor showcases how to configure request logging with automatic
 * masking of sensitive data in headers and request/response bodies. This is crucial
 * for security and compliance when logging API interactions.
 *
 * ## Use Case
 * When logging requests and responses for debugging or monitoring, you need to ensure
 * that sensitive information (passwords, tokens, PII) is masked to prevent security
 * breaches and maintain compliance with data protection regulations.
 *
 * ## Masking Configuration
 * This executor demonstrates two types of masking:
 *
 * ### Header Masking
 * - **Target**: HTTP headers containing sensitive data
 * - **Example**: `authorization` headers are masked as `authorization: ****`
 * - **Configuration**: `MaskHeaders(listOf("authorization"))`
 *
 * ### JSON Body Masking
 * - **Target**: JSON fields in request/response bodies
 * - **Example**: `"access_token": "secret123"` becomes `"access_token": "****"`
 * - **Configuration**: `MaskJson(setOf("access_token"))`
 *
 * ## Production Considerations
 * - Masking adds considerable overhead when processing the response. Make sure to keep it minimal.
 * - There are some limitation on the body masking due to the performance issues.
 * - Request and Response bodies are logged at DEBUG level. Info will only log request/response headers.
 *
 * @see MaskHeaders
 * @see MaskJson
 * @see RequestLoggingStep
 */
class RequestExecutorWithLogsMasking @JvmOverloads constructor(
    transport: Transport? = null
) : AbstractRequestExecutor(transport) {

    /** Masks sensitive HTTP headers to prevent credential leaks in logs */
    private val headersMask = MaskHeaders(listOf("authorization"))

    /** Masks sensitive JSON fields in request/response bodies */
    private val bodyMask = MaskJson(setOf("access_token"))

    override val executionPipeline: ExecutionPipeline = ExecutionPipeline(
        requestPipeline = listOf(
            RequestLoggingStep(
                logger = logger,
                maskHeaders = headersMask,
                maskBody = bodyMask
            ),
        ),
        responsePipeline = listOf()
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
