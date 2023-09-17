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

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConfigKeyTest {

    companion object {
        private const val API_CLIENT_KEY_NAME = "api_credentials.client_key"
        private const val API_CLIENT_KEY_DOCUMENTATION =
            "This is a test configuration key for api client credentials id"

        private const val API_CLIENT_SECRET_NAME = "api_credentials.client_secret"
        private const val API_CLIENT_SECRET_DOCUMENTATION =
            "This is a test configuration key for api client credentials secret"
    }

    @Test
    fun `secrets are marked as sensitive configurations`() {
        val apiKeyConfiguration = ConfigurationKey(
            name = API_CLIENT_KEY_NAME,
            documentation = API_CLIENT_KEY_DOCUMENTATION,
            type = ConfigurationKey.Type.STRING,
            importance = ConfigurationKey.Importance.HIGH,
            defaultValue = null,
            validator = null
        )
        val apiSecretConfiguration = ConfigurationKey(
            name = API_CLIENT_SECRET_NAME,
            documentation = API_CLIENT_SECRET_DOCUMENTATION,
            type = ConfigurationKey.Type.PASSWORD,
            importance = ConfigurationKey.Importance.HIGH,
            defaultValue = null,
            validator = null
        )
        assertFalse(apiKeyConfiguration.type.isSensitive)
        assertTrue(apiSecretConfiguration.type.isSensitive)
    }
}
