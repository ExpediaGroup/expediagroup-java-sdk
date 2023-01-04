package com.expediagroup.openworld.sdk.fraudprevention.models.exception

import com.expediagroup.sdk.core.model.exception.client.OpenWorldClientException

/**
 * An exception to be thrown when a constraint on some property has been violated.
 *
 * @property message The detail message.
 * @property constraintViolations A list of the constraint violations that occurred
 */
class PropertyConstraintViolationException(
    message: String,
    val constraintViolations: List<PropertyConstraintViolation>
) : OpenWorldClientException(message)
