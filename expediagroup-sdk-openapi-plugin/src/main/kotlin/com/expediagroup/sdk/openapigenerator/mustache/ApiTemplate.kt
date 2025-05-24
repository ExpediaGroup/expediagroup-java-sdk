package com.expediagroup.sdk.openapigenerator.mustache

import java.io.Serializable

data class ApiTemplate(
    val templateFile: String,
    val destinationPath: String,
    val fileName: String? = null
) : Serializable
