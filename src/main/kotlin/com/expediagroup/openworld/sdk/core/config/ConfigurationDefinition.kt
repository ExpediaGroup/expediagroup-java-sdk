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
package com.expediagroup.openworld.sdk.core.config

import com.expediagroup.openworld.sdk.core.constant.provider.ExceptionMessageProvider.getConfigurationDefinedMultipleTimesMessage
import com.expediagroup.openworld.sdk.core.constant.provider.ExceptionMessageProvider.getConfigurationKeyNotDefinedMessage
import com.expediagroup.openworld.sdk.core.constant.provider.ExceptionMessageProvider.getExpectedActualNameValueMessage
import com.expediagroup.openworld.sdk.core.constant.provider.ExceptionMessageProvider.getExpectedNameValueMessage
import com.expediagroup.openworld.sdk.core.constant.provider.ExceptionMessageProvider.getRequiredConfigurationsNotDefinedMessage
import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldConfigurationException
import java.util.Locale

/**
 * A definition of a configuration property.
 */
@SuppressWarnings("TooManyFunctions")
class ConfigurationDefinition {
    private var configKeys = mutableMapOf<String, ConfigurationKey>()

    private fun define(key: ConfigurationKey): ConfigurationDefinition {
        if (configKeys.containsKey(key.name)) {
            throw OpenWorldConfigurationException(getConfigurationDefinedMultipleTimesMessage(key.name))
        }
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
    @Suppress("LongParameterList", "ForbiddenComment")
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
        configKeys[name] ?: throw OpenWorldConfigurationException(getConfigurationKeyNotDefinedMessage(name))

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
            throw OpenWorldConfigurationException(getRequiredConfigurationsNotDefinedMessage(undefinedConfigKeys.joinToString(",")))
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

    private fun parseType(name: String, value: Any, type: ConfigurationKey.Type): Any {
        return when (type) {
            ConfigurationKey.Type.BOOLEAN -> parseBoolean(value, name)
            ConfigurationKey.Type.PASSWORD -> parsePassword(value, name)
            ConfigurationKey.Type.STRING -> parseString(value, name)
            ConfigurationKey.Type.INT -> parseInt(value, name)
            ConfigurationKey.Type.DOUBLE -> parseDouble(value, name)
            ConfigurationKey.Type.LIST -> parseList(value, name)
        }
    }

    private fun parseBoolean(value: Any, name: String): Boolean {
        toBooleanOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedNameValueMessage("boolean", name, value))
    }

    private fun parsePassword(value: Any, name: String): ConfigurationKey.Password {
        toPasswordOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedActualNameValueMessage("string", value.javaClass.name, name, value))
    }

    private fun parseString(value: Any, name: String): String {
        toStringOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedActualNameValueMessage("string", value.javaClass.name, name, value))
    }

    private fun parseInt(value: Any, name: String): Int {
        toIntOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedActualNameValueMessage("32-bit integer", value.javaClass.name, name, value))
    }

    private fun parseDouble(value: Any, name: String): Double {
        toDoubleOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedActualNameValueMessage("double", value.javaClass.name, name, value))
    }

    private fun parseList(value: Any, name: String): List<*> {
        toListOrNull(value)?.let { return it }

        throw OpenWorldConfigurationException(getExpectedNameValueMessage("comma-separated list", name, value))
    }

    private fun toBooleanOrNull(value: Any): Boolean? = when (value) {
        is String -> value.lowercase(Locale.getDefault()).toBooleanStrictOrNull()
        is Boolean -> value
        else -> null
    }

    private fun toPasswordOrNull(value: Any): ConfigurationKey.Password? = when (value) {
        is ConfigurationKey.Password -> value
        is String -> ConfigurationKey.Password(value.trim())
        else -> null
    }

    private fun toStringOrNull(value: Any): String? = if (value is String) value.trim() else null

    private fun toIntOrNull(value: Any) = when (value) {
        is Number -> value.toInt()
        is String -> value.toIntOrNull()
        else -> null
    }

    private fun toDoubleOrNull(value: Any): Double? = when (value) {
        is Number -> value.toDouble()
        is String -> value.toDoubleOrNull()
        else -> null
    }

    private fun toListOrNull(value: Any): List<Any?>? = when (value) {
        is List<*> -> value
        is String -> if (value.isBlank()) {
            emptyList()
        } else {
            value.split(",").map { it.trim() }
        }

        else -> null
    }
}
