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

import com.expediagroup.sdk.core.constant.HeaderKey.TRANSACTION_ID
import io.ktor.client.request.HttpRequestBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DefaultEnvironmentProviderTest {
    companion object {
        private val environmentProvider = DefaultEnvironmentProvider("dummy")
        private val httpRequestBuilder = HttpRequestBuilder()

        private val javaVersion = System.getProperty("java.version")
        private val operatingSystemName = System.getProperty("os.name")
        private val operatingSystemVersion = System.getProperty("os.version")
    }

    @Nested
    inner class AppendHeaders {
        @Test
        fun `Verify headers are appended`() {
            environmentProvider.apply {
                httpRequestBuilder.appendHeaders()

                assertEquals("dummy-title", httpRequestBuilder.headers["x-sdk-title"])
                assertTrue(httpRequestBuilder.headers.contains(TRANSACTION_ID))
                assertEquals("expediagroup-sdk-java-dummy/dummy-version (Java $javaVersion; $operatingSystemName $operatingSystemVersion)", httpRequestBuilder.headers["User-agent"])
            }
        }
    }
}
