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
 * This field helps to identify and understand the specific provider or operating company involved in offering the activity.
 * @param name This field includes the provider's name.
 * @param type This field indicates the nature or relationship of the vendor associated with a particular activity. | THIRD_PARTY: This value indicates that the vendor is an external entity or third-party provider. | DIRECT: This value signifies that the vendor is a direct entity or provider associated with the organization or platform offering the activity.
 */
data class OperatingCompany(
    /* This field includes the provider's name. */
@JsonProperty("name")

    
    
    
    
    @field:Valid
    val name: kotlin.String,

    /* This field indicates the nature or relationship of the vendor associated with a particular activity. | THIRD_PARTY: This value indicates that the vendor is an external entity or third-party provider. | DIRECT: This value signifies that the vendor is a direct entity or provider associated with the organization or platform offering the activity. */
@JsonProperty("type")

    val type: OperatingCompany.Type
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var name: kotlin.String? = null,
        private var type: OperatingCompany.Type? = null
    ) {
        fun name(name: kotlin.String) = apply { this.name = name }
        fun type(type: OperatingCompany.Type) = apply { this.type = type }

        fun build(): OperatingCompany {
            // Check required params
            validateNullity()
            return OperatingCompany(
                name = name!!,
                type = type!!
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
     * This field indicates the nature or relationship of the vendor associated with a particular activity. | THIRD_PARTY: This value indicates that the vendor is an external entity or third-party provider. | DIRECT: This value signifies that the vendor is a direct entity or provider associated with the organization or platform offering the activity.
     * Values: THIRD_PARTY,DIRECT
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("THIRD_PARTY")
        THIRD_PARTY("THIRD_PARTY"),
        
        @JsonProperty("DIRECT")
        DIRECT("DIRECT");
    }
}

