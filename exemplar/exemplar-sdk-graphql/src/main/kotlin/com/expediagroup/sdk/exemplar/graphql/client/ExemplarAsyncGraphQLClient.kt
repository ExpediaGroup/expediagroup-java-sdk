package com.expediagroup.sdk.exemplar.graphql.client

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.transport.AsyncTransport
import com.expediagroup.sdk.exemplar.graphql.core.executor.AsyncRequestExecutor
import com.expediagroup.sdk.graphql.AsyncGraphQLClient
import com.expediagroup.sdk.graphql.AsyncGraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import java.util.concurrent.CompletableFuture

class ExemplarAsyncGraphQLClient @JvmOverloads constructor(asyncTransport: AsyncTransport? = null) : AsyncGraphQLClient() {
    override val asyncGraphQLExecutor: AsyncGraphQLExecutor = AsyncGraphQLExecutor(
        asyncRequestExecutor = AsyncRequestExecutor(asyncTransport),
        serverUrl = "http://localhost:8080/graphql",
    )

    fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>> = asyncGraphQLExecutor.execute(operation)
}
