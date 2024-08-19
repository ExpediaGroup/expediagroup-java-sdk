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
 * Container for hotel supported payment information.
 * @param paymentMethod The payment method.
 * @param name The brand name of the payment sub-method to be displayed to the customer.
 * @param paymentSubMethod The payment sub-method.
 * @param brandName The brand name of the payment sub-method to be displayed to the customer.  In many cases it will be the same as the payment sub-method, but \"Visa/Carte Blanche\" and \"Visa/Delta\" are some of the exceptions.
 */
data class ValidFormsOfPayment(
    // The payment method.
    @JsonProperty("PaymentMethod")
    @field:Valid
    val paymentMethod: kotlin.String? = null,
    // The brand name of the payment sub-method to be displayed to the customer.
    @JsonProperty("Name")
    @field:Valid
    val name: kotlin.String? = null,
    // The payment sub-method.
    @Deprecated(message = "This property is deprecated.")
    @JsonProperty("PaymentSubMethod")
    @field:Valid
    val paymentSubMethod: kotlin.String? = null,
    // The brand name of the payment sub-method to be displayed to the customer.  In many cases it will be the same as the payment sub-method, but \"Visa/Carte Blanche\" and \"Visa/Delta\" are some of the exceptions.
    @Deprecated(message = "This property is deprecated.")
    @JsonProperty("BrandName")
    @field:Valid
    val brandName: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var paymentMethod: kotlin.String? = null,
        private var name: kotlin.String? = null,
        private var paymentSubMethod: kotlin.String? = null,
        private var brandName: kotlin.String? = null
    ) {
        fun paymentMethod(paymentMethod: kotlin.String?) = apply { this.paymentMethod = paymentMethod }

        fun name(name: kotlin.String?) = apply { this.name = name }

        fun paymentSubMethod(paymentSubMethod: kotlin.String?) = apply { this.paymentSubMethod = paymentSubMethod }

        fun brandName(brandName: kotlin.String?) = apply { this.brandName = brandName }

        fun build(): ValidFormsOfPayment {
            return ValidFormsOfPayment(
                paymentMethod = paymentMethod,
                name = name,
                paymentSubMethod = paymentSubMethod,
                brandName = brandName
            )
        }
    }
}
