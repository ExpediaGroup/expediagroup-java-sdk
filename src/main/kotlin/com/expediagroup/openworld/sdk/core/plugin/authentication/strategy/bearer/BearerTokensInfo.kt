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
package com.expediagroup.openworld.sdk.core.plugin.authentication.strategy.bearer

import com.expediagroup.openworld.sdk.core.constant.Authentication
import com.expediagroup.openworld.sdk.core.constant.Constant
import io.ktor.client.plugins.auth.providers.BearerTokens
import java.time.LocalDateTime

internal open class BearerTokensInfo(val bearerTokens: BearerTokens, expiresIn: Int) {
    companion object {
        internal val emptyBearerTokenInfo = object : BearerTokensInfo(BearerTokens(Constant.EMPTY_STRING, Constant.EMPTY_STRING), -1) {
            override fun isAboutToExpire() = true
        }
    }

    private val expiryDate: LocalDateTime

    init {
        this.expiryDate = calculateExpiryDate(expiresIn)
    }

    private fun calculateExpiryDate(expiresIn: Int) = LocalDateTime.now().plusSeconds(expiresIn.toLong())

    open fun isAboutToExpire() = LocalDateTime.now().isAfter(expiryDate.minusSeconds(Authentication.BEARER_EXPIRY_DATE_MARGIN))
}
