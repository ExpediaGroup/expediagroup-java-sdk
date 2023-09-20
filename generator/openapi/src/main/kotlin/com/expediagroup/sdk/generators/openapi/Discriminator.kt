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
package com.expediagroup.sdk.generators.openapi

import org.openapitools.codegen.CodegenModel

internal fun getParentDiscriminator(model: CodegenModel): MutableList<Discriminator> {
    if (model.parentModel === null) return mutableListOf()
    val discriminators: MutableList<Discriminator> = getParentDiscriminator(model.parentModel)
    model.parentModel.vars?.find { it.isDiscriminator }?.let { variable ->
        model.parentModel?.discriminator?.let {
            discriminators.add(
                Discriminator(
                    it.propertyBaseName,
                    it.propertyName,
                    variable.datatypeWithEnum,
                    it.mappedModels.find { mappedModel -> mappedModel.modelName.equals(model.classname) }!!.mappingName,
                    model.parentModel.name,
                    variable.isEnum,
                    variable.isString
                )
            )
        }
    }
    return discriminators
}

internal data class Discriminator(
    val originalName: String,
    val name: String,
    val type: String,
    val value: String,
    val parentName: String,
    val isEnum: Boolean,
    val isString: Boolean
)
