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

/**
 * This field signifies the precise geographical coordinates denoting the location of the activity.
 * @param latitude The latitude in degrees. It must be in the range [-90.0, +90.0].
 * @param longitude The longitude in degrees. It must be in the range [-180.0, +180.0].
 */
data class Coordinates(
    // The latitude in degrees. It must be in the range [-90.0, +90.0].
    @JsonProperty("latitude")
    val latitude: kotlin.Double,
    // The longitude in degrees. It must be in the range [-180.0, +180.0].
    @JsonProperty("longitude")
    val longitude: kotlin.Double
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var latitude: kotlin.Double? = null,
        private var longitude: kotlin.Double? = null
    ) {
        fun latitude(latitude: kotlin.Double) = apply { this.latitude = latitude }

        fun longitude(longitude: kotlin.Double) = apply { this.longitude = longitude }

        fun build(): Coordinates {
            // Check required params
            validateNullity()
            return Coordinates(
                latitude = latitude!!,
                longitude = longitude!!
            )
        }

        private fun validateNullity() {
            if (latitude == null) {
                throw NullPointerException("Required parameter latitude is missing")
            }
            if (longitude == null) {
                throw NullPointerException("Required parameter longitude is missing")
            }
        }
    }
}
