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
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param travelerName
 * @param primary Indicator for one of the travelers who is the primary traveler. One traveler in each itinerary item must be listed as primary. By default, for a single traveler this should be set to `true`.
 * @param emailAddress Email address associated with the traveler as supplied by the partner system.
 * @param telephones
 * @param age Age of the traveler.
 * @param birthDate Date of birth for traveler, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param citizenshipCountryCode The alpha-3 ISO country code of the traveler's nationality.
 * @param travelerId A unique identifier for travelers in the transaction.
 */
data class Traveler(
    @JsonProperty("traveler_name")
    @field:Valid
    val travelerName: Name,
    // Indicator for one of the travelers who is the primary traveler. One traveler in each itinerary item must be listed as primary. By default, for a single traveler this should be set to `true`.
    @JsonProperty("primary")
    @field:Valid
    val primary: kotlin.Boolean,
    // Email address associated with the traveler as supplied by the partner system.
    @JsonProperty("email_address")
    @field:Length(max = 200)
    @field:Valid
    val emailAddress: kotlin.String? = null,
    @JsonProperty("telephones")
    @field:Size(min = 1, max = 250)
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>? = null,
    // Age of the traveler.
    @JsonProperty("age")
    @field:Valid
    val age: java.math.BigDecimal? = null,
    // Date of birth for traveler, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("birth_date")
    val birthDate: java.time.OffsetDateTime? = null,
    // The alpha-3 ISO country code of the traveler's nationality.
    @JsonProperty("citizenship_country_code")
    @field:Pattern(regexp = "^[A-Z]{3}$")
    @field:Length(min = 3, max = 3)
    @field:Valid
    val citizenshipCountryCode: kotlin.String? = null,
    // A unique identifier for travelers in the transaction.
    @JsonProperty("traveler_id")
    @field:Length(max = 100)
    @field:Valid
    val travelerId: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var travelerName: Name? = null,
        private var primary: kotlin.Boolean? = null,
        private var emailAddress: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var age: java.math.BigDecimal? = null,
        private var birthDate: java.time.OffsetDateTime? = null,
        private var citizenshipCountryCode: kotlin.String? = null,
        private var travelerId: kotlin.String? = null
    ) {
        fun travelerName(travelerName: Name) = apply { this.travelerName = travelerName }

        fun primary(primary: kotlin.Boolean) = apply { this.primary = primary }

        fun emailAddress(emailAddress: kotlin.String?) = apply { this.emailAddress = emailAddress }

        fun telephones(telephones: kotlin.collections.List<Telephone>?) = apply { this.telephones = telephones }

        fun age(age: java.math.BigDecimal?) = apply { this.age = age }

        fun birthDate(birthDate: java.time.OffsetDateTime?) = apply { this.birthDate = birthDate }

        fun citizenshipCountryCode(citizenshipCountryCode: kotlin.String?) = apply { this.citizenshipCountryCode = citizenshipCountryCode }

        fun travelerId(travelerId: kotlin.String?) = apply { this.travelerId = travelerId }

        fun build(): Traveler {
            // Check required params
            validateNullity()
            return Traveler(
                travelerName = travelerName!!,
                primary = primary!!,
                emailAddress = emailAddress,
                telephones = telephones,
                age = age,
                birthDate = birthDate,
                citizenshipCountryCode = citizenshipCountryCode,
                travelerId = travelerId
            )
        }

        private fun validateNullity() {
            if (travelerName == null) {
                throw NullPointerException("Required parameter travelerName is missing")
            }
            if (primary == null) {
                throw NullPointerException("Required parameter primary is missing")
            }
        }
    }
}
