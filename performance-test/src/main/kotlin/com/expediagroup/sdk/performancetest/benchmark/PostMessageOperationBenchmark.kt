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

package com.expediagroup.sdk.performancetest.benchmark

import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.performancetest.common.PerformanceTestClient
import com.expediagroup.sdk.performancetest.common.benchmark.AsyncBenchmarked
import com.expediagroup.sdk.performancetest.common.benchmark.Benchmarked
import com.expediagroup.sdk.performancetest.common.model.Message
import com.expediagroup.sdk.performancetest.common.operation.PostMessageOperation
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit


class PostMessageOperationBenchmark(
    private val client: PerformanceTestClient
) : Benchmarked<Message>(
    name = "SyncPostMessageOperationBenchmark",
    repeat = 10,
    timeout = 1,
    timeoutUnit = TimeUnit.MINUTES,
    description = "Sync Post Message Operation Executed 10 times"
) {
    override fun benchmark(): Response<Message> {
        return client.execute(PostMessageOperation(Message("Hello, World!".repeat(1e6.toInt()))))
    }
}

class AsyncPostMessageOperationBenchmark(
    private val client: PerformanceTestClient
) : AsyncBenchmarked<Message>(
    name = "AsyncPostMessageOperationBenchmark",
    repeat = 1000,
    timeout = 1,
    timeoutUnit = TimeUnit.HOURS,
    description = "Async Post Message Operation Executed 1000 times"
) {
    override fun benchmarkAsync(): CompletableFuture<Response<Message>> {
        return client.executeAsync(PostMessageOperation(Message("Hello, World!".repeat(1e6.toInt()))))
    }
}
