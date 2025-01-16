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

import io.ktor.http.HttpHeaders
import java.io.Serializable

internal data object LogMaskingFields {
    val DEFAULT_MASKED_HEADER_FIELDS: Set<String> = setOf(HttpHeaders.Authorization)
    val DEFAULT_MASKED_BODY_FIELDS: Set<LogMaskingField> =
        setOf(
            LogMaskingField.Single("cvv"),
            LogMaskingField.Single("pin"),
            LogMaskingField.Single("card_cvv"),
            LogMaskingField.Single("card_cvv2"),
            LogMaskingField.Single("card_number"),
            LogMaskingField.Single("access_token"),
            LogMaskingField.Single("security_code"),
            LogMaskingField.Single("account_number"),
            LogMaskingField.Single("card_avs_response"),
            LogMaskingField.Single("card_cvv_response"),
            LogMaskingField.Single("card_cvv2_response"),
            LogMaskingField.Pair("payment", "number"),
            LogMaskingField.Pair("payment", "security_code")
        )
}

sealed class LogMaskingField {
    data class Single(val value: String) : LogMaskingField()
    data class Pair(val first: String, val second: String) : LogMaskingField()
}
