/**
 * Copyright (C) 2025 Expedia, Inc.
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
package com.expediagroup.sdk.exemplar.model

import com.expediagroup.sdk.core.common.getOrThrow
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Guest information
 * @param firstName First name
 * @param lastName Last name
 * @param email Email address
 * @param phoneNumber Phone number
 */
@ConsistentCopyVisibility data class GuestInfo private constructor(
    // First name
    @JsonProperty("firstName")
    val firstName: kotlin.String,
    // Last name
    @JsonProperty("lastName")
    val lastName: kotlin.String,
    // Email address
    @JsonProperty("email")
    val email: kotlin.String,
    // Phone number
    @JsonProperty("phoneNumber")
    val phoneNumber: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var firstName: kotlin.String? = null,
        private var lastName: kotlin.String? = null,
        private var email: kotlin.String? = null,
        private var phoneNumber: kotlin.String? = null
    ) {
        fun firstName(firstName: kotlin.String) = apply { this.firstName = firstName }

        fun lastName(lastName: kotlin.String) = apply { this.lastName = lastName }

        fun email(email: kotlin.String) = apply { this.email = email }

        fun phoneNumber(phoneNumber: kotlin.String?) = apply { this.phoneNumber = phoneNumber }

        fun build(): GuestInfo {
            val firstName =
                this.firstName.getOrThrow {
                    IllegalArgumentException("firstName must not be null")
                }

            require(firstName?.length ?: 0 >= 1) { "firstName must be at least 1 characters long" }

            val lastName =
                this.lastName.getOrThrow {
                    IllegalArgumentException("lastName must not be null")
                }

            require(lastName?.length ?: 0 >= 1) { "lastName must be at least 1 characters long" }

            val email =
                this.email.getOrThrow {
                    IllegalArgumentException("email must not be null")
                }

            require(email?.length ?: 0 >= 1) { "email must be at least 1 characters long" }

            val instance =
                GuestInfo(
                    firstName = firstName,
                    lastName = lastName,
                    email = email,
                    phoneNumber = phoneNumber
                )

            return instance
        }
    }

    fun toBuilder() =
        Builder(
            firstName = firstName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber
        )
}
