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
 * Data that describes issued refund that should be updated.
 * @param refundIssuedDateTime Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has issued at the participating financial institutions.
 * @param refundIssuedAmount 
 */
data class IssuedRefundUpdateDetails(
    /* Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has issued at the participating financial institutions. */
@JsonProperty("refund_issued_date_time")

    val refundIssuedDateTime: java.time.OffsetDateTime,

    @JsonProperty("refund_issued_amount")

    
    
    
    
    @field:Valid
    val refundIssuedAmount: Amount
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var refundIssuedDateTime: java.time.OffsetDateTime? = null,
        private var refundIssuedAmount: Amount? = null
    ) {
        fun refundIssuedDateTime(refundIssuedDateTime: java.time.OffsetDateTime) = apply { this.refundIssuedDateTime = refundIssuedDateTime }
        fun refundIssuedAmount(refundIssuedAmount: Amount) = apply { this.refundIssuedAmount = refundIssuedAmount }

        fun build(): IssuedRefundUpdateDetails {
            // Check required params
            validateNullity()
            return IssuedRefundUpdateDetails(
                refundIssuedDateTime = refundIssuedDateTime!!,
                refundIssuedAmount = refundIssuedAmount!!
            )
        }

        private fun validateNullity() {
            if (refundIssuedDateTime == null) {
                throw NullPointerException("Required parameter refundIssuedDateTime is missing")
            }
            if (refundIssuedAmount == null) {
                throw NullPointerException("Required parameter refundIssuedAmount is missing")
            }
        }
    }
}

