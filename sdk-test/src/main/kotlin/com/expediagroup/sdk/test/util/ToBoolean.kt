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
private fun fluentToBoolean(instance: Any?): Boolean = when (instance) {
    is Boolean -> instance
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
private fun nonFluentToBoolean(instance: Any?): Boolean = when (instance) {
    is Boolean -> instance
    is String -> instance.isNotBlank()
    is Collection<*> -> instance.all(::toBoolean)
    is Map<*, *> -> instance.all { (_, v) -> toBoolean(v) }
    is Array<*> -> instance.all(::toBoolean)
    is ByteArray -> instance.all(::toBoolean)
    else -> false
}.and(fluentToBoolean(instance))

/**
 * Converts an instance to a boolean representation value based on the specified evaluation mode.
 *
 * @param instance The instance to be evaluated. If null, the function returns false.
 * @param fluent A boolean flag to determine the evaluation mode.
 *               If true, context-aware mode is used; otherwise, non-context-aware mode.
 *               Default is false.
 * @return true if the instance meets the condition according to the specified mode; false otherwise.
 */
fun toBoolean(instance: Any?, fluent: Boolean = false): Boolean =
    instance?.let {
        when (fluent) {
            true -> fluentToBoolean(instance)
            false -> nonFluentToBoolean(instance)
        }
    } ?: false
