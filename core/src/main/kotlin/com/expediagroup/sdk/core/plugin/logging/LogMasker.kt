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
package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.constant.LogMaskingRegex.MASKED_FIELDS_REGEX
import com.expediagroup.sdk.core.constant.LogMaskingRegex.NUMBER_FIELD_REGEX
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED

internal fun mask(message: String): String = MaskProvider.masks.fold(message) { acc, mask -> mask.mask(acc) }

internal interface Mask {
    val getRegex: () -> Regex

    fun mask(string: String): String = string.replace(this.getRegex()) { maskSubstring(it.value) }

    fun maskSubstring(string: String) = OMITTED
}

internal object MaskProvider {
    val masks = listOf(PaymentMask, PaymentNumberMask)

    object PaymentMask : Mask {
        override val getRegex = { MASKED_FIELDS_REGEX }
    }

    object PaymentNumberMask : Mask {
        override val getRegex = { NUMBER_FIELD_REGEX }
    }
}
