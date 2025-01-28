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

import com.expediagroup.sdk.core.constant.LogMaskingFields.DEFAULT_MASKED_BODY_FIELDS
import com.expediagroup.sdk.core.constant.LogMaskingFields.DEFAULT_MASKED_HEADER_FIELDS
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupInvalidFieldNameException
import com.expediagroup.sdk.core.test.ClientFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LoggingMaskedFieldsProviderTest {
    @Test
    fun `given invalid header name then throws exception`() {
        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field*]"
        ) {
            ClientFactory.createExpediaGroupClient(maskedHeaderFields = setOf("invalid_field*"))
        }
    }

    @Test
    fun `given list containing invalid headers names then throws exception`() {
        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            ClientFactory.createExpediaGroupClient(maskedHeaderFields = setOf("invalid_field1*", "invalid_field2#", "valid_field1*"))
        }
    }

    @Test
    fun `given invalid body field name then throws exception`() {
        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field^]"
        ) {
            ClientFactory.createExpediaGroupClient(maskedBodyFields = setOf("invalid_field^"))
        }
    }

    @Test
    fun `given list containing invalid body fields names then throws exception`() {
        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            ClientFactory.createExpediaGroupClient(maskedBodyFields = setOf("invalid_field1*", "invalid_field2#", "valid-field1*"))
        }
    }

    @Test
    fun `given valid fields names then add to sets`() {
        val client =
            ClientFactory.createExpediaGroupClient(
                maskedHeaderFields = setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"),
                maskedBodyFields = setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4")
            )

        val loggingMaskedFieldsProvider = client.getLoggingMaskedFieldsProvider()

        assertThat(loggingMaskedFieldsProvider.getMaskedHeaderFields()).isNotEqualTo(DEFAULT_MASKED_HEADER_FIELDS)
        assertThat(loggingMaskedFieldsProvider.getMaskedHeaderFields()).containsAll(DEFAULT_MASKED_HEADER_FIELDS)
        assertThat(loggingMaskedFieldsProvider.getMaskedHeaderFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))
        assertThat(loggingMaskedFieldsProvider.getMaskedBodyFields()).isNotEqualTo(DEFAULT_MASKED_BODY_FIELDS)
        assertThat(loggingMaskedFieldsProvider.getMaskedBodyFields()).containsAll(DEFAULT_MASKED_BODY_FIELDS)
        assertThat(loggingMaskedFieldsProvider.getMaskedBodyFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))
    }
}
