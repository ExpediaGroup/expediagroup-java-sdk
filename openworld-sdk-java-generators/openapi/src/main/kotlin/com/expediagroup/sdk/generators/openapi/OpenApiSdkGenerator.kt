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
package com.expediagroup.sdk.generators.openapi

import com.expediagroup.sdk.generators.openapi.processor.YamlProcessor
import com.github.rvesse.airline.SingleCommand
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.api.TemplateDefinition
import org.openapitools.codegen.config.CodegenConfigurator
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.util.*
import java.util.zip.ZipInputStream
import kotlin.io.path.writeBytes

/**
 * Configures the OpenAPI Generator based on command line parameters to generate an EG Travel SDK project
 * This will produce a maven project in the specified output directory
 */
@Command(name = "generate", description = "Let's build an EG Travel SDK!")
class OpenApiSdkGenerator {
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

    @Option(name = ["-k", "--isKotlin"])
    lateinit var isKotlin: String

    @Option(name = ["-r", "--isRapid"])
    lateinit var isRapid: String

    fun run() {
        try {
            // Adjust namespace to fit with JVM package naming conventions
            val packageName = namespace.lowercase().replace(Constant.NON_ALPHANUMERIC_REGEX, "")
            val config = CodegenConfigurator().apply {
                // specify the target language
                setGeneratorName("kotlin")
                setTemplateDir("templates/openworld-sdk")
                val path = prepareSpecFile()
                val processedFilePath = preProcessSpecFile(path)
                setInputSpec(processedFilePath)
                setOutputDir(outputDirectory)
                // Configure CodeGen Components
                addGlobalProperty("models", "")
                addGlobalProperty("apis", "")
                addGlobalProperty("supportingFiles", "pom.xml,README.md")
                // Configure generated client suffix eg: AnyNameClient
                addAdditionalProperty("apiSuffix", "Client")
                addAdditionalProperty("apiPackage", "com.expediagroup.openworld.sdk.$packageName.client")
                // Configure generated Enum class names
                addAdditionalProperty("enumPropertyNaming", "UPPERCASE")
                // Configure CodeGen Language
                addAdditionalProperty("library", "jvm-ktor")
                // Configure serialization library
                addAdditionalProperty("serializationLibrary", "jackson")
                addAdditionalProperty("sortParamsByRequiredFlag", true)
                addAdditionalProperty("isKotlin", isKotlin.toBoolean())
                addAdditionalProperty("isRapid", isRapid.toBoolean())
                // Configure SDK Artifact Coordinates
                setArtifactId("openworld-${getSdkLanguage()}-sdk-${namespace.lowercase()}")
                setArtifactVersion(version)
                // Configure package details
                setPackageName("com.expediagroup.openworld.sdk.$packageName")
            }
            // Load Template Customizations
            val generatorInput = config.toClientOptInput().apply {
                userDefinedTemplates(
                    listOf(
                        TemplateDefinition("pom.mustache", "pom.xml"),
                        TemplateDefinition("README.mustache", "README.md"),
                        TemplateDefinition(
                            "factory.mustache",
                            "src/main/kotlin/com/expediagroup/openworld/sdk/$packageName/configs"
                        )
                    )
                )
            }
            // Ready To Form Voltron! Activate Interlock! Dynatherms Connected! Infracells Up! Megathrusters Are Go!
            val generator = DefaultGenerator(false).apply { opts(generatorInput) }
            generator.generate()
        } catch (e: Exception) {
            System.err.println("Failed to generate SDK")
            System.err.println(e.message)
            e.printStackTrace()
        }
    }

    private fun getSdkLanguage() = if (isKotlin.toBoolean()) "kotlin" else "java"

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
