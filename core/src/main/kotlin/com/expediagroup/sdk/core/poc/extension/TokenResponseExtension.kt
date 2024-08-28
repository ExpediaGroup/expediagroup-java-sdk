package com.expediagroup.sdk.core.poc.extension

import com.google.api.client.auth.oauth2.TokenResponse
import com.google.auth.oauth2.AccessToken
import java.time.Instant
import java.util.*

fun TokenResponse.toAccessToken(): AccessToken {
    return AccessToken.newBuilder()
        .setTokenValue(accessToken)
        .setExpirationTime(Date.from(Instant.now().plusSeconds(expiresInSeconds)))
        .setScopes(scope)
        .build()
}
