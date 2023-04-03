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
package com.expediagroup.openworld.sdk.core.authentication.strategy

import com.expediagroup.openworld.sdk.core.constant.Authentication.BEARER
import com.expediagroup.openworld.sdk.core.constant.HeaderKey
import com.expediagroup.openworld.sdk.core.plugin.authentication.AuthenticationPluginTest
import com.expediagroup.openworld.sdk.core.test.ClientFactory
import com.expediagroup.openworld.sdk.core.test.TestConstants.ACCESS_TOKEN
import com.expediagroup.openworld.sdk.core.test.TestConstants.ANY_URL
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OpenWorldAuthenticationStrategyTest : AuthenticationPluginTest() {

    @Test
    fun `making any http call should invoke the authorized token`() {
        runBlocking {
            val httpClient = ClientFactory.createOpenWorldClient().httpClient
            val testRequest = httpClient.get(ANY_URL)

            assertThat(testRequest.request.headers[HeaderKey.AUTHORIZATION]).isEqualTo(
                "$BEARER $ACCESS_TOKEN"
            )
        }
    }
}
