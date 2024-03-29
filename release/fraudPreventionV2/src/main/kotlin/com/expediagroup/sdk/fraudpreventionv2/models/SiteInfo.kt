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
import javax.validation.constraints.Pattern

/**
 *
 * @param countryCode The alpha-3 ISO code that represents a country name.
 * @param agentAssisted Identifies if an agent assisted in booking travel for the customer. `False` if the order was directly booked by customer.
 */
data class SiteInfo(
    // The alpha-3 ISO code that represents a country name.
    @JsonProperty("country_code")
    @field:Pattern(regexp = "^[A-Z]{3}$")
    @field:Valid
    val countryCode: kotlin.String,
    // Identifies if an agent assisted in booking travel for the customer. `False` if the order was directly booked by customer.
    @JsonProperty("agent_assisted")
    @field:Valid
    val agentAssisted: kotlin.Boolean
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var countryCode: kotlin.String? = null,
        private var agentAssisted: kotlin.Boolean? = null
    ) {
        fun countryCode(countryCode: kotlin.String) = apply { this.countryCode = countryCode }

        fun agentAssisted(agentAssisted: kotlin.Boolean) = apply { this.agentAssisted = agentAssisted }

        fun build(): SiteInfo {
            // Check required params
            validateNullity()
            return SiteInfo(
                countryCode = countryCode!!,
                agentAssisted = agentAssisted!!
            )
        }

        private fun validateNullity() {
            if (countryCode == null) {
                throw NullPointerException("Required parameter countryCode is missing")
            }
            if (agentAssisted == null) {
                throw NullPointerException("Required parameter agentAssisted is missing")
            }
        }
    }
}
