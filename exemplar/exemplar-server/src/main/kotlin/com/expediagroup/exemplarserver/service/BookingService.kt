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

package com.expediagroup.exemplarserver.service

import com.expediagroup.exemplarserver.exception.BadRequestException
import com.expediagroup.exemplarserver.exception.BookingNotFoundException
import com.expediagroup.exemplarserver.model.Booking
import com.expediagroup.exemplarserver.model.BookingRequest
import com.expediagroup.exemplarserver.model.BookingStatus
import com.expediagroup.exemplarserver.repository.BookingRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID

@Service
class BookingService(
    private val bookingRepository: BookingRepository,
    private val hotelService: HotelService
) {
    fun findAll(): List<Booking> = bookingRepository.findAll()

    fun find(confirmationNumber: String): Booking = bookingRepository.find(confirmationNumber) ?: throw BookingNotFoundException("Booking with confirmation number $confirmationNumber does not exist")

    fun create(request: BookingRequest): Booking {
        val hotel = hotelService.findById(request.hotelId)

        if (request.checkInDate >= request.checkOutDate) {
            throw BadRequestException("Check-in date must be before check-out date")
        }

        val nights = ChronoUnit.DAYS.between(request.checkInDate, request.checkOutDate)
        val totalPrice = hotel.pricePerNight.multiply(BigDecimal(nights))

        val confirmationNumber = "BK${UUID.randomUUID().toString().replace("-", "").substring(0, 8).uppercase()}"

        val booking =
            Booking(
                confirmationNumber = confirmationNumber,
                status = BookingStatus.CONFIRMED,
                hotel = hotel,
                checkInDate = request.checkInDate,
                checkOutDate = request.checkOutDate,
                guests = request.guests,
                guestInfo = request.guestInfo,
                totalPrice = totalPrice,
                createdAt = OffsetDateTime.now()
            )

        return bookingRepository.save(booking)
    }

    fun update(confirmationNumber: String, booking: Booking): Booking {
        val existingBooking =
            bookingRepository.find(confirmationNumber)
                ?: throw BookingNotFoundException("Booking with confirmation number $confirmationNumber does not exist")

        if (booking.checkInDate >= booking.checkOutDate) {
            throw BadRequestException("Check-in date must be before check-out date")
        }

        val updatedBooking =
            existingBooking.copy(
                checkInDate = booking.checkInDate,
                checkOutDate = booking.checkOutDate,
                guests = booking.guests,
                guestInfo = booking.guestInfo,
                status = booking.status
            )

        return bookingRepository.save(updatedBooking)
    }

    fun delete(confirmationNumber: String): Boolean = bookingRepository.delete(confirmationNumber)
}
