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

/**
 * A configuration provider that could be implemented to provide configuration from a variety of sources.
 */
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
}
