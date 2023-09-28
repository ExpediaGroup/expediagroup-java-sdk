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
 * Feedback from EG external partners if they receive a chargeback for a false negative recommendation from Fraud Prevention system.
 * @param chargebackDetail
 */
data class ChargebackFeedback(

    /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`. */
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,

    @JsonProperty("chargeback_detail")
    @field:Valid
    val chargebackDetail: ChargebackDetail? = null
) : OrderPurchaseUpdateRequest {
    @JsonProperty("type")
    override val type: UpdateType = UpdateType.CHARGEBACK_FEEDBACK

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var chargebackDetail: ChargebackDetail? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }
        fun chargebackDetail(chargebackDetail: ChargebackDetail) = apply { this.chargebackDetail = chargebackDetail }

        fun build(): ChargebackFeedback {
            // Check required params
            validateNullity()
            return ChargebackFeedback(
                riskId = riskId!!,
                chargebackDetail = chargebackDetail
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
        }
    }
}
