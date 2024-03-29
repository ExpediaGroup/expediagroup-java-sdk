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
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Pattern

/**
 *
 * @param `value` The amount required in payment for the product/order in local currency (including any taxes and fees).
 * @param currencyCode The ISO  alpha-3 country code for the amount currency.
 */
data class Amount(
    // The amount required in payment for the product/order in local currency (including any taxes and fees).
    @JsonProperty("value")
    val `value`: kotlin.Double,
    // The ISO  alpha-3 country code for the amount currency.
    @JsonProperty("currency_code")
    @field:Pattern(regexp = "^[A-Z]{3}$")
    @field:Length(max = 3)
    @field:Valid
    val currencyCode: kotlin.String
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var `value`: kotlin.Double? = null,
        private var currencyCode: kotlin.String? = null
    ) {
        fun `value`(`value`: kotlin.Double) = apply { this.`value` = `value` }

        fun currencyCode(currencyCode: kotlin.String) = apply { this.currencyCode = currencyCode }

        fun build(): Amount {
            // Check required params
            validateNullity()
            return Amount(
                `value` = `value`!!,
                currencyCode = currencyCode!!
            )
        }

        private fun validateNullity() {
            if (`value` == null) {
                throw NullPointerException("Required parameter `value` is missing")
            }
            if (currencyCode == null) {
                throw NullPointerException("Required parameter currencyCode is missing")
            }
        }
    }
}
