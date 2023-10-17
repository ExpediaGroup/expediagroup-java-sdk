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
package com.expediagroup.sdk.core.config.provider

import com.expediagroup.sdk.core.constant.provider.ExceptionMessageProvider.getPropertyNotFoundMessage
import com.expediagroup.sdk.core.model.exception.ExpediaGroupException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Properties

/**
 * An implementation of [ConfigurationProvider] that represents a Properties file.
 * All property keys and values are stored as cleartext.
 */
class FileConfigurationProvider : ConfigurationProvider {
    private val emptyConfigurationData = ConfigurationData(emptyMap())

    /**
     * Retrieves the data at the given Properties file.
     *
     * @param path the file where the data resides
     * @param optional whether these configurations are optional or not
     * @return the configuration data
     */
    override fun get(
        path: String,
        optional: Boolean
    ): ConfigurationData {
        if (path.isEmpty()) {
            return emptyConfigurationData
        }

        runCatching {
            return readPropsFileIntoConfigurationData(Files.newBufferedReader(Paths.get(path)))
        }.getOrElse {
            if (!optional) {
                throw ExpediaGroupException(getPropertyNotFoundMessage(path))
            }

            return emptyConfigurationData
        }
    }

    /**
     * Retrieves the data at the given Properties file.
     *
     * We used it with getting the files within jar file.
     * @param url the file url where the data resides
     * @param optional whether these configurations are optional or not
     * @return the configuration data
     */
    override fun get(
        url: URL,
        optional: Boolean
    ): ConfigurationData {
        return runCatching {
            readPropsFileIntoConfigurationData(BufferedReader(InputStreamReader(url.openStream())))
        }.getOrElse {
            if (!optional) throw ExpediaGroupException(getPropertyNotFoundMessage(url))

            return emptyConfigurationData
        }
    }

    private fun readPropsFileIntoConfigurationData(reader: Reader): ConfigurationData {
        val data: MutableMap<String, String> = HashMap()
        reader.use {
            val properties = Properties()
            properties.load(it)
            val keys = properties.keys()
            while (keys.hasMoreElements()) {
                val key = keys.nextElement().toString()
                val value = properties.getProperty(key)
                data[key] = value
            }
            return ConfigurationData(data)
        }
    }
}
