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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Amount
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentOutcome
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.VerificationType

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * A verify operation represents the intent to verify the payment associated with this transaction.
 * @param id 
 * @param amount 
 * @param outcome 
 * @param type 
 */
data class Verify(
    @JsonProperty("id")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val id: kotlin.String? = null,

    @JsonProperty("amount")

    
    
    
    
    @field:Valid
    val amount: Amount? = null,

    @JsonProperty("outcome")

    
    
    
    
    @field:Valid
    val outcome: PaymentOutcome? = null,

    @JsonProperty("type")

    
    
    
    
    @field:Valid
    val type: VerificationType? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var amount: Amount? = null,
        private var outcome: PaymentOutcome? = null,
        private var type: VerificationType? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }
        fun amount(amount: Amount) = apply { this.amount = amount }
        fun outcome(outcome: PaymentOutcome) = apply { this.outcome = outcome }
        fun type(type: VerificationType) = apply { this.type = type }

        fun build(): Verify {
            return Verify(
                id = id,
                amount = amount,
                outcome = outcome,
                type = type
            )
        }

    }
}

