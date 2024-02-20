/*
 * Copyright (C) 2022 Expedia, Inc.
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
package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.constant.HeaderKey
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.util.flattenEntries
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class HttpHandlerTest {
    companion object {
        private val environmentProvider = DefaultEnvironmentProvider("dummy")
        private val httpHandler = DefaultHttpHandler(environmentProvider)
    }

    @Nested
    inner class PerformGet {
        @Test
        fun `performGet should make a GET request and add certain headers`() {
            val capturedRequestHeaders = mutableListOf<Headers>()
            val httpClient =
                HttpClient(MockEngine) {
                    engine {
                        addHandler { request ->
                            capturedRequestHeaders.add(request.headers)
                            respond("Mock response", HttpStatusCode.OK)
                        }
                    }
                }

            runBlocking {
                httpHandler.performGet(httpClient, "https://www.example.com")
            }

            assertEquals(1, capturedRequestHeaders.size)

            val requestHeaders = capturedRequestHeaders[0].flattenEntries().toMap()

            assert(requestHeaders.containsKey(HeaderKey.X_SDK_TITLE) && requestHeaders[HeaderKey.X_SDK_TITLE] == "dummy-title")
            assert(requestHeaders.containsKey(HttpHeaders.UserAgent))
            assert(requestHeaders.containsKey(HeaderKey.TRANSACTION_ID))
        }
    }
}
