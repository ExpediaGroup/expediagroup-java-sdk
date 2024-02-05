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
package com.expediagroup.sdk.core.plugin.encoding

import com.expediagroup.sdk.core.constant.HeaderValue.GZIP
import com.expediagroup.sdk.core.test.ClientFactory
import com.expediagroup.sdk.core.test.TestConstants.ANY_URL
import com.expediagroup.sdk.core.test.TestConstants.SUCCESSFUL_DUMMY_REQUEST
import com.expediagroup.sdk.core.test.TestConstants.TEXT_PLAIN
import io.ktor.client.call.body
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpResponseData
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets.UTF_8
import java.util.zip.GZIPOutputStream

internal class EncodingPluginTest {
    @Test
    fun `adds accept-encoding=gzip to request headers`() {
        runBlocking {
            val httpClient = ClientFactory.createExpediaGroupClient().httpClient
            val testRequest = httpClient.get(ANY_URL)

            Assertions.assertThat(testRequest.request.headers[HttpHeaders.AcceptEncoding]).isEqualTo(
                GZIP
            )
        }
    }

    @Test
    fun `can process content-encoding=gzip responses properly`() {
        runBlocking {
            val mockEngine = createGzipMockEngine()
            val httpClient = ClientFactory.createRapidClient(mockEngine).httpClient
            val testRequest = httpClient.get(ANY_URL)

            Assertions.assertThat(testRequest.body<String>()).isEqualTo(
                SUCCESSFUL_DUMMY_REQUEST
            )
        }
    }

    private fun createGzipMockEngine() =
        MockEngine {
            successfulResponse()
        }

    private fun MockRequestHandleScope.successfulResponse(): HttpResponseData {
        return respond(
            content =
                ByteReadChannel(
                    SUCCESSFUL_DUMMY_REQUEST.let { content ->
                        val bos = ByteArrayOutputStream()
                        GZIPOutputStream(bos).bufferedWriter(UTF_8).use { it.write(content) }
                        bos.toByteArray()
                    }
                ),
            status = HttpStatusCode.OK,
            headers =
                headersOf(
                    Pair(HttpHeaders.ContentType, listOf(TEXT_PLAIN)),
                    Pair(HttpHeaders.ContentEncoding, listOf(GZIP))
                )
        )
    }
}
