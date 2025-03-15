package com.expediagroup.sdk.openapigenerator.util

import com.expediagroup.sdk.openapigenerator.mustache.AssignDiscriminatorsLambda
import com.expediagroup.sdk.openapigenerator.mustache.CustomReturnTypeLambda
import com.expediagroup.sdk.openapigenerator.mustache.DefineApiExceptionsLambda
import com.expediagroup.sdk.openapigenerator.mustache.EliminateDiscriminatorsLambda
import com.expediagroup.sdk.openapigenerator.mustache.ExceptionDataTypesLambda
import com.expediagroup.sdk.openapigenerator.mustache.HasNonBodyParamsLambda
import com.expediagroup.sdk.openapigenerator.mustache.HttpAcceptHeaderLambda
import com.expediagroup.sdk.openapigenerator.mustache.IsPaginatableLambda
import com.expediagroup.sdk.openapigenerator.mustache.NonBodyParamsLambda
import com.expediagroup.sdk.openapigenerator.mustache.ProcessModel
import com.expediagroup.sdk.openapigenerator.mustache.ProcessOperation
import com.expediagroup.sdk.openapigenerator.mustache.RemoveDoubleQuotesLambda
import com.expediagroup.sdk.openapigenerator.mustache.RemoveLeadingSlashesLambda
import java.io.IOException
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.gradle.api.Project
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
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
    private const val CONFIG_FILE_PATH = "/config/generator-config.yaml"

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
        val configFilePath = extractConfigFile(project.layout.buildDirectory.dir("config").get().asFile.absolutePath)

        project.afterEvaluate {
            val namespace = project.properties["namespace"]?.toString()
            require(!namespace.isNullOrBlank()) { "namespace must be set. Make sure to specify the SDK namespace in gradle.properties" }

            val product = Product(namespace)

            loadInitialConfigurations(ext, finalTemplatesDirectoryPath, configFilePath)
            loadArtifactMetadata(ext, product)
            loadGlobalProperties(ext)
            loadTypeMappings(ext)
            loadLambdas(ext)
            loadAdditionalProperties(ext, product)
        }
    }

    /**
     * Extracts the configuration file from the resources to the target directory.
     *
     * @param targetDir The target directory where the configuration file will be extracted.
     * @return The absolute path to the extracted configuration file.
     * @throws IOException if the resource cannot be found or the file cannot be created.
     */
    private fun extractConfigFile(targetDir: String): String {
        val resourceStream: InputStream? = this::class.java.getResourceAsStream(CONFIG_FILE_PATH)

        if (resourceStream == null) {
            throw IOException("Resource not found: $CONFIG_FILE_PATH")
        }

        val targetDirectory: Path = Paths.get(targetDir)

        if (!Files.exists(targetDirectory)) {
            Files.createDirectories(targetDirectory)
        }

        val fileName = Paths.get(CONFIG_FILE_PATH).fileName.toString()
        val targetFile = targetDirectory.resolve(fileName)

        resourceStream.use { input ->
            Files.copy(input, targetFile, StandardCopyOption.REPLACE_EXISTING)
        }

        return targetFile.toAbsolutePath().toString()
    }

    /**
     * Loads lambda functions into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     */
    @Suppress("UNCHECKED_CAST")
    private fun loadLambdas(ext: OpenApiGeneratorGenerateExtension) {
        val operationProcessors: List<(CodegenOperation) -> CodegenOperation> =
            ext.additionalProperties.orNull?.let {
                it.getOrDefault(
                    "operationProcessors",
                    emptyList<(CodegenOperation) -> CodegenOperation>()
                ) as List<(CodegenOperation) -> CodegenOperation>
            } ?: emptyList()

        val modelProcessors: List<(CodegenModel) -> CodegenModel> =
            ext.additionalProperties.orNull?.let {
                it.getOrDefault(
                    "modelProcessors",
                    emptyList<(CodegenModel) -> CodegenModel>()
                ) as List<(CodegenModel) -> CodegenModel>
            } ?: emptyList()

        val lambdas =
            mapOf(
                "customReturnType" to CustomReturnTypeLambda(),
                "httpAcceptHeader" to HttpAcceptHeaderLambda(),
                "removeDoubleQuotes" to RemoveDoubleQuotesLambda(),
                "nonBodyParams" to NonBodyParamsLambda(),
                "hasNonBodyParams" to HasNonBodyParamsLambda(),
                "exceptionDataTypes" to ExceptionDataTypesLambda(),
                "defineApiExceptions" to DefineApiExceptionsLambda(),
                "eliminateDiscriminators" to EliminateDiscriminatorsLambda(),
                "assignDiscriminators" to AssignDiscriminatorsLambda(),
                "removeLeadingSlashes" to RemoveLeadingSlashesLambda(),
                "isPaginatable" to IsPaginatableLambda(),
                "processOperation" to ProcessOperation(operationProcessors),
                "processModel" to ProcessModel(modelProcessors)
            )

        val userAdditionalProps = ext.additionalProperties.orNull ?: emptyMap<String, Any>()
        ext.additionalProperties.set(lambdas + userAdditionalProps)
    }

    /**
     * Loads type mappings into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     */
    private fun loadTypeMappings(ext: OpenApiGeneratorGenerateExtension) {
        val typeMappings =
            mapOf(
                "array" to "kotlin.collections.ArrayList",
                "map" to "kotlin.collections.HashMap",
                "set" to "kotlin.collections.HashSet"
            )

        val userTypeMappings = ext.typeMappings.orNull ?: emptyMap<String, String>()
        ext.typeMappings.set(typeMappings + userTypeMappings)
    }

    /**
     * Loads additional properties into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     * @param product The [Product] containing namespace and other information.
     */
    private fun loadAdditionalProperties(
        ext: OpenApiGeneratorGenerateExtension,
        product: Product
    ) {
        val defaultAdditionalProps =
            mapOf(
                "namespace" to product.namespace,
                "apiSuffix" to "Operation"
            )

        val userAdditionalProps = ext.additionalProperties.orNull ?: emptyMap<String, Any>()
        ext.additionalProperties.set(defaultAdditionalProps + userAdditionalProps)
    }

    /**
     * Loads global properties into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     */
    private fun loadGlobalProperties(ext: OpenApiGeneratorGenerateExtension) {
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
    }

    /**
     * Loads artifact metadata into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     * @param product The [Product] containing namespace and other information.
     */
    private fun loadArtifactMetadata(
        ext: OpenApiGeneratorGenerateExtension,
        product: Product
    ) {
        ext.groupId.convention(product.groupId)
        ext.packageName.convention(product.packageName)
        ext.apiPackage.convention(product.apiPackage)
        ext.modelPackage.convention(product.modelsPackage)
    }

    /**
     * Loads initial configurations into the OpenAPI generator extension.
     *
     * @param ext The [OpenApiGeneratorGenerateExtension] to configure.
     * @param finalTemplatesDirectoryPath The path to the final templates directory.
     * @param configFilePath The path to the configuration file.
     */
    private fun loadInitialConfigurations(
        ext: OpenApiGeneratorGenerateExtension,
        finalTemplatesDirectoryPath: String,
        configFilePath: String
    ) {
        ext.configFile.convention(configFilePath)

        ext.generatorName.set("kotlin")
        ext.templateDir.set(finalTemplatesDirectoryPath)

        ext.dryRun.convention(false)
        ext.cleanupOutput.convention(false)
        ext.generateApiTests.convention(false)
        ext.generateModelTests.convention(false)
        ext.generateApiDocumentation.convention(false)
        ext.generateModelDocumentation.convention(false)
    }
}
