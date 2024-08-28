package com.expediagroup.sdk.core.poc.authentication

import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh

class OAuth2TokenRefreshHandler(
    val authenticationType: AuthenticationProvider.AuthenticationType,
    val serviceClientId: String
): OAuth2CredentialsWithRefresh.OAuth2RefreshHandler {
    private val authenticationProvider = AuthenticationProvider.from(authenticationType, serviceClientId)

    override fun refreshAccessToken(): AccessToken =
        authenticationProvider.refreshAccessToken()
}
