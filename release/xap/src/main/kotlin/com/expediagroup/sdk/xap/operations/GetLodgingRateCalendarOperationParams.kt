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
 * @property ecomHotelId The Expedia hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both.
 * @property hcomHotelId The Hotel.com hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both.
 * @property startDate Start date for check-in search range in an ISO 8601 Date format [YYYY-MM-DD].  **Note**: The start date may not be in the past.
 * @property endDate End date for check-in search range in an ISO 8601 Date format [YYYY-MM-DD].  **Note**: The end date must be after the start date. The maximum supported search range is 180 days.
 * @property lengthOfStay The length of stay to retrieve the lowest price for.
 * @property currency The requested currency expressed according to ISO 4217.
 */
data class GetLodgingRateCalendarOperationParams(
    val partnerTransactionId: kotlin.String,
    val ecomHotelId: kotlin.String? =
        null,
    val hcomHotelId: kotlin.String? =
        null,
    val startDate: java.time.LocalDate,
    val endDate: java.time.LocalDate,
    val lengthOfStay: kotlin.Int? =
        1,
    val currency: kotlin.String? =
        null
) :
    OperationParams {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var partnerTransactionId: kotlin.String? = null,
        private var ecomHotelId: kotlin.String? = null,
        private var hcomHotelId: kotlin.String? = null,
        private var startDate: java.time.LocalDate? = null,
        private var endDate: java.time.LocalDate? = null,
        private var lengthOfStay: kotlin.Int? = null,
        private var currency: kotlin.String? = null
    ) {
        /**
         * @param partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
         */
        fun partnerTransactionId(partnerTransactionId: kotlin.String) = apply { this.partnerTransactionId = partnerTransactionId }

        /**
         * @param ecomHotelId The Expedia hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both.
         */
        fun ecomHotelId(ecomHotelId: kotlin.String) = apply { this.ecomHotelId = ecomHotelId }

        /**
         * @param hcomHotelId The Hotel.com hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both.
         */
        fun hcomHotelId(hcomHotelId: kotlin.String) = apply { this.hcomHotelId = hcomHotelId }

        /**
         * @param startDate Start date for check-in search range in an ISO 8601 Date format [YYYY-MM-DD].  **Note**: The start date may not be in the past.
         */
        fun startDate(startDate: java.time.LocalDate) = apply { this.startDate = startDate }

        /**
         * @param endDate End date for check-in search range in an ISO 8601 Date format [YYYY-MM-DD].  **Note**: The end date must be after the start date. The maximum supported search range is 180 days.
         */
        fun endDate(endDate: java.time.LocalDate) = apply { this.endDate = endDate }

        /**
         * @param lengthOfStay The length of stay to retrieve the lowest price for.
         */
        fun lengthOfStay(lengthOfStay: kotlin.Int) = apply { this.lengthOfStay = lengthOfStay }

        /**
         * @param currency The requested currency expressed according to ISO 4217.
         */
        fun currency(currency: kotlin.String) = apply { this.currency = currency }

        fun build(): GetLodgingRateCalendarOperationParams {
            validateNullity()

            return GetLodgingRateCalendarOperationParams(
                partnerTransactionId = partnerTransactionId!!,
                ecomHotelId = ecomHotelId,
                hcomHotelId = hcomHotelId,
                startDate = startDate!!,
                endDate = endDate!!,
                lengthOfStay = lengthOfStay,
                currency = currency
            )
        }

        private fun validateNullity() {
            if (partnerTransactionId == null) {
                throw NullPointerException("Required parameter partnerTransactionId is missing")
            }
            if (startDate == null) {
                throw NullPointerException("Required parameter startDate is missing")
            }
            if (endDate == null) {
                throw NullPointerException("Required parameter endDate is missing")
            }
        }
    }

    override fun getHeaders(): Map<String, String> {
        return buildMap {
            partnerTransactionId?.also {
                put("Partner-Transaction-Id", partnerTransactionId)
            }
            put("Accept", "application/vnd.exp-hotel.v3+json")
        }
    }

    override fun getQueryParams(): Map<String, Iterable<String>> {
        return buildMap {
            ecomHotelId?.also {
                put(
                    "ecomHotelId",
                    listOf(ecomHotelId)
                )
            }
            hcomHotelId?.also {
                put(
                    "hcomHotelId",
                    listOf(hcomHotelId)
                )
            }
            startDate?.also {
                put(
                    "startDate",
                    listOf(startDate.toString())
                )
            }
            endDate?.also {
                put(
                    "endDate",
                    listOf(endDate.toString())
                )
            }
            lengthOfStay?.also {
                put(
                    "lengthOfStay",
                    listOf(lengthOfStay.toString())
                )
            }
            currency?.also {
                put(
                    "currency",
                    listOf(currency)
                )
            }
        }
    }

    override fun getPathParams(): Map<String, String> {
        return buildMap {
        }
    }
}
