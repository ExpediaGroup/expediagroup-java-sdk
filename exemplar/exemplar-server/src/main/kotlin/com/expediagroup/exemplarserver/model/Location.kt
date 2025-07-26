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

@Schema(description = "Hotel location information")
data class Location(
    @field:NotBlank
    @Schema(description = "Street address", example = "123 Main St")
    val address: String,

    @field:NotBlank
    @Schema(description = "City", example = "New York")
    val city: String,

    @field:NotBlank
    @Schema(description = "State or province", example = "NY")
    val state: String,

    @field:NotBlank
    @Schema(description = "Country", example = "USA")
    val country: String,

    @Schema(description = "Postal code", example = "10001")
    val postalCode: String?,

    @Schema(description = "Latitude", example = "40.7589")
    val latitude: Double?,

    @Schema(description = "Longitude", example = "-73.9851")
    val longitude: Double?
)
