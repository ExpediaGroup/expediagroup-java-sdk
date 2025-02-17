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

package com.expediagroup.sdk.core.transport

import com.expediagroup.sdk.core.common.getOrThrow
import com.expediagroup.sdk.core.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.core.exception.client.ExpediaGroupPipelineExecutionException
import com.expediagroup.sdk.core.exception.client.ExpediaGroupTransportException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import java.util.ServiceLoader

/**
 * Abstract base class for processing HTTP requests within the SDK.
 *
 * This class serves as the main entry point for executing HTTP requests through the SDK core. **Each product-SDK is
 * expected to have its own implementation of this abstract class.**
 *
 * It wraps and enhances the request and response processing by:
 *
 * 1. Applying request/response pipeline steps
 * 2. Enforcing SDK-specific policies and rules (e.g., authentication)
 * 3. Providing common error handling and retry logic (if needed)
 * 4. Managing request/response lifecycle and transformation
 *
 * Implementations should define the order and types of steps to be applied in the request and response pipelines. The
 * execution logic is already handled.
 *
 * ### Execution Pipeline Integration:
 * The [ExecutionPipeline] manages the request and response processing pipelines, allowing flexible and extensible
 * handling of request and response transformations. The pipeline is composed of ordered steps that are applied
 * sequentially.
 *
 * ### Usage Example:
 * ```
 * class RequestExecutor : AbstractRequestExecutor() {
 *     override val executionPipeline = ExecutionPipeline(
 *         requestPipeline = listOf(
 *             AuthenticationStep(),
 *             RequestLoggingStep()
 *         ),
 *         responsePipeline = listOf(
 *             ResponseLoggingStep()
 *         )
 *     )
 * }
 * ```
 */
abstract class AbstractRequestExecutor(
    transport: Transport? = null
) : Disposable {
    protected val transport: Transport = transport ?: loadTransport()

    abstract val executionPipeline: ExecutionPipeline

    /**
     * Executes a request through the request pipeline and processes the response through the response pipeline.
     *
     * The method applies all configured request pipeline steps to the incoming request, executes the request,
     * and then applies all configured response pipeline steps to the resulting response.
     *
     * @param request The request to be processed through the pipelines.
     * @return The fully processed response after all pipeline steps are applied.
     *
     * @throws ExpediaGroupPipelineExecutionException if the request or response pipelines fails
     * @throws ExpediaGroupNetworkException if the request execution fails
     */
    fun execute(request: Request): Response {
        val pipelineRequest =
            try {
                executionPipeline.startRequestPipeline(request)
            } catch (e: Exception) {
                throw ExpediaGroupPipelineExecutionException("exception while executing the request pipeline", e)
            }

        val response =
            try {
                transport.execute(pipelineRequest)
            } catch (e: Exception) {
                throw ExpediaGroupTransportException("Failed to execute the request", e)
            }

        return try {
            executionPipeline.startResponsePipeline(response)
        } catch (e: Exception) {
            throw ExpediaGroupPipelineExecutionException("exception while executing the response pipeline", e)
        }
    }

    /**
     * Closes the underlying [Transport].
     */
    override fun dispose() = transport.dispose()

    companion object {
        private fun loadTransport(): Transport =
            ServiceLoader.load(Transport::class.java).firstOrNull().getOrThrow {
                ExpediaGroupConfigurationException(
                    "No Transport implementation found. Please include valid SDK transport dependency"
                )
            }
    }
}
