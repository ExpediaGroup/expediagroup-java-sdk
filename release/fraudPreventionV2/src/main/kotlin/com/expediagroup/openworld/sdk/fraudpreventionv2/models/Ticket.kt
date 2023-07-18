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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models


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
 * This field provides information about the tickets related to the activity.
 * @param category Describes the type or category of the ticket.
 * @param quantity This field represents the count or number of a specific ticket type associated with an activity.
 */
data class Ticket(
    /* Describes the type or category of the ticket. */
@JsonProperty("category")

    val category: Ticket.Category,

    /* This field represents the count or number of a specific ticket type associated with an activity. */
@JsonProperty("quantity")

    val quantity: kotlin.Int
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var category: Ticket.Category? = null,
        private var quantity: kotlin.Int? = null
    ) {
        fun category(category: Ticket.Category) = apply { this.category = category }
        fun quantity(quantity: kotlin.Int) = apply { this.quantity = quantity }

        fun build(): Ticket {
            // Check required params
            validateNullity()
            return Ticket(
                category = category!!,
                quantity = quantity!!
            )
        }

        private fun validateNullity() {
            if (category == null) {
                throw NullPointerException("Required parameter category is missing")
            }
            if (quantity == null) {
                throw NullPointerException("Required parameter quantity is missing")
            }
        }
    }

    /**
     * Describes the type or category of the ticket.
     * Values: ADULT,CHILD,SENIOR,STUDENT,OTHER
     */
    enum class Category(val value: kotlin.String) {
        @JsonProperty("ADULT")
        ADULT("ADULT"),
        
        @JsonProperty("CHILD")
        CHILD("CHILD"),
        
        @JsonProperty("SENIOR")
        SENIOR("SENIOR"),
        
        @JsonProperty("STUDENT")
        STUDENT("STUDENT"),
        
        @JsonProperty("OTHER")
        OTHER("OTHER");
    }
}

