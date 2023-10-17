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

/**
 *
 * @param multiFactorAuthenticationAttempts
 */
data class MultiFactorAuthenticationUpdateAllOf(
    @JsonProperty("multi_factor_authentication_attempts")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>? = null
    ) {
        fun multiFactorAuthenticationAttempts(multiFactorAuthenticationAttempts: kotlin.collections.List<MultiFactorAuthenticationAttempt>) =
            apply { this.multiFactorAuthenticationAttempts = multiFactorAuthenticationAttempts }

        fun build(): MultiFactorAuthenticationUpdateAllOf {
            // Check required params
            validateNullity()
            return MultiFactorAuthenticationUpdateAllOf(
                multiFactorAuthenticationAttempts = multiFactorAuthenticationAttempts!!
            )
        }

        private fun validateNullity() {
            if (multiFactorAuthenticationAttempts == null) {
                throw NullPointerException("Required parameter multiFactorAuthenticationAttempts is missing")
            }
        }
    }
}
