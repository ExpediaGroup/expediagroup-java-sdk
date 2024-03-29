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

/**
 *
 * @param refundStatus Identifies the refund status. Possible values are: -`ISSUED` - The refund was issued. -`SETTLED` - The refund was settled.
 */
data class RefundUpdateAllOf(
    // Identifies the refund status. Possible values are: -`ISSUED` - The refund was issued. -`SETTLED` - The refund was settled.
    @JsonProperty("refund_status")
    val refundStatus: RefundUpdateAllOf.RefundStatus
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var refundStatus: RefundUpdateAllOf.RefundStatus? = null
    ) {
        fun refundStatus(refundStatus: RefundUpdateAllOf.RefundStatus) = apply { this.refundStatus = refundStatus }

        fun build(): RefundUpdateAllOf {
            // Check required params
            validateNullity()
            return RefundUpdateAllOf(
                refundStatus = refundStatus!!
            )
        }

        private fun validateNullity() {
            if (refundStatus == null) {
                throw NullPointerException("Required parameter refundStatus is missing")
            }
        }
    }

    /**
     * Identifies the refund status. Possible values are: -`ISSUED` - The refund was issued. -`SETTLED` - The refund was settled.
     * Values: ISSUED,SETTLED
     */
    enum class RefundStatus(val value: kotlin.String) {
        @JsonProperty("ISSUED")
        ISSUED("ISSUED"),

        @JsonProperty("SETTLED")
        SETTLED("SETTLED")
    }
}
