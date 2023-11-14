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
 * Indicates that the token sent in the 'Authorization' header is either invalid or missing. Please check the value in the token field along with the token expiration time before retrying.
 * @param code Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon.
 * @param message A human-readable explanation of the error, specific to this error occurrence.
 */
data class AccountTakeoverUnauthorizedError(
    // Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon.
    @JsonProperty("code")
    val code: AccountTakeoverUnauthorizedError.Code,
    // A human-readable explanation of the error, specific to this error occurrence.
    @JsonProperty("message")
    @field:Valid
    val message: kotlin.String
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var code: AccountTakeoverUnauthorizedError.Code? = null,
        private var message: kotlin.String? = null
    ) {
        fun code(code: AccountTakeoverUnauthorizedError.Code) = apply { this.code = code }

        fun message(message: kotlin.String) = apply { this.message = message }

        fun build(): AccountTakeoverUnauthorizedError {
            // Check required params
            validateNullity()
            return AccountTakeoverUnauthorizedError(
                code = code!!,
                message = message!!
            )
        }

        private fun validateNullity() {
            if (code == null) {
                throw NullPointerException("Required parameter code is missing")
            }
            if (message == null) {
                throw NullPointerException("Required parameter message is missing")
            }
        }
    }

    /**
     * Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon.
     * Values: UNAUTHORIZED,FORBIDDEN,NOT_FOUND,ACCOUNT_UPDATE_NOT_FOUND,TOO_MANY_REQUESTS,INTERNAL_SERVER_ERROR,BAD_GATEWAY,RETRYABLE_ACCOUNT_SCREEN_FAILURE,RETRYABLE_ACCOUNT_UPDATE_FAILURE,GATEWAY_TIMEOUT,BAD_REQUEST
     */
    enum class Code(val value: kotlin.String) {
        @JsonProperty("UNAUTHORIZED")
        UNAUTHORIZED("UNAUTHORIZED"),

        @JsonProperty("FORBIDDEN")
        FORBIDDEN("FORBIDDEN"),

        @JsonProperty("NOT_FOUND")
        NOT_FOUND("NOT_FOUND"),

        @JsonProperty("ACCOUNT_UPDATE_NOT_FOUND")
        ACCOUNT_UPDATE_NOT_FOUND("ACCOUNT_UPDATE_NOT_FOUND"),

        @JsonProperty("TOO_MANY_REQUESTS")
        TOO_MANY_REQUESTS("TOO_MANY_REQUESTS"),

        @JsonProperty("INTERNAL_SERVER_ERROR")
        INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),

        @JsonProperty("BAD_GATEWAY")
        BAD_GATEWAY("BAD_GATEWAY"),

        @JsonProperty("RETRYABLE_ACCOUNT_SCREEN_FAILURE")
        RETRYABLE_ACCOUNT_SCREEN_FAILURE("RETRYABLE_ACCOUNT_SCREEN_FAILURE"),

        @JsonProperty("RETRYABLE_ACCOUNT_UPDATE_FAILURE")
        RETRYABLE_ACCOUNT_UPDATE_FAILURE("RETRYABLE_ACCOUNT_UPDATE_FAILURE"),

        @JsonProperty("GATEWAY_TIMEOUT")
        GATEWAY_TIMEOUT("GATEWAY_TIMEOUT"),

        @JsonProperty("BAD_REQUEST")
        BAD_REQUEST("BAD_REQUEST")
    }
}
