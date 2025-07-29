/**
 * Copyright (C) 2025 Expedia, Inc.
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
package com.expediagroup.sdk.exemplar.rest.model

import com.expediagroup.sdk.core.common.getOrThrow
import com.expediagroup.sdk.exemplar.rest.model.GuestInfo
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Hotel booking request
 * @param hotelId Hotel ID to book
 * @param checkInDate Check-in date
 * @param checkOutDate Check-out date
 * @param guests Number of guests
 * @param guestInfo Guest information
 */
@ConsistentCopyVisibility data class BookingRequest private constructor(
    // Hotel ID to book
    @JsonProperty("hotelId")
    val hotelId: kotlin.Long,
    // Check-in date
    @JsonProperty("checkInDate")
    val checkInDate: java.time.LocalDate,
    // Check-out date
    @JsonProperty("checkOutDate")
    val checkOutDate: java.time.LocalDate,
    // Number of guests
    @JsonProperty("guests")
    val guests: kotlin.Int,
    // Guest information
    @JsonProperty("guestInfo")
    val guestInfo: GuestInfo
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var hotelId: kotlin.Long? = null,
        private var checkInDate: java.time.LocalDate? = null,
        private var checkOutDate: java.time.LocalDate? = null,
        private var guests: kotlin.Int? = null,
        private var guestInfo: GuestInfo? = null
    ) {
        fun hotelId(hotelId: kotlin.Long) = apply { this.hotelId = hotelId }

        fun checkInDate(checkInDate: java.time.LocalDate) = apply { this.checkInDate = checkInDate }

        fun checkOutDate(checkOutDate: java.time.LocalDate) = apply { this.checkOutDate = checkOutDate }

        fun guests(guests: kotlin.Int) = apply { this.guests = guests }

        fun guestInfo(guestInfo: GuestInfo) = apply { this.guestInfo = guestInfo }

        fun build(): BookingRequest {
            val hotelId =
                this.hotelId.getOrThrow {
                    IllegalArgumentException("hotelId must not be null")
                }

            val checkInDate =
                this.checkInDate.getOrThrow {
                    IllegalArgumentException("checkInDate must not be null")
                }

            val checkOutDate =
                this.checkOutDate.getOrThrow {
                    IllegalArgumentException("checkOutDate must not be null")
                }

            val guests =
                this.guests.getOrThrow {
                    IllegalArgumentException("guests must not be null")
                }

            val guestInfo =
                this.guestInfo.getOrThrow {
                    IllegalArgumentException("guestInfo must not be null")
                }

            val instance =
                BookingRequest(
                    hotelId = hotelId,
                    checkInDate = checkInDate,
                    checkOutDate = checkOutDate,
                    guests = guests,
                    guestInfo = guestInfo
                )

            return instance
        }
    }

    fun toBuilder() = Builder(
        hotelId = hotelId,
        checkInDate = checkInDate,
        checkOutDate = checkOutDate,
        guests = guests,
        guestInfo = guestInfo
    )
}
