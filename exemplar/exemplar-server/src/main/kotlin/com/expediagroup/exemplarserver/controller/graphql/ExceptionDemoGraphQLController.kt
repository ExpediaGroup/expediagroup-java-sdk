/*
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

package com.expediagroup.exemplarserver.controller.graphql

import com.expediagroup.exemplarserver.model.Hotel
import com.expediagroup.exemplarserver.service.HotelService
import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.execution.DataFetcherResult
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

/**
 * GraphQL controller specifically designed to demonstrate different exception scenarios
 * that can occur in GraphQL operations. This controller provides resolvers that showcase
 * the three main error conditions handled by the SDK's GraphQLExecutor:
 *
 * 1. Transport/Network exceptions (simulated through runtime exceptions)
 * 2. GraphQL errors with no data (field-level errors that prevent data return)
 * 3. Partial responses (successful data with accompanying errors/warnings)
 */
@Controller
class ExceptionDemoGraphQLController(
    private val hotelService: HotelService
) {
    /**
     * NOT REACHABLE. Requests to this resolver will be caught by `GraphQLDemoExceptionFilter` before it reaches here.
     * Spring GraphQL always returns 200 response even when exceptions are thrown. This filter is used as a workaround for
     * demo purposes.
     */
    @QueryMapping
    fun demoHttpException(): Hotel = hotelService.search(null, null)[0]

    /**
     * NOT REACHABLE. Requests to this resolver will be caught by `GraphQLDemoExceptionFilter` before it reaches here.
     * Typically, we need to replicate an error that bubbles up to the top-level resolver. But for simplicity and demo purposes,
     * it was handled by the request filter.
     */
    @QueryMapping
    fun demoNoDataError(): Hotel? = hotelService.search(null, null)[0]

    /**
     * Demonstrates a resolver that returns data with accompanying errors.
     * This simulates partial success scenarios where the main operation succeeds
     * but some fields or business logic generate warnings or non-critical errors.
     */
    @QueryMapping
    fun demoPartialResponse(): DataFetcherResult<Hotel> {
        val hotels = hotelService.search(null, null)

        val error: GraphQLError =
            GraphqlErrorBuilder.newError()
                .message("Some optional data could not be loaded")
                .path(listOf("demoPartialResponse", "rating"))
                .build()

        return DataFetcherResult.newResult<Hotel>()
            .data(hotels[0])
            .error(error)
            .build()
    }
}
