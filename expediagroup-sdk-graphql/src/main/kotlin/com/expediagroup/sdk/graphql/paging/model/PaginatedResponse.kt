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

package com.expediagroup.sdk.graphql.paging.model

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.graphql.model.Response

/**
 * Represents a paginated response, extending a [Response] with pagination metadata.
 *
 * This interface is intended for paginated responses where data spans multiple pages, providing access to
 * a specific data fragment of interest, the full raw response, and pagination details.
 *
 * @param T The type of the specific data fragment that the user is interested in, allowing for direct access to that data.
 * @param R The type of the raw response data, constrained to types extending [Operation.Data], typically containing
 * the complete unprocessed data and error information from the GraphQL operation.
 */
interface PaginatedResponse<T, R : Operation.Data> : Response<T, R> {

    /**
     * Metadata about the pagination state, including page size, cursor position, and whether additional pages are available.
     */
    val pageInfo: PageInfo
}
