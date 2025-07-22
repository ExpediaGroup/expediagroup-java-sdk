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
package com.expediagroup.sdk.exemplar.operation

import com.expediagroup.sdk.exemplar.model.Booking
import com.expediagroup.sdk.exemplar.model.ProblemDetail
import com.expediagroup.sdk.exemplar.model.exception.UpdateBooking400Exception
import com.expediagroup.sdk.exemplar.model.exception.UpdateBooking404Exception
import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.expediagroup.sdk.rest.trait.operation.UrlPathTrait
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.UUID

/**
 * Update booking
 *
 * Update an existing booking
 *
 * Executing the operation returns [com.expediagroup.sdk.rest.model.Response] of type [Booking]
 *
 * The operation may result in the following exceptions:
 * - [UpdateBooking400Exception]
 * - [UpdateBooking404Exception]
 *
 * @property requestBody [Booking]
 * @property params [UpdateBookingOperationParams]
 */
class UpdateBookingOperation(
    private val params: UpdateBookingOperationParams,
    private val requestBody: Booking
) : OperationRequestTrait,
    UrlPathTrait,
    OperationRequestBodyTrait<Booking>,
    JacksonModelOperationResponseBodyTrait<Booking>,
    ContentTypeTrait {
    override fun getOperationId(): String = "updateBooking"

    override fun getHttpMethod(): String = "PUT"

    override fun getRequestInfo(): OperationRequestTrait = this

    override fun getUrlPath(): String {
        var url = "/api/v1/bookings/{confirmationNumber}"

        url =
            url.replace(
                oldValue = "{" + "confirmationNumber" + "}",
                newValue = this.params.confirmationNumber,
                ignoreCase = true
            )

        return url
    }

    override fun getRequestBody(): Booking = requestBody

    override fun getTypeIdentifier(): TypeReference<Booking> = jacksonTypeRef()

    override fun getContentType(): String = "application/json"

    override fun getExceptionForCode(
        code: Int,
        errorResponseStr: String?,
        requestId: UUID?,
        message: String?,
        cause: Throwable?
    ): ExpediaGroupApiException =
        when (code) {
            400 ->
                UpdateBooking400Exception(
                    code = code,
                    requestId = requestId,
                    errorResponse =
                        errorResponseStr?.let {
                            try {
                                com.expediagroup.sdk.exemplar.core.mapper.DefaultObjectMapper.INSTANCE.readValue(errorResponseStr, ProblemDetail::class.java)
                            } catch (e: Exception) {
                                null
                            }
                        },
                    message = message,
                    cause = cause
                )
            404 ->
                UpdateBooking404Exception(
                    code = code,
                    requestId = requestId,
                    errorResponse =
                        errorResponseStr?.let {
                            try {
                                com.expediagroup.sdk.exemplar.core.mapper.DefaultObjectMapper.INSTANCE.readValue(errorResponseStr, ProblemDetail::class.java)
                            } catch (e: Exception) {
                                null
                            }
                        },
                    message = message,
                    cause = cause
                )
            else ->
                ExpediaGroupApiException(
                    code = code,
                    requestId = requestId,
                    message = errorResponseStr,
                    cause = cause
                )
        }
}
