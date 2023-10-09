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
 *
 * @param routingNumber A code that identifies the financial institution for a specific bank account.
 * @param accountNumber Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument.
 * @param telephones Telephone(s) associated with direct debit payment provider.
 */
data class DirectDebitAllOf(
    /* A code that identifies the financial institution for a specific bank account. */
    @JsonProperty("routing_number")
    @field:Length(max = 15)
    @field:Valid
    val routingNumber: kotlin.String,

    /* Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument. */
    @JsonProperty("account_number")
    @field:Length(max = 100)
    @field:Valid
    val accountNumber: kotlin.String,

    /* Telephone(s) associated with direct debit payment provider. */
    @JsonProperty("telephones")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var routingNumber: kotlin.String? = null,
        private var accountNumber: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null
    ) {
        fun routingNumber(routingNumber: kotlin.String) = apply { this.routingNumber = routingNumber }
        fun accountNumber(accountNumber: kotlin.String) = apply { this.accountNumber = accountNumber }
        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }

        fun build(): DirectDebitAllOf {
            // Check required params
            validateNullity()
            return DirectDebitAllOf(
                routingNumber = routingNumber!!,
                accountNumber = accountNumber!!,
                telephones = telephones!!
            )
        }

        private fun validateNullity() {
            if (routingNumber == null) {
                throw NullPointerException("Required parameter routingNumber is missing")
            }
            if (accountNumber == null) {
                throw NullPointerException("Required parameter accountNumber is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }
}
