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

 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.expediagroup.openworld.sdk.fraudprevention.models


import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param deviceBox Device related information retrieved from TrustWidget.
 * @param source Source of the device_box. Default value is `TrustWidget`.
 */
data class DeviceDetails(
    /* Device related information retrieved from TrustWidget. */
@JsonProperty("device_box")

    @field:Length(max = 16000)
    
    
    
    @field:Valid
    val deviceBox: kotlin.String,

    /* Source of the device_box. Default value is `TrustWidget`. */
@JsonProperty("source")

    @field:Length(max = 50)
    
    
    
    @field:Valid
    val source: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var deviceBox: kotlin.String? = null,
        private var source: kotlin.String? = null
    ) {
        fun deviceBox(deviceBox: kotlin.String) = apply { this.deviceBox = deviceBox }
        fun source(source: kotlin.String) = apply { this.source = source }

        fun build(): DeviceDetails {
            // Check required params
            validateNullity()
            return DeviceDetails(
                deviceBox = deviceBox!!,
                source = source
            )
        }

        private fun validateNullity() {
            if (deviceBox == null) {
                throw NullPointerException("Required parameter deviceBox is missing")
            }
        }
    }
}

