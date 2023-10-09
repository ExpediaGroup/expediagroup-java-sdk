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

package com.expediagroup.sdk.rapid.models

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
import jakarta.validation.Valid

/**
 * The coordinates of the property.
 * @param latitude The latitude of the property.
 * @param longitude The longitude of the property.
 */
data class Coordinates(
    // The latitude of the property.
    @JsonProperty("latitude")
    @field:Valid
    val latitude: java.math.BigDecimal? = null,
    // The longitude of the property.
    @JsonProperty("longitude")
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