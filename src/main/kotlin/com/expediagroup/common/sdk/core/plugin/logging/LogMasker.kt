package com.expediagroup.common.sdk.core.plugin.logging

import com.expediagroup.common.sdk.core.constant.LogMaskingRegex.AUTHORIZATION_REGEX
import com.expediagroup.common.sdk.core.constant.LoggingMessage.OMITTED

internal fun mask(message: String): String = MaskProvider.masks.fold(message) { acc, mask -> mask.mask(acc) }

internal object MaskProvider {
    val masks = listOf<Mask>(AuthMask)

    object AuthMask : Mask {
        override val regex: Regex = AUTHORIZATION_REGEX
        override fun maskSubstring(string: String) = OMITTED
    }
}

internal interface Mask {
    val regex: Regex
    fun mask(string: String): String = string.replace(regex) { maskSubstring(it.value) }

    fun maskSubstring(string: String): String
}
