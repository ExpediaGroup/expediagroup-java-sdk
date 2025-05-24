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

    init {
        modelPackage.convention(
            namespace.map { ns -> "com.expediagroup.sdk.$ns.model" }
        )

        operationPackage.convention(
            namespace.map { ns -> "com.expediagroup.sdk.$ns.operation" }
        )

        outputDir.convention(project.layout.projectDirectory.dir("src/main/kotlin"))
    }

    @TaskAction
    fun generate() {
        println("Custom Templates Directory: ${customTemplatesDir.get().asFile.absolutePath}")
        println("Model Processors: ${modelProcessors.get()}")
        println("Operation Processors: ${operationProcessors.get()}")
        println("Lambdas: ${lambdas.get()}")
        println("Supporting Templates: ${supportingTemplates.get()}")
        println("API Templates: ${apiTemplates.get()}")

        val supportingFilesNames = supportingTemplates.get().joinToString(",") { it.fileName.toString() }

        println("Supporting Files NAMES: $supportingFilesNames")

        val config =
            CodegenConfigurator().apply {
                setGeneratorName("kotlin")
                setPackageName(basePackage.get())
                setInputSpec(specFilePath.get().asFile.absolutePath)
                setOutputDir(outputDir.get().asFile.absolutePath)
                setEnablePostProcessFile(true)
                customTemplatesDir.orNull?.let {
                    println("Using custom templates from: ${it.asFile.absolutePath}")
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

                // Lambdas
                addAdditionalProperty("customReturnType", CustomReturnTypeLambda())
                addAdditionalProperty("httpAcceptHeader", HttpAcceptHeaderLambda())
                addAdditionalProperty("nonBodyParams", NonBodyParamsLambda())
                addAdditionalProperty("hasNonBodyParams", HasNonBodyParamsLambda())
                addAdditionalProperty("operationExceptions", OperationExceptionsLambda())
                addAdditionalProperty("operationErrorTypes", OperationErrorTypesLambda())
                addAdditionalProperty("eliminateDiscriminators", EliminateDiscriminatorsLambda())
                addAdditionalProperty("assignDiscriminators", AssignDiscriminatorsLambda())
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
                                template.fileName
                            ).also { it.templateType = TemplateFileType.API }
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

                println("Resolved API Templates: $resolvedApiTemplates")
                println("Resolved Supporting Templates: $resolvedSupportingTemplates")

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
                    }
                )

                println("User Defined Templates $userDefinedTemplates")
            }

        val generator = DefaultGenerator(false).apply { opts(generatorInput) }

        generator.generate()
    }
}
