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
package com.expediagroup.sdk.core.plugin.authentication.strategy

import com.expediagroup.sdk.core.configuration.Credentials
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationConfiguration
import com.expediagroup.sdk.core.test.ClientFactory.createExpediaGroupClient
import com.expediagroup.sdk.core.test.TestConstants
import io.ktor.client.HttpClientConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class AuthenticationStrategyTest {
    @Nested
    inner class AuthenticationStrategyCompanionObjectTest {
        @Test
        fun `test factory method`() {
            val configuration =
                AuthenticationConfiguration.from(
                    HttpClientConfig(),
                    Credentials(
                        TestConstants.CLIENT_KEY_TEST_CREDENTIAL,
                        TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
                    ),
                    "authEndpoint"
                )

            val strategy = AuthenticationStrategy.from(configuration, createExpediaGroupClient())
            assertThat(strategy is ExpediaGroupAuthenticationStrategy)
        }
    }
}
