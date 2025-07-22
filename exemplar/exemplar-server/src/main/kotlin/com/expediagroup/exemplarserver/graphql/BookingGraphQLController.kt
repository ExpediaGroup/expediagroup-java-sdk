/*
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

package com.expediagroup.exemplarserver.graphql

import com.expediagroup.exemplarserver.model.Booking
import com.expediagroup.exemplarserver.model.BookingRequest
import com.expediagroup.exemplarserver.service.BookingService
import com.expediagroup.exemplarserver.service.HotelService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookingGraphQLController(
    private val bookingService: BookingService,
    private val hotelService: HotelService
) {

    @QueryMapping
    fun bookings(): List<Booking> {
        return bookingService.findAll()
    }

    @QueryMapping
    fun booking(@Argument confirmationNumber: String): Booking? {
        return try {
            bookingService.find(confirmationNumber)
        } catch (e: Exception) {
            null // Return null for GraphQL instead of throwing exception
        }
    }

    @MutationMapping
    fun createBooking(@Argument input: BookingInputGraphQL): Booking {
        val request = BookingRequest(
            hotelId = input.hotelId,
            checkInDate = input.checkInDate,
            checkOutDate = input.checkOutDate,
            guests = input.guests,
            guestInfo = input.guestInfo.toGuestInfo()
        )
        return bookingService.create(request)
    }

    @MutationMapping
    fun updateBooking(
        @Argument confirmationNumber: String,
        @Argument input: BookingUpdateInputGraphQL
    ): Booking {
        val existing = bookingService.find(confirmationNumber)
        val updatedBooking = existing.copy(
            checkInDate = input.checkInDate ?: existing.checkInDate,
            checkOutDate = input.checkOutDate ?: existing.checkOutDate,
            guests = input.guests ?: existing.guests,
            status = input.status ?: existing.status,
            guestInfo = input.guestInfo?.toGuestInfo() ?: existing.guestInfo
        )
        return bookingService.update(confirmationNumber, updatedBooking)
    }
}
