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
package com.expediagroup.openworld.sdk.generators.openapi

import com.samskivert.mustache.Mustache
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenProperty

val mustacheHelpers = mapOf(
    "removeLeadingSlash" to {
        Mustache.Lambda { fragment, writer -> writer.write(fragment.execute().removePrefix("/")) }
    },
    "assignDiscriminators" to {
        Mustache.Lambda { fragment, writer ->
            val model = fragment.context() as CodegenModel
            getParentDiscriminator(model).forEach {
                val type = (if (it.isEnum) "${it.parentName}." else "") + it.type
                writer.write("@JsonProperty(\"${it.originalName}\")\n")
                writer.write("override val ${it.name} : $type = $type.${it.value}\n")
            }
        }
    },
    "eliminateDiscriminators" to {
        Mustache.Lambda { fragment, writer ->
            val discriminators: List<String> = getParentDiscriminator(fragment.context(1) as CodegenModel).map { it.originalName }
            val property = fragment.context() as CodegenProperty
            if (!discriminators.contains(property.baseName)) {
                writer.write(fragment.execute())
            }
        }
    }
)
