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
package com.expediagroup.sdk.core.constant

internal object ExceptionMessage {
    private const val CONFIGURATION_DEFINED_TWICE = "Configuration %s is defined twice"
    private const val CONFIGURATION_KEY_NOT_DEFINED = "Configuration key not defined, name:%s"
    private const val REQUIRED_CONFIGURATIONS_NOT_DEFINED = "Some required configurations are not defined: %s"
    private const val PROPERTY_NOT_FOUND = "Could not read properties from file %s"
    private const val EXPECTED_NAME_VALUE = "Expected value to be a %s, name:%s, value:%s"
    private const val EXPECTED_ACTUAL_NAME_VALUE = "Expected value to be a %s, but it was a %s, name:%s, value:%s"
    const val AUTHENTICATION_FAILURE = "Unable to authenticate"
    const val NOT_YET_IMPLEMENTED = "Not yet implemented"

    fun configurationDefinedTwice(configurationName: String) = CONFIGURATION_DEFINED_TWICE.format(configurationName)
    fun propertyNotFound(path: Any) = PROPERTY_NOT_FOUND.format(path)

    fun requiredConfigurationsNotDefined(configurations: String) =
        REQUIRED_CONFIGURATIONS_NOT_DEFINED.format(configurations)

    fun expectedActualNameValue(expected: String, actual: String, name: String, value: Any) =
        EXPECTED_ACTUAL_NAME_VALUE.format(expected, actual, name, value)

    fun expectedNameValue(expected: String, name: String, value: Any) =
        EXPECTED_NAME_VALUE.format(expected, name, value)

    fun configurationKeyNotDefined(name: String) = CONFIGURATION_KEY_NOT_DEFINED.format(name)
}
