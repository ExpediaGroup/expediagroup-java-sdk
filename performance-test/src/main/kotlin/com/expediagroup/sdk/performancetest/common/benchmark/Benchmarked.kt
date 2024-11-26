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
import java.util.concurrent.TimeUnit

abstract class Benchmarked <T> (
    val name: String,
    val description: String = "",
    val repeat: Int = 1,
    val timeout: Long = 60,
    val timeoutUnit: TimeUnit = TimeUnit.SECONDS,
) {
    abstract fun benchmark(): Response<T>
}
