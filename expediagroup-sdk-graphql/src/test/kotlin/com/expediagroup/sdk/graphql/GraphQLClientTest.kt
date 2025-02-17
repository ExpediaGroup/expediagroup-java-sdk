package com.expediagroup.sdk.graphql

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class GraphQLClientTest {
    @Test
    fun `delegates the dispose call to the underlying graphql executor`() {
        // Given
        val mockGraphQLExecutor = mockk<GraphQLExecutor>(relaxed = true)

        val testGraphQLClient =
            object : GraphQLClient() {
                override val graphQLExecutor = mockGraphQLExecutor
            }

        // When
        testGraphQLClient.dispose()

        // Expect
        verify(exactly = 1) { mockGraphQLExecutor.dispose() }
    }
}
