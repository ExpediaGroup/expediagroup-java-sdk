package com.expediagroup.sdk.graphql

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class AsyncGraphQLClientTest {

    @Test
    fun `delegates the dispose call to the underlying graphql executor`() {
        // Given
        val mockAsyncGraphQLExecutor = mockk<AsyncGraphQLExecutor>(relaxed = true)

        val testAsyncGraphQLClient = object : AsyncGraphQLClient() {
            override val asyncGraphQLExecutor = mockAsyncGraphQLExecutor
        }

        // When
        testAsyncGraphQLClient.dispose()

        // Expect
        verify(exactly = 1) { mockAsyncGraphQLExecutor.dispose() }
    }
}
