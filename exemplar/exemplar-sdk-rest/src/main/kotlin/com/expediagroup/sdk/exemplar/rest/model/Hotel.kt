/**
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
package com.expediagroup.sdk.exemplar.rest.model

import com.expediagroup.sdk.core.common.getOrThrow
import com.expediagroup.sdk.exemplar.rest.model.Location
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Hotel information
 * @param id Unique hotel identifier
 * @param name Hotel name
 * @param location Hotel location
 * @param pricePerNight Price per night in USD
 * @param amenities Hotel amenities
 * @param description Hotel description
 * @param starRating Star rating
 * @param checkInTime Check-in time
 * @param checkOutTime Check-out time
 */
@ConsistentCopyVisibility data class Hotel private constructor(
    // Unique hotel identifier
    @JsonProperty("id")
    val id: kotlin.Long,
    // Hotel name
    @JsonProperty("name")
    val name: kotlin.String,
    // Hotel location
    @JsonProperty("location")
    val location: Location,
    // Price per night in USD
    @JsonProperty("pricePerNight")
    val pricePerNight: java.math.BigDecimal,
    // Hotel amenities
    @JsonProperty("amenities")
    val amenities: kotlin.collections
        .List<
            kotlin.String
        >,
    // Hotel description
    @JsonProperty("description")
    val description: kotlin.String? = null,
    // Star rating
    @JsonProperty("starRating")
    val starRating: kotlin.Int? = null,
    // Check-in time
    @JsonProperty("checkInTime")
    val checkInTime: kotlin.String? = null,
    // Check-out time
    @JsonProperty("checkOutTime")
    val checkOutTime: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.Long? = null,
        private var name: kotlin.String? = null,
        private var location: Location? = null,
        private var pricePerNight: java.math.BigDecimal? = null,
        private var amenities: kotlin.collections.List<kotlin.String>? = null,
        private var description: kotlin.String? = null,
        private var starRating: kotlin.Int? = null,
        private var checkInTime: kotlin.String? = null,
        private var checkOutTime: kotlin.String? = null
    ) {
        fun id(id: kotlin.Long) = apply { this.id = id }

        fun name(name: kotlin.String) = apply { this.name = name }

        fun location(location: Location) = apply { this.location = location }

        fun pricePerNight(pricePerNight: java.math.BigDecimal) = apply { this.pricePerNight = pricePerNight }

        fun amenities(amenities: kotlin.collections.List<kotlin.String>) = apply { this.amenities = amenities }

        fun description(description: kotlin.String?) = apply { this.description = description }

        fun starRating(starRating: kotlin.Int?) = apply { this.starRating = starRating }

        fun checkInTime(checkInTime: kotlin.String?) = apply { this.checkInTime = checkInTime }

        fun checkOutTime(checkOutTime: kotlin.String?) = apply { this.checkOutTime = checkOutTime }

        fun build(): Hotel {
            val id =
                this.id.getOrThrow {
                    IllegalArgumentException("id must not be null")
                }

            val name =
                this.name.getOrThrow {
                    IllegalArgumentException("name must not be null")
                }

            require(name?.length ?: 0 >= 1) { "name must be at least 1 characters long" }

            val location =
                this.location.getOrThrow {
                    IllegalArgumentException("location must not be null")
                }

            val pricePerNight =
                this.pricePerNight.getOrThrow {
                    IllegalArgumentException("pricePerNight must not be null")
                }

            val amenities =
                this.amenities.getOrThrow {
                    IllegalArgumentException("amenities must not be null")
                }

            val instance =
                Hotel(
                    id = id,
                    name = name,
                    location = location,
                    pricePerNight = pricePerNight,
                    amenities = amenities,
                    description = description,
                    starRating = starRating,
                    checkInTime = checkInTime,
                    checkOutTime = checkOutTime
                )

            return instance
        }
    }

    fun toBuilder() =
        Builder(
            id = id,
            name = name,
            location = location,
            pricePerNight = pricePerNight,
            amenities = amenities,
            description = description,
            starRating = starRating,
            checkInTime = checkInTime,
            checkOutTime = checkOutTime
        )
}
