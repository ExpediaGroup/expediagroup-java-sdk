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
 * @param cardType The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON`
 * @param cardNumber All the digits (unencrypted) of the credit card number associated with the payment.
 * @param expiryDate Expiration date of the credit card used for payment, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param telephones Telephone(s) associated with card holder and credit card.
 * @param electronicCommerceIndicator Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder's payment credentials.
 * @param virtualCreditCardFlag A flag to indicate that the bank card being used for the charge is a virtual credit card.
 * @param walletType If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible `wallet_type`'s include: `Google` or `ApplePay`.
 * @param cardAvsResponse A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card.
 * @param cardCvvResponse A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase.
 * @param merchantOrderCode Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
 * @param cardAuthenticationFailureCount Total authentication failure count for given card.
 */
data class CreditCardAllOf(
    // The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON`
    @JsonProperty("card_type")
    val cardType: CreditCardAllOf.CardType,
    // All the digits (unencrypted) of the credit card number associated with the payment.
    @JsonProperty("card_number")
    @field:Length(max = 200)
    @field:Valid
    val cardNumber: kotlin.String,
    // Expiration date of the credit card used for payment, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("expiry_date")
    val expiryDate: java.time.OffsetDateTime,
    // Telephone(s) associated with card holder and credit card.
    @JsonProperty("telephones")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>,
    // Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder's payment credentials.
    @JsonProperty("electronic_commerce_indicator")
    @field:Length(max = 200)
    @field:Valid
    val electronicCommerceIndicator: kotlin.String? = null,
    // A flag to indicate that the bank card being used for the charge is a virtual credit card.
    @JsonProperty("virtual_credit_card_flag")
    @field:Valid
    val virtualCreditCardFlag: kotlin.Boolean? = null,
    // If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible `wallet_type`'s include: `Google` or `ApplePay`.
    @JsonProperty("wallet_type")
    @field:Length(max = 200)
    @field:Valid
    val walletType: kotlin.String? = null,
    // A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card.
    @JsonProperty("card_avs_response")
    @field:Length(max = 50)
    @field:Valid
    val cardAvsResponse: kotlin.String? = null,
    // A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase.
    @JsonProperty("card_cvv_response")
    @field:Length(max = 20)
    @field:Valid
    val cardCvvResponse: kotlin.String? = null,
    // Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
    @JsonProperty("merchant_order_code")
    @field:Length(max = 200)
    @field:Valid
    val merchantOrderCode: kotlin.String? = null,
    // Total authentication failure count for given card.
    @JsonProperty("card_authentication_failure_count")
    @field:Valid
    val cardAuthenticationFailureCount: kotlin.Int? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var cardType: CreditCardAllOf.CardType? = null,
        private var cardNumber: kotlin.String? = null,
        private var expiryDate: java.time.OffsetDateTime? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var electronicCommerceIndicator: kotlin.String? = null,
        private var virtualCreditCardFlag: kotlin.Boolean? = null,
        private var walletType: kotlin.String? = null,
        private var cardAvsResponse: kotlin.String? = null,
        private var cardCvvResponse: kotlin.String? = null,
        private var merchantOrderCode: kotlin.String? = null,
        private var cardAuthenticationFailureCount: kotlin.Int? = null
    ) {
        fun cardType(cardType: CreditCardAllOf.CardType) = apply { this.cardType = cardType }

        fun cardNumber(cardNumber: kotlin.String) = apply { this.cardNumber = cardNumber }

        fun expiryDate(expiryDate: java.time.OffsetDateTime) = apply { this.expiryDate = expiryDate }

        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }

        fun electronicCommerceIndicator(electronicCommerceIndicator: kotlin.String) = apply { this.electronicCommerceIndicator = electronicCommerceIndicator }

        fun virtualCreditCardFlag(virtualCreditCardFlag: kotlin.Boolean) = apply { this.virtualCreditCardFlag = virtualCreditCardFlag }

        fun walletType(walletType: kotlin.String) = apply { this.walletType = walletType }

        fun cardAvsResponse(cardAvsResponse: kotlin.String) = apply { this.cardAvsResponse = cardAvsResponse }

        fun cardCvvResponse(cardCvvResponse: kotlin.String) = apply { this.cardCvvResponse = cardCvvResponse }

        fun merchantOrderCode(merchantOrderCode: kotlin.String) = apply { this.merchantOrderCode = merchantOrderCode }

        fun cardAuthenticationFailureCount(cardAuthenticationFailureCount: kotlin.Int) = apply { this.cardAuthenticationFailureCount = cardAuthenticationFailureCount }

        fun build(): CreditCardAllOf {
            // Check required params
            validateNullity()
            return CreditCardAllOf(
                cardType = cardType!!,
                cardNumber = cardNumber!!,
                expiryDate = expiryDate!!,
                telephones = telephones!!,
                electronicCommerceIndicator = electronicCommerceIndicator,
                virtualCreditCardFlag = virtualCreditCardFlag,
                walletType = walletType,
                cardAvsResponse = cardAvsResponse,
                cardCvvResponse = cardCvvResponse,
                merchantOrderCode = merchantOrderCode,
                cardAuthenticationFailureCount = cardAuthenticationFailureCount
            )
        }

        private fun validateNullity() {
            if (cardType == null) {
                throw NullPointerException("Required parameter cardType is missing")
            }
            if (cardNumber == null) {
                throw NullPointerException("Required parameter cardNumber is missing")
            }
            if (expiryDate == null) {
                throw NullPointerException("Required parameter expiryDate is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }

    /**
     * The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON`
     * Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,UATP,VISA
     */
    enum class CardType(val value: kotlin.String) {
        @JsonProperty("AMERICAN_EXPRESS")
        AMERICAN_EXPRESS("AMERICAN_EXPRESS"),

        @JsonProperty("DINERS_CLUB")
        DINERS_CLUB("DINERS_CLUB"),

        @JsonProperty("DISCOVER")
        DISCOVER("DISCOVER"),

        @JsonProperty("JCB")
        JCB("JCB"),

        @JsonProperty("MASTER_CARD")
        MASTER_CARD("MASTER_CARD"),

        @JsonProperty("SOLO")
        SOLO("SOLO"),

        @JsonProperty("SWITCH")
        SWITCH("SWITCH"),

        @JsonProperty("MAESTRO")
        MAESTRO("MAESTRO"),

        @JsonProperty("CHINA_UNION_PAY")
        CHINA_UNION_PAY("CHINA_UNION_PAY"),

        @JsonProperty("UATP")
        UATP("UATP"),

        @JsonProperty("VISA")
        VISA("VISA")
    }
}
