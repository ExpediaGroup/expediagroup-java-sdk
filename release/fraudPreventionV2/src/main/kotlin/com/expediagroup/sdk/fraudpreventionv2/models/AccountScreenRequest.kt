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
 * Information for account screening by Expedia's Fraud Prevention Service.
 * @param transaction
 */
data class AccountScreenRequest(
    @JsonProperty("transaction")
    @field:Valid
    val transaction: AccountTransaction
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var transaction: AccountTransaction? = null
    ) {
        fun transaction(transaction: AccountTransaction) = apply { this.transaction = transaction }

        fun build(): AccountScreenRequest {
            // Check required params
            validateNullity()
            return AccountScreenRequest(
                transaction = transaction!!
            )
        }

        private fun validateNullity() {
            if (transaction == null) {
                throw NullPointerException("Required parameter transaction is missing")
            }
        }
    }
}
