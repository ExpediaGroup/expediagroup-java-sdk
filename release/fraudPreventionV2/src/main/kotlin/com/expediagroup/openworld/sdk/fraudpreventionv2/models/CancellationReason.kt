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
 * Reason of order update cancellation.
 * @param primaryReasonCode Primary cancellation reason code.
 * @param subReasonCode Substitute cancellation reason code.
 * @param primaryReasonDescription Primary cancellation reason code. Required if `order_status = CANCELLED`.
 * @param subReasonDescription Substitute cancellation reason description.
 */
data class CancellationReason(
    /* Primary cancellation reason code. */
@JsonProperty("primary_reason_code")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val primaryReasonCode: kotlin.String? = null,

    /* Substitute cancellation reason code. */
@JsonProperty("sub_reason_code")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val subReasonCode: kotlin.String? = null,

    /* Primary cancellation reason code. Required if `order_status = CANCELLED`. */
@JsonProperty("primary_reason_description")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val primaryReasonDescription: kotlin.String? = null,

    /* Substitute cancellation reason description. */
@JsonProperty("sub_reason_description")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val subReasonDescription: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var primaryReasonCode: kotlin.String? = null,
        private var subReasonCode: kotlin.String? = null,
        private var primaryReasonDescription: kotlin.String? = null,
        private var subReasonDescription: kotlin.String? = null
    ) {
        fun primaryReasonCode(primaryReasonCode: kotlin.String) = apply { this.primaryReasonCode = primaryReasonCode }
        fun subReasonCode(subReasonCode: kotlin.String) = apply { this.subReasonCode = subReasonCode }
        fun primaryReasonDescription(primaryReasonDescription: kotlin.String) = apply { this.primaryReasonDescription = primaryReasonDescription }
        fun subReasonDescription(subReasonDescription: kotlin.String) = apply { this.subReasonDescription = subReasonDescription }

        fun build(): CancellationReason {
            return CancellationReason(
                primaryReasonCode = primaryReasonCode,
                subReasonCode = subReasonCode,
                primaryReasonDescription = primaryReasonDescription,
                subReasonDescription = subReasonDescription
            )
        }

    }
}

