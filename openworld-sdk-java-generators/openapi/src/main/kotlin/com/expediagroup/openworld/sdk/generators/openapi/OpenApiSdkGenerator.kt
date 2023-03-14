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
package com.expediagroup.openworld.sdk.generators.openapi

import com.expediagroup.openworld.sdk.generators.openapi.processor.YamlProcessor
import com.expediagroup.openworld.sdk.model.ClientGenerationException
import com.expediagroup.openworld.sdk.product.Product
import com.expediagroup.openworld.sdk.product.ProductFamily
import com.expediagroup.openworld.sdk.product.ProgrammingLanguage
import com.github.rvesse.airline.SingleCommand
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import kotlin.io.path.writeBytes
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.api.TemplateDefinition
import org.openapitools.codegen.config.CodegenConfigurator
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.util.*
import java.util.zip.ZipInputStream

/**
 * Configures the OpenAPI Generator based on command line parameters to generate an EG Travel SDK project
 * This will produce a maven project in the specified output directory
 */
@Command(name = "generate", description = "Let's build an EG Travel SDK!")
class OpenApiSdkGenerator {
    private val supportingFiles = listOf(
        "pom.xml",
        "README.md",
        "PropertyConstraintViolationException.kt",
        "PropertyConstraintViolation.kt",
        "PropertyConstraintsValidator.kt"
    )

    companion object {
        /**
         * Main Entry Point
         *
         * Parses command line arguments and then generates an EG Travel SDK
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val generator = SingleCommand.singleCommand(OpenApiSdkGenerator::class.java).parse(*args)
            generator.run()
        }
    }

    @Option(name = ["-i", "--input-spec"])
    lateinit var inputFile: String

    @Option(name = ["-o", "--output-directory"])
    lateinit var outputDirectory: String

    @Option(name = ["-n", "--namespace"])
    lateinit var namespace: String

    @Option(name = ["-v", "--version"])
    lateinit var version: String

    @Option(name = ["-l", "--language"])
    lateinit var programmingLanguage: String

    fun run() {
        try {
            val product = Product(namespace, programmingLanguage)
            val config = CodegenConfigurator().apply {
                val path = prepareSpecFile()
                val processedFilePath = preProcessSpecFile(path)

                setGeneratorName("kotlin")
                setTemplateDir("templates/openworld-sdk")
                setInputSpec(processedFilePath)
                setOutputDir(outputDirectory)
                setArtifactId(product.artifactId)
                setArtifactVersion(version)
                setGroupId(product.groupId)
                setPackageName(product.packageName)

                addGlobalProperty("models", "")
                addGlobalProperty("apis", "")
                addGlobalProperty("supportingFiles", supportingFiles.joinToString(","))

                addAdditionalProperty("apiSuffix", "Client")
                addAdditionalProperty("apiPackage", product.apiPackage)
                addAdditionalProperty("enumPropertyNaming", "UPPERCASE")
                addAdditionalProperty("library", "jvm-ktor")
                addAdditionalProperty("serializationLibrary", "jackson")
                addAdditionalProperty("sortParamsByRequiredFlag", true)
                addAdditionalProperty("shadePrefix", product.shadePrefix)
                addAdditionalProperty("namespace", product.namespace)
                addAdditionalProperty("language", product.programmingLanguage.id)

                // Template specific properties
                addAdditionalProperty("isKotlin", ProgrammingLanguage.isKotlin(product.programmingLanguage))
                addAdditionalProperty("isRapid", ProductFamily.isRapid(product.namespace))
                addAdditionalProperty("isOpenWorld", ProductFamily.isOpenWorld(product.namespace))

                // Mustache Helpers
                mustacheHelpers.forEach { (name, function) -> addAdditionalProperty(name, function()) }
            }

            val generatorInput = config.toClientOptInput().apply {
                val packagePath = product.packagePath
                userDefinedTemplates(
                    listOf(
                        TemplateDefinition("pom.mustache", "pom.xml"),
                        TemplateDefinition("README.mustache", "README.md"),
                        TemplateDefinition(
                            "factory.mustache",
                            "$packagePath/configs"
                        ),
                        TemplateDefinition(
                            "propertyConstraintViolationException.mustache",
                            "$packagePath/models/exception/",
                            "PropertyConstraintViolationException.kt"
                        ),
                        TemplateDefinition(
                            "propertyConstraintViolation.mustache",
                            "$packagePath/models/exception/",
                            "PropertyConstraintViolation.kt"
                        ),
                        TemplateDefinition(
                            "propertyConstraintsValidator.mustache",
                            "$packagePath/validation/",
                            "PropertyConstraintsValidator.kt"
                        )
                    )
                )
            }

            val generator = DefaultGenerator(false).apply { opts(generatorInput) }
            generator.generate()
        } catch (e: Exception) {
            throw ClientGenerationException("Failed to generate SDK", e)
        }
    }

    private fun preProcessSpecFile(path: String): String {
        val yamlProcessor = YamlProcessor(path, namespace)
        return yamlProcessor.process()
    }

    private fun prepareSpecFile(): String {
        val buffer = ByteArray(1024)
        val zipInputStream = ZipInputStream(FileInputStream(prepareTmpZipFile()))
        val tempFile = Files.createTempFile("", zipInputStream.nextEntry?.name).toFile()
        val fileOutputStream = FileOutputStream(tempFile)
        var len: Int
        while (zipInputStream.read(buffer).also { len = it } > 0) {
            fileOutputStream.write(buffer, 0, len)
        }
        zipInputStream.closeEntry()
        fileOutputStream.close()
        zipInputStream.close()
        return tempFile.absolutePath
    }

    private fun prepareTmpZipFile(): File {
        val tmpFile = Files.createTempFile("", "tmp")
        tmpFile.writeBytes(Base64.getDecoder().decode(inputFile))
        return tmpFile.toFile()
    }
}
