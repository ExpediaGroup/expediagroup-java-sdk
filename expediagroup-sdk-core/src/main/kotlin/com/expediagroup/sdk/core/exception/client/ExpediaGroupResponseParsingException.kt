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

package com.expediagroup.sdk.core.exception.client

/**
 * Exception thrown when the SDK fails to parse a service response.
 *
 * This is a client-side exception that indicates the response was received
 * but could not be properly deserialized into the expected format.
 *
 * @param message A description of the parsing failure
 * @param cause The underlying parsing/mapping exception
 */
class ExpediaGroupResponseParsingException(
    message: String? = null,
    cause: Throwable? = null
) : ExpediaGroupClientException(message, cause)
