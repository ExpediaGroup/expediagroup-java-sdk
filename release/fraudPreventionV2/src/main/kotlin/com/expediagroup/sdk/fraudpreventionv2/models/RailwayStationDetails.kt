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
import org.hibernate.validator.constraints.Length

/**
 *
 * @param name The popularly known name or title by which the railway station is identified.
 * @param stationCode The unique identifier or code assigned to an individual rail station or a pseudo-station representing all the stations within a specific city, from which rail travel originates.
 * @param address
 * @param type This attribute provides information about the specific classification assigned to the rail station. It helps differentiate between different types of stations, such as major stations (STATION) or stations located within a city (city).
 * @param timezone The timezone associated with the location of the station, specifying the local time offset from Coordinated Universal Time (UTC).
 */
data class RailwayStationDetails(
    /* The popularly known name or title by which the railway station is identified. */
    @JsonProperty("name")
    @field:Length(max = 200)
    @field:Valid
    val name: kotlin.String,

    /* The unique identifier or code assigned to an individual rail station or a pseudo-station representing all the stations within a specific city, from which rail travel originates. */
    @JsonProperty("station_code")
    @field:Length(max = 200)
    @field:Valid
    val stationCode: kotlin.String,

    @JsonProperty("address")
    @field:Valid
    val address: CustomerAccountAddress,

    /* This attribute provides information about the specific classification assigned to the rail station. It helps differentiate between different types of stations, such as major stations (STATION) or stations located within a city (city). */
    @JsonProperty("type")
    val type: RailwayStationDetails.Type? = null,

    /* The timezone associated with the location of the station, specifying the local time offset from Coordinated Universal Time (UTC). */
    @JsonProperty("timezone")
    @field:Length(max = 200)
    @field:Valid
    val timezone: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var name: kotlin.String? = null,
        private var stationCode: kotlin.String? = null,
        private var address: CustomerAccountAddress? = null,
        private var type: RailwayStationDetails.Type? = null,
        private var timezone: kotlin.String? = null
    ) {
        fun name(name: kotlin.String) = apply { this.name = name }
        fun stationCode(stationCode: kotlin.String) = apply { this.stationCode = stationCode }
        fun address(address: CustomerAccountAddress) = apply { this.address = address }
        fun type(type: RailwayStationDetails.Type) = apply { this.type = type }
        fun timezone(timezone: kotlin.String) = apply { this.timezone = timezone }

        fun build(): RailwayStationDetails {
            // Check required params
            validateNullity()
            return RailwayStationDetails(
                name = name!!,
                stationCode = stationCode!!,
                address = address!!,
                type = type,
                timezone = timezone
            )
        }

        private fun validateNullity() {
            if (name == null) {
                throw NullPointerException("Required parameter name is missing")
            }
            if (stationCode == null) {
                throw NullPointerException("Required parameter stationCode is missing")
            }
            if (address == null) {
                throw NullPointerException("Required parameter address is missing")
            }
        }
    }

    /**
     * This attribute provides information about the specific classification assigned to the rail station. It helps differentiate between different types of stations, such as major stations (STATION) or stations located within a city (city).
     * Values: STATION,CITY
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("STATION")
        STATION("STATION"),

        @JsonProperty("CITY")
        CITY("CITY")
    }
}
