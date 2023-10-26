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
 * @param hotelId Unique hotel identifier assigned by the partner.
 * @param hotelName Name of the hotel.
 * @param address
 * @param checkinTime Local date and time of the hotel check-in, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param checkoutTime Local date and time of the hotel check-out, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param priceWithheld Identifies if the product price was withheld from the customer during the booking process.
 * @param roomCount Total number of rooms booked within the hotel product collection.
 */
data class HotelAllOf(
    // Unique hotel identifier assigned by the partner.
    @JsonProperty("hotel_id")
    @field:Length(max = 200)
    @field:Valid
    val hotelId: kotlin.String,
    // Name of the hotel.
    @JsonProperty("hotel_name")
    @field:Length(max = 200)
    @field:Valid
    val hotelName: kotlin.String,
    @JsonProperty("address")
    @field:Valid
    val address: HotelAddress,
    // Local date and time of the hotel check-in, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("checkin_time")
    val checkinTime: java.time.OffsetDateTime,
    // Local date and time of the hotel check-out, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("checkout_time")
    val checkoutTime: java.time.OffsetDateTime,
    // Identifies if the product price was withheld from the customer during the booking process.
    @JsonProperty("price_withheld")
    @field:Valid
    val priceWithheld: kotlin.Boolean? = null,
    // Total number of rooms booked within the hotel product collection.
    @JsonProperty("room_count")
    val roomCount: kotlin.Int? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var hotelId: kotlin.String? = null,
        private var hotelName: kotlin.String? = null,
        private var address: HotelAddress? = null,
        private var checkinTime: java.time.OffsetDateTime? = null,
        private var checkoutTime: java.time.OffsetDateTime? = null,
        private var priceWithheld: kotlin.Boolean? = null,
        private var roomCount: kotlin.Int? = null
    ) {
        fun hotelId(hotelId: kotlin.String) = apply { this.hotelId = hotelId }

        fun hotelName(hotelName: kotlin.String) = apply { this.hotelName = hotelName }

        fun address(address: HotelAddress) = apply { this.address = address }

        fun checkinTime(checkinTime: java.time.OffsetDateTime) = apply { this.checkinTime = checkinTime }

        fun checkoutTime(checkoutTime: java.time.OffsetDateTime) = apply { this.checkoutTime = checkoutTime }

        fun priceWithheld(priceWithheld: kotlin.Boolean) = apply { this.priceWithheld = priceWithheld }

        fun roomCount(roomCount: kotlin.Int) = apply { this.roomCount = roomCount }

        fun build(): HotelAllOf {
            // Check required params
            validateNullity()
            return HotelAllOf(
                hotelId = hotelId!!,
                hotelName = hotelName!!,
                address = address!!,
                checkinTime = checkinTime!!,
                checkoutTime = checkoutTime!!,
                priceWithheld = priceWithheld,
                roomCount = roomCount
            )
        }

        private fun validateNullity() {
            if (hotelId == null) {
                throw NullPointerException("Required parameter hotelId is missing")
            }
            if (hotelName == null) {
                throw NullPointerException("Required parameter hotelName is missing")
            }
            if (address == null) {
                throw NullPointerException("Required parameter address is missing")
            }
            if (checkinTime == null) {
                throw NullPointerException("Required parameter checkinTime is missing")
            }
            if (checkoutTime == null) {
                throw NullPointerException("Required parameter checkoutTime is missing")
            }
        }
    }
}
