package com.expediagroup.sdk.core.poc.client

import com.expediagroup.sdk.core.poc.datastore.ClientsStore
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient
import java.util.UUID

open class ExpediaGroupServiceClient(
    val client: AbstractGoogleJsonClient,
    val serviceClientId: String
) {
    fun publish() {
        ClientsStore.INSTANCE.store(serviceClientId, this)
    }

    constructor(client: AbstractGoogleJsonClient) : this(client, UUID.randomUUID().toString())

    constructor(builder: JsonClientBuilder) : this(builder.build(), builder.serviceClientId)

    constructor(builder: AbstractGoogleJsonClient.Builder, serviceClientId: String) : this(builder.build(), serviceClientId)
}
