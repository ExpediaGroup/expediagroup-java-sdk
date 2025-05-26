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

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

object UrlUtils {
    /**
     * Parses URL path template parameters and returns a map of template segments to path segments.
     *
     * @param path The actual URL path.
     * @param template The URL template with placeholders.
     * @return A map where the keys are template segments and the values are the corresponding path segments.
     * @throws IllegalArgumentException if either path or template is null.
     */
    fun parsePathParams(
        template: String,
        path: String
    ): Map<String, String> {
        val templateSegments = template.trim('/').split('/')
        val pathSegments = path.trim('/').split('/')

        require(templateSegments.size == pathSegments.size) {
            "Template and path must contain the same number of segments"
        }

        return buildMap {
            templateSegments
                .zip(pathSegments)
                .filter { (templatePart, pathPart) -> templatePart != pathPart }
                .filter { (templatePart, _) ->
                    templatePart.startsWith('{') && templatePart.endsWith('}')
                }
                .forEach { (placeholder, value) ->
                    put(placeholder.trim('{', '}'), value)
                }
        }
    }

    /**
     * Parses URL query parameters from a query string and returns a map of parameter names to lists of values.
     *
     * @param query The URL query string.
     * @param destringifyStrategies The strategy to destringify query parameter values (e.g., comma-delimited, space-delimited).
     * @return A map where the keys are parameter names and the values are lists of parameter values.
     */
    fun parseQueryParams(
        query: String,
        destringifyStrategies: Map<String, String>
    ): Map<String, MutableList<String>> =
        buildMap {
            URLDecoder.decode(query, StandardCharsets.UTF_8.name())
                .splitToSequence('&')
                .filter { it.isNotEmpty() }
                .forEach { token ->
                    val eq = token.indexOf('=')
                    if (eq <= 0 || eq == token.lastIndex) return@forEach // malformed

                    val name = token.substring(0, eq)
                    val rawValue = token.substring(eq + 1)

                    val destringifier =
                        destringifyStrategies[name].let {
                            swaggerCollectionFormatDestringifier[it] ?: UrlQueryParamDestringifiers.explode
                        }

                    val queryParamValues = destringifier.invoke(name, rawValue).value

                    getOrPut(name, ::mutableListOf).addAll(queryParamValues)
                }
        }

    /**
     * Resolves the type of URL query parameter values and converts them to the specified type.
     *
     * @param values The list of query parameter values as strings.
     * @param objectMapper The Jackson `ObjectMapper` used for type conversion.
     * @param typeRef The Jackson `TypeReference` specifying the target type.
     * @return The converted value of the specified type.
     * @param T The target type to which the query parameter values should be converted.
     */
    fun <T> resolveUrlQueryParamValuesType(
        values: Collection<String>,
        objectMapper: ObjectMapper,
        typeRef: TypeReference<T>
    ): T =
        if (objectMapper.typeFactory.constructType(typeRef).let { it.isContainerType || it.isArrayType }) {
            objectMapper.convertValue(values, typeRef)
        } else {
            require(values.isNotEmpty()) {
                "Cannot resolve type for empty values"
            }

            objectMapper.convertValue(values.first(), typeRef)
        }
}
