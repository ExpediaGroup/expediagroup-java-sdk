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

/**
 * Information specific to the remediation action initiated by the Partner's system to a user.
 * @param actionName The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system.
 * @param status The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action.
 * @param updateEndDateTime The local date and time the remediation action to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 */
data class RemediationUpdateAction(
    /* The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system.  */
    @JsonProperty("action_name")
    val actionName: RemediationUpdateAction.ActionName,

    /* The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action.  */
    @JsonProperty("status")
    val status: RemediationUpdateAction.Status,

    /* The local date and time the remediation action to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("update_end_date_time")
    val updateEndDateTime: java.time.OffsetDateTime? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var actionName: RemediationUpdateAction.ActionName? = null,
        private var status: RemediationUpdateAction.Status? = null,
        private var updateEndDateTime: java.time.OffsetDateTime? = null
    ) {
        fun actionName(actionName: RemediationUpdateAction.ActionName) = apply { this.actionName = actionName }
        fun status(status: RemediationUpdateAction.Status) = apply { this.status = status }
        fun updateEndDateTime(updateEndDateTime: java.time.OffsetDateTime) = apply { this.updateEndDateTime = updateEndDateTime }

        fun build(): RemediationUpdateAction {
            // Check required params
            validateNullity()
            return RemediationUpdateAction(
                actionName = actionName!!,
                status = status!!,
                updateEndDateTime = updateEndDateTime
            )
        }

        private fun validateNullity() {
            if (actionName == null) {
                throw NullPointerException("Required parameter actionName is missing")
            }
            if (status == null) {
                throw NullPointerException("Required parameter status is missing")
            }
        }
    }

    /**
     * The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system.
     * Values: PASSWORD_RESET,DISABLE_ACCOUNT,TERMINATE_ALL_SESSIONS
     */
    enum class ActionName(val value: kotlin.String) {
        @JsonProperty("PASSWORD_RESET")
        PASSWORD_RESET("PASSWORD_RESET"),

        @JsonProperty("DISABLE_ACCOUNT")
        DISABLE_ACCOUNT("DISABLE_ACCOUNT"),

        @JsonProperty("TERMINATE_ALL_SESSIONS")
        TERMINATE_ALL_SESSIONS("TERMINATE_ALL_SESSIONS")
    }

    /**
     * The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action.
     * Values: SUCCESS,FAILED
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty("SUCCESS")
        SUCCESS("SUCCESS"),

        @JsonProperty("FAILED")
        FAILED("FAILED")
    }
}
