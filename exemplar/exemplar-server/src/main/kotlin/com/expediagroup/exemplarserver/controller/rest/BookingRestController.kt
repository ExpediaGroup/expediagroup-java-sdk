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

import com.expediagroup.exemplarserver.model.Booking
import com.expediagroup.exemplarserver.model.BookingRequest
import com.expediagroup.exemplarserver.service.BookingService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/bookings")
@Tag(name = "Bookings", description = "Hotel booking management API")
class BookingRestController(private val bookingService: BookingService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        operationId = "create-booking",
        summary = "Create a hotel booking",
        description = "Book a hotel room"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Booking created successfully"),
            ApiResponse(responseCode = "400", description = "Invalid booking request"),
            ApiResponse(responseCode = "404", description = "Hotel not found")
        ]
    )
    fun create(@Valid @RequestBody request: BookingRequest): Booking = bookingService.create(request)

    @GetMapping("/{confirmationNumber}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
        operationId = "get-booking-by-confirmation-number",
        summary = "Get booking details",
        description = "Retrieve booking information by confirmation number"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved booking"),
            ApiResponse(responseCode = "404", description = "Booking not found")
        ]
    )
    fun findByConfirmationNumber(
        @Parameter(description = "Booking confirmation number", example = "BK12345678")
        @PathVariable confirmationNumber: String
    ): Booking = bookingService.find(confirmationNumber)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
        operationId = "get-all-bookings",
        summary = "Get all bookings",
        description = "Retrieve all bookings"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved bookings")
        ]
    )
    fun findAll(): List<Booking> = bookingService.findAll()

    @PutMapping("/{confirmationNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(operationId = "update-booking", summary = "Update booking", description = "Update an existing booking")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Booking updated successfully"),
            ApiResponse(responseCode = "404", description = "Booking not found"),
            ApiResponse(responseCode = "400", description = "Booking cannot be updated")
        ]
    )
    fun updateBooking(
        @Parameter(description = "Booking confirmation number", example = "BK12345678")
        @PathVariable("confirmationNumber")
        confirmationNumber: String,
        @Valid
        @RequestBody
        booking: Booking
    ): Booking = bookingService.update(confirmationNumber, booking)

    @DeleteMapping("/{confirmationNumber}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
        operationId = "delete-booking",
        summary = "Delete booking",
        description = "Delete an existing booking"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
            ApiResponse(responseCode = "404", description = "Booking not found"),
            ApiResponse(responseCode = "400", description = "Booking cannot be deleted")
        ]
    )
    fun delete(
        @PathVariable
        @Parameter(description = "Booking confirmation number", example = "BK12345678")
        confirmationNumber: String
    ): Boolean = bookingService.delete(confirmationNumber)
}
