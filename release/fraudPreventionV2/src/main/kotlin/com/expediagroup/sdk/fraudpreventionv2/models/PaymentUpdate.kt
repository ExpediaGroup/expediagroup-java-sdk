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
import org.hibernate.validator.constraints.Length

/**
 * Payment related data that should be updated.
 * @param merchantOrderCode Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
 */
data class PaymentUpdate(
    // The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`.
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,
    // Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
    @JsonProperty("merchant_order_code")
    @field:Length(max = 200)
    @field:Valid
    val merchantOrderCode: kotlin.String
) : OrderPurchaseUpdateRequest {
    @JsonProperty("type")
    override val type: UpdateType = UpdateType.PAYMENT_UPDATE

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var merchantOrderCode: kotlin.String? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }

        fun merchantOrderCode(merchantOrderCode: kotlin.String) = apply { this.merchantOrderCode = merchantOrderCode }

        fun build(): PaymentUpdate {
            // Check required params
            validateNullity()
            return PaymentUpdate(
                riskId = riskId!!,
                merchantOrderCode = merchantOrderCode!!
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
            if (merchantOrderCode == null) {
                throw NullPointerException("Required parameter merchantOrderCode is missing")
            }
        }
    }
}
