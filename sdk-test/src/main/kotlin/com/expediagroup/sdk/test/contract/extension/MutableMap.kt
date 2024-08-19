package com.expediagroup.sdk.test.contract.extension

import org.apache.commons.text.CaseUtils


fun Map<String, Any>.paramsMapWithExtractedJsonArrays(): MutableMap<String, Any> {
    val processedMap = mutableMapOf<String, Any>()

    forEach { (key, value) ->
        var processedValue = value

        if (value.toString().isJsonArray()) {
            processedValue = value.toString().jsonArrayToList().map {
                if (it.toString().isJsonArray()) {
                    it.toString().jsonArrayToList()
                } else {
                    it
                }
            }
        }

        processedMap[key] = processedValue
    }

    return processedMap
}

fun Map<String, Any>.withSnakeCaseHttpHeaders(): MutableMap<String, Any> {
    val processedMap = mutableMapOf<String, Any>()

    forEach { (key, value) ->
        processedMap[key.httpHeaderCamelCase()] = value
    }

    return processedMap
}
