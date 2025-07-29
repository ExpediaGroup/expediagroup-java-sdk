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
package com.expediagroup.sdk.exemplar.rest.core.executor.demo

import com.expediagroup.sdk.core.auth.basic.BasicAuthCredentials
import com.expediagroup.sdk.core.auth.basic.BasicAuthManager
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.BasicAuthStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport

/**
 * **Demo Request Executor: Basic Authentication**
 *
 * This demo RequestExecutor showcases how to configure HTTP Basic Authentication
 * for all outgoing API requests using the SDK's built-in authentication pipeline.
 *
 * ## Use Case
 * When your API requires HTTP Basic Authentication (username/password), this executor
 * automatically adds the appropriate `Authorization` header to every request.
 *
 * ## Authentication Flow
 * 1. Credentials are configured during executor construction
 * 2. `BasicAuthStep` automatically adds `Authorization: Basic <base64-encoded-credentials>` header
 * 3. All API calls use the same authentication credentials
 *
 * @see BasicAuthStep
 * @see BasicAuthManager
 * @see BasicAuthCredentials
 */
class RequestExecutorWithBasicAuth
    @JvmOverloads
    constructor(
        transport: Transport? = null
    ) : AbstractRequestExecutor(transport) {
        override val executionPipeline: ExecutionPipeline =
            ExecutionPipeline(
                requestPipeline =
                    listOf(
                        BasicAuthStep(
                            BasicAuthManager(
                                BasicAuthCredentials(
                                    username = "user",
                                    password = "password"
                                )
                            )
                        )
                    ),
                responsePipeline = listOf()
            )
    }
