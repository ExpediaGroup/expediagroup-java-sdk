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
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Information specific to a user's response to a Multi-Factor Authentication initiated by the Partner's system as a result of a fraud recommendation.
 * @param multiFactorAuthenticationAttempts
 */
data class MultiFactorAuthenticationUpdate(

    /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `AccountScreenResponse`. */
    @JsonProperty("risk_id")
    @field:Length(max = 200)
    @field:Valid
    override val riskId: kotlin.String,

    @JsonProperty("multi_factor_authentication_attempts")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>
) : AccountUpdateRequest {
    @JsonProperty("type")
    override val type: AccountUpdateRequest.Type = AccountUpdateRequest.Type.MULTI_FACTOR_AUTHENTICATION_UPDATE

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var riskId: kotlin.String? = null,
        private var multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>? = null
    ) {
        fun riskId(riskId: kotlin.String) = apply { this.riskId = riskId }
        fun multiFactorAuthenticationAttempts(multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>) = apply {
            this.multiFactorAuthenticationAttempts = multiFactorAuthenticationAttempts
        }

        fun build(): MultiFactorAuthenticationUpdate {
            // Check required params
            validateNullity()
            return MultiFactorAuthenticationUpdate(
                riskId = riskId!!,
                multiFactorAuthenticationAttempts = multiFactorAuthenticationAttempts!!
            )
        }

        private fun validateNullity() {
            if (riskId == null) {
                throw NullPointerException("Required parameter riskId is missing")
            }
            if (multiFactorAuthenticationAttempts == null) {
                throw NullPointerException("Required parameter multiFactorAuthenticationAttempts is missing")
            }
        }
    }
}
