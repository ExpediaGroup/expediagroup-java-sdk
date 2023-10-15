package com.expediagroup.sdk.core.model.exception.client

/**
 * Thrown to indicate that one or more passed field names are invalid.
 *
 * @param fieldsNames the names of the invalid fields.
 */
class ExpediaGroupInvalidFieldNameException(fieldsNames: Collection<String>) :
    ExpediaGroupClientException("All fields names must contain only alphanumeric characters in addition to - and _ but found [${fieldsNames.joinToString(",")}]") {
    constructor(fieldName: String) : this(setOf(fieldName))
}
