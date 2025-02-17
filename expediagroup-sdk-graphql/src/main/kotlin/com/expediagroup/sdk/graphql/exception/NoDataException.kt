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

package com.expediagroup.sdk.graphql.exception

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.GraphQLError

/**
 * Exception thrown when a GraphQL response completes without data but includes error details.
 *
 * Typically used to indicate that the server processed the request but encountered issues,
 * resulting in an empty data payload accompanied by one or more errors.
 *
 * @param message An optional message providing context about the exception.
 * @param cause The underlying cause of the exception, if available.
 * @param errors A list of [GraphQLError] objects describing issues from the GraphQL response, useful for precise error handling.
 */
class NoDataException(
    message: String? = null,
    cause: Throwable? = null,
    val errors: List<GraphQLError>
) : ExpediaGroupServiceException(message, cause)
