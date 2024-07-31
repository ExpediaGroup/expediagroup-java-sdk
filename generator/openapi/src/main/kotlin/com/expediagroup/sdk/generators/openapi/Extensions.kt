package com.expediagroup.sdk.generators.openapi

fun String.toPascalCase(): String {
    var capitalizeNext = true
    val builder = StringBuilder()

    forEach {
        when {
            it.isDigit() || it == ' ' || it == '-' || it == '_' -> capitalizeNext = true
            capitalizeNext -> {
                builder.append(it.uppercaseChar())
                capitalizeNext = false
            }
            else -> builder.append(it)
        }
    }

    return builder.toString()
}
