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

package com.expediagroup.sdk.performancetest.common

import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.performancetest.common.model.Message
import com.expediagroup.sdk.performancetest.common.operation.DownloadFileOperation
import com.expediagroup.sdk.performancetest.common.operation.GetMessageOperation
import com.expediagroup.sdk.performancetest.common.operation.PostMessageOperation
import java.io.InputStream
import java.util.concurrent.CompletableFuture

interface PerformanceTestClient {
    fun execute(operation: DownloadFileOperation): Response<InputStream>
    fun executeAsync(operation: DownloadFileOperation): CompletableFuture<Response<InputStream>>

    fun execute(operation: GetMessageOperation): Response<Message>
    fun executeAsync(operation: GetMessageOperation): CompletableFuture<Response<Message>>

    fun execute(operation: PostMessageOperation): Response<Message>
    fun executeAsync(operation: PostMessageOperation): CompletableFuture<Response<Message>>
}
