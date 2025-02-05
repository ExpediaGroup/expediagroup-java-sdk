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

package com.expediagroup.sdk.performancetest.common.benchmark

import com.expediagroup.sdk.core.model.Response
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

object Benchmarker {
    fun <T> benchmark(
        target: Benchmarked<T>,
    ): Benchmark =
        benchmark(
            name = target.name,
            block = target::benchmark,
            repeat = target.repeat,
            timeout = target.timeout,
            timeoutUnit = target.timeoutUnit,
            description = target.description,
        )

    fun <T> benchmarkAsync(
        target: AsyncBenchmarked<T>,
    ): Benchmark =
        benchmarkAsync(
            name = target.name,
            block = target::benchmarkAsync,
            repeat = target.repeat,
            timeout = target.timeout,
            timeoutUnit = target.timeoutUnit,
            description = target.description,
        )

    fun <T> benchmark(
        name: String,
        block: () -> Response<T>,
        repeat: Int,
        timeout: Long,
        timeoutUnit: TimeUnit,
        description: String = "",
    ): Benchmark {
        require(repeat > 0) { "Repeat count must be greater than 0" }

        val success = AtomicLong(0L)
        val startTime = LocalDateTime.now()

        repeat(repeat) {
            val future = CompletableFuture.runAsync {
                block()
            }

            while (!future.isDone) {
                TimeUnit.MILLISECONDS.sleep(100)

                require(Duration.between(startTime, LocalDateTime.now()).toMillis() < timeoutUnit.toMillis(timeout)) {
                    "Timeout exceeded"
                }
            }

            success.incrementAndGet()
        }

        val endTime = LocalDateTime.now()

        return Benchmark(
            name = name,
            startTime = startTime,
            endTime = endTime,
            executionsCount = repeat,
            description = description
        )
    }

    fun <T> benchmarkAsync(
        name: String,
        block: () -> CompletableFuture<Response<T>>,
        repeat: Int,
        timeout: Long,
        timeoutUnit: TimeUnit,
        description: String = "---",
    ): Benchmark {
        require(repeat > 0) { "Repeat count must be greater than 0" }

        val success = AtomicLong(0L)
        val startTime = LocalDateTime.now()

        repeat(repeat) {
            block().whenComplete { _, throwable ->
                if (throwable != null) {
                    throw throwable
                }

                success.incrementAndGet()
            }
        }

        while (success.get() < repeat) {
            TimeUnit.MILLISECONDS.sleep(100)

            require(Duration.between(startTime, LocalDateTime.now()).toMillis() < timeoutUnit.toMillis(timeout)) {
                "Timeout exceeded"
            }
        }

        return Benchmark(
            name = name,
            startTime = startTime,
            endTime = LocalDateTime.now(),
            executionsCount = repeat,
            description = description
        )
    }
}
