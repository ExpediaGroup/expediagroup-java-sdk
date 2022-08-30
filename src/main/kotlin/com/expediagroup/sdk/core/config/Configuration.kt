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

import com.expediagroup.sdk.core.config.provider.ConfigurationData
import com.expediagroup.sdk.core.exceptions.ConfigurationException

@Deprecated("we should be using the Config Class instead fo parse the values, the strongly typed objects can live with the respective modules")
data class Configuration @JvmOverloads constructor(
    val clientConfiguration: ClientConfiguration,
    val network: NetworkConfiguration = NetworkConfiguration(),
    val logging: LoggingConfiguration = LoggingConfiguration()
)

/**
 * @param configurationData deserialized configuration data which needs to be parsed
 * @param configurationDefinition the configuration  definitions used to parse the data
 **/
class Config(
    val configurationData: ConfigurationData,
    val configurationDefinition: ConfigurationDefinition
) {
    private var configurations = mapOf<String, Any>()

    init {
        configurations = configurationDefinition.parse(configurationData.data())
    }

    operator fun get(key: String): Any {
        if (!configurations.containsKey(key)) throw ConfigurationException(String.format("Unknown configuration $key"))
        return configurations[key]!!
    }

    fun getInt(key: String): Int {
        return get(key) as Int
    }

    fun getDouble(key: String): Double {
        return get(key) as Double
    }

    fun getList(key: String): List<String> {
        return get(key) as List<String>
    }

    fun getBoolean(key: String): Boolean? {
        return get(key) as Boolean
    }

    fun getString(key: String): String {
        return get(key) as String
    }
    fun getPassword(key: String): ConfigurationKey.Password {
        return get(key) as ConfigurationKey.Password
    }
}
