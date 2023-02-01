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
package com.expediagroup.common.sdk.core.config.provider

/**
 * Creates a new ConfigData with the given data.
 *
 * @property data a Map of key-value pairs
 * @property ttl the time to live for the data
 */
class ConfigurationData(private val data: Map<String, String>, private val ttl: Long? = null) {
    /**
     * Returns the data.
     *
     * @return data a Map of key-value pairs
     */
    fun data(): Map<String, String> = data

    /**
     * Returns the TTL (in milliseconds).
     *
     * @return ttl the time-to-live (in milliseconds) of the data, or null if there is no TTL
     */
    fun ttl(): Long? = ttl
}
