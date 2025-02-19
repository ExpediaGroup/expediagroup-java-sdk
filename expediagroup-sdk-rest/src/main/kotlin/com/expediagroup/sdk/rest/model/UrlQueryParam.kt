/*
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.rest.util.StringifyQueryParam

/**
 * Data class representing a URL query parameter.
 *
 * @property key The key of the query parameter.
 * @property value The list of values associated with the query parameter.
 * @property stringify The stringifier used to convert the query parameter to a string.
 */
data class UrlQueryParam(
    val key: String,
    val value: List<String>,
    val stringify: StringifyQueryParam
) {
    init {
        require(key.isNotBlank()) { "Query parameter key cannot be blank!" }
    }

    /**
     * Converts the query parameter to a string using the provided stringifier.
     *
     * @return The string representation of the query parameter.
     */
    override fun toString(): String = stringify(this)
}
