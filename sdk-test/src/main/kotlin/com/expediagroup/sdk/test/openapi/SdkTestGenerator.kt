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
/* You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.test.openapi

import com.expediagroup.sdk.generators.openapi.mustacheHelpers
import com.expediagroup.sdk.generators.openapi.pascalCase
import org.openapitools.codegen.CodegenConstants
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.SupportingFile
import org.openapitools.codegen.config.CodegenConfigurator
import java.io.File

/**
 * Class responsible for generating SDK test files based on a given product specification.
 *
 * @property productTest The ProductTest instance containing information about the product being tested.
 * @property spec The file containing the OpenAPI specification.
 * @property version The version of the SDK being generated. Default is "1.0.0".
 * @property templatesDir The directory containing mustache templates used for generating files. Default is "src/main/resources/templates/expediagroup-sdk".
 * @property outputDir The directory where generated SDK files will be output. Default is "target/sdk".
 */
class SdkTestGenerator(
    private val productTest: ProductTest,
    private val spec: File,
    private val targetArtifact: ArtifactMetadata,
    private val version: String = "1.0.0",
    private val templatesDir: File = File("src/main/resources/templates/expediagroup-sdk"),
    private val outputDir: File = File("target/sdk")
) {
    val supportingFiles = mutableListOf(
        "${productTest.namespace.pascalCase()}ClientExecutor.kt",
        "${productTest.namespace.pascalCase()}OperationsMetadata.kt",
        "${productTest.namespace.pascalCase()}TestCases.kt",
        "Main.kt",
        "pom.xml",
    )

    val config =
        CodegenConfigurator().apply {
            setGeneratorName("kotlin")
            setTemplateDir(templatesDir.absolutePath)
            setInputSpec(spec.absolutePath)
            setOutputDir(outputDir.absolutePath)
            setArtifactId(productTest.artifactId)
            setArtifactVersion(version)
            setGroupId(productTest.groupId)
            setPackageName(productTest.packageName)

            addGlobalProperty(CodegenConstants.APIS, "")
            addGlobalProperty(CodegenConstants.API_DOCS, "false")
            addGlobalProperty(CodegenConstants.MODELS, "false")
            addGlobalProperty(CodegenConstants.MODEL_DOCS, "false")
            addGlobalProperty(CodegenConstants.GENERATE_MODELS, "false")

            addGlobalProperty(CodegenConstants.SUPPORTING_FILES, supportingFiles.joinToString(","))

            addAdditionalProperty(CodegenConstants.API_PACKAGE, "\\.ignore")
            addAdditionalProperty("clientClassname", "${productTest.namespace.pascalCase()}Client")
            addAdditionalProperty(CodegenConstants.ENUM_PROPERTY_NAMING, "UPPERCASE")
            addAdditionalProperty(CodegenConstants.LIBRARY, "jvm-ktor")
            addAdditionalProperty(CodegenConstants.SERIALIZATION_LIBRARY, "jackson")
            addAdditionalProperty(CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG, true)

            addAdditionalProperty("namespace", productTest.namespace)
            addAdditionalProperty("clientClassname", productTest.namespace.pascalCase())

            addAdditionalProperty("targetSdkArtifactId", targetArtifact.artifactId)
            addAdditionalProperty("targetSdkGroupId", targetArtifact.groupId)
            addAdditionalProperty("targetSdkVersion", targetArtifact.version)

            // Mustache Helpers
            mustacheHelpers.forEach { (name, func) ->
                addAdditionalProperty(name, func)
            }
        }

    private val packagePath = productTest.packagePath
    val clientOptInput = config.toClientOptInput().apply {
        userDefinedTemplates(buildList {
            add(
                SupportingFile(
                    "main.mustache",
                    packagePath,
                    "Main.kt"
                )
            )
            add(
                SupportingFile(
                    "executor.mustache",
                    packagePath,
                    "${productTest.namespace.pascalCase()}ClientExecutor.kt"
                )
            )
            add(
                SupportingFile(
                    "metadata.mustache",
                    packagePath,
                    "${productTest.namespace.pascalCase()}OperationsMetadata.kt"
                )
            )
            add(
                SupportingFile(
                    "pom.mustache",
                    "pom.xml"
                )
            )
        })
    }

    private val generator = DefaultGenerator(false).opts(clientOptInput)

    fun generate() {
        generator.generate()
    }
}
