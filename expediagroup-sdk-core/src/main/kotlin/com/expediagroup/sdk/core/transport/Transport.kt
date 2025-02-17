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

package com.expediagroup.sdk.core.transport

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response

/**
 * A transport layer interface that adapts different HTTP client libraries to work with the SDK.
 *
 * This interface serves as an abstraction layer between the SDK and the underlying HTTP client,
 * allowing users to integrate their preferred HTTP client library while maintaining consistent
 * behavior across the SDK. Implementers are responsible for:
 *
 * 1. Converting SDK request/response models to their HTTP client's models
 * 2. Handling HTTP client-specific configuration and setup
 * 3. Managing resources and connections appropriately
 *
 * Example implementation using OkHttp:
 * ```
 * class OkHttpTransport(private val client: OkHttpClient) : Transport {
 *     override fun execute(request: Request): Response {
 *         val okHttpRequest = request.toOkHttpRequest()
 *         return client.newCall(okHttpRequest).execute().toSdkResponse()
 *     }
 * }
 * ```
 *
 * @see [Request]
 * @see [Response]
 */
interface Transport : Disposable {
    /**
     * Executes an HTTP request synchronously.
     *
     * This method should:
     * - Convert the SDK request to the HTTP client's request format
     * - Execute the request using the underlying HTTP client
     * - Convert the HTTP client's response to the SDK response format
     *
     * @param request The SDK request to execute
     * @return The response from the server wrapped in the SDK response model
     */
    fun execute(request: Request): Response
}
