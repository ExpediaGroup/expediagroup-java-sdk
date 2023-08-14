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

package com.expediagroup.openworld.sdk.rapid.models


import com.fasterxml.jackson.annotation.JsonProperty

/**
* The price breakout type.
* Values: BASE_RATE,TAX_AND_SERVICE_FEE,EXTRA_PERSON_FEE,PROPERTY_FEE,SALES_TAX,ADJUSTMENT,RECOVERY_CHARGES_AND_FEES,TRAVELER_SERVICE_FEE
*/
enum class StayType(val value: kotlin.String) {
    @JsonProperty("base_rate")
    BASE_RATE("base_rate"),
    @JsonProperty("tax_and_service_fee")
    TAX_AND_SERVICE_FEE("tax_and_service_fee"),
    @JsonProperty("extra_person_fee")
    EXTRA_PERSON_FEE("extra_person_fee"),
    @JsonProperty("property_fee")
    PROPERTY_FEE("property_fee"),
    @JsonProperty("sales_tax")
    SALES_TAX("sales_tax"),
    @JsonProperty("adjustment")
    ADJUSTMENT("adjustment"),
    @JsonProperty("recovery_charges_and_fees")
    RECOVERY_CHARGES_AND_FEES("recovery_charges_and_fees"),
    @JsonProperty("traveler_service_fee")
    TRAVELER_SERVICE_FEE("traveler_service_fee")
}
