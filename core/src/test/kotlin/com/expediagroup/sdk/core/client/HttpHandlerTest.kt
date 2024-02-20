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
import com.expediagroup.sdk.core.test.ClientFactory
import io.ktor.client.statement.request
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
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
            val client = ClientFactory.createExpediaGroupClient()

            val response =
                runBlocking {
                    httpHandler.performGet(client.httpClient, "https://www.example.com")
                }

            val requestHeaders = response.request.headers
            assertTrue(requestHeaders.contains(HeaderKey.X_SDK_TITLE) && requestHeaders[HeaderKey.X_SDK_TITLE] == "dummy-title")
            assertTrue(requestHeaders.contains(HttpHeaders.UserAgent))
            assertTrue(requestHeaders.contains(HeaderKey.TRANSACTION_ID))
        }
    }
}
