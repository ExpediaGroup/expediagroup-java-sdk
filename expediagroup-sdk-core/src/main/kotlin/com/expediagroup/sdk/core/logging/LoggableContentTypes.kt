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

import com.expediagroup.sdk.core.http.MediaType

/**
 * A list of MIME types representing content types that are deemed loggable.
 * This collection is used to determine whether the content of HTTP requests or responses
 * can be logged based on their MIME types.
 */
internal val LOGGABLE_CONTENT_TYPES =
    listOf(
        MediaType.of("text", "plain"),
        MediaType.of("text", "html"),
        MediaType.of("text", "css"),
        MediaType.of("text", "javascript"),
        MediaType.of("text", "csv"),
        MediaType.of("text", "*"),
        MediaType.of("application", "json"),
        MediaType.of("application", "xml"),
        MediaType.of("application", "x-www-form-urlencoded"),
        MediaType.of("application", "json+graphql"),
        MediaType.of("application", "hal+json")
    )

internal fun isLoggable(
    mediaType: MediaType,
    loggableContentTypes: List<MediaType> = emptyList()
): Boolean =
    LOGGABLE_CONTENT_TYPES.plus(loggableContentTypes).any { loggableType ->
        loggableType.includes(mediaType)
    }
