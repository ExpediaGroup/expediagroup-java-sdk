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
package com.expediagroup.openworld.sdk.core.client.openapi

import com.expediagroup.openworld.sdk.core.client.Client
import com.expediagroup.openworld.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.openworld.sdk.core.model.error.rapid.RapidError
import com.expediagroup.openworld.sdk.core.model.exception.rapid.RapidServiceException
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.toURI

/**
 * Base class for RapidApi used by generated OpenAPI APIs to perform the heavy lifting of actually sending requests.
 */
abstract class RapidOpenApiStub(
    private val clientConfiguration: RapidClientConfiguration = RapidClientConfiguration.EMPTY
) : OpenApiStub(clientConfiguration.toClientConfiguration()) {

    override fun createClient(): Client = Client.from(OkHttp.create(), clientConfiguration.toClientConfiguration(), true)

    override suspend fun throwServiceException(response: HttpResponse) {
        // Make sure we read the body to avoid resource leaks
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
}
