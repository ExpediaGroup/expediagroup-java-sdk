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

package com.expediagroup.openworld.sdk.rapid.models

import com.expediagroup.openworld.sdk.rapid.models.Property
import com.expediagroup.openworld.sdk.rapid.models.UnavailableReason

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param propertyId Expedia property ID.
 * @param score A score to sort properties where the higher the value the better. It can be used to:<br> * Sort the properties on the response<br> * Sort properties across multiple responses in parallel searches for large regions<br>
 * @param unavailableReason 
 */
data class PropertyUnavailability(

    /* Expedia property ID. */
@JsonProperty("property_id")

    
    
    
    
    @field:Valid
    val propertyId: kotlin.String? = null,

    /* A score to sort properties where the higher the value the better. It can be used to:<br> * Sort the properties on the response<br> * Sort properties across multiple responses in parallel searches for large regions<br> */
@JsonProperty("score")

    
    
    
    
    @field:Valid
    val score: java.math.BigDecimal? = null,

    @JsonProperty("unavailable_reason")

    
    
    
    
    @field:Valid
    val unavailableReason: UnavailableReason? = null
) : Property {
    @JsonProperty("status")
override val status : kotlin.String = "partially_unavailable"



    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var propertyId: kotlin.String? = null,
        private var score: java.math.BigDecimal? = null,
        private var unavailableReason: UnavailableReason? = null
    ) {
        fun propertyId(propertyId: kotlin.String) = apply { this.propertyId = propertyId }
        fun score(score: java.math.BigDecimal) = apply { this.score = score }
        fun unavailableReason(unavailableReason: UnavailableReason) = apply { this.unavailableReason = unavailableReason }

        fun build(): PropertyUnavailability {
            return PropertyUnavailability(
                propertyId = propertyId,
                score = score,
                unavailableReason = unavailableReason
            )
        }

    }
}

