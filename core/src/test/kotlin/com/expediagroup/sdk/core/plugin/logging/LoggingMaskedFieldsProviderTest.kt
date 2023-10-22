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
            ClientFactory.createExpediaGroupClient(setOf("invalid_field*"))
        }
    }

    @Test
    fun `given list containing invalid headers names then throws exception`() {
        val initialMaskedHeaderFields = LoggingMaskedFieldsProvider.getMaskedHeaderFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            LoggingMaskedFieldsProvider.addHeaders(listOf("invalid_field1*", "invalid_field2#", "valid_field1*"))
        }

        assertThat(LoggingMaskedFieldsProvider.getMaskedHeaderFields()).isEqualTo(initialMaskedHeaderFields)
    }

    @Test
    fun `given invalid body field name then throws exception`() {
        val initialMaskedBodyFields = LoggingMaskedFieldsProvider.getMaskedBodyFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field^]"
        ) {
            LoggingMaskedFieldsProvider.addBodyField("invalid_field^")
        }

        assertThat(LoggingMaskedFieldsProvider.getMaskedBodyFields()).isEqualTo(initialMaskedBodyFields)
    }

    @Test
    fun `given list containing invalid body fields names then throws exception`() {
        val initialMaskedBodyFields = LoggingMaskedFieldsProvider.getMaskedBodyFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            LoggingMaskedFieldsProvider.addBodyFields(listOf("invalid_field1*", "invalid_field2#", "valid-field1*"))
        }

        assertThat(LoggingMaskedFieldsProvider.getMaskedBodyFields()).isEqualTo(initialMaskedBodyFields)
    }

    @Test
    fun `given valid fields names then add to sets`() {
        val initialMaskedHeaderFields = LoggingMaskedFieldsProvider.getMaskedHeaderFields()
        val initialMaskedBodyFields = LoggingMaskedFieldsProvider.getMaskedBodyFields()

        LoggingMaskedFieldsProvider.addHeader("valid_field1")
        LoggingMaskedFieldsProvider.addHeaders(listOf("valid_field2", "valid-field3", "valid-field4"))
        LoggingMaskedFieldsProvider.addBodyField("valid_field1")
        LoggingMaskedFieldsProvider.addBodyFields(listOf("valid_field2", "valid-field3", "valid-field4"))

        assertThat(LoggingMaskedFieldsProvider.getMaskedHeaderFields()).isNotEqualTo(initialMaskedHeaderFields)
        assertThat(LoggingMaskedFieldsProvider.getMaskedHeaderFields()).containsAll(initialMaskedHeaderFields)
        assertThat(LoggingMaskedFieldsProvider.getMaskedHeaderFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))

        assertThat(LoggingMaskedFieldsProvider.getMaskedBodyFields()).isNotEqualTo(initialMaskedBodyFields)
        assertThat(LoggingMaskedFieldsProvider.getMaskedBodyFields()).containsAll(initialMaskedBodyFields)
        assertThat(LoggingMaskedFieldsProvider.getMaskedBodyFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))
    }
}
