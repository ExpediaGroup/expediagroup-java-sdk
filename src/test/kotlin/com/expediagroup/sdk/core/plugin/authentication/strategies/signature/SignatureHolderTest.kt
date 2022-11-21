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
package com.expediagroup.sdk.core.plugin.authentication.strategies.signature

import com.expediagroup.sdk.core.commons.TestConstants.SIGNATURE_VALUE
import com.expediagroup.sdk.core.constant.Authentication.RAPID_RENEW_SIGNATURE_MARGIN
import com.expediagroup.sdk.core.constant.Authentication.RAPID_TOKEN_LIFETIME
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

internal class SignatureHolderTest {
    companion object {
        private const val MARGIN: Long = RAPID_TOKEN_LIFETIME - RAPID_RENEW_SIGNATURE_MARGIN
    }

    @Test
    fun `given time is now when calling isAboutToExpire should return false`() {
        val signatureHolder = SignatureHolder(SIGNATURE_VALUE, LocalDateTime.now())

        assertThat(signatureHolder.isAboutToExpire()).isFalse
    }

    @ParameterizedTest
    @ValueSource(longs = [MARGIN, MARGIN + 5, MARGIN + 20, MARGIN + 30])
    fun `given time is (now - (margin value or more)) when calling isAboutToExpire should return true`(seconds: Long) {
        val signatureHolder = SignatureHolder(SIGNATURE_VALUE, LocalDateTime.now().minusSeconds(seconds))

        assertThat(signatureHolder.isAboutToExpire()).isTrue
    }
}
