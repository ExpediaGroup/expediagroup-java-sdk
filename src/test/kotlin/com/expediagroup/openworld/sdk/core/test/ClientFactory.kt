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
package com.expediagroup.openworld.sdk.core.test

import com.expediagroup.openworld.sdk.core.client.BaseRapidClient
import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.openworld.sdk.core.configuration.provider.OpenWorldConfigurationProvider
import com.expediagroup.openworld.sdk.core.configuration.provider.RapidConfigurationProvider
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldServiceException
import com.expediagroup.openworld.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.openworld.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.statement.HttpResponse

internal object ClientFactory {
    val openWorldConfiguration = OpenWorldClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = OpenWorldConfigurationProvider.endpoint,
        authEndpoint = OpenWorldConfigurationProvider.authEndpoint,
        requestTimeout = OpenWorldConfigurationProvider.requestTimeout
    )

    private val rapidConfiguration = RapidClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = RapidConfigurationProvider.endpoint
    )

    fun createOpenWorldClient(): OpenWorldClient = createOpenWorldClient(MockEngineFactory.createDefaultEngine(), openWorldConfiguration)

    fun createOpenWorldClient(mockEngine: MockEngine): OpenWorldClient = createOpenWorldClient(mockEngine, openWorldConfiguration)
    fun createOpenWorldClient(mockEngine: HttpClientEngine, configuration: OpenWorldClientConfiguration): OpenWorldClient = object : OpenWorldClient(configuration, mockEngine) {
        override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
            throw OpenWorldServiceException("Dummy service exception")
        }
    }

    fun createRapidClient(mockEngine: HttpClientEngine): BaseRapidClient = object : BaseRapidClient(rapidConfiguration, mockEngine) {
        override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
            throw OpenWorldServiceException("Dummy service exception")
        }
    }

    fun createRapidClient(): BaseRapidClient = createRapidClient(MockEngineFactory.createEmptyResponseEngine())
}
