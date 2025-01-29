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
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Named
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class LogMaskerTest {
    @Nested
    inner class PaymentMaskTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "security_code",
                "card_number",
                "card_cvv_response",
                "card_avs_response",
                "pin",
                "card_cvv",
                "access_token",
                "account_number",
                "card_cvv2",
                "card_cvv2_response",
                "cvv"
            ]
        )
        fun `given a text with payment info then omit it`(key: String) {
            var actual: String = mask(
                "{\"$key\":\"123456\"}",
                DEFAULT_MASKED_BODY_FIELDS
            )
            var expected = "{\"$key\":\"$OMITTED\"}"
            assertThat(actual).isEqualTo(expected)

            actual = mask(
                "{\"$key\":\"value\"}",
                DEFAULT_MASKED_BODY_FIELDS
            )
            expected = "{\"$key\":\"$OMITTED\"}"
            assertThat(actual).isEqualTo(expected)

            actual = mask(
                "{\"$key\":\"417956af-3aee-4c19-8286-e72da5154984\"}",
                DEFAULT_MASKED_BODY_FIELDS
            )
            expected = "{\"$key\":\"$OMITTED\"}"
            assertThat(actual).isEqualTo(expected)

            actual = mask(
                "{\"uuid\":\"417956af-3aee-4c19-8286-e72da5154984\"}",
                DEFAULT_MASKED_BODY_FIELDS
            )
            expected = "{\"uuid\":\"417956af-3aee-4c19-8286-e72da5154984\"}"
            assertThat(actual).isEqualTo(expected)
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PaymentNumberTest {
        @DisplayName("Given a number of")
        @ParameterizedTest(name = "{0} digits then {1}")
        @MethodSource("paymentNumberTests")
        fun `given a number of`(number: String, omitted: Boolean) {
            val actual = mask("{" +
                "\"number\": \"$number\", \"some_key\":\"some_value\"" +
                "}", DEFAULT_MASKED_BODY_FIELDS)
            val expected = "{" +
                "\"number\": \"${if (omitted) OMITTED else number}\", \"some_key\":\"some_value\"" +
                "}"
            assertThat(actual).isEqualTo(expected)
        }

        private fun paymentNumberTests() =
            listOf(
                "12345678901",
                "123456789012",
                "123456789012345",
                "1234567890123456789",
                "12345678901234567890"
            ).map {
                Arguments.of(
                    Named.of(it.length.toString(), it),
                    Named.of(
                        if (it.length in (12..19)) "omit it" else "do not omit it",
                        it.length in (12..19)
                    )
                )
            }
    }
}
