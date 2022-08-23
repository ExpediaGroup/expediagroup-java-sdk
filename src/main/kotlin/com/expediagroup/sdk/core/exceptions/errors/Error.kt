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
package com.expediagroup.sdk.core.exceptions.errors

/**
 * The object used to describe an error, containing both human-readable and in a machine-readable information.
 * @param type A URI reference, compliant with the standard EG error type format, which identifies the error type. It provides a machine-readable identifier for the error type. The error type will be aligned with the HTTP status code of the response. The URI can either be absolute or relative to the API's base URI. When dereferenced, it can also provide human-readable documentation for the error type.
 * @param detail A human-readable explanation of the error, specific to this error occurrence.
 * @param causes An array of cause objects, that identify the specific causes of the error.
 */
data class Error(
    /* A URI reference, compliant with the standard EG error type format, which identifies the error type. It provides a machine-readable identifier for the error type. The error type will be aligned with the HTTP status code of the response. The URI can either be absolute or relative to the API's base URI. When dereferenced, it can also provide human-readable documentation for the error type.  */
    val type: java.net.URI,
    /* A human-readable explanation of the error, specific to this error occurrence. */
    val detail: String,
    /* An array of cause objects, that identify the specific causes of the error. */
    val causes: List<ErrorCause>? = null
)
