package com.expediagroup.sdk.core.poc.logging

import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.json.JsonHttpContent
import org.apache.commons.logging.impl.SimpleLog
import org.slf4j.LoggerFactory
import java.util.logging.Logger

class RequestBodyLogger: HttpExecuteInterceptor {
    private val logger = LoggerFactory.getLogger("com.expediagroup")

    override fun intercept(request: HttpRequest) {
        logger.info("Omar")
        Logger.getGlobal()
        request.setCurlLoggingEnabled(true)
        if (request.content != null) {
            if (request.content is JsonHttpContent) {
                val c = request.content as JsonHttpContent
                c.writeTo(System.out)
            println("Request body: ${request.content.toString()}")
            }
        }
    }
}
