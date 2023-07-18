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
* Transaction type associated with the update event.
* Values: ORDER_UPDATE,CHARGEBACK_FEEDBACK,INSULT_FEEDBACK,REFUND_UPDATE,PAYMENT_UPDATE
*/
enum class UpdateType(val value: kotlin.String) {
    @JsonProperty("ORDER_UPDATE")
    ORDER_UPDATE("ORDER_UPDATE"),
    @JsonProperty("CHARGEBACK_FEEDBACK")
    CHARGEBACK_FEEDBACK("CHARGEBACK_FEEDBACK"),
    @JsonProperty("INSULT_FEEDBACK")
    INSULT_FEEDBACK("INSULT_FEEDBACK"),
    @JsonProperty("REFUND_UPDATE")
    REFUND_UPDATE("REFUND_UPDATE"),
    @JsonProperty("PAYMENT_UPDATE")
    PAYMENT_UPDATE("PAYMENT_UPDATE")
}
