package com.expediagroup.sdk.rest.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

/**
 * Parses URL path template parameters and returns a map of template segments to path segments.
 *
 * @param path The actual URL path.
 * @param template The URL template with placeholders.
 * @return A map where the keys are template segments and the values are the corresponding path segments.
 * @throws IllegalArgumentException if either path or template is null.
 */
fun parseUrlPathTemplateParams(
    template: String,
    path: String
): Map<String, String> =
    listOf(template, path).map {
        it.removePrefix("/")
            .removeSuffix("/")
            .split("/")
            .map(String::trim)
    }.also {
        val templateSegments = it[0]
        val pathSegments = it[1]

        require(templateSegments.size == pathSegments.size) {
            "Template and path segments must have the same number of segments"
        }
    }.zipWithNext { templateSegment, pathSegment ->
        templateSegment.zip(pathSegment)
    }.flatten().filter { (key, value) ->
        key != value && key.startsWith("{") && key.endsWith("}")
    }.associate { (key, value) ->
        key.removePrefix("{").removeSuffix("}") to value
    }

/**
 * Parses URL query parameters from a query string and returns a map of parameter names to lists of values.
 *
 * @param query The URL query string.
 * @param destringifyStrategies The strategy to destringify query parameter values (e.g., comma-delimited, space-delimited).
 * @return A map where the keys are parameter names and the values are lists of parameter values.
 */
fun parseUrlQueryParamsFromQuery(
    query: String,
    destringifyStrategies: Map<String, String>
): Map<String, MutableList<String>> =
    buildMap {
        URLDecoder.decode(query, StandardCharsets.UTF_8.name())
            .trim()
            .split("&")
            .filter(String::isNotBlank)
            .map { it.split("=", limit = 2) }
            .filter { (key, value) -> key.isNotBlank() && value.isNotBlank() }
            .map { (key, value) ->
                key to
                    if (destringifyStrategies[key] != null && swaggerCollectionFormatDestringifier[destringifyStrategies[key]] != null) {
                        val destrignfyStrategy = destringifyStrategies[key]
                        val destringifyFunction = swaggerCollectionFormatDestringifier[destrignfyStrategy]!!

                        destringifyFunction(key, value).value
                    } else {
                        value
                    }
            }.forEach { (key, value) ->
                getOrPut(key) {
                    mutableListOf()
                }.apply {
                    when (value) {
                        is Collection<*> -> {
                            addAll(value.map { it.toString() })
                        }

                        else -> {
                            add(value.toString())
                        }
                    }
                }
            }
    }

/**
 * Resolves the type of URL query parameter values and converts them to the specified type.
 *
 * @param values The list of query parameter values as strings.
 * @param objectMapper The Jackson `ObjectMapper` used for type conversion.
 * @param jacksonTypeRef The Jackson `TypeReference` specifying the target type.
 * @return The converted value of the specified type.
 * @param T The target type to which the query parameter values should be converted.
 */
fun <T> resolveUrlQueryParamValuesType(
    values: Collection<String>,
    objectMapper: ObjectMapper,
    jacksonTypeRef: TypeReference<T>
): T =
    if (objectMapper.typeFactory.constructType(jacksonTypeRef).let { it.isContainerType || it.isArrayType }) {
        objectMapper.convertValue(values, jacksonTypeRef)
    } else {
        require(values.isNotEmpty()) {
            "Cannot resolve type for empty values"
        }

        objectMapper.convertValue(values.first(), jacksonTypeRef)
    }
