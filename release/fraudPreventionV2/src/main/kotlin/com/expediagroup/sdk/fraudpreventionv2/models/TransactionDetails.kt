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
import javax.validation.constraints.Size
import javax.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 *
 * @param orderId Unique identifier assigned to the order by the partner. `order_id` is specific to the partner namespace.
 * @param currentOrderStatus Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled.
 * @param orderType Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`.
 * @param travelProducts
 * @param travelers Individuals who are part of the travel party for the order. At minimum there must be at least `1` traveler.
 * @param payments List of the form(s) of payment being used to purchase the order.  One or more forms of payment can be used within an order. Information gathered will be specific to the form of payment.
 */
data class TransactionDetails(
    // Unique identifier assigned to the order by the partner. `order_id` is specific to the partner namespace.
    @JsonProperty("order_id")
    @field:Length(max = 50)
    @field:Valid
    val orderId: kotlin.String,
    // Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled.
    @JsonProperty("current_order_status")
    val currentOrderStatus: TransactionDetails.CurrentOrderStatus,
    // Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`.
    @JsonProperty("order_type")
    val orderType: TransactionDetails.OrderType,
    @JsonProperty("travel_products")
    @field:Size(min = 1, max = 20)
    @field:Valid
    val travelProducts: kotlin.collections.List<TravelProduct>,
    // Individuals who are part of the travel party for the order. At minimum there must be at least `1` traveler.
    @JsonProperty("travelers")
    @field:Size(min = 1, max = 30)
    @field:Valid
    val travelers: kotlin.collections.List<Traveler>,
    // List of the form(s) of payment being used to purchase the order.  One or more forms of payment can be used within an order. Information gathered will be specific to the form of payment.
    @JsonProperty("payments")
    @field:Size(min = 1, max = 30)
    @field:Valid
    val payments: kotlin.collections.List<Payment>? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var orderId: kotlin.String? = null,
        private var currentOrderStatus: TransactionDetails.CurrentOrderStatus? = null,
        private var orderType: TransactionDetails.OrderType? = null,
        private var travelProducts: kotlin.collections.List<TravelProduct>? = null,
        private var travelers: kotlin.collections.List<Traveler>? = null,
        private var payments: kotlin.collections.List<Payment>? = null
    ) {
        fun orderId(orderId: kotlin.String) = apply { this.orderId = orderId }

        fun currentOrderStatus(currentOrderStatus: TransactionDetails.CurrentOrderStatus) = apply { this.currentOrderStatus = currentOrderStatus }

        fun orderType(orderType: TransactionDetails.OrderType) = apply { this.orderType = orderType }

        fun travelProducts(travelProducts: kotlin.collections.List<TravelProduct>) = apply { this.travelProducts = travelProducts }

        fun travelers(travelers: kotlin.collections.List<Traveler>) = apply { this.travelers = travelers }

        fun payments(payments: kotlin.collections.List<Payment>) = apply { this.payments = payments }

        fun build(): TransactionDetails {
            // Check required params
            validateNullity()
            return TransactionDetails(
                orderId = orderId!!,
                currentOrderStatus = currentOrderStatus!!,
                orderType = orderType!!,
                travelProducts = travelProducts!!,
                travelers = travelers!!,
                payments = payments
            )
        }

        private fun validateNullity() {
            if (orderId == null) {
                throw NullPointerException("Required parameter orderId is missing")
            }
            if (currentOrderStatus == null) {
                throw NullPointerException("Required parameter currentOrderStatus is missing")
            }
            if (orderType == null) {
                throw NullPointerException("Required parameter orderType is missing")
            }
            if (travelProducts == null) {
                throw NullPointerException("Required parameter travelProducts is missing")
            }
            if (travelers == null) {
                throw NullPointerException("Required parameter travelers is missing")
            }
        }
    }

    /**
     * Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled.
     * Values: IN_PROGRESS,COMPLETED
     */
    enum class CurrentOrderStatus(val value: kotlin.String) {
        @JsonProperty("IN_PROGRESS")
        IN_PROGRESS("IN_PROGRESS"),

        @JsonProperty("COMPLETED")
        COMPLETED("COMPLETED")
    }

    /**
     * Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`.
     * Values: CREATE,CHANGE
     */
    enum class OrderType(val value: kotlin.String) {
        @JsonProperty("CREATE")
        CREATE("CREATE"),

        @JsonProperty("CHANGE")
        CHANGE("CHANGE")
    }
}
