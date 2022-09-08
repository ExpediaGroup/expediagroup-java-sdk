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
package com.expediagroup.sdk.core.configuration.provider

import com.expediagroup.sdk.core.config.provider.FileConfigurationProvider
import com.expediagroup.sdk.core.constants.ClientConstants.AUTH_ENDPOINT_KEY
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_CONFIGS_FILE_PATH
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_KEY
import com.expediagroup.sdk.core.constants.ClientConstants.CLIENT_SECRET
import com.expediagroup.sdk.core.constants.ClientConstants.CREDENTIALS_FILE_PATH
import com.expediagroup.sdk.core.constants.ClientConstants.ENDPOINT_KEY

/**
 * File System implementation of [ConfigurationProvider] to fall back to for any missing configuration.
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property authEndpoint The API endpoint to use for authentication.
 */
internal class FileSystemConfigurationProvider(
    private val credentialsFilePath: String = CREDENTIALS_FILE_PATH,
    private val configurationsFilePath: String = CLIENT_CONFIGS_FILE_PATH
) : ConfigurationProvider {
    private val fileConfigurationProvider: FileConfigurationProvider by lazy { FileConfigurationProvider() }
    private val credentials: Map<String, String> by lazy { fileConfigurationProvider[credentialsFilePath].data() }
    private val configurations: Map<String, String> by lazy { fileConfigurationProvider[configurationsFilePath].data() }

    override val key: String? by lazy { credentials[CLIENT_KEY] }
    override val secret: String? by lazy { credentials[CLIENT_SECRET] }
    override val endpoint: String? by lazy { configurations[ENDPOINT_KEY] }
    override val authEndpoint: String? by lazy { configurations[AUTH_ENDPOINT_KEY] }
}
