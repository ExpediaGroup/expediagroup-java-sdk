package com.expediagroup.sdk.core.poc.datastore

import com.expediagroup.sdk.core.poc.model.Configuration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


internal class ConfigurationsStore private constructor(): Store<Configuration> {
    companion object {
        private val DATA_STORE = ConcurrentHashMap<String, Configuration>()

        val INSTANCE = ConfigurationsStore()
    }

    override fun getStore(): ConcurrentMap<String, Configuration> =
        DATA_STORE
}

fun main() {
    val store = ConfigurationsStore.INSTANCE.load("serviceClientId")
}
