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
import javax.validation.Valid

/**
 * The itinerary object.
 * @param itineraryId The itinerary id.
 * @param propertyId The property id.
 * @param links
 * @param email Email address for the customer.
 * @param phone
 * @param rooms
 * @param billingContact
 * @param adjustment
 * @param creationDateTime The creation date/time of the booking.
 * @param affiliateReferenceId Your unique reference value. This field supports from 3 to a maximum of 28 characters.
 * @param affiliateMetadata Field that stores up to 256 characters of additional metadata with the itinerary, uniqueness is not required.
 * @param conversations
 * @param traderInformation
 * @param essentialInformation
 * @param travelPurpose Value potentially passed in during the availability request to indicate the purpose of the trip designated by the traveler.
 * @param itineraryHistory
 * @param roomHistory An array of rooms each containing an array of room history events.
 */
data class Itinerary(
    // The itinerary id.
    @JsonProperty("itinerary_id")
    @field:Valid
    val itineraryId: kotlin.String? = null,
    // The property id.
    @JsonProperty("property_id")
    @field:Valid
    val propertyId: kotlin.String? = null,
    @JsonProperty("links")
    @field:Valid
    val links: ItineraryLinks? = null,
    // Email address for the customer.
    @JsonProperty("email")
    @field:Valid
    val email: kotlin.String? = null,
    @JsonProperty("phone")
    @field:Valid
    val phone: Phone? = null,
    @JsonProperty("rooms")
    @field:Valid
    val rooms: kotlin.collections.List<RoomItinerary>? = null,
    @JsonProperty("billing_contact")
    @field:Valid
    val billingContact: BillingContact? = null,
    @JsonProperty("adjustment")
    @field:Valid
    val adjustment: Adjustment? = null,
    // The creation date/time of the booking.
    @JsonProperty("creation_date_time")
    @field:Valid
    val creationDateTime: kotlin.String? = null,
    // Your unique reference value. This field supports from 3 to a maximum of 28 characters.
    @JsonProperty("affiliate_reference_id")
    @field:Valid
    val affiliateReferenceId: kotlin.String? = null,
    // Field that stores up to 256 characters of additional metadata with the itinerary, uniqueness is not required.
    @JsonProperty("affiliate_metadata")
    @field:Valid
    val affiliateMetadata: kotlin.String? = null,
    @JsonProperty("conversations")
    @field:Valid
    val conversations: Conversations? = null,
    @JsonProperty("trader_information")
    @field:Valid
    val traderInformation: TraderInformation? = null,
    @JsonProperty("essential_information")
    @field:Valid
    val essentialInformation: EssentialInformation? = null,
    // Value potentially passed in during the availability request to indicate the purpose of the trip designated by the traveler.
    @JsonProperty("travel_purpose")
    val travelPurpose: Itinerary.TravelPurpose? = null,
    @JsonProperty("itinerary_history")
    @field:Valid
    val itineraryHistory: kotlin.collections.List<ItineraryHistoryItem>? = null,
    // An array of rooms each containing an array of room history events.
    @JsonProperty("room_history")
    @field:Valid
    val roomHistory: kotlin.collections.List<kotlin.collections.List<RoomHistoryItem>>? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var itineraryId: kotlin.String? = null,
        private var propertyId: kotlin.String? = null,
        private var links: ItineraryLinks? = null,
        private var email: kotlin.String? = null,
        private var phone: Phone? = null,
        private var rooms: kotlin.collections.List<RoomItinerary>? = null,
        private var billingContact: BillingContact? = null,
        private var adjustment: Adjustment? = null,
        private var creationDateTime: kotlin.String? = null,
        private var affiliateReferenceId: kotlin.String? = null,
        private var affiliateMetadata: kotlin.String? = null,
        private var conversations: Conversations? = null,
        private var traderInformation: TraderInformation? = null,
        private var essentialInformation: EssentialInformation? = null,
        private var travelPurpose: Itinerary.TravelPurpose? = null,
        private var itineraryHistory: kotlin.collections.List<ItineraryHistoryItem>? = null,
        private var roomHistory: kotlin.collections.List<kotlin.collections.List<RoomHistoryItem>>? = null
    ) {
        fun itineraryId(itineraryId: kotlin.String?) = apply { this.itineraryId = itineraryId }

        fun propertyId(propertyId: kotlin.String?) = apply { this.propertyId = propertyId }

        fun links(links: ItineraryLinks?) = apply { this.links = links }

        fun email(email: kotlin.String?) = apply { this.email = email }

        fun phone(phone: Phone?) = apply { this.phone = phone }

        fun rooms(rooms: kotlin.collections.List<RoomItinerary>?) = apply { this.rooms = rooms }

        fun billingContact(billingContact: BillingContact?) = apply { this.billingContact = billingContact }

        fun adjustment(adjustment: Adjustment?) = apply { this.adjustment = adjustment }

        fun creationDateTime(creationDateTime: kotlin.String?) = apply { this.creationDateTime = creationDateTime }

        fun affiliateReferenceId(affiliateReferenceId: kotlin.String?) = apply { this.affiliateReferenceId = affiliateReferenceId }

        fun affiliateMetadata(affiliateMetadata: kotlin.String?) = apply { this.affiliateMetadata = affiliateMetadata }

        fun conversations(conversations: Conversations?) = apply { this.conversations = conversations }

        fun traderInformation(traderInformation: TraderInformation?) = apply { this.traderInformation = traderInformation }

        fun essentialInformation(essentialInformation: EssentialInformation?) = apply { this.essentialInformation = essentialInformation }

        fun travelPurpose(travelPurpose: Itinerary.TravelPurpose?) = apply { this.travelPurpose = travelPurpose }

        fun itineraryHistory(itineraryHistory: kotlin.collections.List<ItineraryHistoryItem>?) = apply { this.itineraryHistory = itineraryHistory }

        fun roomHistory(roomHistory: kotlin.collections.List<kotlin.collections.List<RoomHistoryItem>>?) = apply { this.roomHistory = roomHistory }

        fun build(): Itinerary {
            return Itinerary(
                itineraryId = itineraryId,
                propertyId = propertyId,
                links = links,
                email = email,
                phone = phone,
                rooms = rooms,
                billingContact = billingContact,
                adjustment = adjustment,
                creationDateTime = creationDateTime,
                affiliateReferenceId = affiliateReferenceId,
                affiliateMetadata = affiliateMetadata,
                conversations = conversations,
                traderInformation = traderInformation,
                essentialInformation = essentialInformation,
                travelPurpose = travelPurpose,
                itineraryHistory = itineraryHistory,
                roomHistory = roomHistory
            )
        }
    }

    /**
     * Value potentially passed in during the availability request to indicate the purpose of the trip designated by the traveler.
     * Values: LEISURE,BUSINESS,UNSPECIFIED
     */
    enum class TravelPurpose(val value: kotlin.String) {
        @JsonProperty("leisure")
        LEISURE("leisure"),

        @JsonProperty("business")
        BUSINESS("business"),

        @JsonProperty("unspecified")
        UNSPECIFIED("unspecified")
    }
}
