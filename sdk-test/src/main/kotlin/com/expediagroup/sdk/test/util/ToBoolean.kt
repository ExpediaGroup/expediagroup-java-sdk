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
package com.expediagroup.sdk.test.util

import java.io.File


/**
 * Converts the given `instance` to a Boolean based on specific criteria:
 * - If `instance` is a Boolean, returns its value.
 * - If `instance` is a String, returns true if it is not empty.
 * - If `instance` is a Collection, returns true if it is not empty.
 * - If `instance` is a Map, returns true if it is not empty.
 * - If `instance` is an Array, returns true if it is not empty.
 * - If `instance` is a ByteArray, returns true if it is not empty.
 * - For unknown types, returns `false`.
 *
 * @param instance The object to be evaluated and converted to Boolean.
 * @return `true` if the `instance` meets positive criteria based on the given rules, `false` otherwise.
 */
private fun staticToBoolean(instance: Any?): Boolean = when (instance) {
    is Boolean -> instance
    is Number -> instance != 0
    is String -> instance.isNotEmpty()
    is Collection<*> -> instance.isNotEmpty()
    is Map<*, *> -> instance.isNotEmpty()
    is Array<*> -> instance.isNotEmpty()
    is ByteArray -> instance.isNotEmpty()
    is File -> instance.exists()
    else -> false
}

/**
 * Evaluates an instance and returns a boolean indicating its logical value.
 *
 * This function handles various types as follows:
 * - For `Boolean`, it returns the boolean value.
 * - For `String`, it returns `true` if the string is not blank, otherwise `false`.
 * - For `Collection`, `Map`, `Array`, or `ByteArray`, it returns `true` if all elements are
 *   `true` based on internal evaluation, otherwise `false`.
 * - For unknown types, it returns `false`.
 *
 * @param instance The instance to evaluate.
 * @return `true` or `false` based on the internal evaluation logic.
 */
private fun dynamicToBoolean(instance: Any?): Boolean = when (instance) {
    is Boolean -> instance
    is String -> instance.isNotBlank()
    is Collection<*> -> instance.any(::toBoolean)
    is Map<*, *> -> instance.any { (_, v) -> toBoolean(v) }
    is Array<*> -> instance.any(::toBoolean)
    is ByteArray -> instance.any(::toBoolean)
    else -> staticToBoolean(instance)
}.and(staticToBoolean(instance))

/**
 * Converts an instance to a boolean representation value based on the specified evaluation mode.
 *
 * @param instance The instance to be evaluated. If null, the function returns false.
 * @param dynamic A boolean flag to determine the evaluation mode.
 *               If true, context-aware mode is used; otherwise, non-context-aware mode.
 *               Default is false.
 * @return true if the instance meets the condition according to the specified mode; false otherwise.
 */
fun toBoolean(instance: Any?, dynamic: Boolean = false): Boolean =
    instance?.let {
        when (dynamic) {
            true -> dynamicToBoolean(instance)
            false -> staticToBoolean(instance)
        }
    } ?: false
