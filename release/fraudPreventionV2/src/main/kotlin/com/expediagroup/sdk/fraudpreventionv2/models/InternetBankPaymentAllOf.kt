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
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param bankId The bank_id provided by the internet bank payment(IBP) provider (DRWP aka NetGiro) for the bank used for processing the payment.
 * @param bankBranchCode A code that identifies the bank branch for internet bank payment(IBP).
 * @param telephones Telephone(s) associated with internet bank payment(IBP) provider.
 */
data class InternetBankPaymentAllOf(
    /* The bank_id provided by the internet bank payment(IBP) provider (DRWP aka NetGiro) for the bank used for processing the payment. */
    @JsonProperty("bank_id")
    @field:Length(max = 15)
    @field:Valid
    val bankId: kotlin.String,

    /* A code that identifies the bank branch for internet bank payment(IBP). */
    @JsonProperty("bank_branch_code")
    @field:Length(max = 15)
    @field:Valid
    val bankBranchCode: kotlin.String,

    /* Telephone(s) associated with internet bank payment(IBP) provider. */
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
        private var bankId: kotlin.String? = null,
        private var bankBranchCode: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null
    ) {
        fun bankId(bankId: kotlin.String) = apply { this.bankId = bankId }
        fun bankBranchCode(bankBranchCode: kotlin.String) = apply { this.bankBranchCode = bankBranchCode }
        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }

        fun build(): InternetBankPaymentAllOf {
            // Check required params
            validateNullity()
            return InternetBankPaymentAllOf(
                bankId = bankId!!,
                bankBranchCode = bankBranchCode!!,
                telephones = telephones!!
            )
        }

        private fun validateNullity() {
            if (bankId == null) {
                throw NullPointerException("Required parameter bankId is missing")
            }
            if (bankBranchCode == null) {
                throw NullPointerException("Required parameter bankBranchCode is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }
}
