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

package com.expediagroup.sdk.rapid.models

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

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid

/**
 * An individual value add.
 * @param id Unique identifier for the value add promotion.
 * @param description A localized description of the value add promotion.
 * @param category
 * @param offerType
 * @param frequency
 * @param personCount Indicates how many guests the value add promotion applies to.
 */
data class ValueAdd(
    // Unique identifier for the value add promotion.
    @JsonProperty("id")
    @field:Valid
    val id: kotlin.String? = null,
    // A localized description of the value add promotion.
    @JsonProperty("description")
    @field:Valid
    val description: kotlin.String? = null,
    @JsonProperty("category")
    @field:Valid
    val category: CategoryValueAdd? = null,
    @JsonProperty("offer_type")
    @field:Valid
    val offerType: OfferType? = null,
    @JsonProperty("frequency")
    @field:Valid
    val frequency: Frequency? = null,
    // Indicates how many guests the value add promotion applies to.
    @JsonProperty("person_count")
    @field:Valid
    val personCount: java.math.BigDecimal? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var description: kotlin.String? = null,
        private var category: CategoryValueAdd? = null,
        private var offerType: OfferType? = null,
        private var frequency: Frequency? = null,
        private var personCount: java.math.BigDecimal? = null
    ) {
        fun id(id: kotlin.String?) = apply { this.id = id }

        fun description(description: kotlin.String?) = apply { this.description = description }

        fun category(category: CategoryValueAdd?) = apply { this.category = category }

        fun offerType(offerType: OfferType?) = apply { this.offerType = offerType }

        fun frequency(frequency: Frequency?) = apply { this.frequency = frequency }

        fun personCount(personCount: java.math.BigDecimal?) = apply { this.personCount = personCount }

        fun build(): ValueAdd {
            return ValueAdd(
                id = id,
                description = description,
                category = category,
                offerType = offerType,
                frequency = frequency,
                personCount = personCount
            )
        }
    }
}
