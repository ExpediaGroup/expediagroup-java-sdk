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
* * `expedia` - Payment is taken by Expedia. * `property` - Payment is taken by the property. 
* Values: EXPEDIA,PROPERTY
*/
enum class MerchantOfRecord(val value: kotlin.String) {
    @JsonProperty("expedia")
    EXPEDIA("expedia"),
    @JsonProperty("property")
    PROPERTY("property")
}
