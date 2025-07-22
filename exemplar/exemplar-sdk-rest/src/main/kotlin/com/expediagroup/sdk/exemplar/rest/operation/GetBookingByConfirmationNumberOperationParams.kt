/**
 * Copyright (C) 2025 Expedia, Inc.
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
package com.expediagroup.sdk.exemplar.rest.operation

import com.expediagroup.sdk.core.common.getOrThrow
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * @property confirmationNumber Booking confirmation number
 */
@JsonDeserialize(builder = GetBookingByConfirmationNumberOperationParams.Builder::class)
@ConsistentCopyVisibility
data class GetBookingByConfirmationNumberOperationParams private constructor(
    val confirmationNumber: kotlin.String
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        @JsonProperty("confirmationNumber") private var confirmationNumber: kotlin.String? = null
    ) {
        /**
         * @param confirmationNumber Booking confirmation number
         */
        fun confirmationNumber(confirmationNumber: kotlin.String) = apply { this.confirmationNumber = confirmationNumber }

        fun build(): GetBookingByConfirmationNumberOperationParams {
            val confirmationNumber =
                this.confirmationNumber.getOrThrow {
                    IllegalArgumentException("confirmationNumber must not be null")
                }

            val params =
                GetBookingByConfirmationNumberOperationParams(
                    confirmationNumber = confirmationNumber
                )
            return params
        }
    }

    fun toBuilder() =
        Builder(
            confirmationNumber = confirmationNumber
        )

    fun getPathParams(): Map<String, String> =
        buildMap {
            confirmationNumber.also {
                put("confirmationNumber", confirmationNumber)
            }
        }
}
