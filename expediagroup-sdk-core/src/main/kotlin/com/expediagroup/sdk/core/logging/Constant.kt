/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.core.logging

internal object Constant {
    const val NEWLINE = "\n"
    const val OMITTED = "<-- omitted -->"
    const val DEFAULT_LOG_MASKING_REPLACEMENT_TEMPLATE = "\"$1$2${OMITTED}\""
    const val DEFAULT_MAX_BODY_SIZE = 1000000L // 1MB
    const val EXPEDIA_GROUP_SDK = "Expedia Group SDK"
}
