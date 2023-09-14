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
import jakarta.validation.Valid

/**
 *
 * @param code
 * @param `field` A JSON Path expression indicating which field, in the request body, caused the error.
 * @param message
 */
data class AccountTakeoverBadRequestErrorAllOfCauses(
    @JsonProperty("code")
    val code: AccountTakeoverBadRequestErrorAllOfCauses.Code? = null,

    /* A JSON Path expression indicating which field, in the request body, caused the error. */
    @JsonProperty("field")
    @field:Valid
    val `field`: kotlin.String? = null,

    @JsonProperty("message")
    @field:Valid
    val message: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var code: AccountTakeoverBadRequestErrorAllOfCauses.Code? = null,
        private var `field`: kotlin.String? = null,
        private var message: kotlin.String? = null
    ) {
        fun code(code: AccountTakeoverBadRequestErrorAllOfCauses.Code) = apply { this.code = code }
        fun `field`(`field`: kotlin.String) = apply { this.`field` = `field` }
        fun message(message: kotlin.String) = apply { this.message = message }

        fun build(): AccountTakeoverBadRequestErrorAllOfCauses {
            return AccountTakeoverBadRequestErrorAllOfCauses(
                code = code,
                `field` = `field`,
                message = message
            )
        }
    }

    /**
     *
     * Values: MISSING_MANDATORY_PARAM,INVALID_PARAM,INVALID_FORMAT
     */
    enum class Code(val value: kotlin.String) {
        @JsonProperty("MISSING_MANDATORY_PARAM")
        MISSING_MANDATORY_PARAM("MISSING_MANDATORY_PARAM"),

        @JsonProperty("INVALID_PARAM")
        INVALID_PARAM("INVALID_PARAM"),

        @JsonProperty("INVALID_FORMAT")
        INVALID_FORMAT("INVALID_FORMAT")
    }
}
