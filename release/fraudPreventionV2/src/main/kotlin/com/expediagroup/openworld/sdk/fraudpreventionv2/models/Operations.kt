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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Authorize
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.AuthorizeReversal
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Capture
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Refund
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Verify

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
 * All operations related to a payment throughout its lifespan. An operation represents an event external to Fraud Prevention Service that specifies to perform a payment operation. Possible operation types include:  - `Verify`  - `Authorize`  - `AuthorizeReversal`  - `Capture`  - `Refund` 
 * @param verify 
 * @param authorize 
 * @param authorizeReversal 
 * @param capture 
 * @param refunds 
 */
data class Operations(
    @JsonProperty("verify")

    
    
    
    
    @field:Valid
    val verify: Verify? = null,

    @JsonProperty("authorize")

    
    
    
    
    @field:Valid
    val authorize: Authorize? = null,

    @JsonProperty("authorize_reversal")

    
    
    
    
    @field:Valid
    val authorizeReversal: AuthorizeReversal? = null,

    @JsonProperty("capture")

    
    
    
    
    @field:Valid
    val capture: Capture? = null,

    @JsonProperty("refunds")

    
    @field:Size(max = 20)
    
    
    @field:Valid
    val refunds: kotlin.collections.List<Refund>? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var verify: Verify? = null,
        private var authorize: Authorize? = null,
        private var authorizeReversal: AuthorizeReversal? = null,
        private var capture: Capture? = null,
        private var refunds: kotlin.collections.List<Refund>? = null
    ) {
        fun verify(verify: Verify) = apply { this.verify = verify }
        fun authorize(authorize: Authorize) = apply { this.authorize = authorize }
        fun authorizeReversal(authorizeReversal: AuthorizeReversal) = apply { this.authorizeReversal = authorizeReversal }
        fun capture(capture: Capture) = apply { this.capture = capture }
        fun refunds(refunds: kotlin.collections.List<Refund>) = apply { this.refunds = refunds }

        fun build(): Operations {
            return Operations(
                verify = verify,
                authorize = authorize,
                authorizeReversal = authorizeReversal,
                capture = capture,
                refunds = refunds
            )
        }

    }
}

