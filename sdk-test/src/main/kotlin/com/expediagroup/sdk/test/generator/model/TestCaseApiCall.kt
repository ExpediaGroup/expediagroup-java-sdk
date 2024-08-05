package com.expediagroup.sdk.test.generator.model

import com.expediagroup.sdk.test.generator.JSON
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import io.specmatic.core.Scenario
import java.io.File

data class TestCaseApiCall(
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

    fun writeTo(
        outputDir: File,
        mapper: ObjectMapper,
        filenameSuffix: String? = "",
        filenamePrefix: String? = ""
    ) {
        val filename = "${filenamePrefix ?: ""}${request.method}-${request.path?.removePrefix("/")?.replace("/", "-")}${filenameSuffix ?: ""}.$JSON"

        mapper.writeValue(
            File(outputDir, filename),
            mapOf(
                "request" to request,
                "response" to response
            )
        )
    }
}
