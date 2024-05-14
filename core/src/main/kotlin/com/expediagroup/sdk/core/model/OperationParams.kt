package com.expediagroup.sdk.core.model

interface OperationParams {
    fun getHeaders() : Map<String, String>?
    fun getQueryParams(): Map<String, Iterable<String>>?
}
