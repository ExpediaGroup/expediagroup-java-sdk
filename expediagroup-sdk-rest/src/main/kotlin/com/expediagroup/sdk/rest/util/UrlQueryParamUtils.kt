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
import java.net.URLEncoder

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

fun interface DestringifyQueryParam : (String, String) -> UrlQueryParam {
    /**
     * Converts the given String to a list of values.
     *
     * @param query the String to convert
     * @return the list of values extracted from the String
     */
    override fun invoke(
        name: String,
        query: String
    ): UrlQueryParam
}

class UrlQueryParamStringifiers {
    companion object {
        /**
         * Converts a UrlQueryParam to a form-encoded String.
         * Example: key=value1,value2
         */
        val stringifyForm =
            StringifyQueryParam { param ->
                StringBuilder().apply {
                    append("${param.key}=")
                    append(param.value.joinToString(URLEncoder.encode(",", "UTF-8")))
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
                    append(param.value.joinToString(URLEncoder.encode(" ", "UTF-8")))
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
                    append(param.value.joinToString(URLEncoder.encode("|", "UTF-8")))
                }.toString()
            }
    }
}

class UrlQueryParamDestringifiers {
    companion object {
        /**
         * Destringifies a form-encoded query string into a list of values.
         *
         * @param query The form-encoded query string.
         * @return A list of values extracted from the query string.
         */
        val destringifyForm =
            DestringifyQueryParam { name: String, value: String ->
                UrlQueryParam(
                    key = name,
                    value = value.split(",").filter(String::isNotBlank),
                    stringify = UrlQueryParamStringifiers.stringifyForm
                )
            }

        /**
         * Destringifies an exploded form-encoded query string into a list of values.
         *
         * @param query The exploded form-encoded query string.
         * @return A list of values extracted from the query string.
         */
        val destringifyExplode =
            DestringifyQueryParam { name: String, value: String ->
                UrlQueryParam(
                    key = name,
                    value = value.split("&").filter(String::isNotBlank),
                    stringify = UrlQueryParamStringifiers.stringifyExplode
                )
            }

        /**
         * Destringifies a space-delimited query string into a list of values.
         *
         * @param query The space-delimited query string.
         * @return A list of values extracted from the query string.
         */
        val destringifySpaceDelimited =
            DestringifyQueryParam { name: String, value: String ->
                UrlQueryParam(
                    key = name,
                    value = value.split(" ").filter(String::isNotBlank),
                    stringify = UrlQueryParamStringifiers.stringifySpaceDelimited
                )
            }

        /**
         * Destringifies a pipe-delimited query string into a list of values.
         *
         * @param query The pipe-delimited query string.
         * @return A list of values extracted from the query string.
         */
        val destringifyPipeDelimited =
            DestringifyQueryParam { name: String, value: String ->
                UrlQueryParam(
                    key = name,
                    value = value.split("|").filter(String::isNotBlank),
                    stringify = UrlQueryParamStringifiers.stringifyPipeDelimited
                )
            }
    }
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
        "csv" to UrlQueryParamStringifiers.stringifyForm,
        "ssv" to UrlQueryParamStringifiers.stringifySpaceDelimited,
        "pipes" to UrlQueryParamStringifiers.stringifyPipeDelimited,
        "multi" to UrlQueryParamStringifiers.stringifyExplode
    )

/**
 * A map that associates Swagger collection format identifiers with their corresponding
 * destringify functions. This map is used to convert string representations of query
 * parameters to lists of values based on the specified collection format.
 *
 * The supported collection formats are:
 * - "csv": Comma-separated values (e.g., key=value1,value2)
 * - "ssv": Space-separated values (e.g., key=value1%20value2)
 * - "pipes": Pipe-separated values (e.g., key=value1|value2)
 * - "multi": Multiple key-value pairs (e.g., key=value1&key=value2)
 */
val swaggerCollectionFormatDestringifier: Map<String, DestringifyQueryParam> =
    mapOf(
        "csv" to UrlQueryParamDestringifiers.destringifyForm,
        "ssv" to UrlQueryParamDestringifiers.destringifySpaceDelimited,
        "pipes" to UrlQueryParamDestringifiers.destringifyPipeDelimited,
        "multi" to UrlQueryParamDestringifiers.destringifyExplode
    )
