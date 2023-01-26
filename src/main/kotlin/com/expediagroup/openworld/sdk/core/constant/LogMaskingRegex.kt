package com.expediagroup.openworld.sdk.core.constant

import com.expediagroup.openworld.sdk.core.constant.Authentication.BASIC
import com.expediagroup.openworld.sdk.core.constant.Authentication.BEARER
import com.expediagroup.openworld.sdk.core.constant.Authentication.EAN
import com.expediagroup.openworld.sdk.core.constant.HeaderKey.AUTHORIZATION

internal object LogMaskingRegex {
    val AUTHORIZATION_REGEX: Regex = "(?<=$AUTHORIZATION: ($EAN|$BASIC|$BEARER|)\\s)\\S+".toRegex()
}
