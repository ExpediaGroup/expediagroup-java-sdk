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

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 *
 * @param stayDate A single night during the requested stay.
 * @param baseRate Container for nightly base rate.
 */
data class RatePlanPriceNightlyRatesInner(
    // A single night during the requested stay.
    @JsonProperty("StayDate")
    @field:Valid
    val stayDate: kotlin.Any,
    // Container for nightly base rate.
    @JsonProperty("BaseRate")
    @field:Valid
    val baseRate: kotlin.Any
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var stayDate: kotlin.Any? = null,
        private var baseRate: kotlin.Any? = null
    ) {
        fun stayDate(stayDate: kotlin.Any) = apply { this.stayDate = stayDate }

        fun baseRate(baseRate: kotlin.Any) = apply { this.baseRate = baseRate }

        fun build(): RatePlanPriceNightlyRatesInner {
            // Check required params
            validateNullity()
            return RatePlanPriceNightlyRatesInner(
                stayDate = stayDate!!,
                baseRate = baseRate!!
            )
        }

        private fun validateNullity() {
            if (stayDate == null) {
                throw NullPointerException("Required parameter stayDate is missing")
            }
            if (baseRate == null) {
                throw NullPointerException("Required parameter baseRate is missing")
            }
        }
    }
}
