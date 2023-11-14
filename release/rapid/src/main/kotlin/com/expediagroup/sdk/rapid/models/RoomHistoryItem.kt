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
 * A room history event, representing a change made to a specific room.
 * @param historyId Room history id for particular change.
 * @param eventTimestamp Date and time in UTC of the change event, in extended ISO 8601 format.
 * @param eventType Type type of event associated with this history item such as modified or canceled.
 * @param eventSource The source of the event. If `voyager_agent`, `agent_id` will be supplied.
 * @param changeReferenceId Optional identifier provided during changes via Rapid.
 * @param agentId An agent user id number associated with a modification.
 * @param roomId The room id.
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
 * @param amountCharged
 * @param amountRefunded
 * @param penalty
 * @param rate
 */
data class RoomHistoryItem(
    // Room history id for particular change.
    @JsonProperty("history_id")
    @field:Valid
    val historyId: kotlin.String? = null,
    // Date and time in UTC of the change event, in extended ISO 8601 format.
    @JsonProperty("event_timestamp")
    @field:Valid
    val eventTimestamp: kotlin.String? = null,
    // Type type of event associated with this history item such as modified or canceled.
    @JsonProperty("event_type")
    val eventType: RoomHistoryItem.EventType? = null,
    // The source of the event. If `voyager_agent`, `agent_id` will be supplied.
    @JsonProperty("event_source")
    val eventSource: RoomHistoryItem.EventSource? = null,
    // Optional identifier provided during changes via Rapid.
    @JsonProperty("change_reference_id")
    @field:Valid
    val changeReferenceId: kotlin.String? = null,
    // An agent user id number associated with a modification.
    @JsonProperty("agent_id")
    @field:Valid
    val agentId: kotlin.Int? = null,
    // The room id.
    @JsonProperty("room_id")
    @field:Valid
    val roomId: kotlin.String? = null,
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
    @JsonProperty("amount_charged")
    @field:Valid
    val amountCharged: Charge? = null,
    @JsonProperty("amount_refunded")
    @field:Valid
    val amountRefunded: Charge? = null,
    @JsonProperty("penalty")
    @field:Valid
    val penalty: Charge? = null,
    @JsonProperty("rate")
    @field:Valid
    val rate: RateHistory? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var historyId: kotlin.String? = null,
        private var eventTimestamp: kotlin.String? = null,
        private var eventType: RoomHistoryItem.EventType? = null,
        private var eventSource: RoomHistoryItem.EventSource? = null,
        private var changeReferenceId: kotlin.String? = null,
        private var agentId: kotlin.Int? = null,
        private var roomId: kotlin.String? = null,
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
        private var amountCharged: Charge? = null,
        private var amountRefunded: Charge? = null,
        private var penalty: Charge? = null,
        private var rate: RateHistory? = null
    ) {
        fun historyId(historyId: kotlin.String) = apply { this.historyId = historyId }

        fun eventTimestamp(eventTimestamp: kotlin.String) = apply { this.eventTimestamp = eventTimestamp }

        fun eventType(eventType: RoomHistoryItem.EventType) = apply { this.eventType = eventType }

        fun eventSource(eventSource: RoomHistoryItem.EventSource) = apply { this.eventSource = eventSource }

        fun changeReferenceId(changeReferenceId: kotlin.String) = apply { this.changeReferenceId = changeReferenceId }

        fun agentId(agentId: kotlin.Int) = apply { this.agentId = agentId }

        fun roomId(roomId: kotlin.String) = apply { this.roomId = roomId }

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

        fun amountCharged(amountCharged: Charge) = apply { this.amountCharged = amountCharged }

        fun amountRefunded(amountRefunded: Charge) = apply { this.amountRefunded = amountRefunded }

        fun penalty(penalty: Charge) = apply { this.penalty = penalty }

        fun rate(rate: RateHistory) = apply { this.rate = rate }

        fun build(): RoomHistoryItem {
            return RoomHistoryItem(
                historyId = historyId,
                eventTimestamp = eventTimestamp,
                eventType = eventType,
                eventSource = eventSource,
                changeReferenceId = changeReferenceId,
                agentId = agentId,
                roomId = roomId,
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
                amountCharged = amountCharged,
                amountRefunded = amountRefunded,
                penalty = penalty,
                rate = rate
            )
        }
    }

    /**
     * Type type of event associated with this history item such as modified or canceled.
     * Values: CREATED,MODIFIED,CANCELED
     */
    enum class EventType(val value: kotlin.String) {
        @JsonProperty("created")
        CREATED("created"),

        @JsonProperty("modified")
        MODIFIED("modified"),

        @JsonProperty("canceled")
        CANCELED("canceled")
    }

    /**
     * The source of the event. If `voyager_agent`, `agent_id` will be supplied.
     * Values: RAPID_API,VOYAGER_AGENT,OTHER
     */
    enum class EventSource(val value: kotlin.String) {
        @JsonProperty("rapid_api")
        RAPID_API("rapid_api"),

        @JsonProperty("voyager_agent")
        VOYAGER_AGENT("voyager_agent"),

        @JsonProperty("other")
        OTHER("other")
    }
}
