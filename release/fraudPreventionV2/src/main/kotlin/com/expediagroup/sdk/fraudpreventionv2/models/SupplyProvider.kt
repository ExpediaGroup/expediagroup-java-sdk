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

/**
 *
 * @param name This field provides name of the partner involved in offering the activity.
 * @param type This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity.
 * @param vendorName This field describes the name of the third-party vendor who provided the supply provider or the operating company with the activity.
 */
data class SupplyProvider(
    // This field provides name of the partner involved in offering the activity.
    @JsonProperty("name")
    @field:Length(max = 200)
    @field:Valid
    val name: kotlin.String,
    // This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity.
    @JsonProperty("type")
    val type: SupplyProvider.Type,
    // This field describes the name of the third-party vendor who provided the supply provider or the operating company with the activity.
    @JsonProperty("vendor_name")
    @field:Length(max = 200)
    @field:Valid
    val vendorName: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var name: kotlin.String? = null,
        private var type: SupplyProvider.Type? = null,
        private var vendorName: kotlin.String? = null
    ) {
        fun name(name: kotlin.String) = apply { this.name = name }

        fun type(type: SupplyProvider.Type) = apply { this.type = type }

        fun vendorName(vendorName: kotlin.String?) = apply { this.vendorName = vendorName }

        fun build(): SupplyProvider {
            // Check required params
            validateNullity()
            return SupplyProvider(
                name = name!!,
                type = type!!,
                vendorName = vendorName
            )
        }

        private fun validateNullity() {
            if (name == null) {
                throw NullPointerException("Required parameter name is missing")
            }
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
        }
    }

    /**
     * This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity.
     * Values: THIRD_PARTY,DIRECT
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("THIRD_PARTY")
        THIRD_PARTY("THIRD_PARTY"),

        @JsonProperty("DIRECT")
        DIRECT("DIRECT")
    }
}
