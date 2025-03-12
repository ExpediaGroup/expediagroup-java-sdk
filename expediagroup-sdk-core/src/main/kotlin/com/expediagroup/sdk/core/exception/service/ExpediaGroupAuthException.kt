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
package com.expediagroup.sdk.core.exception.service

import com.expediagroup.sdk.core.http.Status
import java.util.UUID

/**
 * An exception that is thrown when an authentication error occurs.
 *
 * @param requestId The ID of the auth request.
 * @param message The error message.
 * @param cause The cause of the error.
 */

class ExpediaGroupAuthException(
    requestId: UUID? = null,
    message: String? = null,
    cause: Throwable? = null
) : ExpediaGroupServiceException(requestId, message, cause) {
    /**
     * An exception that is thrown when an authentication error occurs.
     *
     * @param requestId The ID of the auth request.
     * @param status The HTTP status of the error.
     * @param message The error message.
     */
    constructor(
        requestId: UUID,
        status: Status,
        message: String
    ) : this(requestId, message = "[${status.code}] $message")

    /**
     * An exception that is thrown when an authentication error occurs.
     *
     * @param requestId The ID of the auth request.
     * @param status The HTTP status of the error (as an integer).
     * @param message The error message.
     */
    constructor(
        requestId: UUID,
        status: Int,
        message: String
    ) : this(requestId, Status.fromCode(status), message)
}
