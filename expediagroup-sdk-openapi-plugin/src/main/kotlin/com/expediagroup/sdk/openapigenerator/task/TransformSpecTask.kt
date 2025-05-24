package com.expediagroup.sdk.openapigenerator.task

import com.expediagroup.sdk.openapigenerator.extension.SpecTransformerExtension
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class TransformSpecTask : Exec() {
    @get:InputFile
    abstract val inputSpec: RegularFileProperty

    @get:OutputFile
    abstract val outputSpec: RegularFileProperty

    @get:Nested
    abstract val specTransformerExtension: SpecTransformerExtension

    init {
        onlyIf { specTransformerExtension.enabled.orNull == true }
    }

    @TaskAction
    override fun exec() {
        workingDir = inputSpec.get().asFile.parentFile

        val args =
            mutableListOf(
                "npx",
                "--yes",
                "-p",
                "@expediagroup/spec-transformer",
                "cli",
                "--input",
                inputSpec.get().asFile.name,
                "--output",
                outputSpec.get().asFile.name,
                "--defaultStringType",
                specTransformerExtension.defaultStringType.get()
            )

        if (specTransformerExtension.operationIdsToTags.get()) args += "--operationIdsToTags"

        if (specTransformerExtension.headers.get().isNotEmpty()) {
            args += listOf("--headers", specTransformerExtension.headers.get().joinToString(","))
        }

        commandLine(args).run { super.exec() }
    }
}
