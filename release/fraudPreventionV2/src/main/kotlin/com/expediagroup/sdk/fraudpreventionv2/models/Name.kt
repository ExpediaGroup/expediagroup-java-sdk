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
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Group of attributes intended to hold information about a customer or traveler's name for the order.
 * @param lastName Surname, or last name, of the person.
 * @param firstName Given, or first name, of the person.
 * @param middleName Middle name of the person.
 * @param title Title of the person for name (e.g. Mr., Ms. etc).
 * @param suffix Generational designations (e.g. Sr, Jr, III) or values that indicate the individual holds a position, educational degree, accreditation, office, or honor (e.g. PhD, CCNA, OBE).
 */
data class Name(
    // Surname, or last name, of the person.
    @JsonProperty("last_name")
    @field:Length(max = 200)
    @field:Valid
    val lastName: kotlin.String,
    // Given, or first name, of the person.
    @JsonProperty("first_name")
    @field:Length(max = 200)
    @field:Valid
    val firstName: kotlin.String,
    // Middle name of the person.
    @JsonProperty("middle_name")
    @field:Length(max = 200)
    @field:Valid
    val middleName: kotlin.String? = null,
    // Title of the person for name (e.g. Mr., Ms. etc).
    @JsonProperty("title")
    @field:Length(max = 200)
    @field:Valid
    val title: kotlin.String? = null,
    // Generational designations (e.g. Sr, Jr, III) or values that indicate the individual holds a position, educational degree, accreditation, office, or honor (e.g. PhD, CCNA, OBE).
    @JsonProperty("suffix")
    @field:Length(max = 50)
    @field:Valid
    val suffix: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var lastName: kotlin.String? = null,
        private var firstName: kotlin.String? = null,
        private var middleName: kotlin.String? = null,
        private var title: kotlin.String? = null,
        private var suffix: kotlin.String? = null
    ) {
        fun lastName(lastName: kotlin.String) = apply { this.lastName = lastName }

        fun firstName(firstName: kotlin.String) = apply { this.firstName = firstName }

        fun middleName(middleName: kotlin.String) = apply { this.middleName = middleName }

        fun title(title: kotlin.String) = apply { this.title = title }

        fun suffix(suffix: kotlin.String) = apply { this.suffix = suffix }

        fun build(): Name {
            // Check required params
            validateNullity()
            return Name(
                lastName = lastName!!,
                firstName = firstName!!,
                middleName = middleName,
                title = title,
                suffix = suffix
            )
        }

        private fun validateNullity() {
            if (lastName == null) {
                throw NullPointerException("Required parameter lastName is missing")
            }
            if (firstName == null) {
                throw NullPointerException("Required parameter firstName is missing")
            }
        }
    }
}
