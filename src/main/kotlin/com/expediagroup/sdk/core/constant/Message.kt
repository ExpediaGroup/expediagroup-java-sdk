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

internal object Message {
    const val UNABLE_TO_AUTHENTICATE = "Unable to authenticate"
    const val PROPERTY_NOT_FOUND = "Could not read properties from file %s"
    const val NOT_YET_IMPLEMENTED = "Not yet implemented"
    const val CONFIGURATION_IS_DEFINED_TWICE = "Configuration %s is defined twice"
    const val SOME_REQUIRED_CONFIGURATIONS_NOT_DEFINED = "Some required configurations are not defined: %s"
    const val EXPECTED_VALUE_SHOULD_BE = "Expected value to be a %s, but it was a %s, name:%s, value:%s"
    const val EXPECTED_VALUE_TRUE_OR_FALSE = "Expected value to be either true or false, name:%s, value:%s"
    const val EXPECTED_COMMA_SEPERATED_LIST = "Expected a comma separated list, name:%s, value:%s"
}
