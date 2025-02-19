/*
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

package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.rest.extension.parseRequest
import com.expediagroup.sdk.rest.extension.toRestResponse
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseTrait
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL
import java.util.concurrent.CompletableFuture
import com.expediagroup.sdk.core.http.Response as SDKCoreResponse

/**
 * AsyncRestExecutor is responsible for executing asynchronous REST operations.
 *
 * @property mapper The ObjectMapper used for JSON serialization and deserialization.
 * @property requestExecutor The underlying request executor used to perform HTTP requests asynchronously.
 * @property serverUrl The base URL of the server to which requests are sent.
 */
class AsyncRestExecutor(
    private val mapper: ObjectMapper,
    private val requestExecutor: AbstractAsyncRequestExecutor,
    private val serverUrl: String
) : Disposable by requestExecutor {
    /**
     * Executes an operation that does not expect a response body asynchronously.
     *
     * @param operation The operation to be executed.
     * @return A CompletableFuture containing a Response object with the result of the operation.
     */
    fun execute(operation: OperationNoResponseBodyTrait): CompletableFuture<Response<Nothing?>> =
        execute(operation) { response: SDKCoreResponse ->
            response.toRestResponse(operation)
        }

    /**
     * Executes an operation that expects a response body of type T asynchronously.
     *
     * @param T The type of the response body.
     * @param operation The operation to be executed.
     * @return A CompletableFuture containing a Response object with the result of the operation.
     */
    fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): CompletableFuture<Response<T>> =
        execute(operation) { response ->
            response.toRestResponse(operation, mapper)
        }

    /**
     * Executes an operation and transforms the response using the provided transform function.
     *
     * @param T The type of the response body.
     * @param operation The operation to be executed.
     * @param transform The function to transform the SDKCoreResponse to a Response object.
     * @return A CompletableFuture containing a Response object with the result of the operation.
     */
    private fun <T> execute(
        operation: OperationResponseTrait,
        transform: (SDKCoreResponse) -> Response<T>
    ): CompletableFuture<Response<T>> =
        CompletableFuture<Response<T>>().apply {
            operation
                .getRequestInfo()
                .parseRequest(URL(serverUrl), mapper).let(
                    requestExecutor::execute
                ).let { response ->
                    response.thenApply {
                        this.complete(transform(it))
                    }.exceptionally {
                        this.completeExceptionally(it)
                    }
                }
        }
}
