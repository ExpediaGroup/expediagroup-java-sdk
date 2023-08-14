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

package com.expediagroup.openworld.sdk.rapid.models

import com.expediagroup.openworld.sdk.rapid.models.Amenity
import com.expediagroup.openworld.sdk.rapid.models.Amount
import com.expediagroup.openworld.sdk.rapid.models.BedGroupAvailability
import com.expediagroup.openworld.sdk.rapid.models.CancelPenalty
import com.expediagroup.openworld.sdk.rapid.models.Deposit
import com.expediagroup.openworld.sdk.rapid.models.MerchantOfRecord
import com.expediagroup.openworld.sdk.rapid.models.NonrefundableDateRange
import com.expediagroup.openworld.sdk.rapid.models.PricingInformation
import com.expediagroup.openworld.sdk.rapid.models.Promotions
import com.expediagroup.openworld.sdk.rapid.models.RateLinks
import com.expediagroup.openworld.sdk.rapid.models.SaleScenario
import com.expediagroup.openworld.sdk.rapid.models.Status

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
 * A rate.
 * @param id Unique Identifier for a rate.
 * @param status 
 * @param availableRooms The number of bookable rooms remaining with this rate in EPS inventory. Use this value to create rules for urgency messaging to alert users to low availability on busy travel dates or at popular properties. If the value returns as 2147483647 (max int value), the actual value could not be determined. Ensure your urgency messaging ignores such instances when returned.
 * @param refundable Indicates if the rate is fully refundable at the time of booking. Cancel penalties may still apply. Please refer to the cancel penalties section for reference.
 * @param memberDealAvailable Indicates if a \"Member Only Deal\" is available for this rate.
 * @param saleScenario 
 * @param merchantOfRecord 
 * @param amenities Room amenities.
 * @param links 
 * @param bedGroups A map of the room's bed groups.
 * @param cancelPenalties Array of `cancel_penalty` objects containing cancel penalty information.
 * @param nonrefundableDateRanges An array of stay date ranges within this check-in / check-out range that are not refundable. Stay dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `nonrefundable_date_range` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights are nonrefundable. The 1st night is refundable, the 2nd and 3rd nights are nonrefundable, and the 4th and 5th nights are refundable, subject to `cancel_penalties` restrictions. 
 * @param occupancyPricing A map of room information by occupancy.
 * @param promotions 
 * @param cardOnFileLimit 
 * @param refundableDamageDeposit 
 * @param deposits Array of deposits for the rate.
 */
data class Rate(
    /* Unique Identifier for a rate. */
@JsonProperty("id")

    
    
    
    
    @field:Valid
    val id: kotlin.String? = null,

    @JsonProperty("status")

    
    
    
    
    @field:Valid
    val status: Status? = null,

    /* The number of bookable rooms remaining with this rate in EPS inventory. Use this value to create rules for urgency messaging to alert users to low availability on busy travel dates or at popular properties. If the value returns as 2147483647 (max int value), the actual value could not be determined. Ensure your urgency messaging ignores such instances when returned. */
@JsonProperty("available_rooms")

    
    
    
    
    @field:Valid
    val availableRooms: java.math.BigDecimal? = null,

    /* Indicates if the rate is fully refundable at the time of booking. Cancel penalties may still apply. Please refer to the cancel penalties section for reference. */
@JsonProperty("refundable")

    
    
    
    
    @field:Valid
    val refundable: kotlin.Boolean? = null,

    /* Indicates if a \"Member Only Deal\" is available for this rate. */
@JsonProperty("member_deal_available")

    
    
    
    
    @field:Valid
    val memberDealAvailable: kotlin.Boolean? = null,

    @JsonProperty("sale_scenario")

    
    
    
    
    @field:Valid
    val saleScenario: SaleScenario? = null,

    @JsonProperty("merchant_of_record")

    
    
    
    
    @field:Valid
    val merchantOfRecord: MerchantOfRecord? = null,

    /* Room amenities. */
@JsonProperty("amenities")

    
    
    
    
    @field:Valid
    val amenities: kotlin.collections.Map<kotlin.String, Amenity>? = null,

    @JsonProperty("links")

    
    
    
    
    @field:Valid
    val links: RateLinks? = null,

    /* A map of the room's bed groups. */
@JsonProperty("bed_groups")

    
    
    
    
    @field:Valid
    val bedGroups: kotlin.collections.Map<kotlin.String, BedGroupAvailability>? = null,

    /* Array of `cancel_penalty` objects containing cancel penalty information. */
@JsonProperty("cancel_penalties")

    
    
    
    
    @field:Valid
    val cancelPenalties: kotlin.collections.List<CancelPenalty>? = null,

    /* An array of stay date ranges within this check-in / check-out range that are not refundable. Stay dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `nonrefundable_date_range` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights are nonrefundable. The 1st night is refundable, the 2nd and 3rd nights are nonrefundable, and the 4th and 5th nights are refundable, subject to `cancel_penalties` restrictions.  */
@JsonProperty("nonrefundable_date_ranges")

    
    
    
    
    @field:Valid
    val nonrefundableDateRanges: kotlin.collections.List<NonrefundableDateRange>? = null,

    /* A map of room information by occupancy. */
@JsonProperty("occupancy_pricing")

    
    
    
    
    @field:Valid
    val occupancyPricing: kotlin.collections.Map<kotlin.String, PricingInformation>? = null,

    @JsonProperty("promotions")

    
    
    
    
    @field:Valid
    val promotions: Promotions? = null,

    @JsonProperty("card_on_file_limit")

    
    
    
    
    @field:Valid
    val cardOnFileLimit: Amount? = null,

    @JsonProperty("refundable_damage_deposit")

    
    
    
    
    @field:Valid
    val refundableDamageDeposit: Amount? = null,

    /* Array of deposits for the rate. */
@JsonProperty("deposits")

    
    
    
    
    @field:Valid
    val deposits: kotlin.collections.List<Deposit>? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var status: Status? = null,
        private var availableRooms: java.math.BigDecimal? = null,
        private var refundable: kotlin.Boolean? = null,
        private var memberDealAvailable: kotlin.Boolean? = null,
        private var saleScenario: SaleScenario? = null,
        private var merchantOfRecord: MerchantOfRecord? = null,
        private var amenities: kotlin.collections.Map<kotlin.String, Amenity>? = null,
        private var links: RateLinks? = null,
        private var bedGroups: kotlin.collections.Map<kotlin.String, BedGroupAvailability>? = null,
        private var cancelPenalties: kotlin.collections.List<CancelPenalty>? = null,
        private var nonrefundableDateRanges: kotlin.collections.List<NonrefundableDateRange>? = null,
        private var occupancyPricing: kotlin.collections.Map<kotlin.String, PricingInformation>? = null,
        private var promotions: Promotions? = null,
        private var cardOnFileLimit: Amount? = null,
        private var refundableDamageDeposit: Amount? = null,
        private var deposits: kotlin.collections.List<Deposit>? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }
        fun status(status: Status) = apply { this.status = status }
        fun availableRooms(availableRooms: java.math.BigDecimal) = apply { this.availableRooms = availableRooms }
        fun refundable(refundable: kotlin.Boolean) = apply { this.refundable = refundable }
        fun memberDealAvailable(memberDealAvailable: kotlin.Boolean) = apply { this.memberDealAvailable = memberDealAvailable }
        fun saleScenario(saleScenario: SaleScenario) = apply { this.saleScenario = saleScenario }
        fun merchantOfRecord(merchantOfRecord: MerchantOfRecord) = apply { this.merchantOfRecord = merchantOfRecord }
        fun amenities(amenities: kotlin.collections.Map<kotlin.String, Amenity>) = apply { this.amenities = amenities }
        fun links(links: RateLinks) = apply { this.links = links }
        fun bedGroups(bedGroups: kotlin.collections.Map<kotlin.String, BedGroupAvailability>) = apply { this.bedGroups = bedGroups }
        fun cancelPenalties(cancelPenalties: kotlin.collections.List<CancelPenalty>) = apply { this.cancelPenalties = cancelPenalties }
        fun nonrefundableDateRanges(nonrefundableDateRanges: kotlin.collections.List<NonrefundableDateRange>) = apply { this.nonrefundableDateRanges = nonrefundableDateRanges }
        fun occupancyPricing(occupancyPricing: kotlin.collections.Map<kotlin.String, PricingInformation>) = apply { this.occupancyPricing = occupancyPricing }
        fun promotions(promotions: Promotions) = apply { this.promotions = promotions }
        fun cardOnFileLimit(cardOnFileLimit: Amount) = apply { this.cardOnFileLimit = cardOnFileLimit }
        fun refundableDamageDeposit(refundableDamageDeposit: Amount) = apply { this.refundableDamageDeposit = refundableDamageDeposit }
        fun deposits(deposits: kotlin.collections.List<Deposit>) = apply { this.deposits = deposits }

        fun build(): Rate {
            return Rate(
                id = id,
                status = status,
                availableRooms = availableRooms,
                refundable = refundable,
                memberDealAvailable = memberDealAvailable,
                saleScenario = saleScenario,
                merchantOfRecord = merchantOfRecord,
                amenities = amenities,
                links = links,
                bedGroups = bedGroups,
                cancelPenalties = cancelPenalties,
                nonrefundableDateRanges = nonrefundableDateRanges,
                occupancyPricing = occupancyPricing,
                promotions = promotions,
                cardOnFileLimit = cardOnFileLimit,
                refundableDamageDeposit = refundableDamageDeposit,
                deposits = deposits
            )
        }

    }
}

