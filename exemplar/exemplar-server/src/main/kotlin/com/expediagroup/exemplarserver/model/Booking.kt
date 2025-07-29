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

package com.expediagroup.exemplarserver.model

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime

@Schema(description = "Hotel booking confirmation")
data class Booking(
    @Schema(description = "Unique booking confirmation number", example = "BK123456789")
    val confirmationNumber: String,
    @Schema(description = "Booking status", example = "CONFIRMED")
    val status: BookingStatus,
    @field:NotNull
    @Schema(description = "Booked hotel information")
    val hotel: Hotel,
    @field:NotNull
    @Schema(description = "Check-in date", example = "2025-08-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    val checkInDate: LocalDate,
    @field:NotNull
    @Schema(description = "Check-out date", example = "2025-08-18")
    @JsonFormat(pattern = "yyyy-MM-dd")
    val checkOutDate: LocalDate,
    @Schema(description = "Number of guests", example = "2")
    val guests: Int,
    @field:NotNull
    @Schema(description = "Guest information")
    val guestInfo: GuestInfo,
    @field:NotNull
    @Schema(description = "Total price", example = "599.97")
    val totalPrice: BigDecimal,
    @field:NotNull
    @Schema(description = "Booking creation timestamp")
    val createdAt: OffsetDateTime
)
