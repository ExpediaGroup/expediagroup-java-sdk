/*
 * Copyright (C) 2022 Expedia, Inc.
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
/* You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.test.contract.model.api

import com.expediagroup.sdk.test.contract.extension.isEmptyJsonObject
import com.expediagroup.sdk.test.contract.extension.paramsMapWithExtractedJsonArrays
import com.expediagroup.sdk.test.contract.function.ExtractPathParamsFunc
import com.expediagroup.sdk.test.contract.function.ParamsBasedPathSanitizationFunc
import com.expediagroup.sdk.test.util.toBoolean
import com.fasterxml.jackson.annotation.JsonProperty
import io.specmatic.core.HttpRequest
import io.specmatic.core.Scenario

/**
 * Represents an HTTP request in a test case scenario.
 *
 * @property method The HTTP method (e.g., GET, POST) as a string.
 * @property path The path of the HTTP request.
 * @property headers A map containing the headers of the HTTP request.
 * @property body The body of the HTTP request as a string.
 * @property pathParams A map containing the path parameters for the request.
 * @property queryParams A map containing the query parameters for the request.
 * @property formFields A map containing form fields for the request.
 * @property multiPartFormData A map containing multipart form data for the request.
 */

class TestCaseHttpRequest(
    @JsonProperty val method: String? = "",
    @JsonProperty val path: String? = "",
    @JsonProperty val headers: Map<String, Any>? = emptyMap(),
    @JsonProperty val body: String? = "",
    @JsonProperty val pathParams: Map<String, Any>? = emptyMap(),
    @JsonProperty val queryParams: Map<String, Any>? = emptyMap(),
    @JsonProperty val formFields: Map<String, Any>? = emptyMap(),
    @JsonProperty val multiPartFormData: Map<String, Any>? = emptyMap()
) {
    companion object {
        private val ignoreHeaders =
            listOf(
                "Authorization",
                "Content-Length",
                "Content-Type",
                "Accept",
                "Accept-Encoding",
            )

        /**
         * Constructs a TestCaseHttpRequest object from an HttpRequest and Scenario.
         * @throws IllegalArgumentException if the request contains null fields.
         *
         * @param request HttpRequest to convert
         * @param scenario Scenario associated with the request
         * @return A TestCaseHttpRequest object initialized with the given request and scenario
         */
        fun from(
            request: HttpRequest,
            scenario: Scenario
        ): TestCaseHttpRequest {
            takeIf {
                listOf(
                    request.path,
                    request.method,
                    request.headers,
                    request.bodyString
                ).any { it == null }
            }?.let {
                throw IllegalArgumentException("Request is missing required fields:\n $request")
            }

            val pathParams = ExtractPathParamsFunc.execute(scenario, request)

            return TestCaseHttpRequest(
                method = request.method,
                path = ParamsBasedPathSanitizationFunc.execute(request.path!!, pathParams),
                headers = request.headers.filterKeys { ignoreHeaders.contains(it).not() }
                    .paramsMapWithExtractedJsonArrays(),
                body = request.bodyString,
                queryParams = request.queryParams.asMap().paramsMapWithExtractedJsonArrays(),
                pathParams = pathParams,
            )
        }
    }

    /**
     * Checks if the HTTP request has a non-empty, non-blank body.
     *
     * @return `true` if the body is not empty and not just a JSON object, `false` otherwise.
     */
    fun hasBody(): Boolean =
        toBoolean(body, dynamic = true).and(!(body!!.isEmptyJsonObject()))



    /**
     * Aggregates the headers, path parameters, and query parameters into a single map.
     *
     * @return A map containing all headers, path parameters, and query parameters present in the request.
     */
    fun getParams(): Map<String, Any> = mutableMapOf<String, Any>().apply {
        listOf(headers, pathParams, queryParams).forEach { param ->
            takeIf { toBoolean(param, dynamic = true) }?.let { putAll(it) }
        }
    }

    /**
     * Retrieves the body of the HTTP request if it is not empty and not just a JSON object.
     *
     * @return The body of the request if it is not empty and not a default empty JSON object,
     *         otherwise `null`.
     */
    fun getRequestBody(): String? = if (hasBody()) body else null
}
