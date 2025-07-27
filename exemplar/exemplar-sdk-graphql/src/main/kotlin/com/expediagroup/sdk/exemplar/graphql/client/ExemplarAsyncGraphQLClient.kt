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
package com.expediagroup.sdk.exemplar.graphql.client

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.transport.AsyncTransport
import com.expediagroup.sdk.exemplar.graphql.core.executor.AsyncRequestExecutor
import com.expediagroup.sdk.graphql.AsyncGraphQLClient
import com.expediagroup.sdk.graphql.AsyncGraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import java.util.concurrent.CompletableFuture

/**
 * This is the exemplar asynchronous SDK client that users can use to interact with your GraphQL APIs.
 *
 * It extends [AsyncGraphQLClient] and is designed for asynchronous execution of GraphQL API operations.
 * To use it, you must override the [asyncGraphQLExecutor] property with an instance of [AsyncGraphQLExecutor],
 * which should be configured with your server's base URL and an [AsyncRequestExecutor] instance.
 *
 * While the base implementation is provided here, you are encouraged to customize this client
 * as needed — such as adding new methods, properties, or exposing configuration options via constructors
 * or builder-style APIs.
 *
 * The execution flow is structured as follows:
 * AsyncGraphQLClient (Product SDK layer) → AsyncGraphQLExecutor (GraphQL package) → AsyncRequestExecutor (Core package)
 *
 * This class serves as a reference implementation and can be used as a starting point for building your own SDK client.
 *
 * NOTE: It's not necessarily required to implement this class if you don't need asynchronous operations. See [ExemplarGraphQLClient] for a synchronous version.
 *
 * @see AsyncGraphQLClient
 * @see AsyncGraphQLExecutor
 * @see AsyncRequestExecutor
 */
class ExemplarAsyncGraphQLClient
    @JvmOverloads
    constructor(asyncTransport: AsyncTransport? = null) : AsyncGraphQLClient() {
        override val asyncGraphQLExecutor: AsyncGraphQLExecutor =
            AsyncGraphQLExecutor(
                asyncRequestExecutor = AsyncRequestExecutor(asyncTransport),
                serverUrl = "http://localhost:8080/graphql"
            )

        fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>> = asyncGraphQLExecutor.execute(operation)
    }
