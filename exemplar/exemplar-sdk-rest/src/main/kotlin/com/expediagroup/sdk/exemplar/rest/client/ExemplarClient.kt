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
package com.expediagroup.sdk.exemplar.rest.client

import com.expediagroup.sdk.core.transport.Transport
import com.expediagroup.sdk.exemplar.rest.core.executor.RequestExecutor
import com.expediagroup.sdk.exemplar.rest.core.mapper.DefaultObjectMapper
import com.expediagroup.sdk.rest.RestClient
import com.expediagroup.sdk.rest.RestExecutor
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait

/**
 * This is the exemplar synchronous SDK client that users can use to interact with your REST APIs.
 *
 * It extends [RestClient] and is designed for synchronous execution of API operations.
 * To use it, you must override the [restExecutor] property with an instance of [RestExecutor],
 * which should be configured with your server's base URL and an [RequestExecutor] instance.
 *
 * While the base implementation is provided here, you are encouraged to customize this client
 * as needed — such as adding new methods, properties, or exposing configuration options via constructors
 * or builder-style APIs.
 *
 * The execution flow is structured as follows:
 * RestClient (Product SDK layer) → RestExecutor (REST package) → RequestExecutor (Core package)
 *
 * This class serves as a reference implementation and can be used as a starting point for building your own SDK client.
 *
 * @see RestClient
 * @see RestExecutor
 * @see RequestExecutor
 * @see DefaultObjectMapper
 */
class ExemplarClient
@JvmOverloads
constructor(transport: Transport? = null) : RestClient() {
    override val restExecutor: RestExecutor = RestExecutor(
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
    fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): Response<T> =
        restExecutor.execute(operation)
}
