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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.SettledRefundUpdateDetails

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
 * @param refundDetails 
 */
data class SettledRefundUpdateAllOf(
    @JsonProperty("refund_details")

    
    
    
    
    @field:Valid
    val refundDetails: SettledRefundUpdateDetails? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var refundDetails: SettledRefundUpdateDetails? = null
    ) {
        fun refundDetails(refundDetails: SettledRefundUpdateDetails) = apply { this.refundDetails = refundDetails }

        fun build(): SettledRefundUpdateAllOf {
            return SettledRefundUpdateAllOf(
                refundDetails = refundDetails
            )
        }

    }
}

