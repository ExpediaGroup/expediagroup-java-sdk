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
package com.expediagroup.openworld.sdk.core.configuration.provider

import com.expediagroup.openworld.sdk.core.constant.Constant
import com.expediagroup.openworld.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldConfigurationException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File

internal class FileSystemConfigurationProviderTest {

    @Test
    fun `should return null configurations when paths are not set`() {
        FileSystemConfigurationProvider(
            credentialsFilePath = EMPTY_STRING,
            configurationsFilePath = EMPTY_STRING
        ).let {
            assertNotNull(it)
            assertNull(it.key)
            assertNull(it.secret)
        }
    }

    @Test
    fun `should throw an exception when paths are set but files do not exist`() {
        assertThrows<OpenWorldConfigurationException> {
            FileSystemConfigurationProvider(
                credentialsFilePath = "invalid_path",
                configurationsFilePath = "invalid_path"
            ).key
        }
    }

    @Test
    fun `should return null configurations when paths are set and files exist but empty`() {
        FileSystemConfigurationProvider(
            credentialsFilePath = "src/test/resources/credentials-empty.properties",
            configurationsFilePath = "src/test/resources/configurations-empty.properties"
        ).let {
            assertNotNull(it)
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["configurations", "configurations-without-slash"])
    fun `should return configurations when paths are set and files exist`(configurationsFileName: String) {
        FileSystemConfigurationProvider(
            credentialsFilePath = "src/test/resources/credentials.properties",
            configurationsFilePath = "src/test/resources/$configurationsFileName.properties"
        ).let {
            assertNotNull(it)
            assertEquals("abc123", it.key)
            assertEquals("abcd1234", it.secret)
            assertEquals("https://example.com/", it.endpoint)
            assertEquals("https://auth.example.com/", it.authEndpoint)
        }
    }

    @Test
    fun `test default configurations if default files do not exist`() {
        if (File(Constant.CREDENTIALS_FILE_PATH).exists() && File(Constant.CLIENT_CONFIGS_FILE_PATH).exists()) return

        assertThrows<OpenWorldConfigurationException> {
            FileSystemConfigurationProvider().key
        }
    }
}
