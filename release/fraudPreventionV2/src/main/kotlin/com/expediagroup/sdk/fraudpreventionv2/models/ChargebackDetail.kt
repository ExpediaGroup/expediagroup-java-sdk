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
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Details related to the chargeback.
 * @param chargebackStatus Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received.
 * @param chargebackReason Reason for chargeback which can be `Fraud` or `Non Fraud`.
 * @param chargebackAmount
 * @param bankReasonCode Unique code provided by the acquiring bank for the category of fraud.
 * @param chargebackReportedDateTime Date and time when the chargeback was reported to the partner, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 */
data class ChargebackDetail(
    // Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received.
    @JsonProperty("chargeback_status")
    val chargebackStatus: ChargebackDetail.ChargebackStatus,
    // Reason for chargeback which can be `Fraud` or `Non Fraud`.
    @JsonProperty("chargeback_reason")
    val chargebackReason: ChargebackDetail.ChargebackReason,
    @JsonProperty("chargeback_amount")
    @field:Valid
    val chargebackAmount: Amount,
    // Unique code provided by the acquiring bank for the category of fraud.
    @JsonProperty("bank_reason_code")
    @field:Length(max = 200)
    @field:Valid
    val bankReasonCode: kotlin.String? = null,
    // Date and time when the chargeback was reported to the partner, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("chargeback_reported_date_time")
    val chargebackReportedDateTime: java.time.OffsetDateTime? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var chargebackStatus: ChargebackDetail.ChargebackStatus? = null,
        private var chargebackReason: ChargebackDetail.ChargebackReason? = null,
        private var chargebackAmount: Amount? = null,
        private var bankReasonCode: kotlin.String? = null,
        private var chargebackReportedDateTime: java.time.OffsetDateTime? = null
    ) {
        fun chargebackStatus(chargebackStatus: ChargebackDetail.ChargebackStatus) = apply { this.chargebackStatus = chargebackStatus }

        fun chargebackReason(chargebackReason: ChargebackDetail.ChargebackReason) = apply { this.chargebackReason = chargebackReason }

        fun chargebackAmount(chargebackAmount: Amount) = apply { this.chargebackAmount = chargebackAmount }

        fun bankReasonCode(bankReasonCode: kotlin.String?) = apply { this.bankReasonCode = bankReasonCode }

        fun chargebackReportedDateTime(chargebackReportedDateTime: java.time.OffsetDateTime?) = apply { this.chargebackReportedDateTime = chargebackReportedDateTime }

        fun build(): ChargebackDetail {
            // Check required params
            validateNullity()
            return ChargebackDetail(
                chargebackStatus = chargebackStatus!!,
                chargebackReason = chargebackReason!!,
                chargebackAmount = chargebackAmount!!,
                bankReasonCode = bankReasonCode,
                chargebackReportedDateTime = chargebackReportedDateTime
            )
        }

        private fun validateNullity() {
            if (chargebackStatus == null) {
                throw NullPointerException("Required parameter chargebackStatus is missing")
            }
            if (chargebackReason == null) {
                throw NullPointerException("Required parameter chargebackReason is missing")
            }
            if (chargebackAmount == null) {
                throw NullPointerException("Required parameter chargebackAmount is missing")
            }
        }
    }

    /**
     * Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received.
     * Values: RECEIVED,REVERSAL
     */
    enum class ChargebackStatus(val value: kotlin.String) {
        @JsonProperty("RECEIVED")
        RECEIVED("RECEIVED"),

        @JsonProperty("REVERSAL")
        REVERSAL("REVERSAL")
    }

    /**
     * Reason for chargeback which can be `Fraud` or `Non Fraud`.
     * Values: FRAUD,NON_FRAUD
     */
    enum class ChargebackReason(val value: kotlin.String) {
        @JsonProperty("FRAUD")
        FRAUD("FRAUD"),

        @JsonProperty("NON_FRAUD")
        NON_FRAUD("NON_FRAUD")
    }
}
