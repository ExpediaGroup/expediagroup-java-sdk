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
 * @param airlineCode Airline code of the trip segment
 * @param departureAirportCode Departure airport of the trip segment
 * @param arrivalAirportCode Arrival airport of the trip segment
 * @param departureTime Local date and time of departure from departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param arrivalTime Local date and time of arrival to destination location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 */
data class AirSegment(
    // Airline code of the trip segment
    @JsonProperty("airline_code")
    @field:Length(max = 10)
    @field:Valid
    val airlineCode: kotlin.String,
    // Departure airport of the trip segment
    @JsonProperty("departure_airport_code")
    @field:Length(max = 10)
    @field:Valid
    val departureAirportCode: kotlin.String,
    // Arrival airport of the trip segment
    @JsonProperty("arrival_airport_code")
    @field:Length(max = 10)
    @field:Valid
    val arrivalAirportCode: kotlin.String,
    // Local date and time of departure from departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("departure_time")
    val departureTime: java.time.OffsetDateTime? = null,
    // Local date and time of arrival to destination location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("arrival_time")
    val arrivalTime: java.time.OffsetDateTime? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var airlineCode: kotlin.String? = null,
        private var departureAirportCode: kotlin.String? = null,
        private var arrivalAirportCode: kotlin.String? = null,
        private var departureTime: java.time.OffsetDateTime? = null,
        private var arrivalTime: java.time.OffsetDateTime? = null
    ) {
        fun airlineCode(airlineCode: kotlin.String) = apply { this.airlineCode = airlineCode }

        fun departureAirportCode(departureAirportCode: kotlin.String) = apply { this.departureAirportCode = departureAirportCode }

        fun arrivalAirportCode(arrivalAirportCode: kotlin.String) = apply { this.arrivalAirportCode = arrivalAirportCode }

        fun departureTime(departureTime: java.time.OffsetDateTime) = apply { this.departureTime = departureTime }

        fun arrivalTime(arrivalTime: java.time.OffsetDateTime) = apply { this.arrivalTime = arrivalTime }

        fun build(): AirSegment {
            // Check required params
            validateNullity()
            return AirSegment(
                airlineCode = airlineCode!!,
                departureAirportCode = departureAirportCode!!,
                arrivalAirportCode = arrivalAirportCode!!,
                departureTime = departureTime,
                arrivalTime = arrivalTime
            )
        }

        private fun validateNullity() {
            if (airlineCode == null) {
                throw NullPointerException("Required parameter airlineCode is missing")
            }
            if (departureAirportCode == null) {
                throw NullPointerException("Required parameter departureAirportCode is missing")
            }
            if (arrivalAirportCode == null) {
                throw NullPointerException("Required parameter arrivalAirportCode is missing")
            }
        }
    }
}
