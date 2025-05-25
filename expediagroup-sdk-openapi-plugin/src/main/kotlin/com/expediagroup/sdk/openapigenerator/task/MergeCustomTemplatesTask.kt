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

import com.expediagroup.sdk.openapigenerator.mustache.MustacheTemplatesMergeHandler
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 * Task to merge custom templates into a final directory `(build/final_templates)`.
 * It merges the custom templates provided by the user with the default plugin's templates.
 */
abstract class MergeCustomTemplatesTask : DefaultTask() {
    @get:OutputDirectory
    abstract val mergedDir: DirectoryProperty

    init {
        mergedDir.convention(
            project.layout.buildDirectory.dir("final_templates")
        )
    }

    @TaskAction
    fun run() {
        MustacheTemplatesMergeHandler.resolveFinalTemplates(project)
    }
}
