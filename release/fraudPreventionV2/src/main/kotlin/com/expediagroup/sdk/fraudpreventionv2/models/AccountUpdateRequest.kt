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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * The `type` field value is used as a discriminator, with the following mapping: * `MULTI_FACTOR_AUTHENTICATION_UPDATE`: `MultiFactorAuthenticationUpdate` * `REMEDIATION_UPDATE`: `RemediationUpdate`
 * @param type The categorized type of account update event from the Partner's system.
 * @param riskId The `risk_id` provided by Expedia's Fraud Prevention Service in the `AccountScreenResponse`.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = ["type"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
    Type(value = MultiFactorAuthenticationUpdate::class, name = "MULTI_FACTOR_AUTHENTICATION_UPDATE"),
    Type(value = RemediationUpdate::class, name = "REMEDIATION_UPDATE")
)
interface AccountUpdateRequest {
    // The categorized type of account update event from the Partner's system.

    val type: AccountUpdateRequest.Type
    // The `risk_id` provided by Expedia's Fraud Prevention Service in the `AccountScreenResponse`.

    val riskId: kotlin.String

    /**
     * The categorized type of account update event from the Partner's system.
     * Values: MULTI_FACTOR_AUTHENTICATION_UPDATE,REMEDIATION_UPDATE
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("MULTI_FACTOR_AUTHENTICATION_UPDATE")
        MULTI_FACTOR_AUTHENTICATION_UPDATE("MULTI_FACTOR_AUTHENTICATION_UPDATE"),

        @JsonProperty("REMEDIATION_UPDATE")
        REMEDIATION_UPDATE("REMEDIATION_UPDATE")
    }
}
