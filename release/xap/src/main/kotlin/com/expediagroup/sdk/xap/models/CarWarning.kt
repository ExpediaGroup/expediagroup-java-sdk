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

import com.expediagroup.sdk.xap.models.CarLink
import com.expediagroup.sdk.xap.models.CarMoney
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * Container for warning codes
 * @param code Standardized warning code.
 * @param description Standardized warning description message.
 * @param originalPrice
 * @param newPrice
 * @param changedAmount
 * @param changedPercentage The changed percentage. In the sample 2.97 means the changed percentage is 2.97%.
 * @param links
 */
data class CarWarning(
    // Standardized warning code.
    @JsonProperty("Code")
    @field:Valid
    val code: kotlin.String,
    // Standardized warning description message.
    @JsonProperty("Description")
    @field:Valid
    val description: kotlin.String,
    @JsonProperty("OriginalPrice")
    @field:Valid
    val originalPrice: CarMoney? = null,
    @JsonProperty("NewPrice")
    @field:Valid
    val newPrice: CarMoney? = null,
    @JsonProperty("ChangedAmount")
    @field:Valid
    val changedAmount: CarMoney? = null,
    // The changed percentage. In the sample 2.97 means the changed percentage is 2.97%.
    @JsonProperty("ChangedPercentage")
    @field:Valid
    val changedPercentage: kotlin.String? = null,
    @JsonProperty("Links")
    @field:Valid
    val links: kotlin.collections.Map<kotlin.String, CarLink>? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var code: kotlin.String? = null,
        private var description: kotlin.String? = null,
        private var originalPrice: CarMoney? = null,
        private var newPrice: CarMoney? = null,
        private var changedAmount: CarMoney? = null,
        private var changedPercentage: kotlin.String? = null,
        private var links: kotlin.collections.Map<kotlin.String, CarLink>? = null
    ) {
        fun code(code: kotlin.String) = apply { this.code = code }

        fun description(description: kotlin.String) = apply { this.description = description }

        fun originalPrice(originalPrice: CarMoney?) = apply { this.originalPrice = originalPrice }

        fun newPrice(newPrice: CarMoney?) = apply { this.newPrice = newPrice }

        fun changedAmount(changedAmount: CarMoney?) = apply { this.changedAmount = changedAmount }

        fun changedPercentage(changedPercentage: kotlin.String?) = apply { this.changedPercentage = changedPercentage }

        fun links(links: kotlin.collections.Map<kotlin.String, CarLink>?) = apply { this.links = links }

        fun build(): CarWarning {
            // Check required params
            validateNullity()
            return CarWarning(
                code = code!!,
                description = description!!,
                originalPrice = originalPrice,
                newPrice = newPrice,
                changedAmount = changedAmount,
                changedPercentage = changedPercentage,
                links = links
            )
        }

        private fun validateNullity() {
            if (code == null) {
                throw NullPointerException("Required parameter code is missing")
            }
            if (description == null) {
                throw NullPointerException("Required parameter description is missing")
            }
        }
    }

    fun toBuilder() =
        Builder(
            code = code!!,
            description = description!!,
            originalPrice = originalPrice,
            newPrice = newPrice,
            changedAmount = changedAmount,
            changedPercentage = changedPercentage,
            links = links
        )
}
