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
import javax.validation.constraints.Size
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param accountNumber Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument.
 * @param telephones Telephone(s) associated with direct debit payment provider.
 * @param routingNumber A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`.
 * @param mandateType The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
 */
data class DirectDebitAllOf(
    // Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument.
    @JsonProperty("account_number")
    @field:Length(max = 100)
    @field:Valid
    val accountNumber: kotlin.String,
    // Telephone(s) associated with direct debit payment provider.
    @JsonProperty("telephones")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>,
    // A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`.
    @JsonProperty("routing_number")
    @field:Length(max = 15)
    @field:Valid
    val routingNumber: kotlin.String? = null,
    // The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
    @JsonProperty("mandate_type")
    val mandateType: DirectDebitAllOf.MandateType? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var accountNumber: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var routingNumber: kotlin.String? = null,
        private var mandateType: DirectDebitAllOf.MandateType? = null
    ) {
        fun accountNumber(accountNumber: kotlin.String) = apply { this.accountNumber = accountNumber }

        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }

        fun routingNumber(routingNumber: kotlin.String?) = apply { this.routingNumber = routingNumber }

        fun mandateType(mandateType: DirectDebitAllOf.MandateType?) = apply { this.mandateType = mandateType }

        fun build(): DirectDebitAllOf {
            // Check required params
            validateNullity()
            return DirectDebitAllOf(
                accountNumber = accountNumber!!,
                telephones = telephones!!,
                routingNumber = routingNumber,
                mandateType = mandateType
            )
        }

        private fun validateNullity() {
            if (accountNumber == null) {
                throw NullPointerException("Required parameter accountNumber is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }

    /**
     * The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING`
     * Values: ONE_OFF,RECURRING
     */
    enum class MandateType(val value: kotlin.String) {
        @JsonProperty("ONE_OFF")
        ONE_OFF("ONE_OFF"),

        @JsonProperty("RECURRING")
        RECURRING("RECURRING")
    }
}
