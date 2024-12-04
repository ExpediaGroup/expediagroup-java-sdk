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

package com.expediagroup.sdk.performancetest

import com.expediagroup.sdk.performancetest.benchmark.AsyncDownloadOperationBenchmark
import com.expediagroup.sdk.performancetest.benchmark.AsyncGetMessageOperationBenchmark
import com.expediagroup.sdk.performancetest.benchmark.AsyncPostMessageOperationBenchmark
import com.expediagroup.sdk.performancetest.benchmark.DownloadOperationBenchmark
import com.expediagroup.sdk.performancetest.benchmark.GetMessageOperationBenchmark
import com.expediagroup.sdk.performancetest.benchmark.PostMessageOperationBenchmark
import com.expediagroup.sdk.performancetest.client.BasicAuthBasedClient
import com.expediagroup.sdk.performancetest.client.EanAuthBasedClient
import com.expediagroup.sdk.performancetest.common.PerformanceTestClient
import com.expediagroup.sdk.performancetest.common.benchmark.AsyncBenchmarked
import com.expediagroup.sdk.performancetest.common.benchmark.Benchmark
import com.expediagroup.sdk.performancetest.common.benchmark.Benchmarked
import com.expediagroup.sdk.performancetest.common.benchmark.Benchmarker
import com.expediagroup.sdk.performancetest.common.benchmark.Report
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import java.io.File

@Command(name = "cli", description = "Command Line Interface for SDK Tests Module")
class Main {
    @Option(name = ["-n", "--namespace"])
    private var outputFilePath: String = "output.txt"

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main().run()
        }
    }

    private val clients: List<PerformanceTestClient> = buildList {
        add(
            EanAuthBasedClient.builder()
                .key("dummy-key")
                .secret("dummy-secret")
                .endpoint(System.getProperty("mockServerUrl", "http://localhost:8080"))
                .build()
        )

        add(
            BasicAuthBasedClient.builder()
                .key("dummy-key")
                .secret("dummy-secret")
                .endpoint(System.getProperty("mockServerUrl", "http://localhost:8080"))
                .build()
        )
    }

    private val syncBenchmarks: List<Benchmarked<*>> = buildList {
        clients.forEach { client ->
            add(PostMessageOperationBenchmark(client))
            add(DownloadOperationBenchmark(client))
            add(GetMessageOperationBenchmark(client))
        }
    }

    private val asyncBenchmarks: List<AsyncBenchmarked<*>> = buildList {
        clients.forEach { client ->
            add(AsyncPostMessageOperationBenchmark(client))
            add(AsyncDownloadOperationBenchmark(client))
            add(AsyncGetMessageOperationBenchmark(client))
        }
    }

    fun run() {
        val benchmarks: List<Benchmark> = buildList {
            syncBenchmarks.forEach { add(Benchmarker.benchmark(it)) }
            asyncBenchmarks.forEach { add(Benchmarker.benchmarkAsync(it)) }
        }

        File(outputFilePath).apply {
            createNewFile()
            writeText(Report(benchmarks).renderAsciiTable())
        }
    }
}
