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

import com.expediagroup.exemplarserver.model.Hotel
import com.expediagroup.exemplarserver.service.HotelService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.math.BigDecimal

@Controller
class HotelGraphQLController(
    private val hotelService: HotelService
) {

    @QueryMapping
    fun hotels(
        @Argument city: String?,
        @Argument maxPrice: BigDecimal?
    ): List<Hotel> {
        return hotelService.search(city, maxPrice)
    }

    @QueryMapping
    fun hotel(@Argument id: Long): Hotel? {
        return try {
            hotelService.findById(id)
        } catch (e: Exception) {
            null // Return null for GraphQL instead of throwing exception
        }
    }
}
