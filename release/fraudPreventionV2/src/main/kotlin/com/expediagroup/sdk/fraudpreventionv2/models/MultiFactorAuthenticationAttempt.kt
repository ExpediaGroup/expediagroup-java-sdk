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
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * Information specific to the update event by a user.
 * @param deliveryMethod The delivery method of the Multi-Factor Authentication to a user.
 * @param status The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge.
 * @param referenceId The identifier related to a Multi-Factor Authentication attempt by the Partner's system to the Multi-Factor Authentication provider.
 * @param providerName The vendor providing the Multi-Factor Authentication verification.
 * @param attemptCount The number of attempts a user tried for this Multi-Factor Authentication.
 * @param updateStartDateTime The local date and time the Multi-Factor Authentication was initiated to a user from the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param updateEndDateTime The local date and time the Multi-Factor Authentication to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param telephone
 * @param emailAddress Email address used for the Multi-Factor Authentication by a user.
 */
data class MultiFactorAuthenticationAttempt(
    // The delivery method of the Multi-Factor Authentication to a user.
    @JsonProperty("delivery_method")
    val deliveryMethod: MultiFactorAuthenticationAttempt.DeliveryMethod,
    // The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge.
    @JsonProperty("status")
    val status: MultiFactorAuthenticationAttempt.Status,
    // The identifier related to a Multi-Factor Authentication attempt by the Partner's system to the Multi-Factor Authentication provider.
    @JsonProperty("reference_id")
    @field:Length(max = 200)
    @field:Valid
    val referenceId: kotlin.String,
    // The vendor providing the Multi-Factor Authentication verification.
    @JsonProperty("provider_name")
    @field:Length(max = 200)
    @field:Valid
    val providerName: kotlin.String,
    // The number of attempts a user tried for this Multi-Factor Authentication.
    @JsonProperty("attempt_count")
    @field:Valid
    val attemptCount: java.math.BigDecimal,
    // The local date and time the Multi-Factor Authentication was initiated to a user from the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("update_start_date_time")
    val updateStartDateTime: java.time.OffsetDateTime? = null,
    // The local date and time the Multi-Factor Authentication to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("update_end_date_time")
    val updateEndDateTime: java.time.OffsetDateTime? = null,
    @JsonProperty("telephone")
    @field:Valid
    val telephone: Telephone? = null,
    // Email address used for the Multi-Factor Authentication by a user.
    @JsonProperty("email_address")
    @field:Length(max = 200)
    @field:Valid
    val emailAddress: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var deliveryMethod: MultiFactorAuthenticationAttempt.DeliveryMethod? = null,
        private var status: MultiFactorAuthenticationAttempt.Status? = null,
        private var referenceId: kotlin.String? = null,
        private var providerName: kotlin.String? = null,
        private var attemptCount: java.math.BigDecimal? = null,
        private var updateStartDateTime: java.time.OffsetDateTime? = null,
        private var updateEndDateTime: java.time.OffsetDateTime? = null,
        private var telephone: Telephone? = null,
        private var emailAddress: kotlin.String? = null
    ) {
        fun deliveryMethod(deliveryMethod: MultiFactorAuthenticationAttempt.DeliveryMethod) = apply { this.deliveryMethod = deliveryMethod }

        fun status(status: MultiFactorAuthenticationAttempt.Status) = apply { this.status = status }

        fun referenceId(referenceId: kotlin.String) = apply { this.referenceId = referenceId }

        fun providerName(providerName: kotlin.String) = apply { this.providerName = providerName }

        fun attemptCount(attemptCount: java.math.BigDecimal) = apply { this.attemptCount = attemptCount }

        fun updateStartDateTime(updateStartDateTime: java.time.OffsetDateTime?) = apply { this.updateStartDateTime = updateStartDateTime }

        fun updateEndDateTime(updateEndDateTime: java.time.OffsetDateTime?) = apply { this.updateEndDateTime = updateEndDateTime }

        fun telephone(telephone: Telephone?) = apply { this.telephone = telephone }

        fun emailAddress(emailAddress: kotlin.String?) = apply { this.emailAddress = emailAddress }

        fun build(): MultiFactorAuthenticationAttempt {
            // Check required params
            validateNullity()
            return MultiFactorAuthenticationAttempt(
                deliveryMethod = deliveryMethod!!,
                status = status!!,
                referenceId = referenceId!!,
                providerName = providerName!!,
                attemptCount = attemptCount!!,
                updateStartDateTime = updateStartDateTime,
                updateEndDateTime = updateEndDateTime,
                telephone = telephone,
                emailAddress = emailAddress
            )
        }

        private fun validateNullity() {
            if (deliveryMethod == null) {
                throw NullPointerException("Required parameter deliveryMethod is missing")
            }
            if (status == null) {
                throw NullPointerException("Required parameter status is missing")
            }
            if (referenceId == null) {
                throw NullPointerException("Required parameter referenceId is missing")
            }
            if (providerName == null) {
                throw NullPointerException("Required parameter providerName is missing")
            }
            if (attemptCount == null) {
                throw NullPointerException("Required parameter attemptCount is missing")
            }
        }
    }

    /**
     * The delivery method of the Multi-Factor Authentication to a user.
     * Values: EMAIL,SMS,VOICE,PUSH
     */
    enum class DeliveryMethod(val value: kotlin.String) {
        @JsonProperty("EMAIL")
        EMAIL("EMAIL"),

        @JsonProperty("SMS")
        SMS("SMS"),

        @JsonProperty("VOICE")
        VOICE("VOICE"),

        @JsonProperty("PUSH")
        PUSH("PUSH")
    }

    /**
     * The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge.
     * Values: SUCCESS,ABANDON,FAILED
     */
    enum class Status(val value: kotlin.String) {
        @JsonProperty("SUCCESS")
        SUCCESS("SUCCESS"),

        @JsonProperty("ABANDON")
        ABANDON("ABANDON"),

        @JsonProperty("FAILED")
        FAILED("FAILED")
    }
}
