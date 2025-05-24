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
import com.expediagroup.sdk.openapigenerator.extension.SpecTransformerExtension
import com.expediagroup.sdk.openapigenerator.task.GenerateEgSdkTask
import com.expediagroup.sdk.openapigenerator.task.MergeCustomTemplatesTask
import com.expediagroup.sdk.openapigenerator.task.TransformSpecTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider

class EgSdkGeneratorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val egSdkGeneratorExt = extensions.create("egSdkGenerator", EgSdkGeneratorExtension::class.java)
            val specTransformerExt = egSdkGeneratorExt.extensions.create("specTransformer", SpecTransformerExtension::class.java)

            val mergeCustomTemplatesTask = registerMergeCustomTemplatesTask()
            val transformSpecsTask = registerTransformSpecsTask(egSdkGeneratorExt, specTransformerExt)

            registerGenerateSdkTask(
                egSdkGeneratorExt = egSdkGeneratorExt,
                mergeTemplatesTask = mergeCustomTemplatesTask,
                transformSpecsTask = transformSpecsTask
            )
        }
    }

    private fun Project.registerTransformSpecsTask(
        egSdkGeneratorExt: EgSdkGeneratorExtension,
        specTransformerExt: SpecTransformerExtension
    ) = tasks.register("transformSpecs", TransformSpecTask::class.java) { t ->
        t.inputSpec.set(egSdkGeneratorExt.specFilePath)
        t.outputSpec.set(project.layout.buildDirectory.file("transformed-spec.yaml"))
        t.specTransformerExtension.headers.set(specTransformerExt.headers)
        t.specTransformerExtension.operationIdsToTags.set(specTransformerExt.operationIdsToTags)
        t.specTransformerExtension.defaultStringType.set(specTransformerExt.defaultStringType)
        t.specTransformerExtension.enabled.set(specTransformerExt.enabled)
    }

    private fun Project.registerMergeCustomTemplatesTask(): TaskProvider<MergeCustomTemplatesTask> = tasks.register("mergeCustomTemplatesTask", MergeCustomTemplatesTask::class.java)

    private fun Project.registerGenerateSdkTask(
        egSdkGeneratorExt: EgSdkGeneratorExtension,
        mergeTemplatesTask: TaskProvider<MergeCustomTemplatesTask>,
        transformSpecsTask: TaskProvider<TransformSpecTask>
    ) = tasks.register("generateEgSdk", GenerateEgSdkTask::class.java) {
        // dependencies
        it.dependsOn(mergeTemplatesTask)
        it.dependsOn(transformSpecsTask)

        // choose spec: transformed ↔ original
        it.specFilePath.set(
            egSdkGeneratorExt.specTransformer.enabled.flatMap { enabled ->
                if (enabled) {
                    transformSpecsTask.flatMap { transformSpecsTask -> transformSpecsTask.outputSpec }
                } else {
                    egSdkGeneratorExt.specFilePath
                }
            }
        )

        // mandatory inputs
        it.namespace.set(egSdkGeneratorExt.namespace)
        it.customTemplatesDir.set(mergeTemplatesTask.flatMap { mergeTask -> mergeTask.mergedDir })

        // optional inputs (copy only if user provided)
        egSdkGeneratorExt.basePackage.orNull?.let(it.basePackage::set)
        egSdkGeneratorExt.modelPackage.orNull?.let(it.modelPackage::set)
        egSdkGeneratorExt.operationPackage.orNull?.let(it.operationPackage::set)
        egSdkGeneratorExt.outputDir.orNull?.let(it.outputDir::set)
        egSdkGeneratorExt.modelProcessors.orNull?.let(it.modelProcessors::set)
        egSdkGeneratorExt.operationProcessors.orNull?.let(it.operationProcessors::set)
        egSdkGeneratorExt.lambdas.orNull?.let(it.lambdas::set)
        egSdkGeneratorExt.supportingTemplates.orNull?.let(it.supportingTemplates::set)
        egSdkGeneratorExt.apiTemplates.orNull?.let(it.apiTemplates::set)
    }
}
