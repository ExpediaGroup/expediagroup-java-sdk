package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RequestHeadersStepTest {
    private lateinit var requestHeadersStep: RequestHeadersStep

    @BeforeEach
    fun setUp() {
        requestHeadersStep = RequestHeadersStep()
    }

    @Test
    fun `should add user-agent header`() {
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .build()

        val result = requestHeadersStep.invoke(testRequest)

        assertTrue(
            result.headers.values("user-agent")[0].contains("expedia-group-test-sdk/1.0.0 (Provider/com.expediagroup;")
        )
    }
}
