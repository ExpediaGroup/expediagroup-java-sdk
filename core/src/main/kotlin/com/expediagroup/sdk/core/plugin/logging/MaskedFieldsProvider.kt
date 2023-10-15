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

    fun getMaskedHeaderFields(): Collection<String> = maskedHeaderFields.toSet()

    fun getMaskedBodyFields(): Collection<String> = maskedBodyFields.toSet()

    /**
     * todo
     */
    fun addHeader(headerName: String) {
        headerName.takeIf(::isInvalid)?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedHeaderFields.add(headerName)
        val s = maskedHeaderFields.toString()
        println(s)
    }

    fun addHeaders(headersNames: Collection<String>) {
        headersNames.filter(::isInvalid).takeIf { it.isNotEmpty() }?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedHeaderFields.addAll(headersNames)
    }

    fun addBodyField(fieldName: String) {
        fieldName.takeIf(::isInvalid)?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedBodyFields.add(fieldName)
    }

    fun addBodyFields(fieldsNames: Collection<String>) {
        fieldsNames.filter(::isInvalid).takeIf { it.isNotEmpty() }?.let { throw ExpediaGroupInvalidFieldNameException(it) }
        maskedBodyFields.addAll(fieldsNames)
    }

    private fun isInvalid(fieldName: String): Boolean = !fieldName.matches(FIELD_REGEX)
}
