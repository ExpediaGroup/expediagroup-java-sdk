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

package com.expediagroup.sdk.rapid.models

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

/**
 * The room information.
 * @param id The room id.
 * @param confirmationId
 * @param bedGroupId Unique identifier for a bed type.
 * @param checkin The check-in date of the itinerary.
 * @param checkout The check-out date of the itinerary.
 * @param numberOfAdults The number of adults staying in the room.
 * @param childAges The ages of children for the room.
 * @param givenName The first name of the main guest staying in the room.
 * @param familyName The last name of the main guest staying in the room.
 * @param status
 * @param specialRequest Any special request info associated with the room.
 * @param smoking Indicates if the room is smoking or non-smoking.
 * @param loyaltyId A loyalty identifier for a hotel loyalty program associated with this room guest.
 * @param rate
 * @param links
 */
data class RoomItinerary(
    // The room id.
    @JsonProperty("id")
    @field:Valid
    val id: kotlin.String? = null,
    @JsonProperty("confirmation_id")
    @field:Valid
    val confirmationId: ConfirmationId? = null,
    // Unique identifier for a bed type.
    @JsonProperty("bed_group_id")
    @field:Valid
    val bedGroupId: kotlin.String? = null,
    // The check-in date of the itinerary.
    @JsonProperty("checkin")
    @field:Valid
    val checkin: kotlin.String? = null,
    // The check-out date of the itinerary.
    @JsonProperty("checkout")
    @field:Valid
    val checkout: kotlin.String? = null,
    // The number of adults staying in the room.
    @JsonProperty("number_of_adults")
    @field:Valid
    val numberOfAdults: java.math.BigDecimal? = null,
    // The ages of children for the room.
    @JsonProperty("child_ages")
    @field:Valid
    val childAges: kotlin.collections.List<java.math.BigDecimal>? = null,
    // The first name of the main guest staying in the room.
    @JsonProperty("given_name")
    @field:Valid
    val givenName: kotlin.String? = null,
    // The last name of the main guest staying in the room.
    @JsonProperty("family_name")
    @field:Valid
    val familyName: kotlin.String? = null,
    @JsonProperty("status")
    @field:Valid
    val status: StatusItinerary? = null,
    // Any special request info associated with the room.
    @JsonProperty("special_request")
    @field:Valid
    val specialRequest: kotlin.String? = null,
    // Indicates if the room is smoking or non-smoking.
    @JsonProperty("smoking")
    @field:Valid
    val smoking: kotlin.Boolean? = null,
    // A loyalty identifier for a hotel loyalty program associated with this room guest.
    @JsonProperty("loyalty_id")
    @field:Valid
    val loyaltyId: kotlin.String? = null,
    @JsonProperty("rate")
    @field:Valid
    val rate: RateItinerary? = null,
    @JsonProperty("links")
    @field:Valid
    val links: RoomItineraryLinks? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var confirmationId: ConfirmationId? = null,
        private var bedGroupId: kotlin.String? = null,
        private var checkin: kotlin.String? = null,
        private var checkout: kotlin.String? = null,
        private var numberOfAdults: java.math.BigDecimal? = null,
        private var childAges: kotlin.collections.List<java.math.BigDecimal>? = null,
        private var givenName: kotlin.String? = null,
        private var familyName: kotlin.String? = null,
        private var status: StatusItinerary? = null,
        private var specialRequest: kotlin.String? = null,
        private var smoking: kotlin.Boolean? = null,
        private var loyaltyId: kotlin.String? = null,
        private var rate: RateItinerary? = null,
        private var links: RoomItineraryLinks? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }

        fun confirmationId(confirmationId: ConfirmationId) = apply { this.confirmationId = confirmationId }

        fun bedGroupId(bedGroupId: kotlin.String) = apply { this.bedGroupId = bedGroupId }

        fun checkin(checkin: kotlin.String) = apply { this.checkin = checkin }

        fun checkout(checkout: kotlin.String) = apply { this.checkout = checkout }

        fun numberOfAdults(numberOfAdults: java.math.BigDecimal) = apply { this.numberOfAdults = numberOfAdults }

        fun childAges(childAges: kotlin.collections.List<java.math.BigDecimal>) = apply { this.childAges = childAges }

        fun givenName(givenName: kotlin.String) = apply { this.givenName = givenName }

        fun familyName(familyName: kotlin.String) = apply { this.familyName = familyName }

        fun status(status: StatusItinerary) = apply { this.status = status }

        fun specialRequest(specialRequest: kotlin.String) = apply { this.specialRequest = specialRequest }

        fun smoking(smoking: kotlin.Boolean) = apply { this.smoking = smoking }

        fun loyaltyId(loyaltyId: kotlin.String) = apply { this.loyaltyId = loyaltyId }

        fun rate(rate: RateItinerary) = apply { this.rate = rate }

        fun links(links: RoomItineraryLinks) = apply { this.links = links }

        fun build(): RoomItinerary {
            return RoomItinerary(
                id = id,
                confirmationId = confirmationId,
                bedGroupId = bedGroupId,
                checkin = checkin,
                checkout = checkout,
                numberOfAdults = numberOfAdults,
                childAges = childAges,
                givenName = givenName,
                familyName = familyName,
                status = status,
                specialRequest = specialRequest,
                smoking = smoking,
                loyaltyId = loyaltyId,
                rate = rate,
                links = links
            )
        }
    }
}
