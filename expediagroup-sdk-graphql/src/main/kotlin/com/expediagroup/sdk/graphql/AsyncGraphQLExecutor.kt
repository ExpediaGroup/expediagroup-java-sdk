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

package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.ApolloResponse
import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.graphql.exception.NoDataException
import com.expediagroup.sdk.graphql.model.GraphQLError
import com.expediagroup.sdk.graphql.model.RawResponse
import java.util.concurrent.CompletableFuture

/**
 * A class for executing GraphQL operations asynchronously. It provides a higher-level execute method that accepts [Operation]. This
 * operation is converted to SDK request.
 *
 * By default - this class should be used internally in all higher-level [AsyncGraphQLClient] implementations
 *
 * @param asyncRequestExecutor used for HTTP request execution within the SDK
 * @param serverUrl GraphQL server URL
 */
class AsyncGraphQLExecutor(
    private val asyncRequestExecutor: AbstractAsyncRequestExecutor,
    private val serverUrl: String
) : Disposable by asyncRequestExecutor {
    /**
     * Executes the given GraphQL operation asynchronously.
     *
     * This method converts the Apollo [Operation] into an SDK request, sends it to the [AbstractAsyncRequestExecutor],
     * and processes the response to return a [RawResponse] containing the data and any associated errors.
     *
     * @param T The type of the data returned by the GraphQL operation. Must extend [Operation.Data].
     * @param operation The Apollo [Operation] to be executed.
     * @return A [CompletableFuture] containing the raw response of the operation.
     */
    fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>> {
        val future = CompletableFuture<RawResponse<T>>()

        asyncRequestExecutor.execute(operation.toSDKRequest(serverUrl))
            .thenApply { response ->
                processOperationResponse(response.toApolloResponse(operation), future)
            }.exceptionally { throwable ->
                future.completeExceptionally(throwable)
            }

        return future
    }

    /**
     * Handles the response from a GraphQL operation, determining whether to complete the provided CompletableFuture
     * with either success or an exception based on the response data and errors.
     *
     * @param response The ApolloResponse containing the data and errors from the GraphQL operation.
     * @param future A CompletableFuture that will be completed based on the response handling logic.
     */
    private fun <T : Operation.Data> processOperationResponse(
        response: ApolloResponse<T>,
        future: CompletableFuture<RawResponse<T>>
    ) {
        when {
            response.exception != null ->
                future.completeExceptionally(
                    ExpediaGroupServiceException(
                        cause = response.exception
                    )
                )

            response.data == null && response.hasErrors() ->
                future.completeExceptionally(
                    NoDataException(
                        message = "No data received from the server",
                        errors = response.errors!!.map { GraphQLError.fromApolloError(it) }
                    )
                )

            else ->
                future.complete(
                    RawResponse(
                        data = response.data!!,
                        errors = response.errors?.map { GraphQLError.fromApolloError(it) }
                    )
                )
        }
    }
}
