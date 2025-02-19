package com.expediagroup.sdk.rest

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class AsyncRestClientTest {
    @Test
    fun `delegates the dispose call to the underlying rest executor`() {
        val mockAsyncRestExecutor = mockk<AsyncRestExecutor>(relaxed = true)

        val testRestClient =
            object : AsyncRestClient() {
                override val restExecutor = mockAsyncRestExecutor
            }

        testRestClient.dispose()

        verify(exactly = 1) { mockAsyncRestExecutor.dispose() }
    }
}
