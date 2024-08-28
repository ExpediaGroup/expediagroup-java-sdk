package com.expediagroup.sdk.core.poc.datastore

import java.util.concurrent.ConcurrentMap


internal interface Store<T> {
    fun getStore(): ConcurrentMap<String, T>

    fun store(serviceClientId: String, value: T) {
        getStore()[serviceClientId] = value
    }

    fun load(serviceClientId: String): T =
        getStore()[serviceClientId] ?: throw IllegalStateException("Configuration not found for service client id: $serviceClientId")
}
