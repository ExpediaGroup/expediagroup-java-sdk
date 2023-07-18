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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Activity
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Amount
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Coordinates
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OperatingCompany
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Ticket
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.TravelProduct
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.TravelProductType

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param activity 
 * @param operatingCompany 
 * @param startTime The field represents the start time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ.
 * @param endTime The field represents the end time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ.
 * @param ticket This field provides information about the tickets available for the activity.
 * @param isCouponRequired A coupon is typically a document or electronic code that confirms your reservation or purchase for the activity. It serves as proof of payment and allows you to participate in the activity. This field indicates whether a coupon is necessary for this activity. | For example, let's consider two scenarios: | Activity: Adventure Park | is_coupon_required: false | In this case, the attribute is set to 'false,' indicating that no coupon is necessary. However, you might still need to purchase a ticket to gain entry to the adventure park. The ticket serves as proof of payment and grants you access to the park's activities and attractions. | Activity: Spa Package | is_coupon_required: true | Here, the attribute is set to 'true,' indicating that a coupon is required. To participate in the spa package, you would need to present the designated coupon at the spa. The coupon confirms your reservation, serves as proof of payment, and may entitle you to specific spa treatments or discounts.
 * @param locationCoordinates 
 */
data class Activities(
    @JsonProperty("price")

    
    
    
    
    @field:Valid
    override val price: Amount,


    /* Type of inventory. Ensure attributes mentioned in dictionary below are set to corresponding values only. `inventory_type` has the following mapping with TravelProduct `type` attribute: *       inventory_type            :      type * ------------------------------------------------------ *  `Cruise`                       : `CRUISE` *  `Air`                          : `AIR` *  `Car`                          : `CAR` *  `Insurance`                    : `INSURANCE` *  `Hotel`                        : `HOTEL` *  `Rail`                         :  `RAIL` *  `Activities`                   :  `ACTIVITIES`  */
@JsonProperty("inventory_type")

    @field:Length(max = 30)
    
    
    
    @field:Valid
    override val inventoryType: kotlin.String,

    /* Identifies the business model through which the supply is being sold. Merchant/Agency. * `MERCHANT` is used when Partner is the merchant of record for this order. * `AGENCY` is used when this order is through an agency booking.  */
@JsonProperty("inventory_source")

    override val inventorySource: TravelProduct.InventorySource,

    /* List of travelerGuids who are part of the traveling party on the order for the product. Information for each product and its required travelers should be provided in the API request. If the product booking does not require accompanying quest information then that does not need to be provided in the API request. Example: * For Air products, all travelers' details are required to complete the booking. * For Hotel products, typically the details on the person checking-in is required. * For Car products, typically only the primary driver information is required. If multiple traveler details are in the itinerary, this structure allows to fill up traveler details once in the `travelers` section, and then associate individual products to the respective travelers. This association is made using `traveler_id` field. A GUID can be generated for each object in the `travelers` section. The same GUID can be provided in the `traveler_references` below. The `travelers` array should have at least one `traveler` object, and each `traveler` object should have a `traveler_id` which is not necessarily an account id. Example: *   Travelers * ------------ *  A - GUID1 *  B - GUID2 *  C - GUID3 * *   Products * ------------ * Air *   [GUID1, GUID2, GUID3] * Hotel *   [GUID1] * Car *   [GUID3] * Rail *   [GUID2] * Activities *   [GUID1] * The example above demonstrates the association of travelers with various products. * All three travelers (A, B, and C) are associated with the Air product. * Traveler A is associated with the Hotel and Activities products. * Traveler C is associated with the Car product. * Traveler B is associated with the Rail product.  */
@JsonProperty("travelers_references")

    
    @field:Size(min = 1, max = 40)
    
    
    @field:Valid
    override val travelersReferences: kotlin.collections.List<kotlin.String>,

    @JsonProperty("activity")

    
    
    
    
    @field:Valid
    val activity: Activity,

    @JsonProperty("operating_company")

    
    
    
    
    @field:Valid
    val operatingCompany: OperatingCompany,

    /* The field represents the start time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ. */
@JsonProperty("start_time")

    val startTime: java.time.OffsetDateTime,

    /* The field represents the end time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ. */
@JsonProperty("end_time")

    val endTime: java.time.OffsetDateTime,

    /* This field provides information about the tickets available for the activity. */
@JsonProperty("ticket")

    
    @field:Size(min = 1, max = 40)
    
    
    @field:Valid
    val ticket: kotlin.collections.List<Ticket>,

    /* A coupon is typically a document or electronic code that confirms your reservation or purchase for the activity. It serves as proof of payment and allows you to participate in the activity. This field indicates whether a coupon is necessary for this activity. | For example, let's consider two scenarios: | Activity: Adventure Park | is_coupon_required: false | In this case, the attribute is set to 'false,' indicating that no coupon is necessary. However, you might still need to purchase a ticket to gain entry to the adventure park. The ticket serves as proof of payment and grants you access to the park's activities and attractions. | Activity: Spa Package | is_coupon_required: true | Here, the attribute is set to 'true,' indicating that a coupon is required. To participate in the spa package, you would need to present the designated coupon at the spa. The coupon confirms your reservation, serves as proof of payment, and may entitle you to specific spa treatments or discounts. */
@JsonProperty("is_coupon_required")

    
    
    
    
    @field:Valid
    val isCouponRequired: kotlin.Boolean? = null,

    @JsonProperty("location_coordinates")

    
    
    
    
    @field:Valid
    val locationCoordinates: Coordinates? = null
) : TravelProduct {
    @JsonProperty("type")
override val type : TravelProductType = TravelProductType.ACTIVITIES



    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var price: Amount? = null,
        private var inventoryType: kotlin.String? = null,
        private var inventorySource: TravelProduct.InventorySource? = null,
        private var travelersReferences: kotlin.collections.List<kotlin.String>? = null,
        private var activity: Activity? = null,
        private var operatingCompany: OperatingCompany? = null,
        private var startTime: java.time.OffsetDateTime? = null,
        private var endTime: java.time.OffsetDateTime? = null,
        private var ticket: kotlin.collections.List<Ticket>? = null,
        private var isCouponRequired: kotlin.Boolean? = null,
        private var locationCoordinates: Coordinates? = null
    ) {
        fun price(price: Amount) = apply { this.price = price }
        fun inventoryType(inventoryType: kotlin.String) = apply { this.inventoryType = inventoryType }
        fun inventorySource(inventorySource: TravelProduct.InventorySource) = apply { this.inventorySource = inventorySource }
        fun travelersReferences(travelersReferences: kotlin.collections.List<kotlin.String>) = apply { this.travelersReferences = travelersReferences }
        fun activity(activity: Activity) = apply { this.activity = activity }
        fun operatingCompany(operatingCompany: OperatingCompany) = apply { this.operatingCompany = operatingCompany }
        fun startTime(startTime: java.time.OffsetDateTime) = apply { this.startTime = startTime }
        fun endTime(endTime: java.time.OffsetDateTime) = apply { this.endTime = endTime }
        fun ticket(ticket: kotlin.collections.List<Ticket>) = apply { this.ticket = ticket }
        fun isCouponRequired(isCouponRequired: kotlin.Boolean) = apply { this.isCouponRequired = isCouponRequired }
        fun locationCoordinates(locationCoordinates: Coordinates) = apply { this.locationCoordinates = locationCoordinates }

        fun build(): Activities {
            // Check required params
            validateNullity()
            return Activities(
                price = price!!,
                inventoryType = inventoryType!!,
                inventorySource = inventorySource!!,
                travelersReferences = travelersReferences!!,
                activity = activity!!,
                operatingCompany = operatingCompany!!,
                startTime = startTime!!,
                endTime = endTime!!,
                ticket = ticket!!,
                isCouponRequired = isCouponRequired,
                locationCoordinates = locationCoordinates
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
            if (travelersReferences == null) {
                throw NullPointerException("Required parameter travelersReferences is missing")
            }
            if (activity == null) {
                throw NullPointerException("Required parameter activity is missing")
            }
            if (operatingCompany == null) {
                throw NullPointerException("Required parameter operatingCompany is missing")
            }
            if (startTime == null) {
                throw NullPointerException("Required parameter startTime is missing")
            }
            if (endTime == null) {
                throw NullPointerException("Required parameter endTime is missing")
            }
            if (ticket == null) {
                throw NullPointerException("Required parameter ticket is missing")
            }
        }
    }
}

