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

import com.expediagroup.sdk.test.contract.JSON
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.specmatic.core.Scenario
import java.io.File

/**
 * Represents a test case API call with associated request and response information.
 *
 * @property request The HTTP request details for the test case.
 * @property response The HTTP response details for the test case.
 */
class TestCaseApiCall(
    @JsonProperty val request: TestCaseHttpRequest,
    @JsonProperty val response: TestCaseHttpResponse
) {
    companion object {
        fun from(scenario: Scenario): TestCaseApiCall =
            TestCaseApiCall(
                request =
                TestCaseHttpRequest.from(
                    request = scenario.generateHttpRequest(),
                    scenario = scenario
                ),
                response = TestCaseHttpResponse.from(response = scenario.generateHttpResponse(emptyMap()))
            )
    }

    /**
     * Converts the TestCaseApiCall object to its JSON string representation using the jacksonObjectMapper.
     *
     * @return A string representation of the TestCaseApiCall object in JSON format.
     */
    override fun toString(): String {
        return jacksonObjectMapper().writeValueAsString(
            mapOf(
                "request" to mapOf(
                    "body" to request.getRequestBody(),
                    "params" to request.getParams(),
                ),
                "response" to response
            )
        )
    }

    /**
     * Generates the filename based on the request method and path, with optional prefix and suffix.
     *
     * @param filenameSuffix (Optional) Suffix to append to the filename. Default is an empty string.
     * @param filenamePrefix (Optional) Prefix to prepend to the filename. Default is an empty string.
     * @return The generated filename.
     */
    fun filename(filenameSuffix: String? = "", filenamePrefix: String? = "") =
        "${filenamePrefix ?: ""}${request.method}-${request.path?.removePrefix("/")?.replace("/", "-")}${filenameSuffix ?: ""}.$JSON"

    /**
     * Writes the TestCaseApiCall object as a JSON file to the specified output directory.
     *
     * @param outputDir The directory where the JSON file will be written.
     * @param mapper The ObjectMapper instance for JSON serialization.
     * @param filenameSuffix (Optional) Suffix to append to the filename. Default is an empty string.
     * @param filenamePrefix (Optional) Prefix to prepend to the filename. Default is an empty string.
     */
    fun writeTo(
        outputDir: File,
        mapper: ObjectMapper,
        filenameSuffix: String? = "",
        filenamePrefix: String? = ""
    ) {
        val filename = filename(filenameSuffix, filenamePrefix)
        mapper.writeValue(
            File(outputDir, filename),
            mapOf(
                "request" to request,
                "response" to response
            )
        )
    }
}
