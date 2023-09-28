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
 * Feedback from EG external partners regarding a false positive recommendation that from Fraud Prevention system gave for their customer.
 * @param insultDetail
 */
data class InsultFeedback(

    /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`. */
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,

    @JsonProperty("insult_detail")
    @field:Valid
    val insultDetail: InsultDetail? = null
) : OrderPurchaseUpdateRequest {
    @JsonProperty("type")
    override val type: UpdateType = UpdateType.INSULT_FEEDBACK

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var insultDetail: InsultDetail? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }
        fun insultDetail(insultDetail: InsultDetail) = apply { this.insultDetail = insultDetail }

        fun build(): InsultFeedback {
            // Check required params
            validateNullity()
            return InsultFeedback(
                riskId = riskId!!,
                insultDetail = insultDetail
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
        }
    }
}
