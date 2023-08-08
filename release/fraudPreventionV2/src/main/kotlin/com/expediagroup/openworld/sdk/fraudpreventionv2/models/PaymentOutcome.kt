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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.PaymentStatus

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
 * 
 * @param status 
 * @param code A mnemonic code for the payment processing.
 * @param description A short description providing additional explanation regarding the mnemonic code.
 */
data class PaymentOutcome(
    @JsonProperty("status")

    
    
    
    
    @field:Valid
    val status: PaymentStatus? = null,

    /* A mnemonic code for the payment processing. */
@JsonProperty("code")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val code: kotlin.String? = null,

    /* A short description providing additional explanation regarding the mnemonic code. */
@JsonProperty("description")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val description: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var status: PaymentStatus? = null,
        private var code: kotlin.String? = null,
        private var description: kotlin.String? = null
    ) {
        fun status(status: PaymentStatus) = apply { this.status = status }
        fun code(code: kotlin.String) = apply { this.code = code }
        fun description(description: kotlin.String) = apply { this.description = description }

        fun build(): PaymentOutcome {
            return PaymentOutcome(
                status = status,
                code = code,
                description = description
            )
        }

    }
}

