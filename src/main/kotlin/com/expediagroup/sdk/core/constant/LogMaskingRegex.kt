package com.expediagroup.sdk.core.constant

import com.expediagroup.sdk.core.constant.Authentication.BASIC
import com.expediagroup.sdk.core.constant.Authentication.BEARER
import com.expediagroup.sdk.core.constant.Authentication.EAN

internal object LogMaskingRegex {
    val AUTHORIZATION_PREFIX_REGEX: Regex = "Authorization: ($EAN|$BASIC|$BEARER|)\\s".toRegex()

    val AUTHORIZATION_REGEX: Regex = "$AUTHORIZATION_PREFIX_REGEX(\\S)+".toRegex()
}
