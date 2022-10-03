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
package com.expediagroup.sdk.core.config

import com.expediagroup.sdk.core.config.provider.FileConfigurationProvider
import com.expediagroup.sdk.core.model.exception.ConfigurationException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ConfigTest {

    companion object {
        private const val RESOURCE_FILE_PATH = "/test_configuration.properties"

        private const val API_CLIENT_KEY_NAME = "api_credentials.client_key"
        private const val API_CLIENT_KEY_DOCUMENTATION =
            "This is a test configuration key for api client credentials id"
        private const val API_CLIENT_KEY_VALUE = "test-client"

        private const val API_CLIENT_SECRET_NAME = "api_credentials.client_secret"
        private const val API_CLIENT_SECRET_DOCUMENTATION =
            "This is a test configuration key for api client credentials secret"
        private const val API_CLIENT_SECRET_VALUE = "test-secret"

        private const val EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_NAME = "exemplar_api.client.connection_timeout_in_ms"
        private const val EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_DOCUMENTATION =
            "This is a test configuration for client connection timeout for exemplar API"
        private const val EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_VALUE = 100

        private const val EXEMPLAR_API_CLIENT_RETRY_ENABLED_NAME = "exemplar_api.client.retry_enabled"
        private const val EXEMPLAR_API_CLIENT_RETRY_ENABLED_DOCUMENTATION =
            "This is a test configuration for client retry error codes for exemplar API"
        private const val EXEMPLAR_API_CLIENT_RETRY_ENABLED_VALUE = true

        private const val EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_NAME = "exemplar_api.client.retry_error_codes"
        private const val EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_DOCUMENTATION =
            "This is a test configuration for client retry error codes for exemplar API"
        private val EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_VALUE = listOf("408", "420", "504")

        private const val EXEMPLAR_API_CLIENT_VERSION_NAME = "exemplar_api.client.version"
        private const val EXEMPLAR_API_CLIENT_VERSION_DOCUMENTATION =
            "This is a test configuration for client version of exemplar API"
        private const val EXEMPLAR_API_CLIENT_VERSION_VALUE = 1.1
    }

    @Test
    fun `defined configurations are correctly parsed and available for consumption`() {
        val filePath = this::class.java.getResource(RESOURCE_FILE_PATH)?.file.orEmpty()
        val configurationDefinition = ConfigurationDefinition()

        configurationDefinition.define(
            name = API_CLIENT_KEY_NAME,
            documentation = API_CLIENT_KEY_DOCUMENTATION,
            type = ConfigurationKey.Type.STRING,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = API_CLIENT_SECRET_NAME,
            documentation = API_CLIENT_SECRET_DOCUMENTATION,
            type = ConfigurationKey.Type.PASSWORD,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_NAME,
            documentation = EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_DOCUMENTATION,
            type = ConfigurationKey.Type.INT,
            importance = ConfigurationKey.Importance.MEDIUM
        )
        configurationDefinition.define(
            name = EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_NAME,
            documentation = EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_DOCUMENTATION,
            type = ConfigurationKey.Type.LIST,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = EXEMPLAR_API_CLIENT_RETRY_ENABLED_NAME,
            documentation = EXEMPLAR_API_CLIENT_RETRY_ENABLED_DOCUMENTATION,
            type = ConfigurationKey.Type.BOOLEAN,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = EXEMPLAR_API_CLIENT_VERSION_NAME,
            documentation = EXEMPLAR_API_CLIENT_VERSION_DOCUMENTATION,
            type = ConfigurationKey.Type.DOUBLE,
            importance = ConfigurationKey.Importance.LOW
        )
        val provider = FileConfigurationProvider()
        assertDoesNotThrow {
            val configuration = Config(provider[filePath], configurationDefinition)
            assertEquals(configuration.getString(API_CLIENT_KEY_NAME), API_CLIENT_KEY_VALUE)
            assertEquals(configuration.getPassword(API_CLIENT_SECRET_NAME), ConfigurationKey.Password(API_CLIENT_SECRET_VALUE))
            assertEquals(configuration.getPassword(API_CLIENT_SECRET_NAME).password, API_CLIENT_SECRET_VALUE)
            assertEquals(configuration.getInt(EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_NAME), EXEMPLAR_API_CLIENT_CONNECTION_TIMEOUT_IN_MS_VALUE)
            assertEquals(configuration.getList(EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_NAME), EXEMPLAR_API_CLIENT_RETRY_ERROR_CODES_VALUE)
            assertEquals(configuration.getBoolean(EXEMPLAR_API_CLIENT_RETRY_ENABLED_NAME), EXEMPLAR_API_CLIENT_RETRY_ENABLED_VALUE)
            assertEquals(configuration.getDouble(EXEMPLAR_API_CLIENT_VERSION_NAME), EXEMPLAR_API_CLIENT_VERSION_VALUE)
        }
    }

    @Test
    fun `fails to initialize if defined configurations are unavailable`() {
        val filePath = this::class.java.getResource(RESOURCE_FILE_PATH)?.file.orEmpty()
        val configurationDefinition = ConfigurationDefinition()

        configurationDefinition.define(
            name = "missing_configuration",
            documentation = "documentation of missing configuration",
            type = ConfigurationKey.Type.STRING,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = API_CLIENT_SECRET_NAME,
            documentation = API_CLIENT_SECRET_DOCUMENTATION,
            type = ConfigurationKey.Type.PASSWORD,
            importance = ConfigurationKey.Importance.HIGH
        )
        val provider = FileConfigurationProvider()
        val throwable = assertThrows<ConfigurationException> {
            Config(provider[filePath], configurationDefinition)
        }
        assertEquals(throwable.message, "Some required configurations are not defined: missing_configuration")
    }

    @Test
    fun `throws an exception when an undefined config is retrieved`() {
        val filePath = this::class.java.getResource(RESOURCE_FILE_PATH)?.file.orEmpty()
        val configurationDefinition = ConfigurationDefinition()
        val provider = FileConfigurationProvider()
        val configuration = Config(provider[filePath], configurationDefinition)

        val throwable = assertThrows<ConfigurationException> {
            configuration.getDouble(EXEMPLAR_API_CLIENT_VERSION_NAME)
        }
        assertEquals(throwable.message, "Unknown configuration exemplar_api.client.version")
    }

    @Test
    fun `fails to initialize if defined configuration are of a type that doesn't match the instance`() {
        val filePath = this::class.java.getResource(RESOURCE_FILE_PATH)?.file.orEmpty()
        val configurationDefinition = ConfigurationDefinition()

        configurationDefinition.define(
            name = API_CLIENT_KEY_NAME,
            documentation = API_CLIENT_KEY_DOCUMENTATION,
            type = ConfigurationKey.Type.INT,
            importance = ConfigurationKey.Importance.HIGH
        )
        configurationDefinition.define(
            name = API_CLIENT_SECRET_NAME,
            documentation = API_CLIENT_SECRET_DOCUMENTATION,
            type = ConfigurationKey.Type.PASSWORD,
            importance = ConfigurationKey.Importance.HIGH
        )
        val provider = FileConfigurationProvider()
        val throwable = assertThrows<ConfigurationException> {
            Config(provider[filePath], configurationDefinition)
        }
        assertEquals(throwable.message, "Expected value to be a  32-bit integer, but it was a java.lang.String, name:api_credentials.client_key, value:test-client")
    }
}
