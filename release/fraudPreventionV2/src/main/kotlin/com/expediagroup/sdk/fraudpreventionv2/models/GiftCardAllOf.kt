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
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

/**
 *
 * @param cardNumber Gift card number.
 * @param cardHolderName The name of gift card holder.
 * @param pin The PIN of gift card.
 */
data class GiftCardAllOf(
    /* Gift card number. */
    @JsonProperty("card_number")
    @field:Pattern(regexp = "^[0-9A-Za-z]{4,16}$")
    @field:Length(max = 16)
    @field:Valid
    val cardNumber: kotlin.String,

    /* The name of gift card holder. */
    @JsonProperty("card_holder_name")
    @field:Length(max = 200)
    @field:Valid
    val cardHolderName: kotlin.String,

    /* The PIN of gift card. */
    @JsonProperty("pin")
    @field:Pattern(regexp = "^[0-9]{4,8}$")
    @field:Length(max = 8)
    @field:Valid
    val pin: kotlin.String
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var cardNumber: kotlin.String? = null,
        private var cardHolderName: kotlin.String? = null,
        private var pin: kotlin.String? = null
    ) {
        fun cardNumber(cardNumber: kotlin.String) = apply { this.cardNumber = cardNumber }
        fun cardHolderName(cardHolderName: kotlin.String) = apply { this.cardHolderName = cardHolderName }
        fun pin(pin: kotlin.String) = apply { this.pin = pin }

        fun build(): GiftCardAllOf {
            // Check required params
            validateNullity()
            return GiftCardAllOf(
                cardNumber = cardNumber!!,
                cardHolderName = cardHolderName!!,
                pin = pin!!
            )
        }

        private fun validateNullity() {
            if (cardNumber == null) {
                throw NullPointerException("Required parameter cardNumber is missing")
            }
            if (cardHolderName == null) {
                throw NullPointerException("Required parameter cardHolderName is missing")
            }
            if (pin == null) {
                throw NullPointerException("Required parameter pin is missing")
            }
        }
    }
}
