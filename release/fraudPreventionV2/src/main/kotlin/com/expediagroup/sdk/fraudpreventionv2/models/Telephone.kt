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
import jakarta.validation.constraints.Pattern
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Group of attributes intended to hold information about phone number associated with the transaction.  A user can have one to many phone numbers (home, work, mobile, etc.).
 * @param countryAccessCode Numeric digit between 1 to 3 characters used to represent the country code for international dialing.  Does not include symbols, spaces, or leading zeros.
 * @param areaCode A number prefixed to an individual telephone number: used in making long-distance calls.  Does not include symbols, spaces, or leading zeros.
 * @param phoneNumber A number that is dialed on a telephone, without the country or area codes, to reach a particular person, business, etc.  Does not include symbols, spaces, or leading zeros.
 * @param type
 * @param platformType
 * @param extensionNumber The number used to reach an individual once a phone connection is established.  Does not include symbols, spaces, or leading zeros.
 * @param preferenceRank Ranking of order of user preference for contact via text (if type is Mobile) or voice.  `0` means no preference.  `1` is the primary phone, `2` is the secondary phone, etc.
 * @param lastVerifiedDateTime Local date and time user validated possession of their phone number via a text or voice multi factor authentication challenge, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param verifiedFlag Flag indicating whether user passed validation of possession of their phone number via a text or voice multi factor authentication challenge.
 */
data class Telephone(
    // Numeric digit between 1 to 3 characters used to represent the country code for international dialing.  Does not include symbols, spaces, or leading zeros.
    @JsonProperty("country_access_code")
    @field:Pattern(regexp = "^[0-9]{1,3}$")
    @field:Length(max = 3)
    @field:Valid
    val countryAccessCode: kotlin.String,
    // A number prefixed to an individual telephone number: used in making long-distance calls.  Does not include symbols, spaces, or leading zeros.
    @JsonProperty("area_code")
    @field:Pattern(regexp = "^[0-9]{1,20}$")
    @field:Length(max = 20)
    @field:Valid
    val areaCode: kotlin.String,
    // A number that is dialed on a telephone, without the country or area codes, to reach a particular person, business, etc.  Does not include symbols, spaces, or leading zeros.
    @JsonProperty("phone_number")
    @field:Pattern(regexp = "^[0-9]{1,50}$")
    @field:Length(max = 50)
    @field:Valid
    val phoneNumber: kotlin.String,
    @JsonProperty("type")
    @field:Valid
    val type: TelephoneType? = null,
    @JsonProperty("platform_type")
    @field:Valid
    val platformType: TelephonePlatformType? = null,
    // The number used to reach an individual once a phone connection is established.  Does not include symbols, spaces, or leading zeros.
    @JsonProperty("extension_number")
    @field:Pattern(regexp = "^[0-9]{1,20}$")
    @field:Length(max = 20)
    @field:Valid
    val extensionNumber: kotlin.String? = null,
    // Ranking of order of user preference for contact via text (if type is Mobile) or voice.  `0` means no preference.  `1` is the primary phone, `2` is the secondary phone, etc.
    @JsonProperty("preference_rank")
    @field:Valid
    val preferenceRank: java.math.BigDecimal? = null,
    // Local date and time user validated possession of their phone number via a text or voice multi factor authentication challenge, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("last_verified_date_time")
    val lastVerifiedDateTime: java.time.OffsetDateTime? = null,
    // Flag indicating whether user passed validation of possession of their phone number via a text or voice multi factor authentication challenge.
    @JsonProperty("verified_flag")
    @field:Valid
    val verifiedFlag: kotlin.Boolean? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var countryAccessCode: kotlin.String? = null,
        private var areaCode: kotlin.String? = null,
        private var phoneNumber: kotlin.String? = null,
        private var type: TelephoneType? = null,
        private var platformType: TelephonePlatformType? = null,
        private var extensionNumber: kotlin.String? = null,
        private var preferenceRank: java.math.BigDecimal? = null,
        private var lastVerifiedDateTime: java.time.OffsetDateTime? = null,
        private var verifiedFlag: kotlin.Boolean? = null
    ) {
        fun countryAccessCode(countryAccessCode: kotlin.String) = apply { this.countryAccessCode = countryAccessCode }

        fun areaCode(areaCode: kotlin.String) = apply { this.areaCode = areaCode }

        fun phoneNumber(phoneNumber: kotlin.String) = apply { this.phoneNumber = phoneNumber }

        fun type(type: TelephoneType) = apply { this.type = type }

        fun platformType(platformType: TelephonePlatformType) = apply { this.platformType = platformType }

        fun extensionNumber(extensionNumber: kotlin.String) = apply { this.extensionNumber = extensionNumber }

        fun preferenceRank(preferenceRank: java.math.BigDecimal) = apply { this.preferenceRank = preferenceRank }

        fun lastVerifiedDateTime(lastVerifiedDateTime: java.time.OffsetDateTime) = apply { this.lastVerifiedDateTime = lastVerifiedDateTime }

        fun verifiedFlag(verifiedFlag: kotlin.Boolean) = apply { this.verifiedFlag = verifiedFlag }

        fun build(): Telephone {
            // Check required params
            validateNullity()
            return Telephone(
                countryAccessCode = countryAccessCode!!,
                areaCode = areaCode!!,
                phoneNumber = phoneNumber!!,
                type = type,
                platformType = platformType,
                extensionNumber = extensionNumber,
                preferenceRank = preferenceRank,
                lastVerifiedDateTime = lastVerifiedDateTime,
                verifiedFlag = verifiedFlag
            )
        }

        private fun validateNullity() {
            if (countryAccessCode == null) {
                throw NullPointerException("Required parameter countryAccessCode is missing")
            }
            if (areaCode == null) {
                throw NullPointerException("Required parameter areaCode is missing")
            }
            if (phoneNumber == null) {
                throw NullPointerException("Required parameter phoneNumber is missing")
            }
        }
    }
}
