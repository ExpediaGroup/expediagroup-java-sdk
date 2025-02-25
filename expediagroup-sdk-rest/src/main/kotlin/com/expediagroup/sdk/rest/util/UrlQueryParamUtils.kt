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

package com.expediagroup.sdk.rest.util

import com.expediagroup.sdk.rest.model.UrlQueryParam

/**
 * Functional interface for converting a UrlQueryParam to a String.
 */
fun interface StringifyQueryParam : (UrlQueryParam) -> String {
    /**
     * Converts the given UrlQueryParam to a String.
     *
     * @param queryParam the UrlQueryParam to convert
     * @return the String representation of the UrlQueryParam
     */
    override fun invoke(queryParam: UrlQueryParam): String
}

/**
 * Converts a UrlQueryParam to a form-encoded String.
 * Example: key=value1,value2
 */
val stringifyForm =
    StringifyQueryParam { param ->
        StringBuilder().apply {
            append("${param.key}=")
            append(param.value.joinToString(","))
        }.toString()
    }

/**
 * Converts a UrlQueryParam to an exploded form-encoded String.
 * Example: key=value1&key=value2
 */
val stringifyExplode =
    StringifyQueryParam { param ->
        StringBuilder().apply {
            append("${param.key}=")
            append(param.value.joinToString("&${param.key}="))
        }.toString()
    }

/**
 * Converts a UrlQueryParam to a space-delimited String.
 * Example: key=value1%20value2
 */
val stringifySpaceDelimited =
    StringifyQueryParam { param ->
        StringBuilder().apply {
            append("${param.key}=")
            append(param.value.joinToString("%20"))
        }.toString()
    }

/**
 * Converts a UrlQueryParam to a pipe-delimited String.
 * Example: key=value1|value2
 */
val stringifyPipeDelimited =
    StringifyQueryParam { param ->
        StringBuilder().apply {
            append("${param.key}=")
            append(param.value.joinToString("|"))
        }.toString()
    }

/**
 * A map that associates Swagger collection format identifiers with their corresponding
 * `StringifyQueryParam` implementations. This map is used to convert `UrlQueryParam`
 * objects to their respective string representations based on the specified collection format.
 *
 * The supported collection formats are:
 * - "csv": Comma-separated values (e.g., key=value1,value2)
 * - "ssv": Space-separated values (e.g., key=value1%20value2)
 * - "pipes": Pipe-separated values (e.g., key=value1|value2)
 * - "multi": Multiple key-value pairs (e.g., key=value1&key=value2)
 */
@Suppress("unused")
val swaggerCollectionFormatStringifier =
    mapOf(
        "csv" to stringifyForm,
        "ssv" to stringifySpaceDelimited,
        "pipes" to stringifyPipeDelimited,
        "multi" to stringifyExplode
    )
