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
package com.expediagroup.sdk.exemplar.model

import com.expediagroup.sdk.core.common.getOrThrow
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Hotel location information
 * @param address Street address
 * @param city City
 * @param state State or province
 * @param country Country
 * @param postalCode Postal code
 * @param latitude Latitude
 * @param longitude Longitude
 */
@ConsistentCopyVisibility data class Location private constructor(
    // Street address
    @JsonProperty("address")
    val address: kotlin.String,
    // City
    @JsonProperty("city")
    val city: kotlin.String,
    // State or province
    @JsonProperty("state")
    val state: kotlin.String,
    // Country
    @JsonProperty("country")
    val country: kotlin.String,
    // Postal code
    @JsonProperty("postalCode")
    val postalCode: kotlin.String? = null,
    // Latitude
    @JsonProperty("latitude")
    val latitude: kotlin.Double? = null,
    // Longitude
    @JsonProperty("longitude")
    val longitude: kotlin.Double? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var address: kotlin.String? = null,
        private var city: kotlin.String? = null,
        private var state: kotlin.String? = null,
        private var country: kotlin.String? = null,
        private var postalCode: kotlin.String? = null,
        private var latitude: kotlin.Double? = null,
        private var longitude: kotlin.Double? = null
    ) {
        fun address(address: kotlin.String) = apply { this.address = address }

        fun city(city: kotlin.String) = apply { this.city = city }

        fun state(state: kotlin.String) = apply { this.state = state }

        fun country(country: kotlin.String) = apply { this.country = country }

        fun postalCode(postalCode: kotlin.String?) = apply { this.postalCode = postalCode }

        fun latitude(latitude: kotlin.Double?) = apply { this.latitude = latitude }

        fun longitude(longitude: kotlin.Double?) = apply { this.longitude = longitude }

        fun build(): Location {
            val address =
                this.address.getOrThrow {
                    IllegalArgumentException("address must not be null")
                }

            require(address?.length ?: 0 >= 1) { "address must be at least 1 characters long" }

            val city =
                this.city.getOrThrow {
                    IllegalArgumentException("city must not be null")
                }

            require(city?.length ?: 0 >= 1) { "city must be at least 1 characters long" }

            val state =
                this.state.getOrThrow {
                    IllegalArgumentException("state must not be null")
                }

            require(state?.length ?: 0 >= 1) { "state must be at least 1 characters long" }

            val country =
                this.country.getOrThrow {
                    IllegalArgumentException("country must not be null")
                }

            require(country?.length ?: 0 >= 1) { "country must be at least 1 characters long" }

            val instance =
                Location(
                    address = address,
                    city = city,
                    state = state,
                    country = country,
                    postalCode = postalCode,
                    latitude = latitude,
                    longitude = longitude
                )

            return instance
        }
    }

    fun toBuilder() =
        Builder(
            address = address,
            city = city,
            state = state,
            country = country,
            postalCode = postalCode,
            latitude = latitude,
            longitude = longitude
        )
}
