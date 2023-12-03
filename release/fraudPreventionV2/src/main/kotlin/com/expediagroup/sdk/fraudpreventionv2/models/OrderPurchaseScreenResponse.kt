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
 *
 * @param riskId Unique identifier assigned to the transaction by Expedia's Fraud Prevention Service.
 * @param decision
 */
data class OrderPurchaseScreenResponse(
    // Unique identifier assigned to the transaction by Expedia's Fraud Prevention Service.
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    val riskId: kotlin.String? = null,
    @JsonProperty("decision")
    @field:Valid
    val decision: FraudDecision? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var decision: FraudDecision? = null
    ) {
        fun riskId(riskId: kotlin.String?) = apply { this.riskId = riskId }

        fun decision(decision: FraudDecision?) = apply { this.decision = decision }

        fun build(): OrderPurchaseScreenResponse {
            return OrderPurchaseScreenResponse(
                riskId = riskId,
                decision = decision
            )
        }
    }
}
