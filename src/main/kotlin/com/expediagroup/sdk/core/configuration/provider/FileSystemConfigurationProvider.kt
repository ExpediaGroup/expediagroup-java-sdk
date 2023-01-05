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
import com.expediagroup.sdk.core.constant.ConfigurationName.FILE_SYSTEM_CONFIGURATION_PROVIDER
import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.constant.Key
import com.expediagroup.sdk.core.contract.Contract
import com.expediagroup.sdk.core.contract.adhereTo

/**
 * File System implementation of [ConfigurationProvider] to fall back to for any missing configuration.
 *
 * @property credentialsFilePath path to credentials file
 * @property configurationsFilePath path to configurations file
 */
internal class FileSystemConfigurationProvider(
    private val credentialsFilePath: String = Constant.CREDENTIALS_FILE_PATH,
    private val configurationsFilePath: String = Constant.CLIENT_CONFIGS_FILE_PATH
) : ConfigurationProvider {
    private val fileConfigurationProvider: FileConfigurationProvider by lazy { FileConfigurationProvider() }
    private val credentials: Map<String, String> by lazy { fileConfigurationProvider[credentialsFilePath].data() }
    private val configurations: Map<String, String> by lazy { fileConfigurationProvider[configurationsFilePath].data() }

    override val name: String = FILE_SYSTEM_CONFIGURATION_PROVIDER
    override val key: String? by lazy { credentials[Key.CLIENT_KEY] }
    override val secret: String? by lazy { credentials[Key.CLIENT_SECRET] }
    override val endpoint: String? by lazy { configurations[Key.ENDPOINT]?.adhereTo(Contract.TRAILING_SLASH) }
    override val authEndpoint: String? by lazy { configurations[Key.AUTH_ENDPOINT] }
}
