package com.expediagroup.sdk.core.constant

import io.ktor.http.HttpHeaders

internal data object LogMaskingFields {
    val DEFAULT_MASKED_HEADER_FIELDS: Set<String> = mutableSetOf(HttpHeaders.Authorization)
    val DEFAULT_MASKED_BODY_FIELDS: Set<String> =
        mutableSetOf(
            "cvv",
            "pin",
            "card_cvv",
            "card_cvv2",
            "card_number",
            "security_code",
            "account_number",
            "card_avs_response",
            "card_cvv_response",
            "card_cvv2_response"
        )
}
