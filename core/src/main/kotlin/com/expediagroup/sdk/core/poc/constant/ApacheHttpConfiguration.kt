package com.expediagroup.sdk.core.poc.constant

import com.google.api.client.http.HttpTransport
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.impl.client.CloseableHttpClient

const val DEFAULT_MAX_CONNECTIONS = 1e8.toInt()

const val DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 1e8.toInt()

val DEFAULT_CLIENT: CloseableHttpClient = ApacheHttpTransport.newDefaultHttpClientBuilder()
    .setMaxConnTotal(DEFAULT_MAX_CONNECTIONS)
    .setMaxConnPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE)
    .build()

val HTTP_TRANSPORT: HttpTransport = ApacheHttpTransport(DEFAULT_CLIENT)
