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

package com.expediagroup.sdk.fraudpreventionv2.models

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
import javax.validation.constraints.Size
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param accountNumber Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument.
 * @param telephones Telephone(s) associated with direct debit payment provider.
 * @param routingNumber A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`.
 * @param mandateType The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
 */
data class DirectDebit(
    // The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV`
    @JsonProperty("brand")
    override val brand: Payment.Brand,
    @JsonProperty("billing_name")
    @field:Valid
    override val billingName: Name,
    @JsonProperty("billing_address")
    @field:Valid
    override val billingAddress: PaymentBillingAddress,
    // Email address associated with the payment.
    @JsonProperty("billing_email_address")
    @field:Length(max = 200)
    @field:Valid
    override val billingEmailAddress: kotlin.String,
    // Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument.
    @JsonProperty("account_number")
    @field:Length(max = 100)
    @field:Valid
    val accountNumber: kotlin.String,
    // Telephone(s) associated with direct debit payment provider.
    @JsonProperty("telephones")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>,
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
    override val operations: Operations? = null,
    // A key-value pair map to hold additional attributes.
    @JsonProperty("extensions")
    @field:Valid
    override val extensions: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,
    // A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`.
    @JsonProperty("routing_number")
    @field:Length(max = 15)
    @field:Valid
    val routingNumber: kotlin.String? = null,
    // The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
    @JsonProperty("mandate_type")
    val mandateType: DirectDebit.MandateType? = null
) : Payment {
    @JsonProperty("method")
    override val method: PaymentMethod = PaymentMethod.DIRECT_DEBIT

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var brand: Payment.Brand? = null,
        private var billingName: Name? = null,
        private var billingAddress: PaymentBillingAddress? = null,
        private var billingEmailAddress: kotlin.String? = null,
        private var accountNumber: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var reason: PaymentReason? = null,
        private var authorizedAmount: Amount? = null,
        private var verifiedAmount: Amount? = null,
        private var threeDigitsSecureCriteria: PaymentThreeDSCriteria? = null,
        private var operations: Operations? = null,
        private var extensions: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,
        private var routingNumber: kotlin.String? = null,
        private var mandateType: DirectDebit.MandateType? = null
    ) {
        fun brand(brand: Payment.Brand) = apply { this.brand = brand }

        fun billingName(billingName: Name) = apply { this.billingName = billingName }

        fun billingAddress(billingAddress: PaymentBillingAddress) = apply { this.billingAddress = billingAddress }

        fun billingEmailAddress(billingEmailAddress: kotlin.String) = apply { this.billingEmailAddress = billingEmailAddress }

        fun accountNumber(accountNumber: kotlin.String) = apply { this.accountNumber = accountNumber }

        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }

        fun reason(reason: PaymentReason) = apply { this.reason = reason }

        fun authorizedAmount(authorizedAmount: Amount) = apply { this.authorizedAmount = authorizedAmount }

        fun verifiedAmount(verifiedAmount: Amount) = apply { this.verifiedAmount = verifiedAmount }

        fun threeDigitsSecureCriteria(threeDigitsSecureCriteria: PaymentThreeDSCriteria) = apply { this.threeDigitsSecureCriteria = threeDigitsSecureCriteria }

        fun operations(operations: Operations) = apply { this.operations = operations }

        fun extensions(extensions: kotlin.collections.Map<kotlin.String, kotlin.String>) = apply { this.extensions = extensions }

        fun routingNumber(routingNumber: kotlin.String) = apply { this.routingNumber = routingNumber }

        fun mandateType(mandateType: DirectDebit.MandateType) = apply { this.mandateType = mandateType }

        fun build(): DirectDebit {
            // Check required params
            validateNullity()
            return DirectDebit(
                brand = brand!!,
                billingName = billingName!!,
                billingAddress = billingAddress!!,
                billingEmailAddress = billingEmailAddress!!,
                accountNumber = accountNumber!!,
                telephones = telephones!!,
                reason = reason,
                authorizedAmount = authorizedAmount,
                verifiedAmount = verifiedAmount,
                threeDigitsSecureCriteria = threeDigitsSecureCriteria,
                operations = operations,
                extensions = extensions,
                routingNumber = routingNumber,
                mandateType = mandateType
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
            if (accountNumber == null) {
                throw NullPointerException("Required parameter accountNumber is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }

    /**
     * The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
     * Values: ONE_OFF,RECURRING
     */
    enum class MandateType(val value: kotlin.String) {
        @JsonProperty("ONE_OFF")
        ONE_OFF("ONE_OFF"),

        @JsonProperty("RECURRING")
        RECURRING("RECURRING")
    }
}
