package com.expediagroup.sdk.core.poc.authentication

import com.expediagroup.sdk.core.poc.constant.HTTP_TRANSPORT
import com.expediagroup.sdk.core.poc.datastore.ConfigurationsStore
import com.expediagroup.sdk.core.poc.extension.toAccessToken
import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest
import com.google.api.client.http.BasicAuthentication
import com.google.api.client.http.GenericUrl
import com.google.api.client.json.gson.GsonFactory
import com.google.auth.oauth2.AccessToken

class ExpediaGroupAuthenticationProvider(private val serviceClientId: String): AuthenticationProvider {
    override fun refreshAccessToken(): AccessToken = ConfigurationsStore.INSTANCE.load(serviceClientId).let { configuration ->
        ClientCredentialsTokenRequest(
            HTTP_TRANSPORT,
            GsonFactory.getDefaultInstance(),
            GenericUrl(configuration.authUrl),
        ).apply {
            clientAuthentication = BasicAuthentication(configuration.key, configuration.secret)
            tokenServerUrl = GenericUrl(configuration.authUrl)
        }.execute().toAccessToken()
    }
}
