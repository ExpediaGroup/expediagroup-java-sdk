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
package com.expediagroup.openworld.sdk.core.client

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.client.finalize
import com.expediagroup.common.sdk.core.configuration.ClientConfiguration
import com.expediagroup.common.sdk.core.model.error.Error
import com.expediagroup.common.sdk.core.model.exception.service.OpenWorldServiceException
import com.expediagroup.common.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.toURI

/**
 * The integration point between the SDK Core and the product SDKs.
 *
 * @param httpClientEngine The HTTP client engine to use.
 * @param clientConfiguration The configuration for the client.
 */
class RapidClient(
    httpClientEngine: HttpClientEngine,
    clientConfiguration: ClientConfiguration
) : Client(httpClientEngine, clientConfiguration) {
    private val _httpClient: HttpClient = buildHttpClient(AuthenticationStrategy.AuthenticationType.SIGNATURE)

    init {
        finalize()
    }

    override val httpClient: HttpClient
        get() = _httpClient

    override suspend fun throwServiceException(response: HttpResponse) {
        runCatching {
            response.body<Error>()
        }.onSuccess {
            throw OpenWorldServiceException(response.status, it)
        }.onFailure {
            throw OpenWorldServiceException(
                response.status,
                Error(response.request.url.toURI(), response.status.description)
            )
        }
    }
}
