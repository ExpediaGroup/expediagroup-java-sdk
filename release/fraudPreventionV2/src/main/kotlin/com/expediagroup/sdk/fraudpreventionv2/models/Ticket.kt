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

package com.expediagroup.sdk.fraudpreventionv2.models

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

/**
 *
 * @param type Specifies the type of the ticket, such as ADULT, CHILD, SENIOR, STUDENT, or OTHER.
 * @param quantity This field represents the count or number of tickets associated with the type.
 */
data class Ticket(
    // Specifies the type of the ticket, such as ADULT, CHILD, SENIOR, STUDENT, or OTHER.
    @JsonProperty("type")
    val type: Ticket.Type,
    // This field represents the count or number of tickets associated with the type.
    @JsonProperty("quantity")
    val quantity: kotlin.Int
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var type: Ticket.Type? = null,
        private var quantity: kotlin.Int? = null
    ) {
        fun type(type: Ticket.Type) = apply { this.type = type }

        fun quantity(quantity: kotlin.Int) = apply { this.quantity = quantity }

        fun build(): Ticket {
            // Check required params
            validateNullity()
            return Ticket(
                type = type!!,
                quantity = quantity!!
            )
        }

        private fun validateNullity() {
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
            if (quantity == null) {
                throw NullPointerException("Required parameter quantity is missing")
            }
        }
    }

    /**
     * Specifies the type of the ticket, such as ADULT, CHILD, SENIOR, STUDENT, or OTHER.
     * Values: ADULT,CHILD,SENIOR,STUDENT,OTHER
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("ADULT")
        ADULT("ADULT"),

        @JsonProperty("CHILD")
        CHILD("CHILD"),

        @JsonProperty("SENIOR")
        SENIOR("SENIOR"),

        @JsonProperty("STUDENT")
        STUDENT("STUDENT"),

        @JsonProperty("OTHER")
        OTHER("OTHER")
    }
}
