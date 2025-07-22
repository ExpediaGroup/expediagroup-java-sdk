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

package com.expediagroup.sdk.openapigenerator

import com.expediagroup.sdk.openapigenerator.extension.EgSdkGeneratorExtension
import com.expediagroup.sdk.openapigenerator.task.GenerateEgSdkTask
import com.expediagroup.sdk.openapigenerator.task.MergeCustomTemplatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * **`com.expediagroup.sdk.openapigenerator`**
 *
 * Applying this plugin to a project does exactly two things:
 *
 * * `mergeCustomTemplatesTask`: copies the plugin’s built-in mustache
 *    templates into the build folder and overlays any user-supplied
 *    templates from `egSdkGenerator.customTemplatesDir`.
 * * `generateEgSdk`: consumes the _merged_ template directory plus the
 *    user-defined extension inputs and runs OpenAPI Generator, writing the
 *    Kotlin SDK into `egSdkGenerator.outputDir`
 *    (default = `"$projectDir/src/main/kotlin"`).
 *
 * ### Incremental & configuration-cache behaviour
 * * Every input to the tasks comes from a `Property`; the plugin never calls
 *   `.get()` during configuration.
 * * If neither the templates nor the OpenAPI spec changed,
 *   `generateEgSdk` is _*UP-TO-DATE*_.
 *
 * ### Typical usage
 * ```kotlin
 * plugins { id("com.expediagroup.sdk.openapigenerator") }
 *
 * egSdkGenerator {
 *     basePackage.set("com.expediagroup.sdk.example")
 *     specFilePath.set(layout.projectDirectory.file("specs/cars.yaml"))
 *     customTemplatesDir.set(layout.projectDirectory.dir("my-templates"))
 * }
 * ```
 */
class EgSdkGeneratorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val egSdkGeneratorExt =
                extensions.create(
                    "egSdkGenerator",
                    EgSdkGeneratorExtension::class.java
                )

            val mergeCustomTemplatesTask =
                tasks.register(
                    "mergeCustomTemplatesTask",
                    MergeCustomTemplatesTask::class.java
                )

            tasks.apply {
                register("generateEgSdk", GenerateEgSdkTask::class.java) {
                    it.dependsOn(mergeCustomTemplatesTask)

                    it.specFilePath.set(egSdkGeneratorExt.specFilePath)
                    it.objectMapper.set(egSdkGeneratorExt.objectMapper)
                    it.customTemplatesDir.set(mergeCustomTemplatesTask.flatMap { mergeTask -> mergeTask.mergedDir })
                    it.basePackage.set(egSdkGeneratorExt.basePackage)
                    it.modelPackage.set(egSdkGeneratorExt.modelPackage)
                    it.operationPackage.set(egSdkGeneratorExt.operationPackage)
                    it.outputDir.set(egSdkGeneratorExt.outputDir)
                    it.modelProcessors.set(egSdkGeneratorExt.modelProcessors)
                    it.operationProcessors.set(egSdkGeneratorExt.operationProcessors)
                    it.lambdas.set(egSdkGeneratorExt.lambdas)
                    it.supportingTemplates.set(egSdkGeneratorExt.supportingTemplates)
                    it.apiTemplates.set(egSdkGeneratorExt.apiTemplates)
                }
            }
        }
    }
}
