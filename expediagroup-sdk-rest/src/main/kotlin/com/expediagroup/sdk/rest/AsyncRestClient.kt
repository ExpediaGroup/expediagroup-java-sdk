/*
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

package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract class representing an asynchronous REST client.
 *
 * This class provides a base implementation for an asynchronous REST client that uses an AsyncRestExecutor
 * to perform HTTP requests. It implements the Disposable interface to ensure that
 * resources are properly released when the client is no longer needed.
 */
abstract class AsyncRestClient : Disposable {
    /**
     * The AsyncRestExecutor used to execute asynchronous REST operations.
     */
    protected abstract val restExecutor: AsyncRestExecutor

    /**
     * Disposes of the resources used by the AsyncRestExecutor.
     *
     * This method is called to release any resources held by the AsyncRestExecutor
     * when the AsyncRestClient is no longer needed.
     */
    override fun dispose() {
        restExecutor.dispose()
    }
}
