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
 * Order related data that should be updated.
 * @param orderStatus
 * @param acquirerReferenceNumber A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. `acquirer_reference_number` is a required field only if `order_status` = `COMPLETED` Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions.
 * @param cancellationReason
 */
data class OrderUpdate(

    /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`. */
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,

    @JsonProperty("order_status")
    @field:Valid
    val orderStatus: Status,

    /* A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. `acquirer_reference_number` is a required field only if `order_status` = `COMPLETED` Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions.  */
    @JsonProperty("acquirer_reference_number")
    @field:Length(max = 200)
    @field:Valid
    val acquirerReferenceNumber: kotlin.String? = null,

    @JsonProperty("cancellation_reason")
    @field:Valid
    val cancellationReason: CancellationReason? = null
) : OrderPurchaseUpdateRequest {
    @JsonProperty("type")
    override val type: UpdateType = UpdateType.ORDER_UPDATE

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var orderStatus: Status? = null,
        private var acquirerReferenceNumber: kotlin.String? = null,
        private var cancellationReason: CancellationReason? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }
        fun orderStatus(orderStatus: Status) = apply { this.orderStatus = orderStatus }
        fun acquirerReferenceNumber(acquirerReferenceNumber: kotlin.String) = apply { this.acquirerReferenceNumber = acquirerReferenceNumber }
        fun cancellationReason(cancellationReason: CancellationReason) = apply { this.cancellationReason = cancellationReason }

        fun build(): OrderUpdate {
            // Check required params
            validateNullity()
            return OrderUpdate(
                riskId = riskId!!,
                orderStatus = orderStatus!!,
                acquirerReferenceNumber = acquirerReferenceNumber,
                cancellationReason = cancellationReason
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
            if (orderStatus == null) {
                throw NullPointerException("Required parameter orderStatus is missing")
            }
        }
    }
}
