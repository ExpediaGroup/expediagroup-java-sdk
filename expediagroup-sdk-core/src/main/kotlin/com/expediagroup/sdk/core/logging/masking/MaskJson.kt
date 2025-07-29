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

import com.expediagroup.sdk.core.logging.Constant

/**
 * Class responsible for masking sensitive fields in JSON strings.
 *
 * This class takes a set of field names and creates regular expressions to match and mask
 * the values of these fields in JSON strings. It implements the function type (String) -> String,
 * allowing instances of this class to be used as functions that take a JSON string and return
 * a masked JSON string.
 *
 * @property regexes A list of regular expressions generated for the specified fields.
 * @constructor Creates a MaskJson instance with the specified fields.
 * @param fields The set of field names to be masked in JSON strings.
 */
class MaskJson(
    fields: Set<String>
) : (String) -> String {
    private val regexes = fields.map { MaskingRegexFactory.createRegexFor(setOf(it)) }

    /**
     * Masks the specified fields in the given JSON string.
     *
     * This method applies the regular expressions to the input JSON string, replacing the values
     * of the specified fields with a masking template.
     *
     * @param msg The JSON string to be masked.
     * @return The masked JSON string.
     */
    override fun invoke(msg: String): String = regexes.fold(msg) { acc, regex ->
        regex.replace(acc, Constant.DEFAULT_LOG_MASKING_REPLACEMENT_TEMPLATE)
    }
}
