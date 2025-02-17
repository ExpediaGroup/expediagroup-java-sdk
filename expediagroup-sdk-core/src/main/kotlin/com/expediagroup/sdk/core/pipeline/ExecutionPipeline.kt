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

package com.expediagroup.sdk.core.pipeline

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response

/**
 * A functional interface representing a single step in the request pipeline.
 * Implementations of this interface define transformations or actions
 * to be applied to a [Request] object.
 */
fun interface RequestPipelineStep : (Request) -> Request

/**
 * A functional interface representing a single step in the response pipeline.
 * Implementations of this interface define transformations or actions
 * to be applied to a [Response] object.
 */
fun interface ResponsePipelineStep : (Response) -> Response

/**
 * A class representing a processing pipeline for requests and responses.
 *
 * The `ExecutionPipeline` orchestrates the execution of a series of transformations
 * (steps) on both HTTP requests and responses.
 *
 * @property requestPipeline A list of [RequestPipelineStep]s to be executed on the outgoing [Request].
 * Each step is applied sequentially, with the output of one step becoming the input for the next.
 *
 * @property responsePipeline A list of [ResponsePipelineStep]s to be executed on the incoming [Response].
 * Each step is applied sequentially, with the output of one step becoming the input for the next.
 */
class ExecutionPipeline(
    private val requestPipeline: List<RequestPipelineStep>,
    private val responsePipeline: List<ResponsePipelineStep>
) {
    fun startRequestPipeline(request: Request): Request = requestPipeline.fold(request) { req, step -> step(req) }

    fun startResponsePipeline(response: Response): Response = responsePipeline.fold(response) { res, step -> step(res) }
}
