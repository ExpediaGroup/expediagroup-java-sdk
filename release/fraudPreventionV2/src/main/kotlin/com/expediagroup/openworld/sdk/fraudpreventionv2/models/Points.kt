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

 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.expediagroup.openworld.sdk.fraudpreventionv2.models

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Amount
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Name
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Operations
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Payment
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentBillingAddress
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentMethod
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentReason
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentThreeDSCriteria

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 */
data class Points(
    /* The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  */
@JsonProperty("brand")

    override val brand: Payment.Brand,


    @JsonProperty("billing_name")

    
    
    
    
    @field:Valid
    override val billingName: Name,

    @JsonProperty("billing_address")

    
    
    
    
    @field:Valid
    override val billingAddress: PaymentBillingAddress,

    /* Email address associated with the payment. */
@JsonProperty("billing_email_address")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    override val billingEmailAddress: kotlin.String,

    @JsonProperty("reason")

    
    
    
    
    @field:Valid
    override val reason: PaymentReason? = null,

    @JsonProperty("authorized_amount")

    
    
    
    
    @field:Valid
    override val authorizedAmount: Amount? = null,

    @JsonProperty("verified_amount")

    
    
    
    
    @field:Valid
    override val verifiedAmount: Amount? = null,

    @JsonProperty("three_digits_secure_criteria")

    
    
    
    
    @field:Valid
    override val threeDigitsSecureCriteria: PaymentThreeDSCriteria? = null,

    @JsonProperty("operations")

    
    
    
    
    @field:Valid
    override val operations: Operations? = null
) : Payment {
    @JsonProperty("method")
override val method : PaymentMethod = PaymentMethod.POINTS



    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var brand: Payment.Brand? = null,
        private var billingName: Name? = null,
        private var billingAddress: PaymentBillingAddress? = null,
        private var billingEmailAddress: kotlin.String? = null,
        private var reason: PaymentReason? = null,
        private var authorizedAmount: Amount? = null,
        private var verifiedAmount: Amount? = null,
        private var threeDigitsSecureCriteria: PaymentThreeDSCriteria? = null,
        private var operations: Operations? = null
    ) {
        fun brand(brand: Payment.Brand) = apply { this.brand = brand }
        fun billingName(billingName: Name) = apply { this.billingName = billingName }
        fun billingAddress(billingAddress: PaymentBillingAddress) = apply { this.billingAddress = billingAddress }
        fun billingEmailAddress(billingEmailAddress: kotlin.String) = apply { this.billingEmailAddress = billingEmailAddress }
        fun reason(reason: PaymentReason) = apply { this.reason = reason }
        fun authorizedAmount(authorizedAmount: Amount) = apply { this.authorizedAmount = authorizedAmount }
        fun verifiedAmount(verifiedAmount: Amount) = apply { this.verifiedAmount = verifiedAmount }
        fun threeDigitsSecureCriteria(threeDigitsSecureCriteria: PaymentThreeDSCriteria) = apply { this.threeDigitsSecureCriteria = threeDigitsSecureCriteria }
        fun operations(operations: Operations) = apply { this.operations = operations }

        fun build(): Points {
            // Check required params
            validateNullity()
            return Points(
                brand = brand!!,
                billingName = billingName!!,
                billingAddress = billingAddress!!,
                billingEmailAddress = billingEmailAddress!!,
                reason = reason,
                authorizedAmount = authorizedAmount,
                verifiedAmount = verifiedAmount,
                threeDigitsSecureCriteria = threeDigitsSecureCriteria,
                operations = operations
            )
        }

        private fun validateNullity() {
            if (brand == null) {
                throw NullPointerException("Required parameter brand is missing")
            }
            if (billingName == null) {
                throw NullPointerException("Required parameter billingName is missing")
            }
            if (billingAddress == null) {
                throw NullPointerException("Required parameter billingAddress is missing")
            }
            if (billingEmailAddress == null) {
                throw NullPointerException("Required parameter billingEmailAddress is missing")
            }
        }
    }
}

