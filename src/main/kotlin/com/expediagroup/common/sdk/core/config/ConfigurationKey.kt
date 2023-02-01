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
package com.expediagroup.common.sdk.core.config

/**
 * A key of a configuration property.
 *
 * @property name the name of the property
 * @property documentation the documentation of the property
 * @property type the type of the property
 * @property importance the importance of the property
 * @property defaultValue an optional default value of the property
 * @property validator an optional validator of the property
 */
data class ConfigurationKey(
    val name: String,
    val documentation: String,
    val type: Type,
    val importance: Importance,
    val defaultValue: Any?,
    val validator: Validator?
) {
    /**
     * The config types.
     */
    enum class Type {
        BOOLEAN, STRING, INT, DOUBLE, LIST, PASSWORD;

        /**
         * Whether the configuration type is sensitive.
         */
        val isSensitive: Boolean
            get() = this == PASSWORD
    }

    /**
     * A password representation.
     *
     * @property password the password value
     */
    data class Password(val password: String)

    /**
     * The importance level for a configuration.
     */
    enum class Importance {
        HIGH, MEDIUM, LOW
    }

    /**
     * Validation logic the user may provide to perform single configuration validation.
     */
    interface Validator {
        /**
         * Perform single configuration validation.
         *
         * @param name The name of the configuration
         * @param value The value of the configuration
         * @throws ConfigurationException if the value is invalid
         */
        fun ensureValid(name: String, value: Any): Any
    }
}
