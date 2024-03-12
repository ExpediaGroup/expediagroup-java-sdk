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
import javax.validation.constraints.Size
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param categoryName This field categorizes various types of activities available within the product. It allows API consumers to assign descriptive labels or keywords representing the nature of each activity. Possible category name values include: * `Adventures`: This category includes activities such as hiking, zip-lining, rock climbing, bungee jumping, and other adventurous pursuits. * `Air, Balloon & Helicopter Tours`: This category offers activities like hot air balloon rides, helicopter tours, and aerial sightseeing experiences. * `Cruises & Water Tours`: This includes options such as boat cruises, yacht tours, river rafting, snorkeling, and diving expeditions.  * `Nightlife`: This category encompasses activities like clubbing, pub crawls, live music events, and cultural performances. These activities predominantly occur during the evening or nighttime.
 * @param activityDescription This field provides additional details or a brief explanation of the specific activity.
 * @param supplyProvider
 * @param tickets
 * @param coordinates
 * @param startDateTime The field represents the start time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param endDateTime The field represents the end time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param isPassbook Indicates whether a QR code is required for an activity, serving as proof of reservation or purchase. This includes digital tickets saved on mobile applications such as Google Pay, Apple Wallet, or similar services provided by activity organizers.
 * @param availablePolicy
 */
data class ActivityAllOf(
    // This field categorizes various types of activities available within the product. It allows API consumers to assign descriptive labels or keywords representing the nature of each activity. Possible category name values include: * `Adventures`: This category includes activities such as hiking, zip-lining, rock climbing, bungee jumping, and other adventurous pursuits. * `Air, Balloon & Helicopter Tours`: This category offers activities like hot air balloon rides, helicopter tours, and aerial sightseeing experiences. * `Cruises & Water Tours`: This includes options such as boat cruises, yacht tours, river rafting, snorkeling, and diving expeditions.  * `Nightlife`: This category encompasses activities like clubbing, pub crawls, live music events, and cultural performances. These activities predominantly occur during the evening or nighttime.
    @JsonProperty("category_name")
    @field:Length(max = 200)
    @field:Valid
    val categoryName: kotlin.String,
    // This field provides additional details or a brief explanation of the specific activity.
    @JsonProperty("activity_description")
    @field:Length(max = 200)
    @field:Valid
    val activityDescription: kotlin.String,
    @JsonProperty("supply_provider")
    @field:Valid
    val supplyProvider: SupplyProvider,
    @JsonProperty("tickets")
    @field:Size(min = 1, max = 40)
    @field:Valid
    val tickets: kotlin.collections.List<Ticket>,
    @JsonProperty("coordinates")
    @field:Valid
    val coordinates: Coordinates,
    // The field represents the start time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("start_date_time")
    val startDateTime: java.time.OffsetDateTime? = null,
    // The field represents the end time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("end_date_time")
    val endDateTime: java.time.OffsetDateTime? = null,
    // Indicates whether a QR code is required for an activity, serving as proof of reservation or purchase. This includes digital tickets saved on mobile applications such as Google Pay, Apple Wallet, or similar services provided by activity organizers.
    @JsonProperty("is_passbook")
    @field:Valid
    val isPassbook: kotlin.Boolean? = null,
    @JsonProperty("available_policy")
    @field:Valid
    val availablePolicy: AvailablePolicy? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var categoryName: kotlin.String? = null,
        private var activityDescription: kotlin.String? = null,
        private var supplyProvider: SupplyProvider? = null,
        private var tickets: kotlin.collections.List<Ticket>? = null,
        private var coordinates: Coordinates? = null,
        private var startDateTime: java.time.OffsetDateTime? = null,
        private var endDateTime: java.time.OffsetDateTime? = null,
        private var isPassbook: kotlin.Boolean? = null,
        private var availablePolicy: AvailablePolicy? = null
    ) {
        fun categoryName(categoryName: kotlin.String) = apply { this.categoryName = categoryName }

        fun activityDescription(activityDescription: kotlin.String) = apply { this.activityDescription = activityDescription }

        fun supplyProvider(supplyProvider: SupplyProvider) = apply { this.supplyProvider = supplyProvider }

        fun tickets(tickets: kotlin.collections.List<Ticket>) = apply { this.tickets = tickets }

        fun coordinates(coordinates: Coordinates) = apply { this.coordinates = coordinates }

        fun startDateTime(startDateTime: java.time.OffsetDateTime?) = apply { this.startDateTime = startDateTime }

        fun endDateTime(endDateTime: java.time.OffsetDateTime?) = apply { this.endDateTime = endDateTime }

        fun isPassbook(isPassbook: kotlin.Boolean?) = apply { this.isPassbook = isPassbook }

        fun availablePolicy(availablePolicy: AvailablePolicy?) = apply { this.availablePolicy = availablePolicy }

        fun build(): ActivityAllOf {
            // Check required params
            validateNullity()
            return ActivityAllOf(
                categoryName = categoryName!!,
                activityDescription = activityDescription!!,
                supplyProvider = supplyProvider!!,
                tickets = tickets!!,
                coordinates = coordinates!!,
                startDateTime = startDateTime,
                endDateTime = endDateTime,
                isPassbook = isPassbook,
                availablePolicy = availablePolicy
            )
        }

        private fun validateNullity() {
            if (categoryName == null) {
                throw NullPointerException("Required parameter categoryName is missing")
            }
            if (activityDescription == null) {
                throw NullPointerException("Required parameter activityDescription is missing")
            }
            if (supplyProvider == null) {
                throw NullPointerException("Required parameter supplyProvider is missing")
            }
            if (tickets == null) {
                throw NullPointerException("Required parameter tickets is missing")
            }
            if (coordinates == null) {
                throw NullPointerException("Required parameter coordinates is missing")
            }
        }
    }
}
