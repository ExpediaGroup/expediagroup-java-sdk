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

/**
 * Information related to challenges initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service.
 * @param displayedFlag Indicates that there was a challenge initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service.
 * @param type The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc).
 * @param status The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge.
 */
data class ChallengeDetail(
    // Indicates that there was a challenge initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service.
    @JsonProperty("displayed_flag")
    @field:Valid
    val displayedFlag: kotlin.Boolean,
    // The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc).
    @JsonProperty("type")
    val type: ChallengeDetail.Type,
    // The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge.
    @JsonProperty("status")
    val status: ChallengeDetail.Status
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var displayedFlag: kotlin.Boolean? = null,
        private var type: ChallengeDetail.Type? = null,
        private var status: ChallengeDetail.Status? = null
    ) {
        fun displayedFlag(displayedFlag: kotlin.Boolean) = apply { this.displayedFlag = displayedFlag }

        fun type(type: ChallengeDetail.Type) = apply { this.type = type }

        fun status(status: ChallengeDetail.Status) = apply { this.status = status }

        fun build(): ChallengeDetail {
            // Check required params
            validateNullity()
            return ChallengeDetail(
                displayedFlag = displayedFlag!!,
                type = type!!,
                status = status!!
            )
        }

        private fun validateNullity() {
            if (displayedFlag == null) {
                throw NullPointerException("Required parameter displayedFlag is missing")
            }
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
            if (status == null) {
                throw NullPointerException("Required parameter status is missing")
            }
        }
    }

    /**
     * The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc).
     * Values: CAPTCHA,TWO_FACTOR
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("CAPTCHA")
        CAPTCHA("CAPTCHA"),

        @JsonProperty("TWO_FACTOR")
        TWO_FACTOR("TWO_FACTOR")
    }

    /**
     * The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge.
     * Values: SUCCESS,FAILED
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty("SUCCESS")
        SUCCESS("SUCCESS"),

        @JsonProperty("FAILED")
        FAILED("FAILED")
    }
}
