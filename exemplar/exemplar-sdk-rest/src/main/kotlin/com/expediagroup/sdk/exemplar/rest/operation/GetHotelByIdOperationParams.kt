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
package com.expediagroup.sdk.exemplar.rest.operation

import com.expediagroup.sdk.core.common.getOrThrow
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * @property id
 */
@JsonDeserialize(builder = GetHotelByIdOperationParams.Builder::class)
@ConsistentCopyVisibility
data class GetHotelByIdOperationParams private constructor(
    val id: kotlin.Long

) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        @JsonProperty("id") private var id: kotlin.Long? = null

    ) {
        /**
         * @param id
         */
        fun id(id: kotlin.Long) = apply { this.id = id }

        fun build(): GetHotelByIdOperationParams {
            val id = this.id.getOrThrow {
                IllegalArgumentException("id must not be null")
            }

            val params = GetHotelByIdOperationParams(
                id = id
            )
            return params
        }
    }

    fun toBuilder() = Builder(
        id = id
    )

    fun getPathParams(): Map<String, String> = buildMap {
        id.also {
            put("id", id.toString())
        }
    }
}
