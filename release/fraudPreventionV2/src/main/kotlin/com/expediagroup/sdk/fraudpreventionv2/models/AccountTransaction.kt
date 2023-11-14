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
import javax.validation.Valid

/**
 * Information for an account transaction.
 * @param siteInfo
 * @param deviceDetails
 * @param customerAccount
 * @param transactionDetails
 */
data class AccountTransaction(
    @JsonProperty("site_info")
    @field:Valid
    val siteInfo: AccountTakeoverSiteInfo,
    @JsonProperty("device_details")
    @field:Valid
    val deviceDetails: AccountTakeoverDeviceDetails,
    @JsonProperty("customer_account")
    @field:Valid
    val customerAccount: AccountTakeoverCustomerAccount,
    @JsonProperty("transaction_details")
    @field:Valid
    val transactionDetails: AccountTakeoverTransactionDetails
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var siteInfo: AccountTakeoverSiteInfo? = null,
        private var deviceDetails: AccountTakeoverDeviceDetails? = null,
        private var customerAccount: AccountTakeoverCustomerAccount? = null,
        private var transactionDetails: AccountTakeoverTransactionDetails? = null
    ) {
        fun siteInfo(siteInfo: AccountTakeoverSiteInfo) = apply { this.siteInfo = siteInfo }

        fun deviceDetails(deviceDetails: AccountTakeoverDeviceDetails) = apply { this.deviceDetails = deviceDetails }

        fun customerAccount(customerAccount: AccountTakeoverCustomerAccount) = apply { this.customerAccount = customerAccount }

        fun transactionDetails(transactionDetails: AccountTakeoverTransactionDetails) = apply { this.transactionDetails = transactionDetails }

        fun build(): AccountTransaction {
            // Check required params
            validateNullity()
            return AccountTransaction(
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
