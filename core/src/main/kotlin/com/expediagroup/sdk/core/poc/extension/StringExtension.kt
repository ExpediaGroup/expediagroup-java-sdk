package com.expediagroup.sdk.core.poc.extension

fun String.bearerToEan(): String = when {
    startsWith("Bearer ", ignoreCase = true) -> removePrefix("Bearer ").bearerToEan()
    startsWith("EAN ", ignoreCase = true) -> this
    else -> "EAN $this"
}
