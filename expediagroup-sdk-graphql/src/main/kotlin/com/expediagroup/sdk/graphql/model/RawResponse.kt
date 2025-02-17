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

import com.apollographql.apollo.api.Operation

/**
 * Represents the full, unprocessed response from a GraphQL operation, including the entire data structure
 * and any associated errors.
 *
 * This class serves as a wrapper for the raw response, providing access to both the complete data and error details.
 * Higher-level interfaces, such as [Response], can then extract and simplify access to specific data fragments
 * relevant to the user, while `RawResponse` retains the entire response as received.
 *
 * @param T The type of the full data structure returned by the GraphQL operation, constrained to types extending [Operation.Data].
 * @param data The complete data returned by the GraphQL operation, representing all available fields as per the operation.
 * @param errors A list of errors associated with the response, or `null` if no errors were encountered.
 */
open class RawResponse<T : Operation.Data>(
    val data: T,
    val errors: List<GraphQLError>?
)
