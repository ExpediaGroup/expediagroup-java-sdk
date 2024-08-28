package com.expediagroup.sdk.core.poc.client

import com.expediagroup.sdk.core.poc.model.Configuration
import com.expediagroup.sdk.core.poc.constant.HTTP_TRANSPORT
import com.expediagroup.sdk.core.poc.constant.JSON_FACTORY
import com.expediagroup.sdk.core.poc.authentication.ExpediaGroupAuthenticationAdapter
import com.expediagroup.sdk.core.poc.http.ExpediaGroupRequestInitializer
import com.expediagroup.sdk.core.poc.http.intercept.ExpediaGroupRequestInterceptor
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory


class JsonClientBuilder(
    appName: String,
    transport: HttpTransport = HTTP_TRANSPORT,
    jsonFactory: JsonFactory = JSON_FACTORY,
    configuration: Configuration,
    initializer: ExpediaGroupRequestInitializer,
    val serviceClientId: String
) : AbstractGoogleJsonClient.Builder(
    transport,
    jsonFactory,
    configuration.baseUrl,
    "",
    initializer.withInitializer(ExpediaGroupAuthenticationAdapter(configuration, serviceClientId)),
    false
) {
    init {
        applicationName = appName
    }

    override fun setHttpRequestInitializer(httpRequestInitializer: HttpRequestInitializer): AbstractGoogleJsonClient.Builder {
        if (httpRequestInitializer !is ExpediaGroupRequestInitializer) {
            throw IllegalArgumentException("Only ExpediaGroupRequestInitializer instances are supported")
        }
        return super.setHttpRequestInitializer(httpRequestInitializer)
    }

    override fun build(): AbstractGoogleJsonClient =
        object : AbstractGoogleJsonClient(this) {}
}
