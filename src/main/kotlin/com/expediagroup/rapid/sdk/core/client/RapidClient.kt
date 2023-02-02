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
package com.expediagroup.rapid.sdk.core.client

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.client.finalize
import com.expediagroup.common.sdk.core.constant.Constant
import com.expediagroup.common.sdk.core.model.error.rapid.RapidError
import com.expediagroup.common.sdk.core.model.exception.rapid.RapidServiceException
import com.expediagroup.common.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import com.expediagroup.rapid.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.rapid.sdk.core.configuration.RapidConfigrator
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
    clientConfiguration: RapidClientConfiguration,
    httpClientEngine: HttpClientEngine = Constant.DEFAULT_HTTP_CLIENT_ENGINE
) : Client(clientConfiguration, httpClientEngine) {
    private val _httpClient: HttpClient = buildHttpClient(AuthenticationStrategy.AuthenticationType.SIGNATURE)

    init {
        finalize()
    }

    override val httpClient: HttpClient
        get() = _httpClient

    override suspend fun throwServiceException(response: HttpResponse) {
        runCatching {
            response.body<RapidError>()
        }.onSuccess {
            throw RapidServiceException(response.status, it)
        }.onFailure {
            throw RapidServiceException(
                response.status,
                RapidError(response.request.url.toURI().toString(), response.status.description)
            )
        }
    }

    companion object {

        /** Creates a new RapidClient instance. */
        @JvmStatic
        fun builder() = RapidConfigrator()
    }
}
