package com.expediagroup.sdk.rest

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class RestClientTest {
    @Test
    fun `delegates the dispose call to the underlying rest executor`() {
        val mockRestExecutor = mockk<RestExecutor>(relaxed = true)

        val testRestClient =
            object : RestClient() {
                override val restExecutor = mockRestExecutor
            }

        testRestClient.dispose()

        verify(exactly = 1) { mockRestExecutor.dispose() }
    }
}
