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

import com.expediagroup.sdk.core.constant.Authentication
import com.expediagroup.sdk.core.constant.Constant.EMPTY_STRING
import java.time.Instant

internal open class SignatureHolder(
    val signature: String,
    private val timestamp: Instant
) {
    companion object {
        internal val emptySignatureHolder = object : SignatureHolder(EMPTY_STRING, Instant.MIN) {
            override fun isAboutToExpire() = true
        }
    }

    internal open fun isAboutToExpire() = timestamp.plusSeconds(Authentication.RAPID_TOKEN_LIFETIME - Authentication.RAPID_RENEW_SIGNATURE_MARGIN).isBefore(Instant.now())
}
