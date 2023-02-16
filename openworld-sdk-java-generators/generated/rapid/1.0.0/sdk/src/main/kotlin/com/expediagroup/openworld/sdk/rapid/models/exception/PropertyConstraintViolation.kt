package com.expediagroup.openworld.sdk.rapid.models.exception

/**
 * An entity to represent a constraint violation of a property.
 *
 * @property name The name of the constraint-violated field
 * @property path The path of the constraint-violated field
 * @property message The constraint violation message
 */
data class PropertyConstraintViolation(
    val name: String,
    val path: String,
    val message: String
)
