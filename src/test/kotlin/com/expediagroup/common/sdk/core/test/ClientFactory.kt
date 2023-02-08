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
package com.expediagroup.common.sdk.core.test

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.common.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.configuration.provider.OpenWorldConfigurationProvider
import com.expediagroup.rapid.sdk.core.client.RapidClient
import com.expediagroup.rapid.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.rapid.sdk.core.configuration.provider.RapidConfigurationProvider
import io.ktor.client.engine.HttpClientEngine

internal object ClientFactory {
    val openWorldConfiguration = OpenWorldClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = OpenWorldConfigurationProvider.endpoint,
        authEndpoint = OpenWorldConfigurationProvider.authEndpoint
    )

    private val rapidConfiguration = RapidClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = RapidConfigurationProvider.endpoint
    )

    fun createOpenWorldClient(): OpenWorldClient = Client.create(openWorldConfiguration, MockEngineFactory.createDefaultEngine())

    fun createOpenWorldClient(mockEngine: HttpClientEngine): OpenWorldClient = Client.create(
        openWorldConfiguration,
        mockEngine
    )

    fun createOpenWorldClient(mockEngine: HttpClientEngine, configuration: OpenWorldClientConfiguration): OpenWorldClient = Client.create(configuration, mockEngine)

    fun createRapidClient(mockEngine: HttpClientEngine): RapidClient = Client.create(
        rapidConfiguration,
        mockEngine
    )

    fun createRapidClient(): RapidClient = createRapidClient(MockEngineFactory.createEmptyResponseEngine())
}
