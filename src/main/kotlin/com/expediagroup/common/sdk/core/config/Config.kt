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

import com.expediagroup.common.sdk.core.config.provider.ConfigurationData
import com.expediagroup.common.sdk.core.constant.provider.ExceptionMessageProvider.getConfigurationUnknownMessage
import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldConfigurationException

/**
 * @property configurationData deserialized configuration data which needs to be parsed
 * @property configurationDefinition the configuration  definitions used to parse the data
 **/
class Config(
    private val configurationData: ConfigurationData,
    private val configurationDefinition: ConfigurationDefinition
) {
    private var configurations = mapOf<String, Any>()

    init {
        configurations = configurationDefinition.parse(configurationData.data())
    }

    /**
     * Gets the configuration value given a key. The key should be defined as a Configuration Definition
     *
     * @param key - string key for the config being looked up
     * @return - the value without casting it
     */
    operator fun get(key: String): Any {
        if (!configurations.containsKey(key)) {
            throw OpenWorldConfigurationException(getConfigurationUnknownMessage(key))
        }

        return configurations[key]!!
    }

    /**
     * Gets the configuration value given a key and casts it to Int. The key should be defined as a Configuration Definition and the type should be Int
     *
     * @param key - string key for the config being looked up
     * @return - the value as Int
     */
    fun getInt(key: String): Int = get(key) as Int

    /**
     * Gets the configuration value given a key and casts it to Double. The key should be defined as a Configuration Definition and the type should be Double
     *
     * @param key - string key for the config being looked up
     * @return - the value as Double
     */
    fun getDouble(key: String): Double = get(key) as Double

    /**
     * Gets the configuration value given a key and casts it to List<String>. The key should be defined as a Configuration Definition and the type should be List
     *
     * @param key - string key for the config being looked up
     * @return - the value as List<String>
     */
    fun getList(key: String): List<String> = get(key) as List<String>

    /**
     * Gets the configuration value given a key and casts it to Boolean. The key should be defined as a Configuration Definition and the type should be Boolean
     *
     * @param key - string key for the config being looked up
     * @return - the value as Boolean
     */
    fun getBoolean(key: String): Boolean = get(key) as Boolean

    /**
     * Gets the configuration value given a key and casts it to String. The key should be defined as a Configuration Definition and the type should be String
     *
     * @param key - string key for the config being looked up
     * @return - the value as String
     */
    fun getString(key: String): String = get(key) as String

    /**
     * Gets the configuration value given a key and casts it to Password. The key should be defined as a Configuration Definition and the type should be Password
     *
     * @param key - string key for the config being looked up
     * @return - the value as Password
     */
    fun getPassword(key: String): ConfigurationKey.Password = get(key) as ConfigurationKey.Password
}
