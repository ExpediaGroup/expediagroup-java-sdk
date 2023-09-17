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
 *
 * @param ipAddress IP address of the device used for booking.
 * @param source Source of the device_box. Default value is `TrustWidget`.
 * @param deviceBox Device related information retrieved from TrustWidget.
 */
data class DeviceDetails(
    /* IP address of the device used for booking. */
    @JsonProperty("ip_address")
    @field:Pattern(regexp = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$")
    @field:Valid
    val ipAddress: kotlin.String,

    /* Source of the device_box. Default value is `TrustWidget`. */
    @JsonProperty("source")
    @field:Length(max = 50)
    @field:Valid
    val source: kotlin.String? = null,

    /* Device related information retrieved from TrustWidget. */
    @JsonProperty("device_box")
    @field:Length(max = 16000)
    @field:Valid
    val deviceBox: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var ipAddress: kotlin.String? = null,
        private var source: kotlin.String? = null,
        private var deviceBox: kotlin.String? = null
    ) {
        fun ipAddress(ipAddress: kotlin.String) = apply { this.ipAddress = ipAddress }
        fun source(source: kotlin.String) = apply { this.source = source }
        fun deviceBox(deviceBox: kotlin.String) = apply { this.deviceBox = deviceBox }

        fun build(): DeviceDetails {
            // Check required params
            validateNullity()
            return DeviceDetails(
                ipAddress = ipAddress!!,
                source = source,
                deviceBox = deviceBox
            )
        }

        private fun validateNullity() {
            if (ipAddress == null) {
                throw NullPointerException("Required parameter ipAddress is missing")
            }
        }
    }
}
