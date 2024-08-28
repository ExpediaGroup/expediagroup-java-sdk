package com.expediagroup.sdk.core.poc.authentication

import com.expediagroup.sdk.core.poc.constant.EMPTY_ACCESS_TOKEN
import com.expediagroup.sdk.core.poc.extension.bearerToEan
import com.expediagroup.sdk.core.poc.model.AuthenticationConfiguration
import com.expediagroup.sdk.core.poc.model.Configuration
import com.google.api.client.http.HttpRequest
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh

internal class ExpediaGroupAuthenticationAdapter(
    oAuth2CredentialsWithRefresh: OAuth2CredentialsWithRefresh
): HttpCredentialsAdapter(oAuth2CredentialsWithRefresh) {

    constructor(configuration: AuthenticationConfiguration, serviceClientId: String):
        this(getEmptyOAuth2CredentialsWithRefresh(configuration, serviceClientId))

    constructor(configuration: Configuration, serviceClientId: String):
        this(getEmptyOAuth2CredentialsWithRefresh(configuration.getAuthenticationConfiguration(), serviceClientId))

    constructor(configuration: Configuration) :
        this(configuration.getAuthenticationConfiguration(), configuration.serviceClientId)

    override fun initialize(request: HttpRequest) {
        super.initialize(request)

        val refreshHandler = (this.credentials as OAuth2CredentialsWithRefresh).refreshHandler as OAuth2TokenRefreshHandler

        if (refreshHandler.authenticationType != AuthenticationProvider.AuthenticationType.SIGNATURE) {
            return
        }

        request.headers.authorization = request.headers.authorization.bearerToEan()
    }
}

fun getEmptyOAuth2CredentialsWithRefresh(configuration: AuthenticationConfiguration, serviceClientId: String) = object : OAuth2CredentialsWithRefresh(
    EMPTY_ACCESS_TOKEN,
    OAuth2TokenRefreshHandler(configuration.authenticationType, serviceClientId)
) {}
