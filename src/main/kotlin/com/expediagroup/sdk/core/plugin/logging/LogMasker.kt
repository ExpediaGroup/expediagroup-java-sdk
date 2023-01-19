package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.sdk.core.constant.LogMaskingRegex.AUTHORIZATION_PREFIX_REGEX
import com.expediagroup.sdk.core.constant.LogMaskingRegex.AUTHORIZATION_REGEX
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED

internal fun mask(message: String): String = MaskProvider.masks.fold(message) { acc, mask -> mask.mask(acc) }

internal object MaskProvider {
    val masks = listOf<Mask>(AuthMask)

    object AuthMask : Mask {
        override val regex: Regex = AUTHORIZATION_REGEX
        override fun maskSubstring(string: String): String {
            val token = string.replace(AUTHORIZATION_PREFIX_REGEX, EMPTY_STRING)
            val authorizationPrefix = string.replace(token, EMPTY_STRING)
            return "$authorizationPrefix$OMITTED"
        }
    }
}

internal interface Mask {
    val regex: Regex
    fun mask(string: String): String = string.replace(regex) { maskSubstring(it.value) }

    fun maskSubstring(string: String): String
}
