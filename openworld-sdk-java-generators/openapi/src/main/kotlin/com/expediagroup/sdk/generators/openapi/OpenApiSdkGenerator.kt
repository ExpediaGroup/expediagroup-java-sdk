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

import com.github.rvesse.airline.SingleCommand
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.api.TemplateDefinition
import org.openapitools.codegen.config.CodegenConfigurator

/**
 * Configures the OpenAPI Generator based on command line parameters to generate an EG Travel SDK project
 *
 * This will produce a maven project in the specified output directory, which when built, will
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

    fun run() {
        try {
            val config = CodegenConfigurator().apply {
                setTemplateDir("templates/eg-travel-sdk")
                setInputSpec(inputFile)
                setOutputDir(outputDirectory)
                // Adjust namespace to fit with JVM package naming conventions
                val packageName = namespace.lowercase().replace(Regex("[^a-z0-9]"), "")
                // Configure CodeGen Components
                addGlobalProperty("models", "")
                addGlobalProperty("apis", "")
                addGlobalProperty("supportingFiles", "pom.xml,README.md")
                // Configure generated client suffix eg: AnyNameClient
                addAdditionalProperty("apiSuffix", "Client")
                // Configure generated Enum class names
                addAdditionalProperty("enumPropertyNaming", "UPPERCASE")
                // Configure CodeGen Language
                setGeneratorName("kotlin")
                addAdditionalProperty("library", "jvm-ktor")
                // Configure serialization library
                addAdditionalProperty("serializationLibrary", "gson")
                addAdditionalProperty("sortParamsByRequiredFlag", true)
                addAdditionalProperty("authPackage", null)
                // Configure SDK Artifact Coordinates
                setGroupId("com.expediagroup.sdk.$namespace")
                setArtifactId("openworld-java-sdk-$namespace")
                setArtifactVersion(version)
                // Configure package details
                setPackageName("com.expediagroup.openworld.sdk.$packageName")
                addAdditionalProperty("apiPackage", "com.expediagroup.openworld.sdk.$packageName.client")
            }
            // Load Template Customizations
            val generatorInput = config.toClientOptInput().apply {
                userDefinedTemplates(
                    listOf(
                        TemplateDefinition("pom.mustache", "pom.xml"),
                        TemplateDefinition("README.mustache", "README.md"),
                        TemplateDefinition(
                            "factory.mustache",
                            "src/main/kotlin/com/expediagroup/openworld/sdk/${namespace.lowercase().replace(Regex("[^a-z0-9]"), "")}/configs",
                            "EnvironmentConfigsFactoryImpl.kt"
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
}
