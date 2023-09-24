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
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

/**
 * Information specific to the Partner's website through which a transaction was made.
 * @param brandName The trademark brand name that is displayed to a user on the website.
 * @param locale The locale of the website a user is accessing, which is separate from the user configured browser locale, in ISO 639-2 language code format and in ISO 3166-1 country code format.
 * @param name Name of the website from which the event is generated.
 * @param placementName The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page.
 */
data class AccountTakeoverSiteInfo(
    /* The trademark brand name that is displayed to a user on the website. */
    @JsonProperty("brand_name")
    @field:Length(max = 200)
    @field:Valid
    val brandName: kotlin.String,

    /* The locale of the website a user is accessing, which is separate from the user configured browser locale, in ISO 639-2 language code format and in ISO 3166-1 country code format. */
    @JsonProperty("locale")
    @field:Pattern(regexp = "^([a-z]{2}-[A-Z]{2})$")
    @field:Valid
    val locale: kotlin.String? = null,

    /* Name of the website from which the event is generated. */
    @JsonProperty("name")
    @field:Length(max = 200)
    @field:Valid
    val name: kotlin.String? = null,

    /* The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page.  */
    @JsonProperty("placement_name")
    val placementName: AccountTakeoverSiteInfo.PlacementName? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var brandName: kotlin.String? = null,
        private var locale: kotlin.String? = null,
        private var name: kotlin.String? = null,
        private var placementName: AccountTakeoverSiteInfo.PlacementName? = null
    ) {
        fun brandName(brandName: kotlin.String) = apply { this.brandName = brandName }
        fun locale(locale: kotlin.String) = apply { this.locale = locale }
        fun name(name: kotlin.String) = apply { this.name = name }
        fun placementName(placementName: AccountTakeoverSiteInfo.PlacementName) = apply { this.placementName = placementName }

        fun build(): AccountTakeoverSiteInfo {
            // Check required params
            validateNullity()
            return AccountTakeoverSiteInfo(
                brandName = brandName!!,
                locale = locale,
                name = name,
                placementName = placementName
            )
        }

        private fun validateNullity() {
            if (brandName == null) {
                throw NullPointerException("Required parameter brandName is missing")
            }
        }
    }

    /**
     * The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page.
     * Values: LOGIN,PASSWORD_RESET
     */
    enum class PlacementName(val value: kotlin.String) {
        @JsonProperty("LOGIN")
        LOGIN("LOGIN"),

        @JsonProperty("PASSWORD_RESET")
        PASSWORD_RESET("PASSWORD_RESET")
    }
}
