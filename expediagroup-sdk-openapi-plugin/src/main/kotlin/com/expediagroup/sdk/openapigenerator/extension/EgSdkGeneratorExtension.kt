package com.expediagroup.sdk.openapigenerator.extension

import com.expediagroup.sdk.openapigenerator.mustache.ApiTemplate
import com.expediagroup.sdk.openapigenerator.mustache.SupportingTemplate
import com.samskivert.mustache.Mustache
import org.gradle.api.Action
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
import javax.inject.Inject

abstract class EgSdkGeneratorExtension
    @Inject
    constructor(objects: ObjectFactory) : ExtensionAware {
        abstract val specFilePath: RegularFileProperty
        abstract val basePackage: Property<String>
        abstract val modelPackage: Property<String>
        abstract val operationPackage: Property<String>
        abstract val customTemplatesDir: DirectoryProperty
        abstract val outputDir: DirectoryProperty
        abstract val namespace: Property<String>
        abstract val operationProcessors: ListProperty<(CodegenOperation) -> CodegenOperation>
        abstract val modelProcessors: ListProperty<(CodegenModel) -> CodegenModel>
        abstract val lambdas: ListProperty<Pair<String, Mustache.Lambda>>
        abstract val supportingTemplates: ListProperty<SupportingTemplate>
        abstract val apiTemplates: ListProperty<ApiTemplate>

        val specTransformer: SpecTransformerExtension =
            objects.newInstance(SpecTransformerExtension::class.java)

        fun specTransformer(action: Action<SpecTransformerExtension>) =
            (extensions.findByName("specTransformer") as SpecTransformerExtension)
                .apply { action.execute(this) }
    }
