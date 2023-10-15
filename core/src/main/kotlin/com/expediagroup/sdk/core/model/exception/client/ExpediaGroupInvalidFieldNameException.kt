package com.expediagroup.sdk.core.model.exception.client

/**
 * todo
 */
class ExpediaGroupInvalidFieldNameException(fieldsNames: Collection<String>) :
    ExpediaGroupClientException("All fields names must contain only alphanumeric characters in addition to - and _ but found [${fieldsNames.joinToString(",")}]") {
    constructor(fieldName: String) : this(setOf(fieldName))
}
