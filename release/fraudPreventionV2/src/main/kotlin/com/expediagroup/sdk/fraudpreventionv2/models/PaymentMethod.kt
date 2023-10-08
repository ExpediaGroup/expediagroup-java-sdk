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

import com.fasterxml.jackson.annotation.JsonProperty

/**
* The payment method used at the time of purchase for the transaction. Supported `method`'s are: `CREDIT_CARD`, `PAYPAL`, `POINTS`, `GIFT_CARD`, `INTERNET_BANK_PAYMENT`, `DIRECT_DEBIT`.
* Values: CREDIT_CARD,PAYPAL,POINTS,GIFT_CARD,INTERNET_BANK_PAYMENT,DIRECT_DEBIT
*/
enum class PaymentMethod(val value: kotlin.String) {
    @JsonProperty("CREDIT_CARD")
    CREDIT_CARD("CREDIT_CARD"),

    @JsonProperty("PAYPAL")
    PAYPAL("PAYPAL"),

    @JsonProperty("POINTS")
    POINTS("POINTS"),

    @JsonProperty("GIFT_CARD")
    GIFT_CARD("GIFT_CARD"),

    @JsonProperty("INTERNET_BANK_PAYMENT")
    INTERNET_BANK_PAYMENT("INTERNET_BANK_PAYMENT"),

    @JsonProperty("DIRECT_DEBIT")
    DIRECT_DEBIT("DIRECT_DEBIT")
}
