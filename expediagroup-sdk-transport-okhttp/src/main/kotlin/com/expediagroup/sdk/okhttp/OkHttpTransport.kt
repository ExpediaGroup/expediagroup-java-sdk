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

package com.expediagroup.sdk.okhttp

import com.expediagroup.sdk.core.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.transport.Transport
import okhttp3.OkHttpClient

/**
 * A transport implementation using OkHttp to execute HTTP requests.
 *
 * This class adapts the OkHttp client to the SDK [Transport] interface, allowing seamless integration
 * between OkHttp's request-response mechanism and the SDK transport layer.
 *
 * @property okHttpClient The OkHttp client used to execute HTTP requests.
 */
class OkHttpTransport(private val okHttpClient: OkHttpClient) : Transport {
    constructor() : this(BaseOkHttpClient.getInstance())

    constructor(configuration: OkHttpClientConfiguration) : this(BaseOkHttpClient.getConfiguredInstance(configuration))

    /**
     * Executes the given SDK request using OkHttp and returns the SDK response.
     *
     * This method converts the provided SDK [Request] into an OkHttp request,
     * executes it using the underlying OkHttp client, and converts the OkHttp response
     * back into an SDK [Response].
     *
     * @param request The SDK request to execute.
     * @return The SDK response resulting from the HTTP request execution.
     * @throws ExpediaGroupNetworkException If an error occurs during the request execution.
     */
    override fun execute(request: Request): Response =
        try {
            request.toOkHttpRequest().let { okHttpClient.newCall(it).execute() }.toSDKResponse(request)
        } catch (e: Exception) {
            throw ExpediaGroupNetworkException(
                requestId = request.id,
                message = "Failed to execute the request",
                cause = e
            )
        }

    override fun dispose() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
    }
}
