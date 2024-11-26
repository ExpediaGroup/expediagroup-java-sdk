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

import com.jakewharton.picnic.BorderStyle
import com.jakewharton.picnic.TextAlignment
import com.jakewharton.picnic.renderText
import com.jakewharton.picnic.table

data class Report(
    val benchmarks: List<Benchmark>
) {
    fun renderAsciiTable(): String = table {
        style {
            this.borderStyle = BorderStyle.Solid
        }
        cellStyle {
            border = true
            paddingLeft = 1
            paddingRight = 1
            alignment = TextAlignment.MiddleLeft
        }
        row(
            "Benchmark",
            "Average Execution Time",
            "Start Time",
            "End Time",
            "Total Executions",
            "Total Execution Time",
            "Description"
        )

        benchmarks.forEach {
            row(
                it.name,
                "${it.averageExecutionTime} (ms)",
                it.startTime,
                it.endTime,
                it.executionsCount,
                "${it.duration.toMillis()} (ms)",
                it.description
            )
        }
    }.renderText()
}
