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

import com.expediagroup.sdk.rest.model.UrlQueryParam
import com.expediagroup.sdk.rest.util.UrlQueryParamStringifier.explode
import com.expediagroup.sdk.rest.util.swaggerCollectionFormatStringifier
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

/**
 * @property city
 * @property maxPrice
 */
@JsonDeserialize(builder = SearchHotelOperationParams.Builder::class)
@ConsistentCopyVisibility
data class SearchHotelOperationParams private constructor(
    val city: kotlin.String? =
        null,
    val maxPrice: java.math.BigDecimal? =
        null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        @JsonProperty("city") private var city: kotlin.String? = null,
        @JsonProperty("maxPrice") private var maxPrice: java.math.BigDecimal? = null
    ) {
        /**
         * @param city
         */
        fun city(city: kotlin.String) = apply { this.city = city }

        /**
         * @param maxPrice
         */
        fun maxPrice(maxPrice: java.math.BigDecimal) = apply { this.maxPrice = maxPrice }

        fun build(): SearchHotelOperationParams {
            val params =
                SearchHotelOperationParams(
                    city = city,
                    maxPrice = maxPrice
                )
            return params
        }
    }

    fun toBuilder() =
        Builder(
            city = city,
            maxPrice = maxPrice
        )

    fun getQueryParams(): List<UrlQueryParam> =
        buildList {
            city?.let {
                val key = "city"
                val value =
                    buildList {
                        add(it)
                    }

                add(
                    UrlQueryParam(
                        key = key,
                        value = value,
                        stringify = swaggerCollectionFormatStringifier.getOrDefault("", explode)
                    )
                )
            }
            maxPrice?.let {
                val key = "maxPrice"
                val value =
                    buildList {
                        add(it.toString())
                    }

                add(
                    UrlQueryParam(
                        key = key,
                        value = value,
                        stringify = swaggerCollectionFormatStringifier.getOrDefault("", explode)
                    )
                )
            }
        }
}
