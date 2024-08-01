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
 *
 * @param `value` The total price of the corresponding date.
 * @param currency The ISO 4217 Currency Code that the Value is expressed in.  See [Global Currency Codes](https://developers.expediagroup.com/xap/products/xap/lodging/references/global-currency-codes) for a full list of supported currencies.
 * @param localCurrencyPrice
 */
data class RateCalendarPrice(
    // The total price of the corresponding date.
    @JsonProperty("Value")
    @field:Valid
    val `value`: kotlin.Any,
    // The ISO 4217 Currency Code that the Value is expressed in.  See [Global Currency Codes](https://developers.expediagroup.com/xap/products/xap/lodging/references/global-currency-codes) for a full list of supported currencies.
    @JsonProperty("Currency")
    @field:Valid
    val currency: kotlin.Any,
    @JsonProperty("LocalCurrencyPrice")
    @field:Valid
    val localCurrencyPrice: Money? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var `value`: kotlin.Any? = null,
        private var currency: kotlin.Any? = null,
        private var localCurrencyPrice: Money? = null
    ) {
        fun `value`(`value`: kotlin.Any) = apply { this.`value` = `value` }

        fun currency(currency: kotlin.Any) = apply { this.currency = currency }

        fun localCurrencyPrice(localCurrencyPrice: Money?) = apply { this.localCurrencyPrice = localCurrencyPrice }

        fun build(): RateCalendarPrice {
            // Check required params
            validateNullity()
            return RateCalendarPrice(
                `value` = `value`!!,
                currency = currency!!,
                localCurrencyPrice = localCurrencyPrice
            )
        }

        private fun validateNullity() {
            if (`value` == null) {
                throw NullPointerException("Required parameter `value` is missing")
            }
            if (currency == null) {
                throw NullPointerException("Required parameter currency is missing")
            }
        }
    }
}
