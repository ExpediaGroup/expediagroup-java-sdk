/**
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
package com.expediagroup.sdk.exemplar.rest.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 * @param type
 * @param title
 * @param status
 * @param detail
 * @param instance
 * @param properties
 */
@ConsistentCopyVisibility data class ProblemDetail private constructor(
    @JsonProperty("type")
    val type: java.net.URI? = null,
    @JsonProperty("title")
    val title: kotlin.String? = null,
    @JsonProperty("status")
    val status: kotlin.Int? = null,
    @JsonProperty("detail")
    val detail: kotlin.String? = null,
    @JsonProperty("instance")
    val instance: java.net.URI? = null,
    @JsonProperty("properties")
    val properties: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var type: java.net.URI? = null,
        private var title: kotlin.String? = null,
        private var status: kotlin.Int? = null,
        private var detail: kotlin.String? = null,
        private var instance: java.net.URI? = null,
        private var properties: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null
    ) {
        fun type(type: java.net.URI?) = apply { this.type = type }

        fun title(title: kotlin.String?) = apply { this.title = title }

        fun status(status: kotlin.Int?) = apply { this.status = status }

        fun detail(detail: kotlin.String?) = apply { this.detail = detail }

        fun instance(instance: java.net.URI?) = apply { this.instance = instance }

        fun properties(properties: kotlin.collections.Map<kotlin.String, kotlin.Any>?) = apply { this.properties = properties }

        fun build(): ProblemDetail {
            val instance =
                ProblemDetail(
                    type = type,
                    title = title,
                    status = status,
                    detail = detail,
                    instance = instance,
                    properties = properties
                )

            return instance
        }
    }

    fun toBuilder() = Builder(
        type = type,
        title = title,
        status = status,
        detail = detail,
        instance = instance,
        properties = properties
    )
}
