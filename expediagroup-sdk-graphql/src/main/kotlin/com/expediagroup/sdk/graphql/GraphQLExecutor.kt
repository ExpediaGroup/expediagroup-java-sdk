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
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.graphql.exception.NoDataException
import com.expediagroup.sdk.graphql.model.GraphQLError
import com.expediagroup.sdk.graphql.model.RawResponse

/**
 * A class for executing GraphQL operations. It provides a higher-level execute method that accepts [Operation]. This
 * operation is converted to SDK request.
 *
 * By default - this class should be used internally in all higher-level [GraphQLClient] implementations
 *
 * @param requestExecutor used for HTTP request execution within the SDK
 * @param serverUrl GraphQL server URL
 */
class GraphQLExecutor(
    private val requestExecutor: AbstractRequestExecutor,
    private val serverUrl: String
) : Disposable by requestExecutor {
    /**
     * Executes a GraphQL operation and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param operation The GraphQL operation to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during operation execution.
     * @throws [NoDataException] If the operation completes without data but includes errors.
     */
    fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T> = operation
        .toSDKRequest(serverUrl).let {
            requestExecutor.execute(it)
        }.toApolloResponse(operation).let {
            processApolloResponse(it)
        }

    /**
     * Handles the response from a GraphQL operation
     *
     * @param response The ApolloResponse containing the data and errors from the GraphQL operation.
     */
    private fun <T : Operation.Data> processApolloResponse(response: ApolloResponse<T>): RawResponse<T> = when {
        response.exception != null -> throw ExpediaGroupServiceException(
            requestId = response.requestUuid,
            cause = response.exception
        )

        response.data == null && response.hasErrors() -> throw NoDataException(
            requestId = response.requestUuid,
            message = "No data received from the server",
            errors = response.errors!!.map { GraphQLError.fromApolloError(it) }
        )

        else ->
            RawResponse(
                data = response.data!!,
                errors = response.errors?.map { GraphQLError.fromApolloError(it) }
            )
    }
}
