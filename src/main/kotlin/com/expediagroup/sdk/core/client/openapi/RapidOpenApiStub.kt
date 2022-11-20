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
package com.expediagroup.sdk.core.client.openapi

import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.model.error.rapid.RapidError
import com.expediagroup.sdk.core.model.exception.RapidServiceException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.toURI

/**
 * Base class for RapidApi used by generated OpenAPI APIs to perform the heavy lifting of actually sending requests.
 */
abstract class RapidOpenApiStub(
    clientConfiguration: ClientConfiguration = ClientConfiguration.EMPTY
) : OpenApiStub(clientConfiguration) {

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
}
