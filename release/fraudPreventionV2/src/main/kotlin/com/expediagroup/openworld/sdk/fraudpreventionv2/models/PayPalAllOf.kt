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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models

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
import org.hibernate.validator.constraints.Length

/**
 *
 * @param payerId Unique PayPal Customer Account identification number.
 * @param transactionId Unique transaction number to identify Auth calls at PayPal.
 * @param merchantOrderCode Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
 */
data class PayPalAllOf(
    /* Unique PayPal Customer Account identification number. */
    @JsonProperty("payer_id")
    @field:Length(max = 200)
    @field:Valid
    val payerId: kotlin.String,

    /* Unique transaction number to identify Auth calls at PayPal. */
    @JsonProperty("transaction_id")
    @field:Length(max = 200)
    @field:Valid
    val transactionId: kotlin.String,

    /* Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. */
    @JsonProperty("merchant_order_code")
    @field:Length(max = 200)
    @field:Valid
    val merchantOrderCode: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var payerId: kotlin.String? = null,
        private var transactionId: kotlin.String? = null,
        private var merchantOrderCode: kotlin.String? = null
    ) {
        fun payerId(payerId: kotlin.String) = apply { this.payerId = payerId }
        fun transactionId(transactionId: kotlin.String) = apply { this.transactionId = transactionId }
        fun merchantOrderCode(merchantOrderCode: kotlin.String) = apply { this.merchantOrderCode = merchantOrderCode }

        fun build(): PayPalAllOf {
            // Check required params
            validateNullity()
            return PayPalAllOf(
                payerId = payerId!!,
                transactionId = transactionId!!,
                merchantOrderCode = merchantOrderCode
            )
        }

        private fun validateNullity() {
            if (payerId == null) {
                throw NullPointerException("Required parameter payerId is missing")
            }
            if (transactionId == null) {
                throw NullPointerException("Required parameter transactionId is missing")
            }
        }
    }
}
