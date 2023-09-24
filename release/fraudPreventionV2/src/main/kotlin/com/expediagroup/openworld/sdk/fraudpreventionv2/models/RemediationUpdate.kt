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
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Information specific to remediation actions initiated by the Partner's system to a user as a result of a fraud recommendation.
 * @param remediationUpdateActions
 */
data class RemediationUpdate(

    /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `AccountScreenResponse`. */
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,

    @JsonProperty("remediation_update_actions")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>
) : AccountUpdateRequest {
    @JsonProperty("type")
    override val type: AccountUpdateRequest.Type = AccountUpdateRequest.Type.REMEDIATION_UPDATE

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }
        fun remediationUpdateActions(remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>) = apply { this.remediationUpdateActions = remediationUpdateActions }

        fun build(): RemediationUpdate {
            // Check required params
            validateNullity()
            return RemediationUpdate(
                riskId = riskId!!,
                remediationUpdateActions = remediationUpdateActions!!
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
            if (remediationUpdateActions == null) {
                throw NullPointerException("Required parameter remediationUpdateActions is missing")
            }
        }
    }
}
