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

@Schema(description = "Guest information")
data class GuestInfo(
    @field:NotBlank
    @Schema(description = "First name", example = "John")
    val firstName: String,

    @field:NotBlank
    @Schema(description = "Last name", example = "Doe")
    val lastName: String,

    @field:NotBlank
    @Schema(description = "Email address", example = "john.doe@example.com")
    val email: String,

    @Schema(description = "Phone number", example = "+1-555-123-4567")
    val phoneNumber: String?
)
