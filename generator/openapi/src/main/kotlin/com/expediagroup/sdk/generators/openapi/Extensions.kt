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
