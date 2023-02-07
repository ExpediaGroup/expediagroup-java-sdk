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
package com.expediagroup.common.sdk.core.constant.provider

internal object ExceptionMessageProvider {
    fun getConfigurationDefinedMultipleTimesMessage(configurationName: String): String =
        "Configuration $configurationName is defined multiple times"

    fun getRequiredConfigurationsNotDefinedMessage(configurations: String): String =
        "Some required configurations are not defined: $configurations"

    fun getExpectedActualNameValueMessage(expected: String, actual: String, name: String, value: Any): String =
        "Expected value to be a $expected, but it was a $actual, name: $name, value: $value"

    fun getExpectedNameValueMessage(expected: String, name: String, value: Any): String =
        "Expected value to be a $expected, name: $name, value: $value"

    fun getConfigurationKeyNotDefinedMessage(name: String): String = "Configuration key not defined, name: $name"

    fun getConfigurationUnknownMessage(key: String): String = "Unknown configuration $key"

    fun getMissingRequiredConfigurationMessage(name: String): String = "Missing required configuration: $name"
}
