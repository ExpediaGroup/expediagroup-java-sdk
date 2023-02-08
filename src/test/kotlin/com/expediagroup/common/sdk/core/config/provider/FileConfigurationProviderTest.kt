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
package com.expediagroup.common.sdk.core.config.provider

import com.expediagroup.common.sdk.core.constant.Constant.EMPTY_STRING
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FileConfigurationProviderTest {
    companion object {
        private const val RESOURCE_FILE_PATH = "/test_configuration.properties"
        private const val INVALID_RESOURCE_FILE_NAME = "./wrongfile.name"
        private const val API_CLIENT_KEY_NAME = "api_credentials.client_key"
        private const val API_CLIENT_KEY_VALUE = "test-client"
        private const val API_CLIENT_SECRET_KEY_NAME = "api_credentials.client_secret"
        private const val API_CLIENT_SECRET_VALUE = "test-secret"
    }

    @Test
    fun `given an empty path should return an empty configuration`() {
        val provider = FileConfigurationProvider()
        val configurationData = provider[EMPTY_STRING]
        assertNotNull(configurationData)
        assertThat(configurationData.data()).isEmpty()
    }

    @Test
    fun `file configuration provider should be able to load a file and deserialize the properties into a map`() {
        val provider = FileConfigurationProvider()
        val filePath = this::class.java.getResource(RESOURCE_FILE_PATH)?.file.orEmpty()
        val configurationData = provider[filePath]
        assertNotNull(configurationData)
        assertEquals(configurationData.data()[API_CLIENT_SECRET_KEY_NAME], API_CLIENT_SECRET_VALUE)
        assertEquals(configurationData.data()[API_CLIENT_KEY_NAME], API_CLIENT_KEY_VALUE)
    }

    @Test
    fun `file configuration provider should throw configuration exception if the file is not found`() {
        val provider: ConfigurationProvider = FileConfigurationProvider()
        assertThrows<RuntimeException> {
            provider[INVALID_RESOURCE_FILE_NAME]
        }
    }

    @Test
    fun `file configuration provider return empty data when the optional flag is active and file path doesn't exists`() {
        val provider: ConfigurationProvider = FileConfigurationProvider()
        assertEquals(provider[INVALID_RESOURCE_FILE_NAME, true].data(), emptyMap<String, String>())
    }
}
