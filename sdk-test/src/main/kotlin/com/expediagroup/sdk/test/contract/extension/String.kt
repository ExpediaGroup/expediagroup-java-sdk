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

fun String.httpHeaderCamelCase(): String =
    when {
        contains("-") -> CaseFormat.LOWER_HYPHEN
        contains("_") -> CaseFormat.LOWER_UNDERSCORE
        else -> CaseFormat.UPPER_CAMEL
    }.to(CaseFormat.LOWER_CAMEL, this)

fun String.isEmptyJsonObject(): Boolean = this.trim().replace(" ", "") == "{}"

fun String.isJsonArray(): Boolean = this.trim().startsWith("[").and(this.trim().endsWith("]"))

fun String.jsonArrayToList(): List<Any> {
    if (isJsonArray().not()) {
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
