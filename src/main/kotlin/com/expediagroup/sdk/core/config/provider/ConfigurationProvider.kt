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

import java.net.URL

interface ConfigurationProvider {

    /**
     * Retrieves the data at the given path.
     *
     * @param path the path where the data resides
     * @param optional will not throw an exception if optional field is set to true
     * @return the configuration data
     */
    operator fun get(path: String, optional: Boolean = false): ConfigurationData

    /**
     * Retrieves the data at the given path.
     *
     * @param url the uri where the data resides
     * @param optional will not throw an exception if optional field is set to true
     * @return the configuration data
     */
    operator fun get(url: URL, optional: Boolean = false): ConfigurationData

    /**
     * Retrieves the data with the given keys at the given path.
     *
     * @param path the path where the data resides
     * @param keys the keys whose values will be retrieved
     * @param optional will not throw an exception if optional field is set to true
     * @return the configuration data
     */
    operator fun get(path: String, keys: Set<String>, optional: Boolean = false): ConfigurationData

    /**
     * Subscribes to changes for the given keys at the given path (optional operation).
     *
     * @param path the path where the data resides
     * @param keys the keys whose values will be retrieved
     * @param callback the callback to invoke upon change
     * @throws [UnsupportedOperationException] if the subscribe operation is not supported
     */
    fun subscribe(path: String, keys: Set<String>, callback: ConfigurationChangeCallback)

    /**
     * Unsubscribes to changes for the given keys at the given path (optional operation).
     *
     * @param path the path where the data resides
     * @param keys the keys whose values will be retrieved
     * @param callback the callback to be unsubscribed from changes
     * @throws [UnsupportedOperationException] if the unsubscribe operation is not supported
     */
    fun unsubscribe(path: String, keys: Set<String>, callback: ConfigurationChangeCallback)

    /**
     * Clears all subscribers (optional operation).
     *
     * @throws [UnsupportedOperationException] if the unsubscribeAll operation is not supported
     */
    fun unsubscribeAll()
}
