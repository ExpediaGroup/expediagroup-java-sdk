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
import org.hibernate.validator.constraints.Length
import javax.validation.Valid

/**
 * This field holds details about activity's capabilities and execution details related to inventory hold functionality.
 * @param isAvailable This field indicates if the fulfillment of an activity is possible or not.
 * @param holdDurationValue This field indicates the duration of the hold on an activity.
 * @param holdDurationUnitOfMeasure This field indicates the unit of duration of the hold on an activity.
 * @param isDelayedCustomerConfirmation This field indicates whether customer order confirmation can be delayed. Customer will receive ticket number, voucher ID or any other type of confirmation until transaction is successfully completed or approved by an analyst during the review process.
 */
data class DelayedFulfillment(
    // This field indicates if the fulfillment of an activity is possible or not.
    @JsonProperty("is_available")
    @field:Valid
    val isAvailable: kotlin.Boolean? = null,
    // This field indicates the duration of the hold on an activity.
    @JsonProperty("hold_duration_value")
    val holdDurationValue: java.math.BigDecimal? = null,
    // This field indicates the unit of duration of the hold on an activity.
    @JsonProperty("hold_duration_unit_of_measure")
    @field:Length(max = 100)
    @field:Valid
    val holdDurationUnitOfMeasure: kotlin.String? = null,
    // This field indicates whether customer order confirmation can be delayed. Customer will receive ticket number, voucher ID or any other type of confirmation until transaction is successfully completed or approved by an analyst during the review process.
    @JsonProperty("is_delayed_customer_confirmation")
    @field:Valid
    val isDelayedCustomerConfirmation: kotlin.Boolean? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var isAvailable: kotlin.Boolean? = null,
        private var holdDurationValue: java.math.BigDecimal? = null,
        private var holdDurationUnitOfMeasure: kotlin.String? = null,
        private var isDelayedCustomerConfirmation: kotlin.Boolean? = null
    ) {
        fun isAvailable(isAvailable: kotlin.Boolean?) = apply { this.isAvailable = isAvailable }

        fun holdDurationValue(holdDurationValue: java.math.BigDecimal?) = apply { this.holdDurationValue = holdDurationValue }

        fun holdDurationUnitOfMeasure(holdDurationUnitOfMeasure: kotlin.String?) = apply { this.holdDurationUnitOfMeasure = holdDurationUnitOfMeasure }

        fun isDelayedCustomerConfirmation(isDelayedCustomerConfirmation: kotlin.Boolean?) = apply { this.isDelayedCustomerConfirmation = isDelayedCustomerConfirmation }

        fun build(): DelayedFulfillment {
            return DelayedFulfillment(
                isAvailable = isAvailable,
                holdDurationValue = holdDurationValue,
                holdDurationUnitOfMeasure = holdDurationUnitOfMeasure,
                isDelayedCustomerConfirmation = isDelayedCustomerConfirmation
            )
        }
    }
}
