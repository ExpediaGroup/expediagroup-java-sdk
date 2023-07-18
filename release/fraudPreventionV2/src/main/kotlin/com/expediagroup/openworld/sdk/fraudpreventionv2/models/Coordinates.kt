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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models


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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * Group of attributes intended to hold information about location coordinates.
 * @param latitude The latitude in degrees. It must be in the range [-90.0, +90.0].
 * @param longitude The longitude in degrees. It must be in the range [-180.0, +180.0].
 */
data class Coordinates(
    /* The latitude in degrees. It must be in the range [-90.0, +90.0]. */
@JsonProperty("latitude")

    
    
    @field:Min(-90)
    @field:Max(90)
    @field:Valid
    val latitude: java.math.BigDecimal? = null,

    /* The longitude in degrees. It must be in the range [-180.0, +180.0]. */
@JsonProperty("longitude")

    
    
    @field:Min(-180)
    @field:Max(180)
    @field:Valid
    val longitude: java.math.BigDecimal? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var latitude: java.math.BigDecimal? = null,
        private var longitude: java.math.BigDecimal? = null
    ) {
        fun latitude(latitude: java.math.BigDecimal) = apply { this.latitude = latitude }
        fun longitude(longitude: java.math.BigDecimal) = apply { this.longitude = longitude }

        fun build(): Coordinates {
            return Coordinates(
                latitude = latitude,
                longitude = longitude
            )
        }

    }
}

