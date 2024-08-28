package com.expediagroup.sdk.core.poc.model

import com.expediagroup.sdk.core.poc.authentication.AuthenticationProvider
import com.expediagroup.sdk.core.poc.datastore.ConfigurationsStore
import java.io.Serializable


data class AuthenticationConfiguration(
    val credentials: Credentials,
    val authUrl: String? = null,
    val authenticationType: AuthenticationProvider.AuthenticationType
)

data class Configuration(
    val serviceClientId: String = "EG_${java.util.UUID.randomUUID()}",
    val baseUrl: String,
    val authUrl: String? = null,
    val key: String,
    val secret: String,
    val authenticationType: AuthenticationProvider.AuthenticationType = AuthenticationProvider.AuthenticationType.SIGNATURE
): Serializable {
    companion object {
        @JvmStatic
        val serialVersionUID = 1L
    }

    fun publish(serviceClientId: String) {
        ConfigurationsStore.INSTANCE.store(serviceClientId, this)
    }

    fun publish() {
        publish(serviceClientId)
    }

    fun getAuthenticationConfiguration() = AuthenticationConfiguration(
        credentials = Credentials(
            key = key,
            secret = secret
        ),
        authUrl = authUrl,
        authenticationType = authenticationType
    )

    fun withServiceClientId(serviceClientId: String) = Configuration(
        serviceClientId = serviceClientId,
        baseUrl = baseUrl,
        authUrl = authUrl,
        key = key,
        secret = secret,
        authenticationType = authenticationType
    )
}
