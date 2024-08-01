package com.expediagroup.sdk.generators.openapi

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
