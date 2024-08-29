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
import com.expediagroup.sdk.product.Product
import com.expediagroup.sdk.test.contract.model.api.TestCaseApiCall
import org.openapitools.codegen.CodegenConstants
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.SupportingFile
import org.openapitools.codegen.config.CodegenConfigurator
import java.io.File

class SdkTestGenerator(
    private val namespace: String,
    private val spec: File,
    private val version: String = "1.0.0",
    private val testCases: List<TestCaseApiCall> = emptyList(),
    private val templatesDir: File = File("src/main/resources/templates/expediagroup-sdk"),
    private val outputDir: File = File("target/sdk")
) {
    val product = Product(namespace, "rapid-java", "kotlin")

    val supportingFiles = mutableListOf(
        "${namespace.pascalCase()}ClientExecutor.kt",
        "${namespace.pascalCase()}OperationsMetadata.kt",
        "${namespace.pascalCase()}TestCases.kt",
        "Main.kt",
        "pom.xml",
    )

    val config =
        CodegenConfigurator().apply {
            setGeneratorName("kotlin")
            setTemplateDir(templatesDir.absolutePath)
            setInputSpec(spec.absolutePath)
            setOutputDir(outputDir.absolutePath)
            setArtifactId(product.artifactId)
            setArtifactVersion(version)
            setGroupId(product.groupId)
            setPackageName(product.packageName)

            addGlobalProperty(CodegenConstants.APIS, "")
            addGlobalProperty(CodegenConstants.API_DOCS, "false")
            addGlobalProperty(CodegenConstants.MODELS, "false")
            addGlobalProperty(CodegenConstants.MODEL_DOCS, "false")
            addGlobalProperty(CodegenConstants.GENERATE_MODELS, "false")

            testCases.groupBy { testCase ->
                "${testCase.request.method}: ${testCase.request.path}"
            }.also { map ->
                addAdditionalProperty("tests", map.entries)
            }

            addGlobalProperty(CodegenConstants.SUPPORTING_FILES, supportingFiles.joinToString(","))

            addAdditionalProperty(CodegenConstants.API_PACKAGE, product.apiPackage)
            addAdditionalProperty("clientClassname", "${namespace.pascalCase()}Client")
            addAdditionalProperty(CodegenConstants.ENUM_PROPERTY_NAMING, "UPPERCASE")
            addAdditionalProperty(CodegenConstants.LIBRARY, "jvm-ktor")
            addAdditionalProperty(CodegenConstants.SERIALIZATION_LIBRARY, "jackson")
            addAdditionalProperty(CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG, true)

            addAdditionalProperty("namespace", product.namespace)
            addAdditionalProperty("clientClassname", namespace.pascalCase())

            // Mustache Helpers
            mustacheHelpers.forEach { (name, func) ->
                addAdditionalProperty(name, func)
            }
        }

    private val packagePath = "${product.packagePath}/test"
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
                    "${namespace.pascalCase()}ClientExecutor.kt"
                )
            )
            add(
                SupportingFile(
                    "metadata.mustache",
                    packagePath,
                    "${namespace.pascalCase()}OperationsMetadata.kt"
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
