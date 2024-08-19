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

import io.specmatic.conversions.EnvironmentAndPropertiesConfiguration
import io.specmatic.conversions.OpenApiSpecification
import io.specmatic.core.Feature
import io.specmatic.core.Hook
import io.specmatic.core.OPENAPI_FILE_EXTENSIONS
import io.specmatic.core.PassThroughHook
import io.specmatic.core.SecurityConfiguration
import io.specmatic.core.unsupportedFileExtensionContractException
import java.io.File

/**
* Converts a file into a Specmatic Feature object.
*
* @param hook hooks to be used during file processing, default is PassThroughHook.
* @param sourceProvider optional source provider info.
* @param sourceRepository optional source repository URL.
* @param sourceRepositoryBranch optional branch of source repository.
* @param specificationPath optional path to the specification file.
* @param securityConfiguration optional security configuration.
* @param environmentAndPropertiesConfiguration configuration for environment and properties, default is EnvironmentAndPropertiesConfiguration.
* @throws unsupportedFileExtensionContractException if the file extension is not supported.
* @return converted Feature object.
*/
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
