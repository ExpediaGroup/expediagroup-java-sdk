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
import org.hibernate.validator.constraints.Length

/**
 *
 * @param pickUpLocation Location where the automobile will be picked up.
 * @param dropOffLocation Location at which the automobile will be returned.
 * @param pickupTime Local date and time the automobile will be picked-up, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param returnTime Local date and time the automobile will be returned, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 */
data class CarAllOf(
    /* Location where the automobile will be picked up. */
    @JsonProperty("pick_up_location")
    @field:Length(max = 200)
    @field:Valid
    val pickUpLocation: kotlin.String,

    /* Location at which the automobile will be returned. */
    @JsonProperty("drop_off_location")
    @field:Length(max = 200)
    @field:Valid
    val dropOffLocation: kotlin.String,

    /* Local date and time the automobile will be picked-up, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("pickup_time")
    val pickupTime: java.time.OffsetDateTime,

    /* Local date and time the automobile will be returned, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
    @JsonProperty("return_time")
    val returnTime: java.time.OffsetDateTime
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var pickUpLocation: kotlin.String? = null,
        private var dropOffLocation: kotlin.String? = null,
        private var pickupTime: java.time.OffsetDateTime? = null,
        private var returnTime: java.time.OffsetDateTime? = null
    ) {
        fun pickUpLocation(pickUpLocation: kotlin.String) = apply { this.pickUpLocation = pickUpLocation }
        fun dropOffLocation(dropOffLocation: kotlin.String) = apply { this.dropOffLocation = dropOffLocation }
        fun pickupTime(pickupTime: java.time.OffsetDateTime) = apply { this.pickupTime = pickupTime }
        fun returnTime(returnTime: java.time.OffsetDateTime) = apply { this.returnTime = returnTime }

        fun build(): CarAllOf {
            // Check required params
            validateNullity()
            return CarAllOf(
                pickUpLocation = pickUpLocation!!,
                dropOffLocation = dropOffLocation!!,
                pickupTime = pickupTime!!,
                returnTime = returnTime!!
            )
        }

        private fun validateNullity() {
            if (pickUpLocation == null) {
                throw NullPointerException("Required parameter pickUpLocation is missing")
            }
            if (dropOffLocation == null) {
                throw NullPointerException("Required parameter dropOffLocation is missing")
            }
            if (pickupTime == null) {
                throw NullPointerException("Required parameter pickupTime is missing")
            }
            if (returnTime == null) {
                throw NullPointerException("Required parameter returnTime is missing")
            }
        }
    }
}
