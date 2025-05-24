package com.expediagroup.sdk.openapigenerator.extension

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import javax.inject.Inject

abstract class SpecTransformerExtension
    @Inject
    constructor(objects: ObjectFactory) {
        @get:Input
        val enabled: Property<Boolean> =
            objects.property(Boolean::class.java)
                .convention(false)

        @get:Input
        val headers: ListProperty<String> =
            objects.listProperty(String::class.java).convention(
                listOf("accept", "accept-encoding", "key")
            )

        @get:Input
        val operationIdsToTags: Property<Boolean> =
            objects.property(Boolean::class.java).convention(true)

        @get:Input
        val defaultStringType: Property<String> =
            objects.property(String::class.java).convention("QUOTE_SINGLE")
    }
