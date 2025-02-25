package com.expediagroup.sdk.openapigenerator.mustache

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
                    it.mappedModels.find { mappedModel -> mappedModel.modelName.equals(model.classname) }!!.mappingName.uppercase(),
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
