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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * The `method` field value is used as a discriminator, with the following mapping: * `CREDIT_CARD`: `CreditCard` * `PAYPAL`: `PayPal` * `POINTS`: `Points` * `GIFT_CARD`: `GiftCard` * `INTERNET_BANK_PAYMENT`: `InternetBankPayment` * `DIRECT_DEBIT`: `DirectDebit`
 * @param brand The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV`
 * @param method
 * @param billingName
 * @param billingAddress
 * @param billingEmailAddress Email address associated with the payment.
 * @param reason
 * @param authorizedAmount
 * @param verifiedAmount
 * @param threeDigitsSecureCriteria
 * @param operations
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = ["method"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "method", visible = true)
@JsonSubTypes(
    Type(value = CreditCard::class, name = "CREDIT_CARD"),
    Type(value = DirectDebit::class, name = "DIRECT_DEBIT"),
    Type(value = GiftCard::class, name = "GIFT_CARD"),
    Type(value = InternetBankPayment::class, name = "INTERNET_BANK_PAYMENT"),
    Type(value = PayPal::class, name = "PAYPAL"),
    Type(value = Points::class, name = "POINTS")
)
interface Payment {
    // The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV`

    val brand: Payment.Brand

    val method: PaymentMethod

    val billingName: Name

    val billingAddress: PaymentBillingAddress
    // Email address associated with the payment.

    val billingEmailAddress: kotlin.String
    val reason: PaymentReason?
    val authorizedAmount: Amount?
    val verifiedAmount: Amount?
    val threeDigitsSecureCriteria: PaymentThreeDSCriteria?
    val operations: Operations?

    /**
     * The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV`
     * Values: AMERICAN_EXPRESS,DINERS_CLUB_INTERNATIONAL,BC_CARD,DISCOVER,JCB,MASTER_CARD,MAESTRO,POSTEPAY_MASTERCARD,SOLO,SWITCH,CHINA_UNION_PAY,UATP,UATP_SUPPLY,AIR_PLUS,UA_PASS_PLUS,VISA,VISA_DELTA,VISA_ELECTRON,CARTA_SI,CARTE_BLEUE,VISA_DANKORT,POSTEPAY_VISA_ELECTRON,PAYPAL,EXPEDIA_REWARDS,AMEX_POINTS,BANK_OF_AMERICA_REWARDS,DISCOVER_POINTS,MASTER_CARD_POINTS,CITI_THANK_YOU_POINTS,MERRILL_LYNCH_REWARDS,WELLS_FARGO_POINTS,DELTA_SKY_MILES,UNITED_POINTS,DISCOVER_MILES,ALASKA_MILES,RBC_REWARDS,BILT_REWARDS,ORBUCKS,CHEAP_CASH,BONUS_PLUS,ULTIMATE_REWARDS,GIFT_CARD,IBP,LOCAL_DEBIT_CARD,SOFORT,YANDEX,WEB_MONEY,QIWI,BITCOIN,ELV,INTER_COMPANY,SEPA_ELV
     */
    enum class Brand(val value: kotlin.String) {
        @JsonProperty("AMERICAN_EXPRESS")
        AMERICAN_EXPRESS("AMERICAN_EXPRESS"),

        @JsonProperty("DINERS_CLUB_INTERNATIONAL")
        DINERS_CLUB_INTERNATIONAL("DINERS_CLUB_INTERNATIONAL"),

        @JsonProperty("BC_CARD")
        BC_CARD("BC_CARD"),

        @JsonProperty("DISCOVER")
        DISCOVER("DISCOVER"),

        @JsonProperty("JCB")
        JCB("JCB"),

        @JsonProperty("MASTER_CARD")
        MASTER_CARD("MASTER_CARD"),

        @JsonProperty("MAESTRO")
        MAESTRO("MAESTRO"),

        @JsonProperty("POSTEPAY_MASTERCARD")
        POSTEPAY_MASTERCARD("POSTEPAY_MASTERCARD"),

        @JsonProperty("SOLO")
        SOLO("SOLO"),

        @JsonProperty("SWITCH")
        SWITCH("SWITCH"),

        @JsonProperty("CHINA_UNION_PAY")
        CHINA_UNION_PAY("CHINA_UNION_PAY"),

        @JsonProperty("UATP")
        UATP("UATP"),

        @JsonProperty("UATP_SUPPLY")
        UATP_SUPPLY("UATP_SUPPLY"),

        @JsonProperty("AIR_PLUS")
        AIR_PLUS("AIR_PLUS"),

        @JsonProperty("UA_PASS_PLUS")
        UA_PASS_PLUS("UA_PASS_PLUS"),

        @JsonProperty("VISA")
        VISA("VISA"),

        @JsonProperty("VISA_DELTA")
        VISA_DELTA("VISA_DELTA"),

        @JsonProperty("VISA_ELECTRON")
        VISA_ELECTRON("VISA_ELECTRON"),

        @JsonProperty("CARTA_SI")
        CARTA_SI("CARTA_SI"),

        @JsonProperty("CARTE_BLEUE")
        CARTE_BLEUE("CARTE_BLEUE"),

        @JsonProperty("VISA_DANKORT")
        VISA_DANKORT("VISA_DANKORT"),

        @JsonProperty("POSTEPAY_VISA_ELECTRON")
        POSTEPAY_VISA_ELECTRON("POSTEPAY_VISA_ELECTRON"),

        @JsonProperty("PAYPAL")
        PAYPAL("PAYPAL"),

        @JsonProperty("EXPEDIA_REWARDS")
        EXPEDIA_REWARDS("EXPEDIA_REWARDS"),

        @JsonProperty("AMEX_POINTS")
        AMEX_POINTS("AMEX_POINTS"),

        @JsonProperty("BANK_OF_AMERICA_REWARDS")
        BANK_OF_AMERICA_REWARDS("BANK_OF_AMERICA_REWARDS"),

        @JsonProperty("DISCOVER_POINTS")
        DISCOVER_POINTS("DISCOVER_POINTS"),

        @JsonProperty("MASTER_CARD_POINTS")
        MASTER_CARD_POINTS("MASTER_CARD_POINTS"),

        @JsonProperty("CITI_THANK_YOU_POINTS")
        CITI_THANK_YOU_POINTS("CITI_THANK_YOU_POINTS"),

        @JsonProperty("MERRILL_LYNCH_REWARDS")
        MERRILL_LYNCH_REWARDS("MERRILL_LYNCH_REWARDS"),

        @JsonProperty("WELLS_FARGO_POINTS")
        WELLS_FARGO_POINTS("WELLS_FARGO_POINTS"),

        @JsonProperty("DELTA_SKY_MILES")
        DELTA_SKY_MILES("DELTA_SKY_MILES"),

        @JsonProperty("UNITED_POINTS")
        UNITED_POINTS("UNITED_POINTS"),

        @JsonProperty("DISCOVER_MILES")
        DISCOVER_MILES("DISCOVER_MILES"),

        @JsonProperty("ALASKA_MILES")
        ALASKA_MILES("ALASKA_MILES"),

        @JsonProperty("RBC_REWARDS")
        RBC_REWARDS("RBC_REWARDS"),

        @JsonProperty("BILT_REWARDS")
        BILT_REWARDS("BILT_REWARDS"),

        @JsonProperty("ORBUCKS")
        ORBUCKS("ORBUCKS"),

        @JsonProperty("CHEAP_CASH")
        CHEAP_CASH("CHEAP_CASH"),

        @JsonProperty("BONUS_PLUS")
        BONUS_PLUS("BONUS_PLUS"),

        @JsonProperty("ULTIMATE_REWARDS")
        ULTIMATE_REWARDS("ULTIMATE_REWARDS"),

        @JsonProperty("GIFT_CARD")
        GIFT_CARD("GIFT_CARD"),

        @JsonProperty("IBP")
        IBP("IBP"),

        @JsonProperty("LOCAL_DEBIT_CARD")
        LOCAL_DEBIT_CARD("LOCAL_DEBIT_CARD"),

        @JsonProperty("SOFORT")
        SOFORT("SOFORT"),

        @JsonProperty("YANDEX")
        YANDEX("YANDEX"),

        @JsonProperty("WEB_MONEY")
        WEB_MONEY("WEB_MONEY"),

        @JsonProperty("QIWI")
        QIWI("QIWI"),

        @JsonProperty("BITCOIN")
        BITCOIN("BITCOIN"),

        @JsonProperty("ELV")
        ELV("ELV"),

        @JsonProperty("INTER_COMPANY")
        INTER_COMPANY("INTER_COMPANY"),

        @JsonProperty("SEPA_ELV")
        SEPA_ELV("SEPA_ELV")
    }
}
