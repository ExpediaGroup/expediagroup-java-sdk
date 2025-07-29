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

package com.expediagroup.sdk.core.logging.masking

/**
 * Object responsible for creating regular expressions for masking sensitive fields in logs.
 */
object MaskingRegexFactory {
    /**
     * Checks if a field name can be masked.
     *
     * A field name can be masked if it contains only alphanumeric characters (a-z, A-Z, 0-9),
     * hyphens (-), and underscores (_). Field names containing any other characters cannot be masked.
     *
     * @param field The field name to check.
     * @return True if the field name can be masked, false otherwise.
     */
    private fun canMaskField(field: String) = field.matches("^[a-zA-Z0-9-_]+$".toRegex())

    /**
     * Generates a regular expression to match and mask specified fields in a JSON string.
     *
     * The pattern matches:
     * The field name (one of the specified fields) captured in group 1.
     * Optional backslash, closing double quotes, colon(:), optional whitespace, and opening double quotes.
     * The value of the field, matching the specified valueToMatch pattern.
     * Optional backslash, followed by a closing double quote.
     *
     * @param fields The fields to be matched and masked.
     * @param match The pattern to match the field values. Defaults to matching any sequence of characters except double quotes.
     * @return A Regex object that matches the specified fields and their values in a JSON string.
     * @throws IllegalArgumentException if any field name is invalid.
     */
    fun createRegexFor(fields: Set<String>, match: String = "[^\\\"]+"): Regex = fields.joinToString("|").let {
        "\"($it)(\\\\?\"\\s*:\\s*\\\\*\")$match(?:\\\\?\")".toRegex().also {
            require(fields.all(::canMaskField)) { "Invalid field name in $fields" }
        }
    }
}
