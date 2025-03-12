/*
 * Copyright (C) 2024 Expedia, Inc.
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

import java.util.UUID

/**
 * Exception thrown when network-related errors occur during service operations.
 *
 * This exception wraps network-level failures that occur while communicating with
 * Expedia Group services (e.g., connection timeouts, DNS failures, SSL/TLS errors).
 *
 * @param requestId The unique identifier for the request
 * @param message A human-readable description of the network error
 * @param cause The underlying exception that caused this network error
 */

class ExpediaGroupNetworkException(
    requestId: UUID,
    message: String? = null,
    cause: Throwable? = null
) : ExpediaGroupServiceException(requestId, message, cause)
