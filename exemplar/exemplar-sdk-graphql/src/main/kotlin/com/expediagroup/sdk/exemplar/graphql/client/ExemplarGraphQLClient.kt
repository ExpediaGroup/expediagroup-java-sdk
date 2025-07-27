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
import com.expediagroup.sdk.core.transport.Transport
import com.expediagroup.sdk.exemplar.graphql.core.executor.RequestExecutor
import com.expediagroup.sdk.graphql.GraphQLClient
import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse

/**
 * This is the exemplar synchronous SDK client that users can use to interact with your GraphQL APIs.
 *
 * It extends [GraphQLClient] and is designed for synchronous/blocking execution of GraphQL API operations.
 * To use it, you must override the [graphQLExecutor] property with an instance of [GraphQLExecutor],
 * which should be configured with your server's base URL and an [RequestExecutor] instance.
 *
 * While the base implementation is provided here, you are encouraged to customize this client
 * as needed — such as adding new methods, properties, or exposing configuration options via constructors
 * or builder-style APIs.
 *
 * The execution flow is structured as follows:
 * GraphQLClient (Product SDK layer) → GraphQLExecutor (GraphQL package) → RequestExecutor (Core package)
 *
 * This class serves as a reference implementation and can be used as a starting point for building your own SDK client.
 *
 * @see GraphQLClient
 * @see GraphQLExecutor
 * @see RequestExecutor
 */
class ExemplarGraphQLClient
    @JvmOverloads
    constructor(transport: Transport? = null) : GraphQLClient() {
        override val graphQLExecutor: GraphQLExecutor =
            GraphQLExecutor(
                requestExecutor = RequestExecutor(transport = transport),
                serverUrl = "http://localhost:8080/graphql"
            )

        fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T> = graphQLExecutor.execute(operation)
    }
