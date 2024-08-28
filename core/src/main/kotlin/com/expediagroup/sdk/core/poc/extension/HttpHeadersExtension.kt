package com.expediagroup.sdk.core.poc.extension

import com.google.api.client.http.HttpHeaders

fun HttpHeaders.rapidAuthorizationHeader() = authorization.bearerToEan()
