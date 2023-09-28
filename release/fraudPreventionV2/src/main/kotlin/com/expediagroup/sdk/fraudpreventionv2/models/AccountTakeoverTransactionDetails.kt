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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * The `transaction_type` field value is used as a discriminator, with the following mapping: * `LOGIN`: `LoginTransactionDetails`
 * @param type The categorized type of account event related to a user's action.
 * @param transactionDateTime The local date and time the transaction occured in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param transactionId Unique identifier to identify a transaction attempt in the Partner's system.
 * @param currentUserSession
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = ["type"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
    Type(value = LoginTransactionDetails::class, name = "LOGIN")
)
interface AccountTakeoverTransactionDetails {

    /* The categorized type of account event related to a user's action. */

    val type: AccountTakeoverTransactionDetails.Type
    /* The local date and time the transaction occured in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */

    val transactionDateTime: java.time.OffsetDateTime
    /* Unique identifier to identify a transaction attempt in the Partner's system. */

    val transactionId: kotlin.String
    val currentUserSession: CurrentUserSession?

    /**
     * The categorized type of account event related to a user's action.
     * Values: LOGIN
     */
    enum class Type(val value: kotlin.String) {
        @JsonProperty("LOGIN")
        LOGIN("LOGIN")
    }
}
