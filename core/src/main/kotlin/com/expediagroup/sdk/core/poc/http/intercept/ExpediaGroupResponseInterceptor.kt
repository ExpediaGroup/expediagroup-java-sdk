package com.expediagroup.sdk.core.poc.http.intercept

import com.google.api.client.http.HttpResponse
import com.google.api.client.http.HttpResponseInterceptor

class ExpediaGroupResponseInterceptor(
    private val interceptors: List<HttpResponseInterceptor> = emptyList()
): HttpResponseInterceptor {

    override fun interceptResponse(response: HttpResponse?) {
        interceptors.forEach { interceptor ->
            interceptor.interceptResponse(response)
        }
    }

    fun withInterceptor(interceptor: HttpResponseInterceptor): ExpediaGroupResponseInterceptor =
        ExpediaGroupResponseInterceptor(
            interceptors.plus(interceptor)
        )

    fun withInterceptors(interceptors: List<HttpResponseInterceptor>): ExpediaGroupResponseInterceptor =
        ExpediaGroupResponseInterceptor(
            interceptors.plus(interceptors)
        )
}
