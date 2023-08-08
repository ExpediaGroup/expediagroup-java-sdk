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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * Payment ThreeDS criteria attributes.
 * @param probableFlag This is a flag passed that indicates that this transaction could potentially go through 3DS.
 * @param transactionModel Model used to process payment transaction.
 */
data class PaymentThreeDSCriteria(
    /* This is a flag passed that indicates that this transaction could potentially go through 3DS. */
@JsonProperty("probable_flag")

    
    
    
    
    @field:Valid
    val probableFlag: kotlin.Boolean? = null,

    /* Model used to process payment transaction. */
@JsonProperty("transaction_model")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val transactionModel: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var probableFlag: kotlin.Boolean? = null,
        private var transactionModel: kotlin.String? = null
    ) {
        fun probableFlag(probableFlag: kotlin.Boolean) = apply { this.probableFlag = probableFlag }
        fun transactionModel(transactionModel: kotlin.String) = apply { this.transactionModel = transactionModel }

        fun build(): PaymentThreeDSCriteria {
            return PaymentThreeDSCriteria(
                probableFlag = probableFlag,
                transactionModel = transactionModel
            )
        }

    }
}

