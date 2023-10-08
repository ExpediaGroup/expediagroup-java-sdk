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

import com.expediagroup.sdk.core.constant.Authentication.BASIC
import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.constant.HeaderKey.AUTHORIZATION
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.plugin.logging.MaskProvider.AuthMask
import com.expediagroup.sdk.core.plugin.logging.MaskProvider.PaymentMask
import com.expediagroup.sdk.core.plugin.logging.MaskProvider.PaymentNumberMask
import io.mockk.mockkObject
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LogMaskerTest {
    @ParameterizedTest
    @ValueSource(strings = [BASIC, BEARER, EAN])
    fun `given text apply all masks available`(authType: String) {
        val text = "$AUTHORIZATION: $authType token cvv:'123'"
        mockkObject(AuthMask)

        val maskedText = mask(text)

        assertThat(maskedText).isEqualTo("$AUTHORIZATION: $authType $OMITTED cvv:'$OMITTED'")
        verify(exactly = 1) { AuthMask.mask(text) }
    }

    @Nested
    inner class AuthMaskTest {
        @ParameterizedTest
        @ValueSource(strings = [BASIC, BEARER, EAN])
        fun `given text with auth then omit token`(authType: String) {
            val text = "$AUTHORIZATION: $authType token"

            val maskedText = AuthMask.mask(text)

            assertThat(maskedText).isEqualTo("$AUTHORIZATION: $authType $OMITTED")
        }
    }

    @Nested
    inner class PaymentMaskTest {

        @ParameterizedTest
        @ValueSource(
            strings = [
                "security_code",
                "number",
                "card_number",
                "card_cvv_response",
                "card_avs_response",
                "pin",
                "card_cvv",
                "account_number",
                "card_cvv2",
                "card_cvv2_response",
                "cvv"
            ]
        )
        fun `given a text with payment info then omit it`(key: String) {
            assertThat(PaymentMask.mask("$key:\"123456\" something else")).isEqualTo("$key:\"$OMITTED\" something else")
            assertThat(PaymentMask.mask("$key: \"123456\" something else")).isEqualTo("$key: \"$OMITTED\" something else")
            assertThat(PaymentMask.mask("$key:'123456' something else")).isEqualTo("$key:'$OMITTED' something else")
            assertThat(PaymentMask.mask("$key: '123456' something else")).isEqualTo("$key: '$OMITTED' something else")
        }
    }

    @Nested
    inner class PaymentNumberTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "012345678901234",
                "0123456789012345"
            ]
        )
        fun `given a text with number of 15 or 16 digits then omit it`(number: String) {
            assertThat(PaymentNumberMask.mask("number:\"$number\" something else")).isEqualTo("number:\"$OMITTED\" something else")
            assertThat(PaymentNumberMask.mask("number: \"$number\" something else")).isEqualTo("number: \"$OMITTED\" something else")
            assertThat(PaymentNumberMask.mask("number:'$number' something else")).isEqualTo("number:'$OMITTED' something else")
            assertThat(PaymentNumberMask.mask("number: '$number' something else")).isEqualTo("number: '$OMITTED' something else")
        }

        @Test
        fun `given a text with number of 14 digits then do not omit it`() {
            val number = "01234567890123"
            assertThat(PaymentNumberMask.mask("number:\"$number\" something else")).isEqualTo("number:\"$number\" something else")
            assertThat(PaymentNumberMask.mask("number: \"$number\" something else")).isEqualTo("number: \"$number\" something else")
            assertThat(PaymentNumberMask.mask("number:'$number' something else")).isEqualTo("number:'$number' something else")
            assertThat(PaymentNumberMask.mask("number: '$number' something else")).isEqualTo("number: '$number' something else")
        }
    }
}
