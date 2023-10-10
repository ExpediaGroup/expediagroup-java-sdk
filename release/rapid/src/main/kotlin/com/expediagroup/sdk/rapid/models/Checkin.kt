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

package com.expediagroup.sdk.rapid.models

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

/**
 * The property's check-in information.
 * @param `24hour` Present if the property has 24-hour check-in.
 * @param beginTime The time at which a property begins to allow check-ins.
 * @param endTime The time at which a property stops allowing check-ins.
 * @param instructions The property's check-in policy.
 * @param specialInstructions Any special instructions for checking into this property that may be specific to this property.
 * @param minAge The minimum age for a customer to be able to check-in at a property.
 */
data class Checkin(
    // Present if the property has 24-hour check-in.
    @JsonProperty("24_hour")
    @field:Valid
    val `24hour`: kotlin.String? = null,
    // The time at which a property begins to allow check-ins.
    @JsonProperty("begin_time")
    @field:Valid
    val beginTime: kotlin.String? = null,
    // The time at which a property stops allowing check-ins.
    @JsonProperty("end_time")
    @field:Valid
    val endTime: kotlin.String? = null,
    // The property's check-in policy.
    @JsonProperty("instructions")
    @field:Valid
    val instructions: kotlin.String? = null,
    // Any special instructions for checking into this property that may be specific to this property.
    @JsonProperty("special_instructions")
    @field:Valid
    val specialInstructions: kotlin.String? = null,
    // The minimum age for a customer to be able to check-in at a property.
    @JsonProperty("min_age")
    @field:Valid
    val minAge: java.math.BigDecimal? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var `24hour`: kotlin.String? = null,
        private var beginTime: kotlin.String? = null,
        private var endTime: kotlin.String? = null,
        private var instructions: kotlin.String? = null,
        private var specialInstructions: kotlin.String? = null,
        private var minAge: java.math.BigDecimal? = null
    ) {
        fun `24hour`(`24hour`: kotlin.String) = apply { this.`24hour` = `24hour` }

        fun beginTime(beginTime: kotlin.String) = apply { this.beginTime = beginTime }

        fun endTime(endTime: kotlin.String) = apply { this.endTime = endTime }

        fun instructions(instructions: kotlin.String) = apply { this.instructions = instructions }

        fun specialInstructions(specialInstructions: kotlin.String) = apply { this.specialInstructions = specialInstructions }

        fun minAge(minAge: java.math.BigDecimal) = apply { this.minAge = minAge }

        fun build(): Checkin {
            return Checkin(
                `24hour` = `24hour`,
                beginTime = beginTime,
                endTime = endTime,
                instructions = instructions,
                specialInstructions = specialInstructions,
                minAge = minAge
            )
        }
    }
}
