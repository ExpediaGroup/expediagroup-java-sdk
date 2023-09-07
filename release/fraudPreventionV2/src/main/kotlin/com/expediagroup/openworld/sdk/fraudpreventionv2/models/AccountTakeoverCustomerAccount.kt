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
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Information about a user's account.
 * @param userId Unique account identifier provided by the Partner's Identity Provider/System assigned to the account owner by the partner. `user_id` is specific to the Partner's namespace. Used to track repeat account activity by the same user.
 * @param accountType Identifies the account type of a user''s account. Possible values are: - `INDIVIDUAL` - Applicable if this account is for an individual traveler. - `BUSINESS` - Applicable if this account is for a business or organization account used by suppliers or Partners.
 * @param username Username of the account.
 * @param emailAddress Email address for the account owner.
 * @param registeredTime The local date and time that the customer first registered on the Partner's site, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param activeFlag Indicator for if this account is an active account or not.
 * @param accountRole Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users.
 * @param name
 * @param telephones
 * @param address
 * @param loyaltyMemberId Unique loyalty identifier for a user.
 */
data class AccountTakeoverCustomerAccount(
    /* Unique account identifier provided by the Partner's Identity Provider/System assigned to the account owner by the partner. `user_id` is specific to the Partner's namespace. Used to track repeat account activity by the same user. */
    @JsonProperty("user_id")
    @field:Length(max = 200)
    @field:Valid
    val userId: kotlin.String,

    /* Identifies the account type of a user''s account. Possible values are: - `INDIVIDUAL` - Applicable if this account is for an individual traveler. - `BUSINESS` - Applicable if this account is for a business or organization account used by suppliers or Partners.  */
    @JsonProperty("account_type")
    val accountType: AccountTakeoverCustomerAccount.AccountType,

    /* Username of the account. */
    @JsonProperty("username")
    @field:Length(max = 200)
    @field:Valid
    val username: kotlin.String,

    /* Email address for the account owner. */
    @JsonProperty("email_address")
    @field:Valid
    val emailAddress: kotlin.String,

    /* The local date and time that the customer first registered on the Partner's site, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("registered_time")
    val registeredTime: java.time.OffsetDateTime,

    /* Indicator for if this account is an active account or not. */
    @JsonProperty("active_flag")
    @field:Valid
    val activeFlag: kotlin.Boolean,

    /* Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users.  */
    @JsonProperty("account_role")
    val accountRole: AccountTakeoverCustomerAccount.AccountRole? = null,

    @JsonProperty("name")
    @field:Valid
    val name: AccountTakeoverName? = null,

    @JsonProperty("telephones")
    @field:Size(max = 20)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>? = null,

    @JsonProperty("address")
    @field:Valid
    val address: CustomerAccountAddress? = null,

    /* Unique loyalty identifier for a user. */
    @JsonProperty("loyalty_member_id")
    @field:Length(max = 200)
    @field:Valid
    val loyaltyMemberId: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var userId: kotlin.String? = null,
        private var accountType: AccountTakeoverCustomerAccount.AccountType? = null,
        private var username: kotlin.String? = null,
        private var emailAddress: kotlin.String? = null,
        private var registeredTime: java.time.OffsetDateTime? = null,
        private var activeFlag: kotlin.Boolean? = null,
        private var accountRole: AccountTakeoverCustomerAccount.AccountRole? = null,
        private var name: AccountTakeoverName? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var address: CustomerAccountAddress? = null,
        private var loyaltyMemberId: kotlin.String? = null
    ) {
        fun userId(userId: kotlin.String) = apply { this.userId = userId }
        fun accountType(accountType: AccountTakeoverCustomerAccount.AccountType) = apply { this.accountType = accountType }
        fun username(username: kotlin.String) = apply { this.username = username }
        fun emailAddress(emailAddress: kotlin.String) = apply { this.emailAddress = emailAddress }
        fun registeredTime(registeredTime: java.time.OffsetDateTime) = apply { this.registeredTime = registeredTime }
        fun activeFlag(activeFlag: kotlin.Boolean) = apply { this.activeFlag = activeFlag }
        fun accountRole(accountRole: AccountTakeoverCustomerAccount.AccountRole) = apply { this.accountRole = accountRole }
        fun name(name: AccountTakeoverName) = apply { this.name = name }
        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }
        fun address(address: CustomerAccountAddress) = apply { this.address = address }
        fun loyaltyMemberId(loyaltyMemberId: kotlin.String) = apply { this.loyaltyMemberId = loyaltyMemberId }

        fun build(): AccountTakeoverCustomerAccount {
            // Check required params
            validateNullity()
            return AccountTakeoverCustomerAccount(
                userId = userId!!,
                accountType = accountType!!,
                username = username!!,
                emailAddress = emailAddress!!,
                registeredTime = registeredTime!!,
                activeFlag = activeFlag!!,
                accountRole = accountRole,
                name = name,
                telephones = telephones,
                address = address,
                loyaltyMemberId = loyaltyMemberId
            )
        }

        private fun validateNullity() {
            if (userId == null) {
                throw NullPointerException("Required parameter userId is missing")
            }
            if (accountType == null) {
                throw NullPointerException("Required parameter accountType is missing")
            }
            if (username == null) {
                throw NullPointerException("Required parameter username is missing")
            }
            if (emailAddress == null) {
                throw NullPointerException("Required parameter emailAddress is missing")
            }
            if (registeredTime == null) {
                throw NullPointerException("Required parameter registeredTime is missing")
            }
            if (activeFlag == null) {
                throw NullPointerException("Required parameter activeFlag is missing")
            }
        }
    }

    /**
     * Identifies the account type of a user''s account. Possible values are: - `INDIVIDUAL` - Applicable if this account is for an individual traveler. - `BUSINESS` - Applicable if this account is for a business or organization account used by suppliers or Partners.
     * Values: INDIVIDUAL,BUSINESS
     */
    enum class AccountType(val value: kotlin.String) {
        @JsonProperty("INDIVIDUAL")
        INDIVIDUAL("INDIVIDUAL"),

        @JsonProperty("BUSINESS")
        BUSINESS("BUSINESS")
    }

    /**
     * Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users.
     * Values: USER,MANAGER,ADMIN
     */
    enum class AccountRole(val value: kotlin.String) {
        @JsonProperty("USER")
        USER("USER"),

        @JsonProperty("MANAGER")
        MANAGER("MANAGER"),

        @JsonProperty("ADMIN")
        ADMIN("ADMIN")
    }
}
