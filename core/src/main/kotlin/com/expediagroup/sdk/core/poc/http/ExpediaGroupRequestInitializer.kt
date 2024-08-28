package com.expediagroup.sdk.core.poc.http

import com.expediagroup.sdk.core.poc.http.intercept.ExpediaGroupRequestInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

class ExpediaGroupRequestInitializer(
    private val httpRequestInitializers: List<HttpRequestInitializer> = emptyList()
): HttpRequestInitializer {
    override fun initialize(request: HttpRequest) {
        httpRequestInitializers.forEach { initializer ->
            initializer.initialize(request)
        }

        request.interceptor = ExpediaGroupRequestInterceptor()
    }

    fun withInitializer(initializer: HttpRequestInitializer): ExpediaGroupRequestInitializer {
       return ExpediaGroupRequestInitializer(httpRequestInitializers.plus(initializer).toMutableList())
    }

    fun withInitializers(initializers: List<HttpRequestInitializer>): ExpediaGroupRequestInitializer {
        return ExpediaGroupRequestInitializer(httpRequestInitializers.plus(initializers).toMutableList())
    }
}
