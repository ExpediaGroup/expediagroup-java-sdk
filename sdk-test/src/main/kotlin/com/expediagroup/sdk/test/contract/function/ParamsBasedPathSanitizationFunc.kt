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
package com.expediagroup.sdk.test.contract.function


/**
 * A function to sanitize paths by replacing segments with parameter keys.
 *
 * This type alias represents a function that takes a path in the form of a string
 * and a map of parameters, and returns the sanitized path.
 *
 * The path segments that match the values in the parameters map are replaced with
 * the corresponding parameter keys enclosed in curly braces.
 */
class ParamsBasedPathSanitizationFunc : (String, Map<String, Any>) -> String {
    companion object {
        val execute = ParamsBasedPathSanitizationFunc()
    }


    /**
     * Sanitizes the given path by replacing segments that match values in the provided parameters map
     * with their corresponding keys enclosed in curly braces.
     *
     * @param path The original path string to be sanitized.
     * @param params A map of parameter keys and their corresponding values to be used for sanitization.
     * @return The sanitized path string where matched segments are replaced with parameter keys.
     *
     * @sample
     * val path = "/api/v1/users/123"
     * val params = mapOf("userId" to "123")
     * val result = invoke(path, params)
     * println(result) // Output: "/api/v1/users/{userId}"
     */
    override fun invoke(
        path: String,
        params: Map<String, Any>
    ): String =
        path.split("/").joinToString("/") { segment ->
            params.entries.find { it.value == segment }.let {
                when (it) {
                    null -> segment
                    else -> segment.replace(segment, "{${it.key}}")
                }
            }
        }
}
