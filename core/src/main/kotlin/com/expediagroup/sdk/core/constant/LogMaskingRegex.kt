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
package com.expediagroup.sdk.core.constant

import com.expediagroup.sdk.core.constant.Authentication.BASIC
import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN
import com.expediagroup.sdk.core.constant.HeaderKey.AUTHORIZATION

internal object LogMaskingRegex {
    val AUTHORIZATION_REGEX: Regex = "(?<=$AUTHORIZATION: ($EAN|$BASIC|$BEARER|)\\s)\\S+".toRegex()

    private val paymentKeys =
        arrayListOf(
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
        )

    val PAYMENT_REGEX = "(?<=(${paymentKeys.joinToString("|")}):\\s?[\"'])(\\s*\\S+\\s*)(?=[\"'])".toRegex()

    val NUMBER_FIELD_REGEX = "(?<=number:\\D?([\"']))(\\s*\\d{15,16}\\s*)(?=[\"'])".toRegex()
}
