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

package com.expediagroup.exemplarserver.repository

import com.expediagroup.exemplarserver.model.Booking
import org.springframework.stereotype.Repository

@Repository
class BookingRepository {
    private val bookings = mutableListOf<Booking>()

    fun findAll(): List<Booking> = bookings

    fun find(confirmationNumber: String): Booking? =
        bookings.firstOrNull {
            it.confirmationNumber == confirmationNumber
        }

    fun save(booking: Booking): Booking = bookings.add(booking).let { booking }

    fun delete(confirmationNumber: String): Boolean = bookings.remove(find(confirmationNumber))
}
