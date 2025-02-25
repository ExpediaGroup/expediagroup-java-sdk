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

import com.expediagroup.sdk.openapigenerator.util.OpenApiGeneratorConfigurator
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.openapitools.generator.gradle.plugin.extensions.OpenApiGeneratorGenerateExtension

/**
 * A Gradle plugin that applies the standard OpenAPI Generator plugin ("org.openapi.generator")
 * and configures it with Expedia Group SDK defaults.
 *
 * This plugin will:
 * 1. Apply the official "org.openapi.generator" plugin.
 * 2. Retrieve the [OpenApiGeneratorGenerateExtension].
 * 3. Invoke [OpenApiGeneratorConfigurator.configure] to set custom default settings.
 */
class EgSdkOpenApiGeneratorPlugin : Plugin<Project> {
    /**
     * Invoked by Gradle when this plugin is applied to a project.
     * Applies the base OpenAPI Generator plugin and configures
     * the extension using [OpenApiGeneratorConfigurator].
     *
     * @param project the Gradle [Project] on which the plugin is being applied
     */
    override fun apply(project: Project) {
        project.pluginManager.apply("org.openapi.generator")

        project.extensions.configure(OpenApiGeneratorGenerateExtension::class.java) { ext ->
            OpenApiGeneratorConfigurator.configure(project, ext)
        }
    }
}
