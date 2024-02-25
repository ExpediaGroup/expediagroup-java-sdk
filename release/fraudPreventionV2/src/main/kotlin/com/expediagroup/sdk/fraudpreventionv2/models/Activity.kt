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
data class Activity(
    @JsonProperty("price")
    @field:Valid
    override val price: Amount,
    // Type of inventory. Ensure attributes mentioned in dictionary below are set to corresponding values only. `inventory_type` has the following mapping with TravelProduct `type` attribute: *       inventory_type            :      type * ------------------------------------------------------ *  `Cruise`                       : `CRUISE` *  `Air`                          : `AIR` *  `Car`                          : `CAR` *  `Insurance`                    : `INSURANCE` *  `Hotel`                        : `HOTEL` *  `Rail`                         : `RAIL` *  `Activity`                     : `ACTIVITY`
    @JsonProperty("inventory_type")
    @field:Length(max = 30)
    @field:Valid
    override val inventoryType: kotlin.String,
    // Identifies the business model through which the supply is being sold. Merchant/Agency. * `MERCHANT` is used when Partner is the merchant of record for this order. * `AGENCY` is used when this order is through an agency booking.
    @JsonProperty("inventory_source")
    override val inventorySource: TravelProduct.InventorySource,
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
    // List of travelerGuids who are part of the traveling party on the order for the product. Information for each product and its required travelers should be provided in the API request. If the product booking does not require accompanying quest information then that does not need to be provided in the API request. Example: * For Air products, all travelers' details are required to complete the booking. * For Hotel products, typically the details on the person checking-in is required. * For Car products, typically only the primary driver information is required. If multiple traveler details are in the itinerary, this structure allows to fill up traveler details once in the `travelers` section, and then associate individual products to the respective travelers. This association is made using `traveler_id` field. A GUID can be generated for each object in the `travelers` section. The same GUID can be provided in the `traveler_references` below. The `travelers` array should have at least one `traveler` object, and each `traveler` object should have a `traveler_id` which is not necessarily an account id. Example: *   Travelers * ------------ *  A - GUID1 *  B - GUID2 *  C - GUID3 * *   Products * ------------ * Air *   [GUID1, GUID2, GUID3] * Hotel *   [GUID1] * Car *   [GUID3] * Rail *   [GUID2] * Activity *   [GUID1] * The example above demonstrates the association of travelers with various products. * All three travelers (A, B, and C) are associated with the Air product. * Traveler A is associated with the Hotel and Activity products. * Traveler C is associated with the Car product. * Traveler B is associated with the Rail product.
    @JsonProperty("travelers_references")
    @field:Size(min = 1, max = 40)
    @field:Valid
    override val travelersReferences: kotlin.collections.List<kotlin.String>? = null,
    // The attribute serves as a boolean indicator that significantly influences the handling of payment information during the fraud prevention process: * When 'pay_later' is set to 'true':   - This configuration signals that payment information is optional for the booking. Travelers are given the choice to defer payment until they arrive at the rental counter following the completion of the booking.   - It is imperative for partners to explicitly set this attribute to 'true' when payment information can be optional for a particular booking scenario. * When 'pay_later' is set to 'false':   - In this mode, the attribute mandates the inclusion of payment information during the order purchase screen request. Travelers are required to provide payment details.   - Partners must exercise caution and ensure they supply the necessary payment information, as failure to do so in cases where 'pay_later' is set to 'false' will result in a 'Bad Request' error. This error helps maintain the consistency and accuracy of the fraud prevention process and payment handling.
    @JsonProperty("pay_later")
    @field:Valid
    override val payLater: kotlin.Boolean? = null,
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
) : TravelProduct {
    @JsonProperty("type")
    override val type: TravelProductType = TravelProductType.ACTIVITY

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var price: Amount? = null,
        private var inventoryType: kotlin.String? = null,
        private var inventorySource: TravelProduct.InventorySource? = null,
        private var categoryName: kotlin.String? = null,
        private var activityDescription: kotlin.String? = null,
        private var supplyProvider: SupplyProvider? = null,
        private var tickets: kotlin.collections.List<Ticket>? = null,
        private var coordinates: Coordinates? = null,
        private var travelersReferences: kotlin.collections.List<kotlin.String>? = null,
        private var payLater: kotlin.Boolean? = null,
        private var startDateTime: java.time.OffsetDateTime? = null,
        private var endDateTime: java.time.OffsetDateTime? = null,
        private var isPassbook: kotlin.Boolean? = null,
        private var availablePolicy: AvailablePolicy? = null
    ) {
        fun price(price: Amount) = apply { this.price = price }

        fun inventoryType(inventoryType: kotlin.String) = apply { this.inventoryType = inventoryType }

        fun inventorySource(inventorySource: TravelProduct.InventorySource) = apply { this.inventorySource = inventorySource }

        fun categoryName(categoryName: kotlin.String) = apply { this.categoryName = categoryName }

        fun activityDescription(activityDescription: kotlin.String) = apply { this.activityDescription = activityDescription }

        fun supplyProvider(supplyProvider: SupplyProvider) = apply { this.supplyProvider = supplyProvider }

        fun tickets(tickets: kotlin.collections.List<Ticket>) = apply { this.tickets = tickets }

        fun coordinates(coordinates: Coordinates) = apply { this.coordinates = coordinates }

        fun travelersReferences(travelersReferences: kotlin.collections.List<kotlin.String>?) = apply { this.travelersReferences = travelersReferences }

        fun payLater(payLater: kotlin.Boolean?) = apply { this.payLater = payLater }

        fun startDateTime(startDateTime: java.time.OffsetDateTime?) = apply { this.startDateTime = startDateTime }

        fun endDateTime(endDateTime: java.time.OffsetDateTime?) = apply { this.endDateTime = endDateTime }

        fun isPassbook(isPassbook: kotlin.Boolean?) = apply { this.isPassbook = isPassbook }

        fun availablePolicy(availablePolicy: AvailablePolicy?) = apply { this.availablePolicy = availablePolicy }

        fun build(): Activity {
            // Check required params
            validateNullity()
            return Activity(
                price = price!!,
                inventoryType = inventoryType!!,
                inventorySource = inventorySource!!,
                categoryName = categoryName!!,
                activityDescription = activityDescription!!,
                supplyProvider = supplyProvider!!,
                tickets = tickets!!,
                coordinates = coordinates!!,
                travelersReferences = travelersReferences,
                payLater = payLater,
                startDateTime = startDateTime,
                endDateTime = endDateTime,
                isPassbook = isPassbook,
                availablePolicy = availablePolicy
            )
        }

        private fun validateNullity() {
            if (price == null) {
                throw NullPointerException("Required parameter price is missing")
            }
            if (inventoryType == null) {
                throw NullPointerException("Required parameter inventoryType is missing")
            }
            if (inventorySource == null) {
                throw NullPointerException("Required parameter inventorySource is missing")
            }
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
