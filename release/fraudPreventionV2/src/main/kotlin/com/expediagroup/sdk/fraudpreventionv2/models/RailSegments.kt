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
import jakarta.validation.Valid

/**
 *
 * @param departureTime The local date and time of the scheduled departure from the departure station, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param arrivalTime The local date and time of the scheduled arrival at the destination station, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param departureStation
 * @param arrivalStation
 * @param transportationMethod This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories.
 * @param operatingCompany
 */
data class RailSegments(
    /* The local date and time of the scheduled departure from the departure station, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("departure_time")
    val departureTime: java.time.OffsetDateTime,

    /* The local date and time of the scheduled arrival at the destination station, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("arrival_time")
    val arrivalTime: java.time.OffsetDateTime,

    @JsonProperty("departure_station")
    @field:Valid
    val departureStation: RailwayStationDetails,

    @JsonProperty("arrival_station")
    @field:Valid
    val arrivalStation: RailwayStationDetails,

    /* This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories.  */
    @JsonProperty("transportation_method")
    val transportationMethod: RailSegments.TransportationMethod,

    @JsonProperty("operating_company")
    @field:Valid
    val operatingCompany: RailSegmentsOperatingCompany? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var departureTime: java.time.OffsetDateTime? = null,
        private var arrivalTime: java.time.OffsetDateTime? = null,
        private var departureStation: RailwayStationDetails? = null,
        private var arrivalStation: RailwayStationDetails? = null,
        private var transportationMethod: RailSegments.TransportationMethod? = null,
        private var operatingCompany: RailSegmentsOperatingCompany? = null
    ) {
        fun departureTime(departureTime: java.time.OffsetDateTime) = apply { this.departureTime = departureTime }
        fun arrivalTime(arrivalTime: java.time.OffsetDateTime) = apply { this.arrivalTime = arrivalTime }
        fun departureStation(departureStation: RailwayStationDetails) = apply { this.departureStation = departureStation }
        fun arrivalStation(arrivalStation: RailwayStationDetails) = apply { this.arrivalStation = arrivalStation }
        fun transportationMethod(transportationMethod: RailSegments.TransportationMethod) = apply { this.transportationMethod = transportationMethod }
        fun operatingCompany(operatingCompany: RailSegmentsOperatingCompany) = apply { this.operatingCompany = operatingCompany }

        fun build(): RailSegments {
            // Check required params
            validateNullity()
            return RailSegments(
                departureTime = departureTime!!,
                arrivalTime = arrivalTime!!,
                departureStation = departureStation!!,
                arrivalStation = arrivalStation!!,
                transportationMethod = transportationMethod!!,
                operatingCompany = operatingCompany
            )
        }

        private fun validateNullity() {
            if (departureTime == null) {
                throw NullPointerException("Required parameter departureTime is missing")
            }
            if (arrivalTime == null) {
                throw NullPointerException("Required parameter arrivalTime is missing")
            }
            if (departureStation == null) {
                throw NullPointerException("Required parameter departureStation is missing")
            }
            if (arrivalStation == null) {
                throw NullPointerException("Required parameter arrivalStation is missing")
            }
            if (transportationMethod == null) {
                throw NullPointerException("Required parameter transportationMethod is missing")
            }
        }
    }

    /**
     * This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories.
     * Values: BUS,FERRY,PUBLIC_TRANSPORT,RAIL,TRAM,TRANSFER,OTHERS
     */
    enum class TransportationMethod(val value: kotlin.String) {
        @JsonProperty("BUS")
        BUS("BUS"),

        @JsonProperty("FERRY")
        FERRY("FERRY"),

        @JsonProperty("PUBLIC_TRANSPORT")
        PUBLIC_TRANSPORT("PUBLIC_TRANSPORT"),

        @JsonProperty("RAIL")
        RAIL("RAIL"),

        @JsonProperty("TRAM")
        TRAM("TRAM"),

        @JsonProperty("TRANSFER")
        TRANSFER("TRANSFER"),

        @JsonProperty("OTHERS")
        OTHERS("OTHERS")
    }
}
