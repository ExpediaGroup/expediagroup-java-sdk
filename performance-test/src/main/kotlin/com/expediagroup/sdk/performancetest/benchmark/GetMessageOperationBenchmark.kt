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
import com.expediagroup.sdk.performancetest.common.operation.GetMessageOperation
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

class GetMessageOperationBenchmark(
    private val client: PerformanceTestClient
) : Benchmarked<Message>(
    name = "SyncGetMessageOperationBenchmark",
    repeat = 10,
    timeout = 1,
    timeoutUnit = TimeUnit.MINUTES,
    description = "Sync Get Message Operation Executed 10 times using ${client.javaClass.simpleName} client"
) {
    override fun benchmark(): Response<Message> {
        return client.execute(GetMessageOperation())
    }
}

class AsyncGetMessageOperationBenchmark(
    private val client: PerformanceTestClient
) : AsyncBenchmarked<Message>(
    name = "AsyncGetMessageOperationBenchmark",
    repeat = 1000,
    timeout = 1,
    timeoutUnit = TimeUnit.HOURS,
    description = "Async Get Message Operation Executed 1000 times using ${client.javaClass.simpleName} client"
) {
    override fun benchmarkAsync(): CompletableFuture<Response<Message>> {
        return client.executeAsync(GetMessageOperation())
    }
}
