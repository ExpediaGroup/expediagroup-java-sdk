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

package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.common.MetadataLoader
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.pipeline.RequestPipelineStep

class RequestHeadersStep : RequestPipelineStep {
    private val metadata = MetadataLoader.load()

    override fun invoke(request: Request): Request = request
        .newBuilder()
        .setHeader("User-Agent", metadata.asUserAgentString())
        .build()
}
