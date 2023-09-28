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
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Authorize Reversal operation on the payment. An authorize reversal operation represents a notification received usually from a 3rd party payment processor to indicate that an authorization hold should be released as a result of a sale being partially or completely cancelled.
 * @param id
 * @param amount
 * @param outcome
 */
data class AuthorizeReversal(
    @JsonProperty("id")

    @field:Length(max = 200)

    @field:Valid
    val id: kotlin.String? = null,

    @JsonProperty("amount")
    @field:Valid
    val amount: Amount? = null,

    @JsonProperty("outcome")
    @field:Valid
    val outcome: PaymentOutcome? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var amount: Amount? = null,
        private var outcome: PaymentOutcome? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }
        fun amount(amount: Amount) = apply { this.amount = amount }
        fun outcome(outcome: PaymentOutcome) = apply { this.outcome = outcome }

        fun build(): AuthorizeReversal {
            return AuthorizeReversal(
                id = id,
                amount = amount,
                outcome = outcome
            )
        }
    }
}
