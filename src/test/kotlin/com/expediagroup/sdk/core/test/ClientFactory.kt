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
package com.expediagroup.sdk.core.test

import com.expediagroup.sdk.core.client.BaseRapidClient
import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.configuration.RapidClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.RapidConfigurationProvider
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.test.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.test.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.statement.HttpResponse

internal object ClientFactory {
    val expediaGroupConfiguration = ExpediaGroupClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = ExpediaGroupConfigurationProvider.endpoint,
        authEndpoint = ExpediaGroupConfigurationProvider.authEndpoint,
        requestTimeout = ExpediaGroupConfigurationProvider.requestTimeout
    )

    private val rapidConfiguration = RapidClientConfiguration(
        key = CLIENT_KEY_TEST_CREDENTIAL,
        secret = CLIENT_SECRET_TEST_CREDENTIAL,
        endpoint = RapidConfigurationProvider.endpoint
    )

    fun createExpediaGroupClient(): ExpediaGroupClient = createExpediaGroupClient(MockEngineFactory.createDefaultEngine(), expediaGroupConfiguration)

    fun createExpediaGroupClient(mockEngine: MockEngine): ExpediaGroupClient = createExpediaGroupClient(mockEngine, expediaGroupConfiguration)
    fun createExpediaGroupClient(mockEngine: HttpClientEngine, configuration: ExpediaGroupClientConfiguration): ExpediaGroupClient = object : ExpediaGroupClient(configuration, mockEngine) {
        override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
            throw ExpediaGroupServiceException("Dummy service exception")
        }
    }

    fun createRapidClient(mockEngine: HttpClientEngine): _root_ide_package_.com.expediagroup.sdk.core.client.BaseRapidClient = object : _root_ide_package_.com.expediagroup.sdk.core.client.BaseRapidClient(rapidConfiguration, mockEngine) {
        override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
            throw ExpediaGroupServiceException("Dummy service exception")
        }
    }

    fun createRapidClient(): _root_ide_package_.com.expediagroup.sdk.core.client.BaseRapidClient = createRapidClient(MockEngineFactory.createEmptyResponseEngine())
}
