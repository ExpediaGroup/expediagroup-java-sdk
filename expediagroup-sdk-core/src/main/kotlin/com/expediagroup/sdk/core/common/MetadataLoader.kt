/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.core.common

import java.util.Locale
import java.util.Properties

/**
 * Utility object for loading SDK metadata from the generated `sdk.properties` file along with other
 * system properties like JVM info and host OS info.
 */
internal object MetadataLoader {
    private const val UNKNOWN = "unknown"

    @Volatile
    private var cachedMetadata: Metadata? = null

    /**
     * Loads the SDK metadata from sdk.properties file and caches the results for future calls.
     */
    fun load(): Metadata = cachedMetadata ?: synchronized(this) {
        cachedMetadata ?: readPropertiesFile().also { cachedMetadata = it }
    }

    /**
     * Clears the cached metadata
     */
    @Synchronized
    fun clear() {
        cachedMetadata = null
    }

    private fun readPropertiesFile(): Metadata {
        val props = Properties()

        Thread.currentThread().contextClassLoader?.getResourceAsStream("sdk.properties")?.use {
            props.load(it)
        }

        return Metadata(
            artifactName = props.getProperty("artifactName", UNKNOWN),
            groupId = props.getProperty("groupId", UNKNOWN),
            version = props.getProperty("version", UNKNOWN),
            jdkVersion = System.getProperty("java.version", UNKNOWN),
            jdkVendor = System.getProperty("java.vendor", UNKNOWN),
            osName = System.getProperty("os.name", UNKNOWN),
            osVersion = System.getProperty("os.version", UNKNOWN),
            arch = System.getProperty("os.arch", UNKNOWN),
            locale = Locale.getDefault().toString()
        )
    }
}

data class Metadata(
    val artifactName: String,
    val groupId: String,
    val version: String,
    val jdkVersion: String,
    val jdkVendor: String,
    val osName: String,
    val osVersion: String,
    val arch: String,
    val locale: String
) {
    fun asUserAgentString(): String =
        "$artifactName/$version (Provider/$groupId; Java/$jdkVersion; Vendor/$jdkVendor; OS/$osName - $osVersion; Arch/$arch; Locale/$locale)"
}
