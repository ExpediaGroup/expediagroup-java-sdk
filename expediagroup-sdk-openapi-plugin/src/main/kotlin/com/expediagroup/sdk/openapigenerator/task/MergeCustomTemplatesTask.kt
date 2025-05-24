package com.expediagroup.sdk.openapigenerator.task

import com.expediagroup.sdk.openapigenerator.mustache.MustacheTemplatesMergeHandler
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

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
