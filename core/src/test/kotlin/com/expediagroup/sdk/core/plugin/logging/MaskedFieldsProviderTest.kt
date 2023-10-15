package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupInvalidFieldNameException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MaskedFieldsProviderTest {
    @Test
    fun `given invalid header name then throws exception`() {
        val initialMaskedHeaderFields = MaskedFieldsProvider.getMaskedHeaderFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field*]"
        ) {
            MaskedFieldsProvider.addHeader("invalid_field*")
        }

        assertThat(MaskedFieldsProvider.getMaskedHeaderFields()).isEqualTo(initialMaskedHeaderFields)
    }

    @Test
    fun `given list containing invalid headers names then throws exception`() {
        val initialMaskedHeaderFields = MaskedFieldsProvider.getMaskedHeaderFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            MaskedFieldsProvider.addHeaders(listOf("invalid_field1*", "invalid_field2#", "valid_field1*"))
        }

        assertThat(MaskedFieldsProvider.getMaskedHeaderFields()).isEqualTo(initialMaskedHeaderFields)
    }

    @Test
    fun `given invalid body field name then throws exception`() {
        val initialMaskedBodyFields = MaskedFieldsProvider.getMaskedBodyFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field^]"
        ) {
            MaskedFieldsProvider.addBodyField("invalid_field^")
        }

        assertThat(MaskedFieldsProvider.getMaskedBodyFields()).isEqualTo(initialMaskedBodyFields)
    }

    @Test
    fun `given list containing invalid body fields names then throws exception`() {
        val initialMaskedBodyFields = MaskedFieldsProvider.getMaskedBodyFields()

        assertThrows<ExpediaGroupInvalidFieldNameException>(
            "All fields names must contain only alphanumeric characters in addition to - and _ but found [invalid_field1*, invalid_field2*]"
        ) {
            MaskedFieldsProvider.addBodyFields(listOf("invalid_field1*", "invalid_field2#", "valid-field1*"))
        }

        assertThat(MaskedFieldsProvider.getMaskedBodyFields()).isEqualTo(initialMaskedBodyFields)
    }

    @Test
    fun `given valid fields names then add to sets`() {
        val initialMaskedHeaderFields = MaskedFieldsProvider.getMaskedHeaderFields()
        val initialMaskedBodyFields = MaskedFieldsProvider.getMaskedBodyFields()

        MaskedFieldsProvider.addHeader("valid_field1")
        MaskedFieldsProvider.addHeaders(listOf("valid_field2", "valid-field3", "valid-field4"))
        MaskedFieldsProvider.addBodyField("valid_field1")
        MaskedFieldsProvider.addBodyFields(listOf("valid_field2", "valid-field3", "valid-field4"))

        assertThat(MaskedFieldsProvider.getMaskedHeaderFields()).isNotEqualTo(initialMaskedHeaderFields)
        assertThat(MaskedFieldsProvider.getMaskedHeaderFields()).containsAll(initialMaskedHeaderFields)
        assertThat(MaskedFieldsProvider.getMaskedHeaderFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))

        assertThat(MaskedFieldsProvider.getMaskedBodyFields()).isNotEqualTo(initialMaskedBodyFields)
        assertThat(MaskedFieldsProvider.getMaskedBodyFields()).containsAll(initialMaskedBodyFields)
        assertThat(MaskedFieldsProvider.getMaskedBodyFields()).containsAll(setOf("valid_field1", "valid_field2", "valid-field3", "valid-field4"))
    }
}
