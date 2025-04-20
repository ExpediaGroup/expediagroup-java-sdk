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

/**
 * Functional interface for converting a string representation of a query parameter
 * into a `UrlQueryParam` object.
 *
 * This interface takes two input strings: the name of the query parameter and its value,
 * and returns a `UrlQueryParam` object that represents the parsed query parameter.
 */
fun interface DestringifyQueryParam : (String, String) -> UrlQueryParam {
    /**
     * Converts the given query parameter name and value into a `UrlQueryParam` object.
     *
     * @param name The name of the query parameter.
     * @param query The string representation of the query parameter's value.
     * @return A `UrlQueryParam` object representing the parsed query parameter.
     */
    override fun invoke(
        name: String,
        query: String
    ): UrlQueryParam
}

object UrlQueryParamStringifier {
    /**
     * Converts a UrlQueryParam to a form-encoded String.
     * Example: key=value1,value2
     */
    val form =
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
    val explode =
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
    val spaceDelimited =
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
    val pipeDelimited =
        StringifyQueryParam { param ->
            StringBuilder().apply {
                append("${param.key}=")
                append(param.value.joinToString(URLEncoder.encode("|", "UTF-8")))
            }.toString()
        }
}

object UrlQueryParamDestringifiers {
    /**
     * Converts a string representation of a query parameter in "form" format
     * (comma-separated values) into a `UrlQueryParam` object.
     */
    val form =
        DestringifyQueryParam { name: String, value: String ->
            UrlQueryParam(
                key = name,
                value = value.split(",").filter(String::isNotBlank),
                stringify = UrlQueryParamStringifier.form
            )
        }

    /**
     * Converts a string representation of a query parameter in "explode" format
     * (multiple key-value pairs separated by '&') into a `UrlQueryParam` object.
     *
     */
    val explode =
        DestringifyQueryParam { name: String, value: String ->
            UrlQueryParam(
                key = name,
                value = value.split("&").filter(String::isNotBlank),
                stringify = UrlQueryParamStringifier.explode
            )
        }

    /**
     * Converts a string representation of a query parameter in "space-delimited" format
     * (values separated by spaces) into a `UrlQueryParam` object.
     */
    val spaceDelimited =
        DestringifyQueryParam { name: String, value: String ->
            UrlQueryParam(
                key = name,
                value = value.split(" ").filter(String::isNotBlank),
                stringify = UrlQueryParamStringifier.spaceDelimited
            )
        }

    /**
     * Converts a string representation of a query parameter in "pipe-delimited" format
     * (values separated by '|') into a `UrlQueryParam` object.
     */
    val pipeDelimited =
        DestringifyQueryParam { name: String, value: String ->
            UrlQueryParam(
                key = name,
                value = value.split("|").filter(String::isNotBlank),
                stringify = UrlQueryParamStringifier.pipeDelimited
            )
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
val swaggerCollectionFormatStringifier =
    mapOf(
        "csv" to UrlQueryParamStringifier.form,
        "ssv" to UrlQueryParamStringifier.spaceDelimited,
        "pipes" to UrlQueryParamStringifier.pipeDelimited,
        "multi" to UrlQueryParamStringifier.explode
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
        "csv" to UrlQueryParamDestringifiers.form,
        "ssv" to UrlQueryParamDestringifiers.spaceDelimited,
        "pipes" to UrlQueryParamDestringifiers.pipeDelimited,
        "multi" to UrlQueryParamDestringifiers.explode
    )
