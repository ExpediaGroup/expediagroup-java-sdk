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
 * Data that describes settled refund that should be updated.
 * @param refundSettlementDateTime Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has settled at the participating financial institutions.
 * @param refundDepositDateTime Date and time when the refund was deposited to the original form of payment.
 * @param acquirerReferenceNumber A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions.
 * @param settlementId Unique settlement identifier specific to the payment processor for the settlement transaction generated for a previously submitted payment refund.
 * @param refundSettledAmount
 */
data class SettledRefundUpdateDetails(
    /* Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has settled at the participating financial institutions. */
    @JsonProperty("refund_settlement_date_time")
    val refundSettlementDateTime: java.time.OffsetDateTime,

    /* Date and time when the refund was deposited to the original form of payment. */
    @JsonProperty("refund_deposit_date_time")
    val refundDepositDateTime: java.time.OffsetDateTime,

    /* A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions.  */
    @JsonProperty("acquirer_reference_number")
    @field:Length(max = 200)
    @field:Valid
    val acquirerReferenceNumber: kotlin.String,

    /* Unique settlement identifier specific to the payment processor for the settlement transaction generated for a previously submitted payment refund. */
    @JsonProperty("settlement_id")
    @field:Length(max = 200)
    @field:Valid
    val settlementId: kotlin.String,

    @JsonProperty("refund_settled_amount")
    @field:Valid
    val refundSettledAmount: Amount
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var refundSettlementDateTime: java.time.OffsetDateTime? = null,
        private var refundDepositDateTime: java.time.OffsetDateTime? = null,
        private var acquirerReferenceNumber: kotlin.String? = null,
        private var settlementId: kotlin.String? = null,
        private var refundSettledAmount: Amount? = null
    ) {
        fun refundSettlementDateTime(refundSettlementDateTime: java.time.OffsetDateTime) = apply { this.refundSettlementDateTime = refundSettlementDateTime }
        fun refundDepositDateTime(refundDepositDateTime: java.time.OffsetDateTime) = apply { this.refundDepositDateTime = refundDepositDateTime }
        fun acquirerReferenceNumber(acquirerReferenceNumber: kotlin.String) = apply { this.acquirerReferenceNumber = acquirerReferenceNumber }
        fun settlementId(settlementId: kotlin.String) = apply { this.settlementId = settlementId }
        fun refundSettledAmount(refundSettledAmount: Amount) = apply { this.refundSettledAmount = refundSettledAmount }

        fun build(): SettledRefundUpdateDetails {
            // Check required params
            validateNullity()
            return SettledRefundUpdateDetails(
                refundSettlementDateTime = refundSettlementDateTime!!,
                refundDepositDateTime = refundDepositDateTime!!,
                acquirerReferenceNumber = acquirerReferenceNumber!!,
                settlementId = settlementId!!,
                refundSettledAmount = refundSettledAmount!!
            )
        }

        private fun validateNullity() {
            if (refundSettlementDateTime == null) {
                throw NullPointerException("Required parameter refundSettlementDateTime is missing")
            }
            if (refundDepositDateTime == null) {
                throw NullPointerException("Required parameter refundDepositDateTime is missing")
            }
            if (acquirerReferenceNumber == null) {
                throw NullPointerException("Required parameter acquirerReferenceNumber is missing")
            }
            if (settlementId == null) {
                throw NullPointerException("Required parameter settlementId is missing")
            }
            if (refundSettledAmount == null) {
                throw NullPointerException("Required parameter refundSettledAmount is missing")
            }
        }
    }
}
