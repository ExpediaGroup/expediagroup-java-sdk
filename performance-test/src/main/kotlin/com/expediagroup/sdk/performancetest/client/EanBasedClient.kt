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

package com.expediagroup.sdk.performancetest.client

import com.expediagroup.sdk.core.client.BaseRapidClient
import com.expediagroup.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.sdk.core.model.EmptyResponse
import com.expediagroup.sdk.core.model.Nothing
import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.core.model.exception.handle
import com.expediagroup.sdk.performancetest.common.PerformanceTestClient
import com.expediagroup.sdk.performancetest.common.model.Message
import com.expediagroup.sdk.performancetest.common.operation.DownloadFileOperation
import com.expediagroup.sdk.performancetest.common.operation.GetMessageOperation
import com.expediagroup.sdk.performancetest.common.operation.PostMessageOperation
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.io.InputStream
import java.util.concurrent.CompletableFuture

class EanBasedClient(
    clientConfiguration: RapidClientConfiguration
) : PerformanceTestClient, BaseRapidClient(
    namespace = "ean",
    clientConfiguration = clientConfiguration
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    private suspend inline fun <reified RequestType> executeHttpRequest(operation: Operation<RequestType>): HttpResponse {
        return httpClient.request {
            method = HttpMethod.parse(operation.method)
            url(operation.url)

            operation.params?.getHeaders()?.let {
                headers.appendAll(it)
            }

            operation.params?.getQueryParams()?.let {
                url.parameters.appendAll(it)
            }

            contentType(ContentType.Application.Json)
            setBody(operation.requestBody)
        }
    }

    private inline fun <reified RequestType> executeAsyncWithEmptyResponse(operation: Operation<RequestType>): CompletableFuture<EmptyResponse> {
        return GlobalScope.future(Dispatchers.IO) {
            try {
                val response = executeHttpRequest(operation)
                throwIfError(response, operation.operationId)
                EmptyResponse(response.status.value, response.headers.entries())
            } catch (exception: Exception) {
                exception.handle()
            }
        }
    }

    private inline fun <reified RequestType, reified ResponseType> execute(operation: Operation<RequestType>): Response<ResponseType> {
        try {
            return executeAsync<RequestType, ResponseType>(operation).get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    private inline fun <reified RequestType, reified ResponseType> executeAsync(operation: Operation<RequestType>): CompletableFuture<Response<ResponseType>> {
        return GlobalScope.future(Dispatchers.IO) {
            try {
                val response = executeHttpRequest(operation)
                throwIfError(response, operation.operationId)
                Response(response.status.value, response.body<ResponseType>(), response.headers.entries())
            } catch (exception: Exception) {
                exception.handle()
            }
        }
    }

    override fun execute(operation: DownloadFileOperation): Response<InputStream> {
        return execute<Nothing, InputStream>(operation)
    }

    override fun executeAsync(operation: DownloadFileOperation): CompletableFuture<Response<InputStream>> {
        return executeAsync<Nothing, InputStream>(operation)
    }

    override fun execute(operation: GetMessageOperation): Response<Message> {
        return execute<Nothing, Message>(operation)
    }

    override fun executeAsync(operation: GetMessageOperation): CompletableFuture<Response<Message>> {
        return executeAsync<Nothing, Message>(operation)
    }

    override fun execute(operation: PostMessageOperation): Response<Message> {
        return execute<Message, Message>(operation)
    }

    override fun executeAsync(operation: PostMessageOperation): CompletableFuture<Response<Message>> {
        return executeAsync<Message, Message>(operation)
    }

    override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
        throw Exception("Service exception occurred for operation $operationId with status code ${response.status.value}")
    }

    class Builder : BaseRapidClient.Builder<Builder>() {
        override fun build() =
            EanBasedClient(
                RapidClientConfiguration(key, secret, endpoint, requestTimeout, connectionTimeout, socketTimeout, maskedLoggingHeaders, maskedLoggingBodyFields)
            )
    }
}
