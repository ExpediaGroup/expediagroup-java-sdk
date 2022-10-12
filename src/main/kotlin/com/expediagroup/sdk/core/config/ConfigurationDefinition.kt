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

import com.expediagroup.sdk.core.constant.Message.CONFIGURATION_IS_DEFINED_TWICE
import com.expediagroup.sdk.core.constant.Message.EXPECTED_COMMA_SEPERATED_LIST
import com.expediagroup.sdk.core.constant.Message.EXPECTED_VALUE_SHOULD_BE
import com.expediagroup.sdk.core.constant.Message.EXPECTED_VALUE_TRUE_OR_FALSE
import com.expediagroup.sdk.core.constant.Message.SOME_REQUIRED_CONFIGURATIONS_NOT_DEFINED
import com.expediagroup.sdk.core.model.exception.ConfigurationException
import org.slf4j.LoggerFactory

/**
 * A definition of a configuration property.
 */
class ConfigurationDefinition {
    private val logger = LoggerFactory.getLogger(javaClass)
    private var configKeys = mutableMapOf<String, ConfigurationKey>()

    /**
     * Define a new configuration which is required by the SDK.
     *
     * @param key key which needs to be defined
     * @return ConfigurationDefinition object after adding the configuration key
     */
    private fun define(key: ConfigurationKey): ConfigurationDefinition {
        if (configKeys.containsKey(key.name)) throwConfigurationException(CONFIGURATION_IS_DEFINED_TWICE.format(key.name))
        configKeys[key.name] = key
        return this
    }

    /**
     * Define a new configuration which is required by the SDK.
     *
     * @param name of the configuration, it should be unique, use a . delimited string eg : api_credentials.client_key
     * @param documentation documentation for the configuration key, its logged and used by the client of the sdk to set the right value
     * @param type type of the expected configuration value.
     * @param importance specifies the importance of the key, sdk fails to initialize if a configuration for a key of high importance is not passed
     * @param defaultValue the default value of the configuration if it's not passed, it's an optional field, some key's won't have a default
     * @param validator - configuration validator if the value needs additional validation. eg : if a value has to be between 1-10 just expecting the type to be INT would not be enough
     * @return ConfigurationDefinition object after adding the configuration key
     */

    // TODO: Fix the cause and remove the suppression warning.
    @Suppress("LongParameterList")
    fun define(
        name: String,
        documentation: String,
        type: ConfigurationKey.Type,
        importance: ConfigurationKey.Importance,
        defaultValue: Any? = null,
        validator: ConfigurationKey.Validator? = null
    ): ConfigurationDefinition {
        val key = ConfigurationKey(
            name = name,
            documentation = documentation,
            type = type,
            importance = importance,
            defaultValue = defaultValue,
            validator = validator
        )
        return define(key)
    }

    /**
     * Gets the configuration key given the unique identifier.
     *
     * @param name - identifier for the configuration key
     * @return - configuration key
     */
    fun get(name: String): ConfigurationKey =
        configKeys[name] ?: throw ConfigurationException("configuration key not defined, name:$name")

    /**
     * Parses the configuration values based on the defined keys.
     *
     * @param props - unparsed configuration values as properties
     * @return - map of configuration names along with its parsed values
     */
    fun parse(props: Map<String, Any>): Map<String, Any> {
        // Check all configurations are defined
        val undefinedConfigKeys: List<String> = undefinedConfigs(props)
        if (undefinedConfigKeys.isNotEmpty()) {
            throwConfigurationException(
                SOME_REQUIRED_CONFIGURATIONS_NOT_DEFINED.format(
                    undefinedConfigKeys.joinToString(
                        ","
                    )
                )
            )
        }
        // parse all known keys
        val values: MutableMap<String, Any> = HashMap()
        for (key in configKeys.values) values[key.name] =
            parseValue(key, props[key.name])
        return values
    }

    private fun undefinedConfigs(props: Map<String, Any>): List<String> {
        val importantKeys = configKeys.values.filter { key ->
            run {
                key.defaultValue == null && key.importance == ConfigurationKey.Importance.HIGH
            }
        }.map { it.name }
        return importantKeys.filterNot { props.keys.contains(it) }
    }

    private fun parseValue(key: ConfigurationKey, value: Any?): Any {
        return parseType(key.name, run { value ?: key.defaultValue }!!, key.type)
            .let { key.validator?.ensureValid(key.name, it) ?: it }
    }

    // TODO: Fix the causes and remove the suppression warning.
    @Suppress("ComplexMethod", "ThrowsCount")
    private fun parseType(name: String, value: Any, type: ConfigurationKey.Type): Any {
        return when (type) {
            ConfigurationKey.Type.BOOLEAN ->
                when (value) {
                    is String ->
                        if (value.equals("true", ignoreCase = true)) true
                        else if (value.equals("false", ignoreCase = true)) false
                        else throwConfigurationException(EXPECTED_VALUE_TRUE_OR_FALSE.format(name, value))

                    is Boolean -> value
                    else -> throwConfigurationException(EXPECTED_VALUE_TRUE_OR_FALSE.format(name, value))
                }

            ConfigurationKey.Type.PASSWORD ->
                value as? ConfigurationKey.Password
                    ?: if (value is String) ConfigurationKey.Password(value.trim())
                    else throwConfigurationException(
                        EXPECTED_VALUE_SHOULD_BE.format(
                            "string",
                            value.javaClass.name,
                            name,
                            value
                        )
                    )

            ConfigurationKey.Type.STRING ->
                if (value is String) value.trim()
                else throwConfigurationException(
                    EXPECTED_VALUE_SHOULD_BE.format(
                        "string",
                        value.javaClass.name,
                        name,
                        value
                    )
                )

            ConfigurationKey.Type.INT ->
                when (value) {
                    is Number -> value.toInt()
                    is String -> value.toIntOrNull() ?: throwConfigurationException(
                        EXPECTED_VALUE_SHOULD_BE.format(
                            "32-bit integer",
                            value.javaClass.name,
                            name,
                            value
                        )
                    )

                    else -> throwConfigurationException(
                        EXPECTED_VALUE_SHOULD_BE.format(
                            "32-bit integer",
                            value.javaClass.name,
                            name,
                            value
                        )
                    )
                }

            ConfigurationKey.Type.DOUBLE ->
                when (value) {
                    is Number -> value.toDouble()
                    is String -> value.toDoubleOrNull() ?: throwConfigurationException(
                        EXPECTED_VALUE_SHOULD_BE.format(
                            "double",
                            value.javaClass.name,
                            name,
                            value
                        )
                    )

                    else -> throwConfigurationException(
                        EXPECTED_VALUE_SHOULD_BE.format(
                            "double",
                            value.javaClass.name,
                            name,
                            value
                        )
                    )
                }

            ConfigurationKey.Type.LIST ->
                value as? List<*>
                    ?: if (value is String) if (value.isEmpty()) emptyList<Any>() else value.split(",")
                    else throwConfigurationException(EXPECTED_COMMA_SEPERATED_LIST.format(name, value))
        }
    }

    private fun throwConfigurationException(message: String) {
        logger.error(message)
        throw ConfigurationException(message)
    }
}
