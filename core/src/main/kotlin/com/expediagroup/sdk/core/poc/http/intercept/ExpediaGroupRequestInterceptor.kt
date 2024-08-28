package com.expediagroup.sdk.core.poc.http.intercept

import com.expediagroup.sdk.core.poc.logging.RequestBodyLogger
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest

class ExpediaGroupRequestInterceptor(
    private val interceptors: List<HttpExecuteInterceptor> = listOf(
        RequestBodyLogger()
    )
): HttpExecuteInterceptor {

    override fun intercept(request: HttpRequest?) {
        interceptors.forEach { interceptor ->
            interceptor.intercept(request)
        }
    }

    fun withInterceptor(interceptor: HttpExecuteInterceptor): ExpediaGroupRequestInterceptor =
        ExpediaGroupRequestInterceptor(
            interceptors.plus(interceptor).toMutableList()
        )

    fun withInterceptors(interceptors: List<HttpExecuteInterceptor>): ExpediaGroupRequestInterceptor =
        ExpediaGroupRequestInterceptor(
            interceptors.plus(interceptors).toMutableList()
        )
}
