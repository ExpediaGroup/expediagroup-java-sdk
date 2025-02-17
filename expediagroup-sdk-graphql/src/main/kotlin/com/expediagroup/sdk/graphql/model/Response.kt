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
 * Represents a response from a data source, containing both the specific data fragment of interest and the underlying raw response.
 *
 * This interface allows users to directly access a targeted portion of the response data, simplifying data access
 * by focusing on a specific fragment within a potentially nested response structure.
 *
 * @param T The type of the specific data fragment that the user is interested in, allowing for direct access to that data.
 * @param R The type of the raw response data, constrained to types extending [Operation.Data], typically containing
 * the complete unprocessed data and error information from the GraphQL operation.
 */
interface Response<T, R : Operation.Data> {

    /**
     * The specific data fragment of interest to the user, extracted from the full response.
     * This fragment simplifies access to nested data by focusing on the relevant portion directly.
     */
    val data: T

    /**
     * The raw response received from the data source, containing the complete unprocessed data and any errors.
     * This provides access to the full response structure when needed.
     */
    val rawResponse: RawResponse<R>
}

