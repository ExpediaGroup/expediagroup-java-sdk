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
 * Container for information for the stay dates of the rate plan.
 * @param checkInDate The initial day of the hotel stay in an ISO 8601 Date format [YYYY-MM-DD].
 * @param checkOutDate The final day of the hotel stay in an ISO 8601 Date format [YYYY-MM-DD].
 */
data class StayDates(
    // The initial day of the hotel stay in an ISO 8601 Date format [YYYY-MM-DD].
    @JsonProperty("CheckInDate")
    val checkInDate: java.time.LocalDate,
    // The final day of the hotel stay in an ISO 8601 Date format [YYYY-MM-DD].
    @JsonProperty("CheckOutDate")
    val checkOutDate: java.time.LocalDate
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var checkInDate: java.time.LocalDate? = null,
        private var checkOutDate: java.time.LocalDate? = null
    ) {
        fun checkInDate(checkInDate: java.time.LocalDate) = apply { this.checkInDate = checkInDate }

        fun checkOutDate(checkOutDate: java.time.LocalDate) = apply { this.checkOutDate = checkOutDate }

        fun build(): StayDates {
            // Check required params
            validateNullity()
            return StayDates(
                checkInDate = checkInDate!!,
                checkOutDate = checkOutDate!!
            )
        }

        private fun validateNullity() {
            if (checkInDate == null) {
                throw NullPointerException("Required parameter checkInDate is missing")
            }
            if (checkOutDate == null) {
                throw NullPointerException("Required parameter checkOutDate is missing")
            }
        }
    }
}
