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

import com.expediagroup.sdk.xap.models.CarLocationOption
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * Container for error list.
 * @param code Error code describing the issue
 * @param description A simple description of what the error is.
 * @param detailCode Detailed error code describing the issue.
 * @param locationKeyword The requested location that caused the error.
 * @param locationOptions List for possible locations from which the customer must choose the best one to be re-submitted in the request.
 */
data class CarError(
    // Error code describing the issue
    @JsonProperty("Code")
    @field:Valid
    val code: kotlin.String,
    // A simple description of what the error is.
    @JsonProperty("Description")
    @field:Valid
    val description: kotlin.String,
    // Detailed error code describing the issue.
    @JsonProperty("DetailCode")
    @field:Valid
    val detailCode: kotlin.String? = null,
    // The requested location that caused the error.
    @JsonProperty("LocationKeyword")
    @field:Valid
    val locationKeyword: kotlin.String? = null,
    // List for possible locations from which the customer must choose the best one to be re-submitted in the request.
    @JsonProperty("LocationOptions")
    @field:Valid
    val locationOptions: kotlin.collections.List<CarLocationOption>? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var code: kotlin.String? = null,
        private var description: kotlin.String? = null,
        private var detailCode: kotlin.String? = null,
        private var locationKeyword: kotlin.String? = null,
        private var locationOptions: kotlin.collections.List<CarLocationOption>? = null
    ) {
        fun code(code: kotlin.String) = apply { this.code = code }

        fun description(description: kotlin.String) = apply { this.description = description }

        fun detailCode(detailCode: kotlin.String?) = apply { this.detailCode = detailCode }

        fun locationKeyword(locationKeyword: kotlin.String?) = apply { this.locationKeyword = locationKeyword }

        fun locationOptions(locationOptions: kotlin.collections.List<CarLocationOption>?) = apply { this.locationOptions = locationOptions }

        fun build(): CarError {
            // Check required params
            validateNullity()
            return CarError(
                code = code!!,
                description = description!!,
                detailCode = detailCode,
                locationKeyword = locationKeyword,
                locationOptions = locationOptions
            )
        }

        private fun validateNullity() {
            if (code == null) {
                throw NullPointerException("Required parameter code is missing")
            }
            if (description == null) {
                throw NullPointerException("Required parameter description is missing")
            }
        }
    }

    fun toBuilder() =
        Builder(
            code = code!!,
            description = description!!,
            detailCode = detailCode,
            locationKeyword = locationKeyword,
            locationOptions = locationOptions
        )
}
