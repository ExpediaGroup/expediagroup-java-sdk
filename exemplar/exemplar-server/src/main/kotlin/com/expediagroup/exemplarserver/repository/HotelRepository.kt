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

import com.expediagroup.exemplarserver.model.Hotel
import com.expediagroup.exemplarserver.model.Location
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class HotelRepository {
    private val hotels =
        listOf(
            Hotel(
                id = 1L,
                name = "Grand Plaza Hotel",
                description = "A luxurious hotel in the heart of the city",
                location =
                Location(
                    address = "123 Main St",
                    city = "New York",
                    state = "NY",
                    country = "USA",
                    postalCode = "10001",
                    latitude = 40.7589,
                    longitude = -73.9851
                ),
                pricePerNight = BigDecimal("199.99"),
                amenities = listOf("WiFi", "Pool", "Gym", "Restaurant", "Spa"),
                starRating = 4,
                checkInTime = "15:00",
                checkOutTime = "11:00"
            ),
            Hotel(
                id = 2L,
                name = "Seaside Resort",
                description = "Beachfront resort with stunning ocean views",
                location =
                Location(
                    address = "456 Ocean Drive",
                    city = "Miami",
                    state = "FL",
                    country = "USA",
                    postalCode = "33139",
                    latitude = 25.7617,
                    longitude = -80.1918
                ),
                pricePerNight = BigDecimal("299.99"),
                amenities = listOf("WiFi", "Beach Access", "Pool", "Restaurant", "Bar"),
                starRating = 5,
                checkInTime = "16:00",
                checkOutTime = "11:00"
            ),
            Hotel(
                id = 3L,
                name = "Mountain Lodge",
                description = "Cozy lodge nestled in the mountains",
                location =
                Location(
                    address = "789 Mountain View Rd",
                    city = "Aspen",
                    state = "CO",
                    country = "USA",
                    postalCode = "81611",
                    latitude = 39.1911,
                    longitude = -106.8175
                ),
                pricePerNight = BigDecimal("149.99"),
                amenities = listOf("WiFi", "Fireplace", "Hiking Trails", "Restaurant"),
                starRating = 3,
                checkInTime = "15:00",
                checkOutTime = "10:00"
            )
        )

    fun findAll(): List<Hotel> = hotels

    fun findById(id: Long): Hotel? = hotels.find { it.id == id }
}
