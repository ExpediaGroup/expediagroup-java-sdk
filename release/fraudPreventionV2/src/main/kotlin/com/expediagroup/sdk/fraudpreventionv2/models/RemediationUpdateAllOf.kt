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
 * @param remediationUpdateActions
 */
data class RemediationUpdateAllOf(
    @JsonProperty("remediation_update_actions")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>? = null
    ) {
        fun remediationUpdateActions(remediationUpdateActions: kotlin.collections.List<RemediationUpdateAction>) = apply { this.remediationUpdateActions = remediationUpdateActions }

        fun build(): RemediationUpdateAllOf {
            // Check required params
            validateNullity()
            return RemediationUpdateAllOf(
                remediationUpdateActions = remediationUpdateActions!!
            )
        }

        private fun validateNullity() {
            if (remediationUpdateActions == null) {
                throw NullPointerException("Required parameter remediationUpdateActions is missing")
            }
        }
    }
}
