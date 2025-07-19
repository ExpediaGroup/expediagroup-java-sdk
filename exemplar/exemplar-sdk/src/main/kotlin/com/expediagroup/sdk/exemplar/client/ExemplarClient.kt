/**
 * Copyright (C) 2025 Expedia, Inc.
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
package com.expediagroup.sdk.exemplar.client

import com.expediagroup.sdk.core.transport.Transport
import com.expediagroup.sdk.exemplar.core.executor.RequestExecutor
import com.expediagroup.sdk.exemplar.core.mapper.DefaultObjectMapper
import com.expediagroup.sdk.rest.RestClient
import com.expediagroup.sdk.rest.RestExecutor
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait

class ExemplarClient
    @JvmOverloads
    constructor(transport: Transport? = null) : RestClient() {
        override val restExecutor: RestExecutor =
            RestExecutor(
                mapper = DefaultObjectMapper.INSTANCE,
                serverUrl = "http://localhost:8080",
                requestExecutor = RequestExecutor(transport)
            )

        /**
         * Executes an operation that does not expect a response body.
         *
         * @param operation The operation to execute.
         * @return The response of the operation.
         */
        fun execute(operation: OperationNoResponseBodyTrait): Response<Nothing?> = restExecutor.execute(operation)

        /**
         * Executes an operation that expects a response body.
         *
         * @param T The type of the response body.
         * @param operation The operation to execute.
         * @return The response of the operation.
         */
        fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): Response<T> = restExecutor.execute(operation)
    }
