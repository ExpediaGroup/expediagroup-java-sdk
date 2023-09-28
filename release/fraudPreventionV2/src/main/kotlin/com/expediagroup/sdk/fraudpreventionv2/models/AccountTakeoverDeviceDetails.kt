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
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

/**
 * Information specific to the Partner's device through which a transaction was made.
 * @param deviceBox Device related information retrieved from TrustWidget.
 * @param ipAddress IP address of the device used for this event.
 * @param userAgent The application type, operating system, software vendor, or software version of the originating request.
 * @param source Source of the device_box. Default value is `TrustWidget`.
 * @param type The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet.
 */
data class AccountTakeoverDeviceDetails(
    /* Device related information retrieved from TrustWidget. */
    @JsonProperty("device_box")
    @field:Length(max = 16000)
    @field:Valid
    val deviceBox: kotlin.String,

    /* IP address of the device used for this event. */
    @JsonProperty("ip_address")
    @field:Pattern(regexp = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$")
    @field:Valid
    val ipAddress: kotlin.String,

    /* The application type, operating system, software vendor, or software version of the originating request. */
    @JsonProperty("user_agent")
    @field:Length(max = 200)
    @field:Valid
    val userAgent: kotlin.String,

    /* Source of the device_box. Default value is `TrustWidget`. */
    @JsonProperty("source")
    @field:Length(max = 50)
    @field:Valid
    val source: kotlin.String? = null,

    /* The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet.  */
    @JsonProperty("type")
    val type: AccountTakeoverDeviceDetails.Type? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var deviceBox: kotlin.String? = null,
        private var ipAddress: kotlin.String? = null,
        private var userAgent: kotlin.String? = null,
        private var source: kotlin.String? = null,
        private var type: AccountTakeoverDeviceDetails.Type? = null
    ) {
        fun deviceBox(deviceBox: kotlin.String) = apply { this.deviceBox = deviceBox }
        fun ipAddress(ipAddress: kotlin.String) = apply { this.ipAddress = ipAddress }
        fun userAgent(userAgent: kotlin.String) = apply { this.userAgent = userAgent }
        fun source(source: kotlin.String) = apply { this.source = source }
        fun type(type: AccountTakeoverDeviceDetails.Type) = apply { this.type = type }

        fun build(): AccountTakeoverDeviceDetails {
            // Check required params
            validateNullity()
            return AccountTakeoverDeviceDetails(
                deviceBox = deviceBox!!,
                ipAddress = ipAddress!!,
                userAgent = userAgent!!,
                source = source,
                type = type
            )
        }

        private fun validateNullity() {
            if (deviceBox == null) {
                throw NullPointerException("Required parameter deviceBox is missing")
            }
            if (ipAddress == null) {
                throw NullPointerException("Required parameter ipAddress is missing")
            }
            if (userAgent == null) {
                throw NullPointerException("Required parameter userAgent is missing")
            }
        }
    }

    /**
     * The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet.
     * Values: WEBSITE,PHONE_WEB,TABLET_WEB,PHONE_APP,TABLET_APP
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("WEBSITE")
        WEBSITE("WEBSITE"),

        @JsonProperty("PHONE_WEB")
        PHONE_WEB("PHONE_WEB"),

        @JsonProperty("TABLET_WEB")
        TABLET_WEB("TABLET_WEB"),

        @JsonProperty("PHONE_APP")
        PHONE_APP("PHONE_APP"),

        @JsonProperty("TABLET_APP")
        TABLET_APP("TABLET_APP")
    }
}
