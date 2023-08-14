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
* Classification of the phone (e.g. `Home`, `Mobile`). 
* Values: HOME,MOBILE,BUSINESS,FAX,OTHER
*/
enum class TelephoneType(val value: kotlin.String) {
    @JsonProperty("HOME")
    HOME("HOME"),
    @JsonProperty("MOBILE")
    MOBILE("MOBILE"),
    @JsonProperty("BUSINESS")
    BUSINESS("BUSINESS"),
    @JsonProperty("FAX")
    FAX("FAX"),
    @JsonProperty("OTHER")
    OTHER("OTHER")
}
