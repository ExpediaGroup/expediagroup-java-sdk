package com.expediagroup.sdk.test.generator.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.specmatic.core.HttpResponse

data class TestCaseHttpResponse(
    @JsonProperty val status: Int
) {
    companion object {
        fun from(response: HttpResponse): TestCaseHttpResponse =
            TestCaseHttpResponse(
                status = response.status
            )
    }
}
