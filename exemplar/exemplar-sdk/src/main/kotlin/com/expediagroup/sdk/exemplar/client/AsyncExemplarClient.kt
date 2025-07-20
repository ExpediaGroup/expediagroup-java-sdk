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
package com.expediagroup.sdk.exemplar.client

import com.expediagroup.sdk.core.transport.AsyncTransport
import com.expediagroup.sdk.exemplar.core.executor.AsyncRequestExecutor
import com.expediagroup.sdk.exemplar.core.mapper.DefaultObjectMapper
import com.expediagroup.sdk.rest.AsyncRestClient
import com.expediagroup.sdk.rest.AsyncRestExecutor
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import java.util.concurrent.CompletableFuture

/**
 * This is the exemplar asynchronous SDK client that users can use to interact with your REST APIs.
 *
 * It extends [AsyncRestClient] and is designed for asynchronous execution of API operations.
 * To use it, you must override the [restExecutor] property with an instance of [AsyncRestExecutor],
 * which should be configured with your server's base URL and an [AsyncRequestExecutor] instance.
 *
 * While the base implementation is provided here, you are encouraged to customize this client
 * as needed — such as adding new methods, properties, or exposing configuration options via constructors
 * or builder-style APIs.
 *
 * The execution flow is structured as follows:
 * AsyncRestClient (Product SDK layer) → AsyncRestExecutor (REST package) → AsyncRequestExecutor (Core package)
 *
 * This class serves as a reference implementation and can be used as a starting point for building your own SDK client.
 *
 * NOTE: It's not necessarily required to implement this class if you don't need asynchronous operations. See [ExemplarClient] for a synchronous version.
 *
 * @see AsyncRestClient
 * @see AsyncRestExecutor
 * @see AsyncRequestExecutor
 * @see DefaultObjectMapper
 */
class AsyncExemplarClient
    @JvmOverloads
    constructor(asyncTransport: AsyncTransport? = null) : AsyncRestClient() {
        override val restExecutor: AsyncRestExecutor =
            AsyncRestExecutor(
                mapper = DefaultObjectMapper.INSTANCE,
                serverUrl = "http://localhost:8080",
                requestExecutor = AsyncRequestExecutor(asyncTransport)
            )

        /**
         * Executes an operation that does not expect a response body.
         *
         * @param operation The operation to execute.
         * @return A CompletableFuture containing the response.
         */
        fun execute(operation: OperationNoResponseBodyTrait): CompletableFuture<Response<Nothing?>> = restExecutor.execute(operation)

        /**
         * Executes an operation that expects a response body.
         *
         * @param T The type of the response body.
         * @param operation The operation to execute.
         * @return A CompletableFuture containing the response.
         */
        fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): CompletableFuture<Response<T>> = restExecutor.execute(operation)
    }
