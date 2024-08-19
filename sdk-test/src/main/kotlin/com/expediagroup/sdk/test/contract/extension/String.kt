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

import com.google.common.base.CaseFormat

/**
 * Checks if the string represents an empty JSON object.
 *
 * This function trims any leading or trailing whitespace from the string
 * and removes all spaces within the string, then compares it to "{}".
 *
 * @receiver The string to be checked.
 * @return `true` if the string is an empty JSON object, `false` otherwise.
 */
fun String.isEmptyJsonObject(): Boolean = this.trim().replace(" ", "") == "{}"

/**
 * Extension function that checks if a given string is formatted as a JSON array.
 *
 * This function trims any leading or trailing whitespace from the string and
 * then checks if it starts with '[' and ends with ']'.
 *
 * @return `true` if the string is a JSON array,
 *         `false` otherwise.
 */
fun String.isJsonArray(): Boolean = this.trim().let {
    it.startsWith("[") && it.endsWith("]")
}
/**
 * Converts a JSON array string into a List of Any type.
 *
 * @return a list where each element represents an item in the JSON array.
 * @throws IllegalArgumentException if the input string is not a JSON array.
 *
 * The function first checks if the string is a valid JSON array.
 * If it is not, an IllegalArgumentException is thrown.
 * It then trims the string, removes the opening and closing square brackets,
 * and splits the string by commas into individual elements.
 * Each element is checked if it's a JSON array itself, in which case the function calls itself recursively,
 * otherwise, the element is added to the list as is.
 */
fun String.jsonArrayToList(): List<Any> {
    takeUnless(String::isJsonArray)?.let {
        throw IllegalArgumentException("String is not a JSON array")
    }

    return trim()
        .removePrefix("[")
        .removeSuffix("]")
        .replace(" ", "")
        .split(",").map {
            if (it.isJsonArray()) {
                it.jsonArrayToList()
            } else {
                it
            }
        }
}
