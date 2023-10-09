/*
 * Copyright (C) 2022 Expedia, Inc.
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

package com.expediagroup.sdk.fraudpreventionv2.models

/*
 * Copyright (C) 2022 Expedia, Inc.
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

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

/**
 *
 * @param routeType The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey.
 * @param railSegments
 */
data class RailAllOf(
    // The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey.
    @JsonProperty("route_type")
    val routeType: RailAllOf.RouteType,
    @JsonProperty("rail_segments")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val railSegments: kotlin.collections.List<RailSegments>
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var routeType: RailAllOf.RouteType? = null,
        private var railSegments: kotlin.collections.List<RailSegments>? = null
    ) {
        fun routeType(routeType: RailAllOf.RouteType) = apply { this.routeType = routeType }

        fun railSegments(railSegments: kotlin.collections.List<RailSegments>) = apply { this.railSegments = railSegments }

        fun build(): RailAllOf {
            // Check required params
            validateNullity()
            return RailAllOf(
                routeType = routeType!!,
                railSegments = railSegments!!
            )
        }

        private fun validateNullity() {
            if (routeType == null) {
                throw NullPointerException("Required parameter routeType is missing")
            }
            if (railSegments == null) {
                throw NullPointerException("Required parameter railSegments is missing")
            }
        }
    }

    /**
     * The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey.
     * Values: MULTIPLE_DESTINATIONS,ONE_WAY,ROUND_TRIP
     */
    enum class RouteType(val value: kotlin.String) {
        @JsonProperty("MULTIPLE_DESTINATIONS")
        MULTIPLE_DESTINATIONS("MULTIPLE_DESTINATIONS"),

        @JsonProperty("ONE_WAY")
        ONE_WAY("ONE_WAY"),

        @JsonProperty("ROUND_TRIP")
        ROUND_TRIP("ROUND_TRIP")
    }
}
