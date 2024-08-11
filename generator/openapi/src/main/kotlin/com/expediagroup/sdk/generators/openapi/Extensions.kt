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
package com.expediagroup.sdk.generators.openapi

/**
 * This extension function converts a string to PascalCase.
 * PascalCase is a type of identifier that consists of compound words or phrases such that each word or abbreviation begins with a capital letter.
 * Non-alphabetic characters are ignored, and the next alphabetic character after them is capitalized.
 *
 * @receiver String The string to be converted to PascalCase.
 * @return String The string converted to PascalCase.
 */
fun String.pascalCase(): String {
    var capitalizeNext = true
    val builder = StringBuilder()
    forEach { char ->
        when {
            char.isLetterOrDigit().and(capitalizeNext) -> builder.append(char.uppercaseChar())
            char.isLetterOrDigit() -> builder.append(char)
        }
        capitalizeNext = char.isLetter().not().or(builder.isEmpty())
    }
    return builder.toString()
}
