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

package com.expediagroup.sdk.openapigenerator.extension

import com.expediagroup.sdk.openapigenerator.mustache.ApiTemplate
import com.expediagroup.sdk.openapigenerator.mustache.SupportingTemplate
import com.samskivert.mustache.Mustache
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation

/**
 * Extension for configuring the Expedia Group OpenAPI Generator plugin.
 *
 * This extension allows users to specify various properties related to the OpenAPI specification,
 * code generation, and template customization.
 *
 * The extension represents the user-facing configuration block **`egSdkGenerator { … }`** in gradle build files.
 *
 * ```kotlin
 * egSdkGenerator {
 *     specFilePath = layout.projectDirectory.file("specs/openapi.yaml")
 *     namespace = "rapid"
 * }
 * ```
 */
abstract class EgSdkGeneratorExtension(project: Project) : ExtensionAware {

    /** OpenAPI definition that feeds the generator */
    abstract val specFilePath: RegularFileProperty

    /** base package name used when no specific package override is supplied. */
    abstract val basePackage: Property<String>

    /** Package into which **model** classes are generated. */
    abstract val modelPackage: Property<String>

    /** Package into which **operation** (API) classes are generated. */
    abstract val operationPackage: Property<String>

    /** Folder that contains user-overrides for `.mustache` templates. */
    abstract val customTemplatesDir: DirectoryProperty

    /** Final destination directory for the generated Kotlin sources. */
    abstract val outputDir: DirectoryProperty

    /** namespace (e.g. `"rapid"`) inserted into package names {basePackage}.{namespace} */
    abstract val namespace: Property<String>

    /** User-supplied processors that post-process **operations** before templating. */
    abstract val operationProcessors: ListProperty<(CodegenOperation) -> CodegenOperation>

    /** User-supplied processors that post-process **models** before templating. */
    abstract val modelProcessors: ListProperty<(CodegenModel) -> CodegenModel>

    /** Additional named Mustache lambdas available from templates. */
    abstract val lambdas: ListProperty<Pair<String, Mustache.Lambda>>

    /** Extra supporting-file templates to copy */
    abstract val supportingTemplates: ListProperty<SupportingTemplate>

    /** Extra API-level templates (`TemplateFileType.API`) to render. */
    abstract val apiTemplates: ListProperty<ApiTemplate>

    init {
        // Default values
        modelPackage.set(namespace.map { ns -> "com.expediagroup.sdk.$ns.model" })
        operationPackage.set(namespace.map { ns -> "com.expediagroup.sdk.$ns.operation" })
        outputDir.set(project.layout.projectDirectory.dir("src/main/kotlin"))
    }
}
