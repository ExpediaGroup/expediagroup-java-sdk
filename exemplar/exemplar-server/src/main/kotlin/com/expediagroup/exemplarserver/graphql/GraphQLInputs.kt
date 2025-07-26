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

import com.expediagroup.exemplarserver.model.BookingStatus
import com.expediagroup.exemplarserver.model.GuestInfo
import java.time.LocalDate

data class BookingInputGraphQL(
    val hotelId: Long,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate,
    val guests: Int,
    val guestInfo: GuestInfoInputGraphQL
)

data class BookingUpdateInputGraphQL(
    val checkInDate: LocalDate? = null,
    val checkOutDate: LocalDate? = null,
    val guests: Int? = null,
    val status: BookingStatus? = null,
    val guestInfo: GuestInfoInputGraphQL? = null
)

data class GuestInfoInputGraphQL(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String? = null
) {
    fun toGuestInfo() = GuestInfo(
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phone
    )
}
