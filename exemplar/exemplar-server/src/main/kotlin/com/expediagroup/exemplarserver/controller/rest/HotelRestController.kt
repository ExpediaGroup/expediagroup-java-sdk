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

package com.expediagroup.exemplarserver.controller.rest

import com.expediagroup.exemplarserver.model.Hotel
import com.expediagroup.exemplarserver.service.HotelService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/hotels")
@Tag(name = "Hotels", description = "Hotel search and information API")
class HotelRestController(
    private val hotelService: HotelService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(operationId = "search-hotel", summary = "Search hotels", description = "Search for hotels based on criteria")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Successfully retrieved hotels")])
    fun search(
        @RequestParam(required = false) city: String?,
        @RequestParam(required = false) maxPrice: BigDecimal?
    ): List<Hotel> {
        return hotelService.search(city, maxPrice)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(operationId = "get-hotel-by-id", summary = "Get hotel by ID", description = "Retrieve detailed information about a specific hotel")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved hotel"),
            ApiResponse(responseCode = "404", description = "Hotel not found")
        ]
    )
    fun findById(@PathVariable id: Long): Hotel {
        return hotelService.findById(id)
    }
}
