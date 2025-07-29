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

package com.expediagroup.sdk.graphql.model

import com.apollographql.apollo.api.Error

/**
 * Represents an error returned from a GraphQL operation.
 *
 * @param message A message detailing the nature of the error.
 * @param path The path in the GraphQL query where the error occurred, represented as a list of field names.
 * This may be `null` if the error is not tied to a specific query path.
 */
data class GraphQLError(
    val message: String,
    val path: List<String>?
) {
    companion object {
        fun fromApolloError(apolloError: Error): GraphQLError = GraphQLError(
            message = apolloError.message,
            path = apolloError.path?.map { it.toString() }
        )
    }
}
