package com.expediagroup.sdk.openapigenerator.mustache

import java.io.Serializable

data class SupportingTemplate(
    val templateFile: String,
    val destinationPath: String,
    val fileName: String? = null
) : Serializable
