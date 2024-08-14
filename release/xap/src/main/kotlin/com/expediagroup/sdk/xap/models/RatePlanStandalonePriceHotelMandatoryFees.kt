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
/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.expediagroup.sdk.xap.models

import com.expediagroup.sdk.xap.models.Money
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * The total standalone mandatory fees.
 * @param `value` The value of the element being defined.
 * @param currency The ISO 4217 Currency Code that the value is expressed in.
 * @param localCurrencyPrice
 */
data class RatePlanStandalonePriceHotelMandatoryFees(
    // The value of the element being defined.
    @JsonProperty("Value")
    @field:Valid
    val `value`: kotlin.String? = null,
    // The ISO 4217 Currency Code that the value is expressed in.
    @JsonProperty("Currency")
    @field:Valid
    val currency: kotlin.String? = null,
    @JsonProperty("LocalCurrencyPrice")
    @field:Valid
    val localCurrencyPrice: Money? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var `value`: kotlin.String? = null,
        private var currency: kotlin.String? = null,
        private var localCurrencyPrice: Money? = null
    ) {
        fun `value`(`value`: kotlin.String?) = apply { this.`value` = `value` }

        fun currency(currency: kotlin.String?) = apply { this.currency = currency }

        fun localCurrencyPrice(localCurrencyPrice: Money?) = apply { this.localCurrencyPrice = localCurrencyPrice }

        fun build(): RatePlanStandalonePriceHotelMandatoryFees {
            return RatePlanStandalonePriceHotelMandatoryFees(
                `value` = `value`,
                currency = currency,
                localCurrencyPrice = localCurrencyPrice
            )
        }
    }
}
