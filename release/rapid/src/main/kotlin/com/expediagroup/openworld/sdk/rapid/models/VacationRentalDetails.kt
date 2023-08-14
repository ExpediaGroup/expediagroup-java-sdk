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
import com.expediagroup.openworld.sdk.rapid.models.EnhancedHouseRules
import com.expediagroup.openworld.sdk.rapid.models.PropertyManager
import com.expediagroup.openworld.sdk.rapid.models.RentalAgreement
import com.expediagroup.openworld.sdk.rapid.models.UnitConfiguration

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
 * Details for vacation rental properties.
 * @param registryNumber The property's registry number required by some jurisdictions.
 * @param privateHost Indicates if a property has a private host.
 * @param propertyManager 
 * @param rentalAgreement 
 * @param houseRules List of strings detailing house rules.
 * @param enhancedHouseRules Map of enhanced house rules.
 * @param amenities 
 * @param vrboSrpId The Vrbo srp needed for link-off.
 * @param listingId The listing id for a Vrbo property.
 * @param listingNumber The listing number for a Vrbo property.
 * @param listingSource The listing source.
 * @param listingUnit The specific unit.
 * @param unitConfigurations Map of the vacation rental unit configurations. The key value is the unit location.
 * @param freeText A free text description that could contain significantly unstructured information that could impact the booking and should be displayed to customers. This field could contain html break tags `<br>` that may make display challenging.
 */
data class VacationRentalDetails(
    /* The property's registry number required by some jurisdictions. */
@JsonProperty("registry_number")

    
    
    
    
    @field:Valid
    val registryNumber: kotlin.String? = null,

    /* Indicates if a property has a private host. */
@JsonProperty("private_host")

    
    
    
    
    @field:Valid
    val privateHost: kotlin.Boolean? = null,

    @JsonProperty("property_manager")

    
    
    
    
    @field:Valid
    val propertyManager: PropertyManager? = null,

    @JsonProperty("rental_agreement")

    
    
    
    
    @field:Valid
    val rentalAgreement: RentalAgreement? = null,

    /* List of strings detailing house rules. */
@JsonProperty("house_rules")

    
    
    
    
    @field:Valid
    val houseRules: kotlin.collections.List<kotlin.String>? = null,

    /* Map of enhanced house rules. */
@JsonProperty("enhanced_house_rules")

    
    
    
    
    @field:Valid
    val enhancedHouseRules: kotlin.collections.Map<kotlin.String, EnhancedHouseRules>? = null,

    @JsonProperty("amenities")

    
    
    
    
    @field:Valid
    val amenities: Amenity? = null,

    /* The Vrbo srp needed for link-off. */
@JsonProperty("vrbo_srp_id")

    
    
    
    
    @field:Valid
    val vrboSrpId: kotlin.String? = null,

    /* The listing id for a Vrbo property. */
@JsonProperty("listing_id")

    
    
    
    
    @field:Valid
    val listingId: kotlin.String? = null,

    /* The listing number for a Vrbo property. */
@JsonProperty("listing_number")

    
    
    
    
    @field:Valid
    val listingNumber: kotlin.String? = null,

    /* The listing source. */
@JsonProperty("listing_source")

    
    
    
    
    @field:Valid
    val listingSource: kotlin.String? = null,

    /* The specific unit. */
@JsonProperty("listing_unit")

    
    
    
    
    @field:Valid
    val listingUnit: kotlin.String? = null,

    /* Map of the vacation rental unit configurations. The key value is the unit location. */
@JsonProperty("unit_configurations")

    
    
    
    
    @field:Valid
    val unitConfigurations: kotlin.collections.Map<kotlin.String, kotlin.collections.List<UnitConfiguration>>? = null,

    /* A free text description that could contain significantly unstructured information that could impact the booking and should be displayed to customers. This field could contain html break tags `<br>` that may make display challenging. */
@JsonProperty("free_text")

    
    
    
    
    @field:Valid
    val freeText: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var registryNumber: kotlin.String? = null,
        private var privateHost: kotlin.Boolean? = null,
        private var propertyManager: PropertyManager? = null,
        private var rentalAgreement: RentalAgreement? = null,
        private var houseRules: kotlin.collections.List<kotlin.String>? = null,
        private var enhancedHouseRules: kotlin.collections.Map<kotlin.String, EnhancedHouseRules>? = null,
        private var amenities: Amenity? = null,
        private var vrboSrpId: kotlin.String? = null,
        private var listingId: kotlin.String? = null,
        private var listingNumber: kotlin.String? = null,
        private var listingSource: kotlin.String? = null,
        private var listingUnit: kotlin.String? = null,
        private var unitConfigurations: kotlin.collections.Map<kotlin.String, kotlin.collections.List<UnitConfiguration>>? = null,
        private var freeText: kotlin.String? = null
    ) {
        fun registryNumber(registryNumber: kotlin.String) = apply { this.registryNumber = registryNumber }
        fun privateHost(privateHost: kotlin.Boolean) = apply { this.privateHost = privateHost }
        fun propertyManager(propertyManager: PropertyManager) = apply { this.propertyManager = propertyManager }
        fun rentalAgreement(rentalAgreement: RentalAgreement) = apply { this.rentalAgreement = rentalAgreement }
        fun houseRules(houseRules: kotlin.collections.List<kotlin.String>) = apply { this.houseRules = houseRules }
        fun enhancedHouseRules(enhancedHouseRules: kotlin.collections.Map<kotlin.String, EnhancedHouseRules>) = apply { this.enhancedHouseRules = enhancedHouseRules }
        fun amenities(amenities: Amenity) = apply { this.amenities = amenities }
        fun vrboSrpId(vrboSrpId: kotlin.String) = apply { this.vrboSrpId = vrboSrpId }
        fun listingId(listingId: kotlin.String) = apply { this.listingId = listingId }
        fun listingNumber(listingNumber: kotlin.String) = apply { this.listingNumber = listingNumber }
        fun listingSource(listingSource: kotlin.String) = apply { this.listingSource = listingSource }
        fun listingUnit(listingUnit: kotlin.String) = apply { this.listingUnit = listingUnit }
        fun unitConfigurations(unitConfigurations: kotlin.collections.Map<kotlin.String, kotlin.collections.List<UnitConfiguration>>) = apply { this.unitConfigurations = unitConfigurations }
        fun freeText(freeText: kotlin.String) = apply { this.freeText = freeText }

        fun build(): VacationRentalDetails {
            return VacationRentalDetails(
                registryNumber = registryNumber,
                privateHost = privateHost,
                propertyManager = propertyManager,
                rentalAgreement = rentalAgreement,
                houseRules = houseRules,
                enhancedHouseRules = enhancedHouseRules,
                amenities = amenities,
                vrboSrpId = vrboSrpId,
                listingId = listingId,
                listingNumber = listingNumber,
                listingSource = listingSource,
                listingUnit = listingUnit,
                unitConfigurations = unitConfigurations,
                freeText = freeText
            )
        }

    }
}

