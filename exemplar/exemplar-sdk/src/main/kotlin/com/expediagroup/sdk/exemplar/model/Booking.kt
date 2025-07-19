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
package com.expediagroup.sdk.exemplar.model

import com.expediagroup.sdk.core.common.getOrThrow
import com.expediagroup.sdk.exemplar.model.GuestInfo
import com.expediagroup.sdk.exemplar.model.Hotel
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Hotel booking confirmation
 * @param confirmationNumber Unique booking confirmation number
 * @param status Booking status
 * @param hotel Booked hotel information
 * @param checkInDate Check-in date
 * @param checkOutDate Check-out date
 * @param guests Number of guests
 * @param guestInfo Guest information
 * @param totalPrice Total price
 * @param createdAt Booking creation timestamp
 */
@ConsistentCopyVisibility data class Booking private constructor(
    // Unique booking confirmation number
    @JsonProperty("confirmationNumber")
    val confirmationNumber: kotlin.String,
    // Booking status
    @JsonProperty("status")
    val status: Booking.Status,
    // Booked hotel information
    @JsonProperty("hotel")
    val hotel: Hotel,
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
    val guestInfo: GuestInfo,
    // Total price
    @JsonProperty("totalPrice")
    val totalPrice: java.math.BigDecimal,
    // Booking creation timestamp
    @JsonProperty("createdAt")
    val createdAt: java.time.OffsetDateTime
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var confirmationNumber: kotlin.String? = null,
        private var status: Booking.Status? = null,
        private var hotel: Hotel? = null,
        private var checkInDate: java.time.LocalDate? = null,
        private var checkOutDate: java.time.LocalDate? = null,
        private var guests: kotlin.Int? = null,
        private var guestInfo: GuestInfo? = null,
        private var totalPrice: java.math.BigDecimal? = null,
        private var createdAt: java.time.OffsetDateTime? = null
    ) {
        fun confirmationNumber(confirmationNumber: kotlin.String) = apply { this.confirmationNumber = confirmationNumber }

        fun status(status: Booking.Status) = apply { this.status = status }

        fun hotel(hotel: Hotel) = apply { this.hotel = hotel }

        fun checkInDate(checkInDate: java.time.LocalDate) = apply { this.checkInDate = checkInDate }

        fun checkOutDate(checkOutDate: java.time.LocalDate) = apply { this.checkOutDate = checkOutDate }

        fun guests(guests: kotlin.Int) = apply { this.guests = guests }

        fun guestInfo(guestInfo: GuestInfo) = apply { this.guestInfo = guestInfo }

        fun totalPrice(totalPrice: java.math.BigDecimal) = apply { this.totalPrice = totalPrice }

        fun createdAt(createdAt: java.time.OffsetDateTime) = apply { this.createdAt = createdAt }

        fun build(): Booking {
            val confirmationNumber =
                this.confirmationNumber.getOrThrow {
                    IllegalArgumentException("confirmationNumber must not be null")
                }

            val status =
                this.status.getOrThrow {
                    IllegalArgumentException("status must not be null")
                }

            val hotel =
                this.hotel.getOrThrow {
                    IllegalArgumentException("hotel must not be null")
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

            val totalPrice =
                this.totalPrice.getOrThrow {
                    IllegalArgumentException("totalPrice must not be null")
                }

            val createdAt =
                this.createdAt.getOrThrow {
                    IllegalArgumentException("createdAt must not be null")
                }

            val instance =
                Booking(
                    confirmationNumber = confirmationNumber,
                    status = status,
                    hotel = hotel,
                    checkInDate = checkInDate,
                    checkOutDate = checkOutDate,
                    guests = guests,
                    guestInfo = guestInfo,
                    totalPrice = totalPrice,
                    createdAt = createdAt
                )

            return instance
        }
    }

    fun toBuilder() =
        Builder(
            confirmationNumber = confirmationNumber,
            status = status,
            hotel = hotel,
            checkInDate = checkInDate,
            checkOutDate = checkOutDate,
            guests = guests,
            guestInfo = guestInfo,
            totalPrice = totalPrice,
            createdAt = createdAt
        )

    /**
     * Booking status
     * Values: PENDING,CONFIRMED,CANCELLED,COMPLETED
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty("PENDING")
        PENDING("PENDING"),

        @JsonProperty("CONFIRMED")
        CONFIRMED("CONFIRMED"),

        @JsonProperty("CANCELLED")
        CANCELLED("CANCELLED"),

        @JsonProperty("COMPLETED")
        COMPLETED("COMPLETED")
    }
}
