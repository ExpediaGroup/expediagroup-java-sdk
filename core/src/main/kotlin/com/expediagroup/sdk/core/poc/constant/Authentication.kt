package com.expediagroup.sdk.core.poc.constant

import com.google.auth.oauth2.AccessToken
import java.util.Date

const val RAPID_DEFAULT_TOKEN_EXPIRATION_SECONDS: Long = 60 * 4

val EMPTY_ACCESS_TOKEN: AccessToken = AccessToken.newBuilder()
    .setTokenValue("")
    .setExpirationTime(Date())
    .build()
