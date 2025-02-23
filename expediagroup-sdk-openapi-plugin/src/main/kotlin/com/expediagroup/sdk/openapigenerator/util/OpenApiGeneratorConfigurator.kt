/*
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.openapigenerator.util

import org.gradle.api.Project
import org.openapitools.generator.gradle.plugin.extensions.OpenApiGeneratorGenerateExtension

/**
 * Configures an [OpenApiGeneratorGenerateExtension] instance with default settings specific to
 * Expedia Group's SDK requirements, while allowing user overrides.
 *
 * This object:
 * 1. Resolves a final templates' directory.
 * 2. Validates that a "namespace" project property is set.
 * 3. Sets default Kotlin-based generation options.
 * 4. Merges user-supplied global and additional properties with SDK defaults.
 */
object OpenApiGeneratorConfigurator {
    /**
     * Applies default configuration values to the given [ext] extension after the project is evaluated.
     *
     * - **Namespace requirement**: Expects a "namespace" property to be defined in `gradle.properties`.
     * - **Templates**: Resolves a local directory containing Mustache templates and sets it on `ext.templateDir`.
     * - **Packaging**: Derives group, package, and API model paths from the [Product].
     * - **Properties**: Merges default global and additional properties with user-defined ones.
     *
     * @param project The Gradle [Project] where the plugin is applied.
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     * @throws IllegalArgumentException if the "namespace" property is missing or blank.
     */
    fun configure(
        project: Project,
        ext: OpenApiGeneratorGenerateExtension
    ) {
        val finalTemplatesDirectoryPath = MustacheTemplatesHandler.resolveFinalTemplates(project)

        project.afterEvaluate {
            val namespace = project.properties["namespace"]?.toString()

            require(!namespace.isNullOrBlank()) {
                "namespace must be set. Make sure to specify the SDK namespace in gradle.properties"
            }

            val product = Product(namespace)

            // Set official defaults / conventions
            ext.generatorName.set("kotlin")
            ext.templateDir.set(finalTemplatesDirectoryPath)

            ext.groupId.convention(product.groupId)
            ext.packageName.convention(product.packageName)
            ext.apiPackage.convention(product.apiPackage)
            ext.modelPackage.convention(product.modelsPackage)

            // Merge global properties
            val defaultGlobalProps =
                mapOf(
                    "models" to "",
                    "apis" to "",
                    "supportingFiles" to "false",
                    "modelDocs" to "false",
                    "modelTests" to "false"
                )
            val userGlobalProps = ext.globalProperties.orNull ?: emptyMap<String, String>()
            ext.globalProperties.set(defaultGlobalProps + userGlobalProps)

            // Merge additional properties
            val defaultAdditionalProps =
                mapOf(
                    "namespace" to namespace.lowercase(),
                    "apiSuffix" to "Operation"
                )
            val userAdditionalProps = ext.additionalProperties.orNull ?: emptyMap<String, Any>()
            ext.additionalProperties.set(defaultAdditionalProps + userAdditionalProps)
        }
    }
}
