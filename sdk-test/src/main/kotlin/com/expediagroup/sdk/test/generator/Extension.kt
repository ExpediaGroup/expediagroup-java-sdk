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
package com.expediagroup.sdk.test.generator

import com.fasterxml.jackson.databind.ObjectMapper
import io.specmatic.conversions.EnvironmentAndPropertiesConfiguration
import io.specmatic.conversions.OpenApiSpecification
import io.specmatic.core.Feature
import io.specmatic.core.Hook
import io.specmatic.core.OPENAPI_FILE_EXTENSIONS
import io.specmatic.core.PassThroughHook
import io.specmatic.core.Scenario
import io.specmatic.core.SecurityConfiguration
import io.specmatic.core.unsupportedFileExtensionContractException
import java.io.File

fun File.toSpecmaticFeature(
    hook: Hook = PassThroughHook(),
    sourceProvider: String? = null,
    sourceRepository: String? = null,
    sourceRepositoryBranch: String? = null,
    specificationPath: String? = null,
    securityConfiguration: SecurityConfiguration? = null,
    environmentAndPropertiesConfiguration: EnvironmentAndPropertiesConfiguration = EnvironmentAndPropertiesConfiguration()
): Feature =
    when (extension) {
        in OPENAPI_FILE_EXTENSIONS ->
            OpenApiSpecification.fromYAML(
                hook.readContract(path),
                path,
                sourceProvider = sourceProvider,
                sourceRepository = sourceRepository,
                sourceRepositoryBranch = sourceRepositoryBranch,
                specificationPath = specificationPath,
                securityConfiguration = securityConfiguration,
                environmentAndPropertiesConfiguration = environmentAndPropertiesConfiguration
            ).toFeature()

        else -> throw unsupportedFileExtensionContractException(path, extension)
    }

fun Scenario.writeTo(
    outputDir: File,
    mapper: ObjectMapper,
    filenameSuffix: String? = "",
    filenamePrefix: String? = ""
) {
    val request = generateHttpRequest()
    val response = generateHttpResponse(emptyMap())
    val filename = "${filenamePrefix ?: ""}${request.method}-${request.path?.removePrefix("/")?.replace("/", "-")}${filenameSuffix ?: ""}.$JSON"

    mapper.writeValue(
        File(outputDir, filename),
        mapOf(
            "request" to request,
            "response" to response
        )
    )
}
