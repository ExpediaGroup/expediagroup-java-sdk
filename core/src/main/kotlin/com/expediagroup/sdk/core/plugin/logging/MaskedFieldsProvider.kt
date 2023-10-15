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
package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.constant.LogMaskingRegex.FIELD_REGEX
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupInvalidFieldNameException
import io.ktor.http.HttpHeaders

object MaskedFieldsProvider {
    private val maskedHeaderFields: MutableCollection<String> = mutableSetOf(HttpHeaders.Authorization)
    private val maskedBodyFields: MutableCollection<String> =
        mutableSetOf(
            "security_code", "card_number", "card_cvv_response", "card_avs_response", "pin", "card_cvv", "account_number", "card_cvv2", "card_cvv2_response", "cvv"
        )

    /**
     * @return a copy of the list of headers to be masked
     */
    fun getMaskedHeaderFields(): Collection<String> = maskedHeaderFields.toSet()

    /**
     * @return a copy of the list of body fields to be masked
     */
    fun getMaskedBodyFields(): Collection<String> = maskedBodyFields.toSet()

    /**
     * Adds a header field to the list of masked headers.
     *
     * @param headerName the name of the header to be added.
     * @throws ExpediaGroupInvalidFieldNameException if the field name is invalid.
     */
    fun addHeader(headerName: String) {
        headerName.takeIf(::isInvalid)?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedHeaderFields.add(headerName)
    }

    /**
     * Adds the provided headers to the list of masked headers.
     *
     * @param headersNames the names of the headers to be added.
     * @throws ExpediaGroupInvalidFieldNameException if the field name is invalid.
     */
    fun addHeaders(headersNames: Collection<String>) {
        headersNames.filter(::isInvalid).takeIf { it.isNotEmpty() }?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedHeaderFields.addAll(headersNames)
    }

    /**
     * Adds a field to the list of masked body fields.
     *
     * @param fieldName the name of the field to be added.
     * @throws ExpediaGroupInvalidFieldNameException if the field name is invalid.
     */
    fun addBodyField(fieldName: String) {
        fieldName.takeIf(::isInvalid)?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedBodyFields.add(fieldName)
    }

    /**
     * Adds the provided fields to the list of masked body fields.
     *
     * @param fieldsNames the names of the fields to be added.
     * @throws ExpediaGroupInvalidFieldNameException if the field name is invalid.
     */
    fun addBodyFields(fieldsNames: Collection<String>) {
        fieldsNames.filter(::isInvalid).takeIf { it.isNotEmpty() }?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedBodyFields.addAll(fieldsNames)
    }

    private fun isInvalid(fieldName: String): Boolean = !fieldName.matches(FIELD_REGEX)
}
