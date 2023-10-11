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
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

/**
 *
 * @param addressType
 * @param addressLine1 Address line 1 of the address provided.
 * @param addressLine2 Address line 2 of the address provided.
 * @param city City of the address provided.
 * @param state The two-characters ISO code for the state or province of the address.
 * @param zipCode Zip code of the address provided.
 * @param countryCode ISO alpha-3 country code of the address provided.
 */
data class Address(
    @JsonProperty("address_type")
    val addressType: Address.AddressType? = null,

    /* Address line 1 of the address provided. */
    @JsonProperty("address_line1")
    @field:Length(max = 200)
    @field:Valid
    val addressLine1: kotlin.String? = null,

    /* Address line 2 of the address provided. */
    @JsonProperty("address_line2")
    @field:Length(max = 200)
    @field:Valid
    val addressLine2: kotlin.String? = null,

    /* City of the address provided. */
    @JsonProperty("city")
    @field:Length(max = 200)
    @field:Valid
    val city: kotlin.String? = null,

    /* The two-characters ISO code for the state or province of the address. */
    @JsonProperty("state")
    @field:Pattern(regexp = "^[A-Z]{2}$")
    @field:Valid
    val state: kotlin.String? = null,

    /* Zip code of the address provided. */
    @JsonProperty("zip_code")
    @field:Length(max = 20)
    @field:Valid
    val zipCode: kotlin.String? = null,

    /* ISO alpha-3 country code of the address provided. */
    @JsonProperty("country_code")
    @field:Pattern(regexp = "^[A-Z]{3}$")
    @field:Valid
    val countryCode: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var addressType: Address.AddressType? = null,
        private var addressLine1: kotlin.String? = null,
        private var addressLine2: kotlin.String? = null,
        private var city: kotlin.String? = null,
        private var state: kotlin.String? = null,
        private var zipCode: kotlin.String? = null,
        private var countryCode: kotlin.String? = null
    ) {
        fun addressType(addressType: Address.AddressType) = apply { this.addressType = addressType }
        fun addressLine1(addressLine1: kotlin.String) = apply { this.addressLine1 = addressLine1 }
        fun addressLine2(addressLine2: kotlin.String) = apply { this.addressLine2 = addressLine2 }
        fun city(city: kotlin.String) = apply { this.city = city }
        fun state(state: kotlin.String) = apply { this.state = state }
        fun zipCode(zipCode: kotlin.String) = apply { this.zipCode = zipCode }
        fun countryCode(countryCode: kotlin.String) = apply { this.countryCode = countryCode }

        fun build(): Address {
            return Address(
                addressType = addressType,
                addressLine1 = addressLine1,
                addressLine2 = addressLine2,
                city = city,
                state = state,
                zipCode = zipCode,
                countryCode = countryCode
            )
        }
    }

    /**
     *
     * Values: HOME,WORK
     */
    enum class AddressType(val value: kotlin.String) {
        @JsonProperty("HOME")
        HOME("HOME"),

        @JsonProperty("WORK")
        WORK("WORK")
    }
}
