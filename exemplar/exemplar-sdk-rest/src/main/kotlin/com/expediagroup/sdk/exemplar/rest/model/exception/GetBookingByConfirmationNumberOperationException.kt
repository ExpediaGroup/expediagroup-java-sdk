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
package com.expediagroup.sdk.exemplar.rest.model.exception

import com.expediagroup.sdk.exemplar.rest.model.ProblemDetail
import com.expediagroup.sdk.rest.exception.service.ExpediaGroupApiException
import java.util.UUID

class GetBookingByConfirmationNumber400Exception(
    code: Int = 400,
    val errorResponse: ProblemDetail?,
    requestId: UUID?,
    message: String?,
    cause: Throwable?
) : ExpediaGroupApiException(
    code = code,
    requestId = requestId,
    message = message,
    cause = cause
)
class GetBookingByConfirmationNumber404Exception(
    code: Int = 404,
    val errorResponse: ProblemDetail?,
    requestId: UUID?,
    message: String?,
    cause: Throwable?
) : ExpediaGroupApiException(
    code = code,
    requestId = requestId,
    message = message,
    cause = cause
)
