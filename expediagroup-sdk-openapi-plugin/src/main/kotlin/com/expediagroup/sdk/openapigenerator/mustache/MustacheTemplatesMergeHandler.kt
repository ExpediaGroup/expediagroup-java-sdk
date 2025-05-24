package com.expediagroup.sdk.openapigenerator.mustache

import com.expediagroup.sdk.openapigenerator.extension.EgSdkGeneratorExtension
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.logging.Logging
import java.io.File
import java.net.JarURLConnection
import java.net.URL

/**
 * Responsible for assembling final Mustache templates,
 * combining default templates and any user-provided templates.
 */
object MustacheTemplatesMergeHandler {
    private val logger = Logging.getLogger(this.javaClass)

    /** Directory name where default templates reside within resources. */
    const val DEFAULT_TEMPLATES_DIR_NAME = "templates"

    /** Directory name used inside the build folder for merged final templates. */
    const val FINAL_TEMPLATES_DIR_NAME = "final_templates"

    /**
     * Creates or locates the final templates directory, populates it with default templates,
     * and merges any externally provided templates.
     *
     * @param project The Gradle [org.gradle.api.Project] instance.
     * @return The absolute path to the final templates' directory.
     */
    fun resolveFinalTemplates(project: Project): String {
        val finalTemplatesDirectory = initializeFinalTemplatesDirectory(project)
        extractDefaultTemplates(finalTemplatesDirectory)
        setupExternalTemplatesMerge(project, finalTemplatesDirectory)
        return finalTemplatesDirectory.absolutePath
    }

    /**
     * Ensures the final templates directory exists in the build folder.
     * If it doesn't exist, it is created.
     *
     * @param project The Gradle [Project] instance.
     * @return A [java.io.File] pointing to the final templates' directory.
     */
    private fun initializeFinalTemplatesDirectory(project: Project): File {
        val finalDir = project.layout.buildDirectory.dir(FINAL_TEMPLATES_DIR_NAME).get().asFile
        if (!finalDir.exists()) {
            finalDir.mkdirs()
            logger.info("Created final templates directory: ${finalDir.absolutePath}")
        }
        return finalDir
    }

    /**
     * Extracts built-in default templates from this JAR (under the given resource path)
     * and copies them into the provided target directory.
     *
     * @param targetDir Where to copy the default templates.
     */
    private fun extractDefaultTemplates(targetDir: File) {
        val resourceUrl = this::class.java.classLoader.getResource(DEFAULT_TEMPLATES_DIR_NAME)
        if (resourceUrl == null) {
            logger.warn("Default templates directory not found: $DEFAULT_TEMPLATES_DIR_NAME")
            return
        }

        when (resourceUrl.protocol) {
            "jar" -> extractResourcesFromJar(resourceUrl, targetDir)
            else -> logger.error("Unsupported resource protocol: ${resourceUrl.protocol}")
        }
    }

    /**
     * Reads all entries under [DEFAULT_TEMPLATES_DIR_NAME] from the JAR file
     * and copies them into [targetDir].
     *
     * @param resourceUrl The URL pointing to the default templates in the JAR.
     * @param targetDir The final destination for extracted files.
     */
    private fun extractResourcesFromJar(
        resourceUrl: URL,
        targetDir: File
    ) {
        try {
            val connection = resourceUrl.openConnection() as JarURLConnection
            connection.jarFile.use { jarFile ->
                jarFile.entries().asSequence()
                    .filter { it.name.startsWith("$DEFAULT_TEMPLATES_DIR_NAME/") && !it.isDirectory }
                    .forEach { entry ->
                        val relativePath = entry.name.removePrefix("$DEFAULT_TEMPLATES_DIR_NAME/")
                        val outputFile = File(targetDir, relativePath)

                        outputFile.parentFile.mkdirs()
                        jarFile.getInputStream(entry).use { input ->
                            outputFile.outputStream().use { output -> input.copyTo(output) }
                        }

                        logger.debug("Copied default template: $relativePath")
                    }
            }
        } catch (e: Exception) {
            logger.error("Failed to copy templates from JAR", e)
        }
    }

    /**
     * After project evaluation, merges any user-defined templates from the OpenApi Generator extension
     * into the final templates' directory.
     *
     * @param project The Gradle [Project] instance.
     * @param finalTemplatesDirectory The destination directory for merged templates.
     */
    private fun setupExternalTemplatesMerge(
        project: Project,
        finalTemplatesDirectory: File
    ) {
        val openApiExt =
            project.extensions.findByType(EgSdkGeneratorExtension::class.java)
                ?: return

        val externalTemplatePath = openApiExt.customTemplatesDir.orNull ?: return
        val externalTemplateDir = project.file(externalTemplatePath).takeIf { dir -> dir.exists() }

        if (externalTemplateDir == null) {
            logger.warn("External templates directory not found: $externalTemplatePath")
            return
        }

        project.copy { copySpec ->
            copySpec.from(externalTemplateDir)
            copySpec.into(finalTemplatesDirectory)
            copySpec.duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }

        logger.lifecycle("Merged user templates from $externalTemplatePath into ${finalTemplatesDirectory.absolutePath}")
    }
}
