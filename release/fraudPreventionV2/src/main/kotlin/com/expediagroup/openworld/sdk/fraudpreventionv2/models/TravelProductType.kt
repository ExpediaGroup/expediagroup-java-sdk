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


import com.fasterxml.jackson.annotation.JsonProperty

/**
* Type of product.
* Values: CRUISE,AIR,CAR,INSURANCE,HOTEL,RAIL,ACTIVITIES
*/
enum class TravelProductType(val value: kotlin.String) {
    @JsonProperty("CRUISE")
    CRUISE("CRUISE"),
    @JsonProperty("AIR")
    AIR("AIR"),
    @JsonProperty("CAR")
    CAR("CAR"),
    @JsonProperty("INSURANCE")
    INSURANCE("INSURANCE"),
    @JsonProperty("HOTEL")
    HOTEL("HOTEL"),
    @JsonProperty("RAIL")
    RAIL("RAIL"),
    @JsonProperty("ACTIVITIES")
    ACTIVITIES("ACTIVITIES")
}
