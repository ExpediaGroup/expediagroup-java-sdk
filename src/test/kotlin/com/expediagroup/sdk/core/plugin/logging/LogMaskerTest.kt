package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.constant.Authentication.BASIC
import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.constant.HeaderKey.AUTHORIZATION
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.plugin.logging.MaskProvider.AuthMask
import io.mockk.mockkObject
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LogMaskerTest {
    @ParameterizedTest
    @ValueSource(strings = [BASIC, BEARER, EAN])
    fun `given text apply all masks available`(authType: String) {
        val text = "$AUTHORIZATION: $authType token"
        mockkObject(AuthMask)

        val maskedText = mask(text)

        assertThat(maskedText).isEqualTo("$AUTHORIZATION: $authType $OMITTED")
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
}
