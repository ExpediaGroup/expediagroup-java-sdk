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

/**
 *
 * @param siteInfo
 * @param deviceDetails
 * @param customerAccount
 * @param transactionDetails
 */
data class OrderPurchaseTransaction(
    @JsonProperty("site_info")
    @field:Valid
    val siteInfo: SiteInfo,
    @JsonProperty("device_details")
    @field:Valid
    val deviceDetails: DeviceDetails,
    @JsonProperty("customer_account")
    @field:Valid
    val customerAccount: CustomerAccount,
    @JsonProperty("transaction_details")
    @field:Valid
    val transactionDetails: TransactionDetails
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var siteInfo: SiteInfo? = null,
        private var deviceDetails: DeviceDetails? = null,
        private var customerAccount: CustomerAccount? = null,
        private var transactionDetails: TransactionDetails? = null
    ) {
        fun siteInfo(siteInfo: SiteInfo) = apply { this.siteInfo = siteInfo }

        fun deviceDetails(deviceDetails: DeviceDetails) = apply { this.deviceDetails = deviceDetails }

        fun customerAccount(customerAccount: CustomerAccount) = apply { this.customerAccount = customerAccount }

        fun transactionDetails(transactionDetails: TransactionDetails) = apply { this.transactionDetails = transactionDetails }

        fun build(): OrderPurchaseTransaction {
            // Check required params
            validateNullity()
            return OrderPurchaseTransaction(
                siteInfo = siteInfo!!,
                deviceDetails = deviceDetails!!,
                customerAccount = customerAccount!!,
                transactionDetails = transactionDetails!!
            )
        }

        private fun validateNullity() {
            if (siteInfo == null) {
                throw NullPointerException("Required parameter siteInfo is missing")
            }
            if (deviceDetails == null) {
                throw NullPointerException("Required parameter deviceDetails is missing")
            }
            if (customerAccount == null) {
                throw NullPointerException("Required parameter customerAccount is missing")
            }
            if (transactionDetails == null) {
                throw NullPointerException("Required parameter transactionDetails is missing")
            }
        }
    }
}
