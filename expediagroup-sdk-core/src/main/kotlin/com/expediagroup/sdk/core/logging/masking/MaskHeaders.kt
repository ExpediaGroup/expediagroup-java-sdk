package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.logging.Constant

class MaskHeaders(
    private val keys: List<String>
) : (Headers) -> Headers {
    override fun invoke(headers: Headers): Headers =
        headers.newBuilder().apply {
            headers.names().filter { keys.contains(it) }.forEach { key ->
                set(key, Constant.OMITTED)
            }
        }.build()
}
