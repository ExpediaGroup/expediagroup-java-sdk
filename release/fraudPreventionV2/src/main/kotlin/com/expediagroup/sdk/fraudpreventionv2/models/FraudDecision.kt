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

import com.fasterxml.jackson.annotation.JsonProperty

/**
*
* Values: ACCEPT,REVIEW,REJECT
*/
enum class FraudDecision(val value: kotlin.String) {
    @JsonProperty("ACCEPT")
    ACCEPT("ACCEPT"),

    @JsonProperty("REVIEW")
    REVIEW("REVIEW"),

    @JsonProperty("REJECT")
    REJECT("REJECT")
}