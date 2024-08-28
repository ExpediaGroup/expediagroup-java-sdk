package com.expediagroup.sdk.core.poc.extension

import com.expediagroup.sdk.core.model.Operation
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.json.JsonHttpContent
import com.google.api.client.json.gson.GsonFactory

fun HttpRequest.baseOn(operation: Operation<*>) {
    this.responseInterceptor
    if (operation.params != null) {
        operation.params.getHeaders()?.forEach { (key, value) ->
            this.headers?.put(key, value)
        }

        operation.params.getQueryParams()?.forEach { (key, value) ->
            this.url.put(key, value)
        }
    }

    content = if (operation.requestBody != null) {
        JsonHttpContent(GsonFactory.getDefaultInstance(), operation.requestBody)
    } else {
        null
    }
}
