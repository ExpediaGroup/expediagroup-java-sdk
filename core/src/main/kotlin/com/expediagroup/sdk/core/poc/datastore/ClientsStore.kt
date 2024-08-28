package com.expediagroup.sdk.core.poc.datastore

import com.expediagroup.sdk.core.poc.client.ExpediaGroupServiceClient
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

internal class ClientsStore private constructor():
    Store<ExpediaGroupServiceClient> {
    companion object {
        private val DATA_STORE = ConcurrentHashMap<String, ExpediaGroupServiceClient>()

        val INSTANCE = ClientsStore()
    }

    override fun getStore(): ConcurrentMap<String, ExpediaGroupServiceClient> =
        DATA_STORE
}
