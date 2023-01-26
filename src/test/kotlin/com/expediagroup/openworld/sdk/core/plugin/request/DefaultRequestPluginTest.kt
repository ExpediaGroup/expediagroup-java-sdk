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
package com.expediagroup.openworld.sdk.core.plugin.request

import com.expediagroup.openworld.sdk.core.commons.ClientFactory
import com.expediagroup.openworld.sdk.core.configuration.provider.DefaultConfigurationProvider
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class DefaultRequestPluginTest {

    @Test
    fun `making any http call with relative url should invoke the endpoint from the configuration`() {
        runBlocking {
            val client = ClientFactory.createClient()
            val testRequest = client.httpClient.get("/any-url")

            Assertions.assertThat(testRequest.request.url.toString()).isEqualTo(
                "${DefaultConfigurationProvider.endpoint}any-url"
            )
        }
    }
}
