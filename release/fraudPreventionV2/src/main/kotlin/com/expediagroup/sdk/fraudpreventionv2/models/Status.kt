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
* Defines the current state of the Order. Generally, OrderPurchaseScreenRequest is followed by an OrderUpdate reflecting the change in current order status. From `IN_PROGRESS` to any of below possible values: * `COMPLETED` is used when the order has been processed fully. For example, inventory has been reserved, and the payment has been settled. * `CHANGE_COMPLETED` is like `COMPLETED` but on a changed order. * `CANCELLED` is used when the order is cancelled. This could be acustomer initiated cancel or based on Fraud recommendation. * `FAILED` is used when order failed due to any errors on Partner system. This could be followed by another OrderUpdate call with any `order_status` once the order is recovered, abandoned, or cancelled. * `CHANGE_FAILED` is like `FAILED` but on a changed order. * * `CHANGE_COMPLETED` or `CHANGE_FAILED` are applicable if OrderPurchaseScreen Fraud API was called via a change in order which is through `transaction.transaction_details.order_type` = `CHANGE` * `COMPLETED` or `CANCELLED` order status indicates the completion of lifecycle on an order.
* Values: COMPLETED,CHANGE_COMPLETED,CANCELLED,FAILED,CHANGE_FAILED
*/
enum class Status(val value: kotlin.String) {
    @JsonProperty("COMPLETED")
    COMPLETED("COMPLETED"),

    @JsonProperty("CHANGE_COMPLETED")
    CHANGE_COMPLETED("CHANGE_COMPLETED"),

    @JsonProperty("CANCELLED")
    CANCELLED("CANCELLED"),

    @JsonProperty("FAILED")
    FAILED("FAILED"),

    @JsonProperty("CHANGE_FAILED")
    CHANGE_FAILED("CHANGE_FAILED")
}
