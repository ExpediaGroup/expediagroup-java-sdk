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

import com.expediagroup.sdk.core.commons.ClientFactory
import com.expediagroup.sdk.core.commons.TestConstants.ANY_URL
import com.expediagroup.sdk.core.commons.TestConstants.GZIP
import com.expediagroup.sdk.core.constant.HeaderKey
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class EncodingPluginTest {
    @Test
    fun `adds accept-encoding=gzip to request headers`() {
        runBlocking {
            val httpClient = ClientFactory.createClient().httpClient
            val testRequest = httpClient.get(ANY_URL)

            Assertions.assertThat(testRequest.request.headers[HeaderKey.ACCEPT_ENCODING]).isEqualTo(
                GZIP
            )
        }
    }
}
