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
package com.expediagroup.sdk.test.contract.extension

/**
 * Extension function for Map to process and convert JSON array values to lists.
 *
 * This function iterates over each key-value pair in the map. If the value is identified as a JSON array (and/or nested
 * JSON arrays), the function converts these values into Kotlin lists.
 *
 * @receiver Map<String, Any> The map to process.
 * @return MutableMap<String, Any> A new map with JSON arrays converted to lists.
 *
 * @sample
 * val originalMap = mapOf(
 *     "key1" to "[1,2,3]", // JSON Array
 *     "key2" to "simpleValue",
 *     "key3" to "[[4,5], [6]]" // Nested JSON Array
 * )
 * val result = originalMap.paramsMapWithExtractedJsonArrays()
 * println(result) // Outputs: {key1=[1, 2, 3], key2=simpleValue, key3=[[4, 5], [6]]}
 */
fun Map<String, Any>.paramsMapWithExtractedJsonArrays(): MutableMap<String, Any> {
    val processedMap = mutableMapOf<String, Any>()

    forEach { (key, value) ->
        var processedValue = value

        if (value.toString().isJsonArray()) {
            processedValue = value.toString().jsonArrayToList().map {
                if (it.toString().isJsonArray()) {
                    it.toString().jsonArrayToList()
                } else {
                    it
                }
            }
        }

        processedMap[key] = processedValue
    }

    return processedMap
}
