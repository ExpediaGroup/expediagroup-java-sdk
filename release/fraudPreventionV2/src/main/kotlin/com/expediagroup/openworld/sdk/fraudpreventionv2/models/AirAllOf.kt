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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.AirSegment

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
 * 
 * @param departureTime Local date and time of departure from original departure location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param arrivalTime Local date and time of arrival to final destination location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param airSegments Additional airline and flight details for each of the trip segments.
 * @param flightType Identifies the type of air trip based on the air destinations.
 * @param passengerNameRecord Airline booking confirmation code for the trip.
 * @param globalDistributionSystemType Associated with Passenger Name Record (PNR).
 */
data class AirAllOf(
    /* Local date and time of departure from original departure location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
@JsonProperty("departure_time")

    val departureTime: java.time.OffsetDateTime,

    /* Local date and time of arrival to final destination location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
@JsonProperty("arrival_time")

    val arrivalTime: java.time.OffsetDateTime,

    /* Additional airline and flight details for each of the trip segments. */
@JsonProperty("air_segments")

    
    @field:Size(min = 1, max = 30)
    
    
    @field:Valid
    val airSegments: kotlin.collections.List<AirSegment>,

    /* Identifies the type of air trip based on the air destinations. */
@JsonProperty("flight_type")

    val flightType: AirAllOf.FlightType? = null,

    /* Airline booking confirmation code for the trip. */
@JsonProperty("passenger_name_record")

    @field:Length(max = 100)
    
    
    
    @field:Valid
    val passengerNameRecord: kotlin.String? = null,

    /* Associated with Passenger Name Record (PNR). */
@JsonProperty("global_distribution_system_type")

    @field:Length(max = 100)
    
    
    
    @field:Valid
    val globalDistributionSystemType: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var departureTime: java.time.OffsetDateTime? = null,
        private var arrivalTime: java.time.OffsetDateTime? = null,
        private var airSegments: kotlin.collections.List<AirSegment>? = null,
        private var flightType: AirAllOf.FlightType? = null,
        private var passengerNameRecord: kotlin.String? = null,
        private var globalDistributionSystemType: kotlin.String? = null
    ) {
        fun departureTime(departureTime: java.time.OffsetDateTime) = apply { this.departureTime = departureTime }
        fun arrivalTime(arrivalTime: java.time.OffsetDateTime) = apply { this.arrivalTime = arrivalTime }
        fun airSegments(airSegments: kotlin.collections.List<AirSegment>) = apply { this.airSegments = airSegments }
        fun flightType(flightType: AirAllOf.FlightType) = apply { this.flightType = flightType }
        fun passengerNameRecord(passengerNameRecord: kotlin.String) = apply { this.passengerNameRecord = passengerNameRecord }
        fun globalDistributionSystemType(globalDistributionSystemType: kotlin.String) = apply { this.globalDistributionSystemType = globalDistributionSystemType }

        fun build(): AirAllOf {
            // Check required params
            validateNullity()
            return AirAllOf(
                departureTime = departureTime!!,
                arrivalTime = arrivalTime!!,
                airSegments = airSegments!!,
                flightType = flightType,
                passengerNameRecord = passengerNameRecord,
                globalDistributionSystemType = globalDistributionSystemType
            )
        }

        private fun validateNullity() {
            if (departureTime == null) {
                throw NullPointerException("Required parameter departureTime is missing")
            }
            if (arrivalTime == null) {
                throw NullPointerException("Required parameter arrivalTime is missing")
            }
            if (airSegments == null) {
                throw NullPointerException("Required parameter airSegments is missing")
            }
        }
    }

    /**
     * Identifies the type of air trip based on the air destinations.
     * Values: ROUNDTRIP,ONEWAY,MULTIPLE_DESTINATION
     */
    enum class FlightType(val value: kotlin.String) {
        @JsonProperty("ROUNDTRIP")
        ROUNDTRIP("ROUNDTRIP"),
        
        @JsonProperty("ONEWAY")
        ONEWAY("ONEWAY"),
        
        @JsonProperty("MULTIPLE_DESTINATION")
        MULTIPLE_DESTINATION("MULTIPLE_DESTINATION");
    }
}

