/*
 * Copyright (C) 2025 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.exemplarserver.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ReadListener
import jakarta.servlet.ServletInputStream
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

/**
 * Custom filter to simulate exceptions for GraphQL demonstration purposes.
 *
 * This filter intercepts GraphQL requests that contain specific trigger content and
 * causes them to fail at the HTTP transport level, before GraphQL processing occurs.
 */
@Component
class GraphQLDemoExceptionFilter : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        val cachedRequest = CachedBodyHttpServletRequest(httpRequest)

        if (cachedRequest.requestURI == "/graphql" && cachedRequest.method == "POST") {
            val requestBody = cachedRequest.reader.use { it.readText() }

            if (requestBody.contains("\"operationName\":\"DemoHttpException\"")) {
                httpResponse.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
                httpResponse.contentType = "application/json"
                httpResponse.writer.write("""{"error": "Transport failure: Internal server error"}""")
                return
            }

            if (requestBody.contains("\"operationName\":\"DemoNoDataError\"")) {
                httpResponse.status = HttpServletResponse.SC_OK
                httpResponse.contentType = "application/json"
                httpResponse.writer.write("""{"data": null, "errors": [{ "message": "Some error occurred" }]}""")
                return
            }
        }

        chain.doFilter(cachedRequest, response)
    }
}

internal class CachedBodyHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val cachedBody: ByteArray = request.inputStream.readAllBytes()

    override fun getInputStream(): ServletInputStream {
        val byteArrayInputStream = ByteArrayInputStream(cachedBody)

        return object : ServletInputStream() {
            override fun isFinished() = byteArrayInputStream.available() == 0

            override fun isReady() = true

            override fun setReadListener(listener: ReadListener) {}

            override fun read(): Int = byteArrayInputStream.read()
        }
    }

    override fun getReader(): BufferedReader = BufferedReader(InputStreamReader(inputStream))
}
