package com.expediagroup.sdk.rest.exception.client

import com.expediagroup.sdk.core.exception.client.ExpediaGroupClientException

/**
 * An exception to be thrown when a constraint on some property has been violated.
 *
 * @property message The detail message.
 * @property constraintViolations A list of the constraint violations that occurred
 */
class PropertyConstraintViolationException(
    message: String = "Some field constraints have been violated",
    constraintViolations: List<String>
) : ExpediaGroupClientException(
        "$message ${constraintViolations.joinToString(separator = ",\n\t- ", prefix = "[\n\t- ", postfix = "\n]")}"
    )
