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

package com.expediagroup.sdk.openapigenerator.task

import com.expediagroup.sdk.openapigenerator.mustache.ApiTemplate
import com.expediagroup.sdk.openapigenerator.mustache.AssignDiscriminatorsLambda
import com.expediagroup.sdk.openapigenerator.mustache.CustomReturnTypeLambda
import com.expediagroup.sdk.openapigenerator.mustache.EliminateDiscriminatorsLambda
import com.expediagroup.sdk.openapigenerator.mustache.HasNonBodyParamsLambda
import com.expediagroup.sdk.openapigenerator.mustache.HttpAcceptHeaderLambda
import com.expediagroup.sdk.openapigenerator.mustache.NonBodyParamsLambda
import com.expediagroup.sdk.openapigenerator.mustache.OperationErrorTypesLambda
import com.expediagroup.sdk.openapigenerator.mustache.OperationExceptionsLambda
import com.expediagroup.sdk.openapigenerator.mustache.ProcessModel
import com.expediagroup.sdk.openapigenerator.mustache.ProcessOperation
import com.expediagroup.sdk.openapigenerator.mustache.RemoveDoubleQuotesLambda
import com.expediagroup.sdk.openapigenerator.mustache.SupportingTemplate
import com.samskivert.mustache.Mustache
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.openapitools.codegen.CodegenConstants
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.SupportingFile
import org.openapitools.codegen.api.TemplateDefinition
import org.openapitools.codegen.api.TemplateFileType
import org.openapitools.codegen.config.CodegenConfigurator
import kotlin.collections.joinToString

/**
 * Task to generate the Expedia Group SDK from an OpenAPI specification.
 * This task uses the OpenAPI Generator to create Kotlin code based on the provided OpenAPI spec.
 * It allows customization of the generated code through various properties and templates.
 */
abstract class GenerateEgSdkTask : DefaultTask() {
    @get:Input
    abstract val namespace: Property<String>

    @get:InputFile
    abstract val specFilePath: RegularFileProperty

    @get:Input
    abstract val basePackage: Property<String>

    @get:Input
    @get:Optional
    abstract val modelPackage: Property<String>

    @get:Input
    @get:Optional
    abstract val operationPackage: Property<String>

    @get:OutputDirectory
    @get:Optional
    abstract val outputDir: DirectoryProperty

    @get:InputDirectory
    @get:Optional
    abstract val customTemplatesDir: DirectoryProperty

    @get:Input
    @get:Optional
    abstract val operationProcessors: ListProperty<(CodegenOperation) -> CodegenOperation>

    @get:Input
    @get:Optional
    abstract val modelProcessors: ListProperty<(CodegenModel) -> CodegenModel>

    @get:Input
    @get:Optional
    abstract val lambdas: ListProperty<Pair<String, Mustache.Lambda>>

    @get:Input
    @get:Optional
    abstract val supportingTemplates: ListProperty<SupportingTemplate>

    @get:Input
    @get:Optional
    abstract val apiTemplates: ListProperty<ApiTemplate>

    @TaskAction
    fun generate() {
        val supportingFilesNames = supportingTemplates.get().joinToString(",") { it.fileName }

        val config =
            CodegenConfigurator().apply {
                setGeneratorName("kotlin")
                setPackageName(basePackage.get())
                setInputSpec(specFilePath.get().asFile.absolutePath)
                setEnablePostProcessFile(true)

                setOutputDir(outputDir.get().asFile.absolutePath)

                customTemplatesDir.orNull?.let {
                    setTemplateDir(it.asFile.absolutePath)
                }

                // Global Properties
                addGlobalProperty(CodegenConstants.APIS, "")
                addGlobalProperty(CodegenConstants.API_TESTS, "false")
                addGlobalProperty(CodegenConstants.API_DOCS, "false")

                addGlobalProperty(CodegenConstants.MODELS, "")
                addGlobalProperty(CodegenConstants.MODEL_TESTS, "false")
                addGlobalProperty(CodegenConstants.MODEL_DOCS, "false")
                addGlobalProperty(CodegenConstants.SUPPORTING_FILES, supportingFilesNames)

                // Additional Properties
                addAdditionalProperty("namespace", namespace.get())
                addAdditionalProperty("modelPackage", modelPackage.get())
                addAdditionalProperty("operationPackage", operationPackage.get())
                addAdditionalProperty(CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG, true)
                addAdditionalProperty(CodegenConstants.ENUM_PROPERTY_NAMING, "UPPERCASE")
                addAdditionalProperty(CodegenConstants.API_SUFFIX, "Operation")
                addAdditionalProperty(CodegenConstants.API_PACKAGE, operationPackage.get())
                addAdditionalProperty(CodegenConstants.SOURCE_FOLDER, "")
                addAdditionalProperty("omitGradleWrapper", true)
                addAdditionalProperty("jacksonObjectMapper", "${basePackage.get()}.configuration.OBJECT_MAPPER")

                // Lambdas
                addAdditionalProperty("customReturnType", CustomReturnTypeLambda())
                addAdditionalProperty("httpAcceptHeader", HttpAcceptHeaderLambda())
                addAdditionalProperty("nonBodyParams", NonBodyParamsLambda())
                addAdditionalProperty("hasNonBodyParams", HasNonBodyParamsLambda())
                addAdditionalProperty("operationExceptions", OperationExceptionsLambda())
                addAdditionalProperty("operationErrorTypes", OperationErrorTypesLambda())
                addAdditionalProperty("eliminateDiscriminators", EliminateDiscriminatorsLambda())
                addAdditionalProperty("assignDiscriminators", AssignDiscriminatorsLambda())
                addAdditionalProperty("removeDoubleQuotes", RemoveDoubleQuotesLambda())
                addAdditionalProperty("processOperation", ProcessOperation(operationProcessors.get()))
                addAdditionalProperty("processModel", ProcessModel(modelProcessors.get()))
            }

        val generatorInput =
            config.toClientOptInput().apply {
                val resolvedApiTemplates =
                    apiTemplates.orNull?.let {
                        it.map { template ->
                            TemplateDefinition(
                                template.templateFile,
                                template.destinationPath,
                                template.fileNameSuffix
                            ).also { t -> t.templateType = TemplateFileType.API }
                        }
                    } ?: emptyList()

                val resolvedSupportingTemplates =
                    supportingTemplates.orNull?.let {
                        it.map { template ->
                            SupportingFile(
                                template.templateFile,
                                template.destinationPath,
                                template.fileName
                            )
                        }
                    } ?: emptyList()

                userDefinedTemplates(
                    buildList {
                        addAll(resolvedApiTemplates)
                        addAll(resolvedSupportingTemplates)
                        add(
                            TemplateDefinition(
                                "operation_params.mustache",
                                "Params.kt"
                            ).also { it.templateType = TemplateFileType.API }
                        )
                        add(
                            TemplateDefinition(
                                "api_exception.mustache",
                                "${modelPackage.get().replace('.', '/')}/exception",
                                "Exception.kt"
                            ).also { it.templateType = TemplateFileType.API }
                        )
                    }
                )
            }

        val generator = DefaultGenerator(false).apply { opts(generatorInput) }

        generator.generate()
    }
}
