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
import org.hibernate.validator.constraints.Length

/**
 *
 * @param authenticationType The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE`
 * @param successfulLoginFlag Identifies if a login attempt by a user was successful or not.
 * @param authenticationSubType The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS`
 * @param failedLoginReason The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked.
 */
data class LoginTransactionDetails(

    /* The local date and time the transaction occured in the Partner's system, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("transaction_date_time")

    override val transactionDateTime: java.time.OffsetDateTime,

    /* Unique identifier to identify a transaction attempt in the Partner's system. */
    @JsonProperty("transaction_id")
    @field:Length(max = 200)
    @field:Valid
    override val transactionId: kotlin.String,

    /* The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE`  */
    @JsonProperty("authentication_type")
    val authenticationType: LoginTransactionDetails.AuthenticationType,

    /* Identifies if a login attempt by a user was successful or not. */
    @JsonProperty("successful_login_flag")
    @field:Valid
    val successfulLoginFlag: kotlin.Boolean,

    @JsonProperty("current_user_session")
    @field:Valid
    override val currentUserSession: CurrentUserSession? = null,

    /* The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS`  */
    @JsonProperty("authentication_sub_type")
    val authenticationSubType: LoginTransactionDetails.AuthenticationSubType? = null,

    /* The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked.  */
    @JsonProperty("failed_login_reason")
    val failedLoginReason: LoginTransactionDetails.FailedLoginReason? = null
) : AccountTakeoverTransactionDetails {
    @JsonProperty("type")
    override val type: AccountTakeoverTransactionDetails.Type = AccountTakeoverTransactionDetails.Type.LOGIN

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var transactionDateTime: java.time.OffsetDateTime? = null,
        private var transactionId: kotlin.String? = null,
        private var authenticationType: LoginTransactionDetails.AuthenticationType? = null,
        private var successfulLoginFlag: kotlin.Boolean? = null,
        private var currentUserSession: CurrentUserSession? = null,
        private var authenticationSubType: LoginTransactionDetails.AuthenticationSubType? = null,
        private var failedLoginReason: LoginTransactionDetails.FailedLoginReason? = null
    ) {
        fun transactionDateTime(transactionDateTime: java.time.OffsetDateTime) = apply { this.transactionDateTime = transactionDateTime }
        fun transactionId(transactionId: kotlin.String) = apply { this.transactionId = transactionId }
        fun authenticationType(authenticationType: LoginTransactionDetails.AuthenticationType) = apply { this.authenticationType = authenticationType }
        fun successfulLoginFlag(successfulLoginFlag: kotlin.Boolean) = apply { this.successfulLoginFlag = successfulLoginFlag }
        fun currentUserSession(currentUserSession: CurrentUserSession) = apply { this.currentUserSession = currentUserSession }
        fun authenticationSubType(authenticationSubType: LoginTransactionDetails.AuthenticationSubType) = apply { this.authenticationSubType = authenticationSubType }
        fun failedLoginReason(failedLoginReason: LoginTransactionDetails.FailedLoginReason) = apply { this.failedLoginReason = failedLoginReason }

        fun build(): LoginTransactionDetails {
            // Check required params
            validateNullity()
            return LoginTransactionDetails(
                transactionDateTime = transactionDateTime!!,
                transactionId = transactionId!!,
                authenticationType = authenticationType!!,
                successfulLoginFlag = successfulLoginFlag!!,
                currentUserSession = currentUserSession,
                authenticationSubType = authenticationSubType,
                failedLoginReason = failedLoginReason
            )
        }

        private fun validateNullity() {
            if (transactionDateTime == null) {
                throw NullPointerException("Required parameter transactionDateTime is missing")
            }
            if (transactionId == null) {
                throw NullPointerException("Required parameter transactionId is missing")
            }
            if (authenticationType == null) {
                throw NullPointerException("Required parameter authenticationType is missing")
            }
            if (successfulLoginFlag == null) {
                throw NullPointerException("Required parameter successfulLoginFlag is missing")
            }
        }
    }

    /**
     * The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE`
     * Values: CREDENTIALS,PASSWORD_RESET,SOCIAL,SINGLE_SIGN_ON,MULTI_FACTOR_AUTHENTICATION
     */
    enum class AuthenticationType(val value: kotlin.String) {
        @JsonProperty("CREDENTIALS")
        CREDENTIALS("CREDENTIALS"),

        @JsonProperty("PASSWORD_RESET")
        PASSWORD_RESET("PASSWORD_RESET"),

        @JsonProperty("SOCIAL")
        SOCIAL("SOCIAL"),

        @JsonProperty("SINGLE_SIGN_ON")
        SINGLE_SIGN_ON("SINGLE_SIGN_ON"),

        @JsonProperty("MULTI_FACTOR_AUTHENTICATION")
        MULTI_FACTOR_AUTHENTICATION("MULTI_FACTOR_AUTHENTICATION")
    }

    /**
     * The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS`
     * Values: EMAIL,PHONE,GOOGLE,FACEBOOK,APPLE
     */
    enum class AuthenticationSubType(val value: kotlin.String) {
        @JsonProperty("EMAIL")
        EMAIL("EMAIL"),

        @JsonProperty("PHONE")
        PHONE("PHONE"),

        @JsonProperty("GOOGLE")
        GOOGLE("GOOGLE"),

        @JsonProperty("FACEBOOK")
        FACEBOOK("FACEBOOK"),

        @JsonProperty("APPLE")
        APPLE("APPLE")
    }

    /**
     * The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked.
     * Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED
     */
    enum class FailedLoginReason(val value: kotlin.String) {
        @JsonProperty("INVALID_CREDENTIALS")
        INVALID_CREDENTIALS("INVALID_CREDENTIALS"),

        @JsonProperty("ACCOUNT_NOT_FOUND")
        ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND"),

        @JsonProperty("VERIFICATION_FAILED")
        VERIFICATION_FAILED("VERIFICATION_FAILED"),

        @JsonProperty("ACCOUNT_LOCKED")
        ACCOUNT_LOCKED("ACCOUNT_LOCKED")
    }
}
