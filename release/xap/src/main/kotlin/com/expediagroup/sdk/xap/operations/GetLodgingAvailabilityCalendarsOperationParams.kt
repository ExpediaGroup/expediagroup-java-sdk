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
package com.expediagroup.sdk.xap.operations

import com.expediagroup.sdk.core.model.OperationParams

/**
 * @property partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
 * @property propertyIds Comma-separated list of Expedia Property IDs.  The API request supports a maximum of 50 Property IDs in a single request.
 */
data class GetLodgingAvailabilityCalendarsOperationParams(
    val partnerTransactionId: kotlin.String,
    val propertyIds: kotlin.String? =
        null
) :
    OperationParams {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var partnerTransactionId: kotlin.String? = null,
        private var propertyIds: kotlin.String? = null
    ) {
        /**
         * @param partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
         */
        fun partnerTransactionId(partnerTransactionId: kotlin.String) = apply { this.partnerTransactionId = partnerTransactionId }

        /**
         * @param propertyIds Comma-separated list of Expedia Property IDs.  The API request supports a maximum of 50 Property IDs in a single request.
         */
        fun propertyIds(propertyIds: kotlin.String) = apply { this.propertyIds = propertyIds }

        fun build(): GetLodgingAvailabilityCalendarsOperationParams {
            validateNullity()

            return GetLodgingAvailabilityCalendarsOperationParams(
                partnerTransactionId = partnerTransactionId!!,
                propertyIds = propertyIds
            )
        }

        private fun validateNullity() {
            if (partnerTransactionId == null) {
                throw NullPointerException("Required parameter partnerTransactionId is missing")
            }
        }
    }

    override fun getHeaders(): Map<String, String> {
        return buildMap {
            partnerTransactionId?.also {
                put("Partner-Transaction-Id", partnerTransactionId)
            }
            put("Accept", "application/vnd.exp-lodging.v3+json")
        }
    }

    override fun getQueryParams(): Map<String, Iterable<String>> {
        return buildMap {
            propertyIds?.also {
                put(
                    "propertyIds",
                    listOf(propertyIds)
                )
            }
        }
    }

    override fun getPathParams(): Map<String, String> {
        return buildMap {
        }
    }
}
