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

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

@Schema(description = "Hotel information")
data class Hotel(
    @Schema(description = "Unique hotel identifier", example = "12345")
    val id: Long,

    @field:NotBlank
    @Schema(description = "Hotel name", example = "Grand Plaza Hotel")
    val name: String,

    @Schema(description = "Hotel description", example = "A luxurious hotel in the heart of the city")
    val description: String?,

    @field:NotNull
    @Schema(description = "Hotel location")
    val location: Location,

    @field:Positive
    @Schema(description = "Price per night in USD", example = "199.99")
    val pricePerNight: BigDecimal,

    @Schema(description = "Hotel amenities")
    val amenities: List<String> = emptyList(),

    @Schema(description = "Star rating", example = "4")
    val starRating: Int?,

    @Schema(description = "Check-in time", example = "15:00")
    val checkInTime: String?,

    @Schema(description = "Check-out time", example = "11:00")
    val checkOutTime: String?
)
