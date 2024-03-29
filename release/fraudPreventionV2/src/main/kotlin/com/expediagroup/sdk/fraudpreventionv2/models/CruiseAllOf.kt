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
import org.hibernate.validator.constraints.Length
import javax.validation.Valid

/**
 *
 * @param departureTime Local date and time of departure from original departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param arrivalTime Local date and time of arrival from original arrival location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param embarkationPort Location from where cruise will depart.
 * @param disembarkationPort The cruise's final destination.
 * @param shipName Name of the cruise ship.
 */
data class CruiseAllOf(
    // Local date and time of departure from original departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("departure_time")
    val departureTime: java.time.OffsetDateTime,
    // Local date and time of arrival from original arrival location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("arrival_time")
    val arrivalTime: java.time.OffsetDateTime,
    // Location from where cruise will depart.
    @JsonProperty("embarkation_port")
    @field:Length(max = 200)
    @field:Valid
    val embarkationPort: kotlin.String,
    // The cruise's final destination.
    @JsonProperty("disembarkation_port")
    @field:Length(max = 200)
    @field:Valid
    val disembarkationPort: kotlin.String,
    // Name of the cruise ship.
    @JsonProperty("ship_name")
    @field:Length(max = 200)
    @field:Valid
    val shipName: kotlin.String
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var departureTime: java.time.OffsetDateTime? = null,
        private var arrivalTime: java.time.OffsetDateTime? = null,
        private var embarkationPort: kotlin.String? = null,
        private var disembarkationPort: kotlin.String? = null,
        private var shipName: kotlin.String? = null
    ) {
        fun departureTime(departureTime: java.time.OffsetDateTime) = apply { this.departureTime = departureTime }

        fun arrivalTime(arrivalTime: java.time.OffsetDateTime) = apply { this.arrivalTime = arrivalTime }

        fun embarkationPort(embarkationPort: kotlin.String) = apply { this.embarkationPort = embarkationPort }

        fun disembarkationPort(disembarkationPort: kotlin.String) = apply { this.disembarkationPort = disembarkationPort }

        fun shipName(shipName: kotlin.String) = apply { this.shipName = shipName }

        fun build(): CruiseAllOf {
            // Check required params
            validateNullity()
            return CruiseAllOf(
                departureTime = departureTime!!,
                arrivalTime = arrivalTime!!,
                embarkationPort = embarkationPort!!,
                disembarkationPort = disembarkationPort!!,
                shipName = shipName!!
            )
        }

        private fun validateNullity() {
            if (departureTime == null) {
                throw NullPointerException("Required parameter departureTime is missing")
            }
            if (arrivalTime == null) {
                throw NullPointerException("Required parameter arrivalTime is missing")
            }
            if (embarkationPort == null) {
                throw NullPointerException("Required parameter embarkationPort is missing")
            }
            if (disembarkationPort == null) {
                throw NullPointerException("Required parameter disembarkationPort is missing")
            }
            if (shipName == null) {
                throw NullPointerException("Required parameter shipName is missing")
            }
        }
    }
}
