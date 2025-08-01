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

package com.expediagroup.sdk.openapigenerator.mustache

import java.io.Serializable

/**
 * Represents a supporting template used in the OpenAPI generator.
 * Mapped internally to the OpenAPI generator's `SupportingFile` class.
 *
 * @property templateFile template file name (relative to the customTemplatesDir).
 * @property destinationPath destination path where the rendered output of this template will be placed.
 * @property fileName the name of the file generated from this template.
 */
data class SupportingTemplate(
    val templateFile: String,
    val destinationPath: String,
    val fileName: String
) : Serializable
