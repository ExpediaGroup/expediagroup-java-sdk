package com.expediagroup.sdk.exemplar.graphql.client

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.transport.Transport
import com.expediagroup.sdk.exemplar.graphql.core.executor.RequestExecutor
import com.expediagroup.sdk.graphql.GraphQLClient
import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse

class ExemplarGraphQLClient @JvmOverloads constructor(transport: Transport? = null) : GraphQLClient() {
    override val graphQLExecutor: GraphQLExecutor = GraphQLExecutor(
        requestExecutor = RequestExecutor(transport = transport),
        serverUrl = "http://localhost:8080/graphql",
    )

    fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T> = graphQLExecutor.execute(operation)
}
