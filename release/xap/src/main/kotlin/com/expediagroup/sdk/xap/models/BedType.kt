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
/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.expediagroup.sdk.xap.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * Statement of bed types available for this offer. A room may have several bed type options available.  **NOTE**: due to the large number of bed type options available, we no longer publish a list of available bed types. More information is available in [Lodging Bed Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/bed-types).
 * @param id The bed type ID
 * @param description The bed type description.
 */
data class BedType(
    // The bed type ID
    @JsonProperty("Id")
    @field:Valid
    val id: kotlin.String,
    // The bed type description.
    @JsonProperty("Description")
    @field:Valid
    val description: kotlin.String
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var description: kotlin.String? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }

        fun description(description: kotlin.String) = apply { this.description = description }

        fun build(): BedType {
            // Check required params
            validateNullity()
            return BedType(
                id = id!!,
                description = description!!
            )
        }

        private fun validateNullity() {
            if (id == null) {
                throw NullPointerException("Required parameter id is missing")
            }
            if (description == null) {
                throw NullPointerException("Required parameter description is missing")
            }
        }
    }
}
