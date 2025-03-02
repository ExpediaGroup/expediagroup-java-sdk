/*
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.logging.Constant

/**
 * A class that masks specified headers in a `Headers` object.
 *
 * @property keys A list of header keys that should be masked.
 */
class MaskHeaders(
    private val keys: List<String>
) : (Headers) -> Headers {
    /**
     * Masks the specified headers in the given `Headers` object.
     *
     * @param headers The original `Headers` object.
     * @return A new `Headers` object with the specified headers masked.
     */
    override fun invoke(headers: Headers): Headers =
        headers.newBuilder().apply {
            headers.names().filter { keys.contains(it) }.forEach { key ->
                set(key, Constant.OMITTED)
            }
        }.build()
}
