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

import com.expediagroup.openworld.sdk.rapid.models.TraderAddress

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * Information of the professional entity that sells the property inventory or related services.
 * @param contactMessage The trader contact message.
 * @param name The trader name.
 * @param address 
 * @param rightToWithdrawMessage The trader right to withdraw message.
 * @param email The trader email address.
 * @param phone The trader phone number.
 */
data class TraderDetailsInner(
    /* The trader contact message. */
@JsonProperty("contact_message")

    
    
    
    
    @field:Valid
    val contactMessage: kotlin.String,

    /* The trader name. */
@JsonProperty("name")

    
    
    
    
    @field:Valid
    val name: kotlin.String? = null,

    @JsonProperty("address")

    
    
    
    
    @field:Valid
    val address: TraderAddress? = null,

    /* The trader right to withdraw message. */
@JsonProperty("right_to_withdraw_message")

    
    
    
    
    @field:Valid
    val rightToWithdrawMessage: kotlin.String? = null,

    /* The trader email address. */
@JsonProperty("email")

    
    
    
    
    @field:Valid
    val email: kotlin.String? = null,

    /* The trader phone number. */
@JsonProperty("phone")

    
    
    
    
    @field:Valid
    val phone: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var contactMessage: kotlin.String? = null,
        private var name: kotlin.String? = null,
        private var address: TraderAddress? = null,
        private var rightToWithdrawMessage: kotlin.String? = null,
        private var email: kotlin.String? = null,
        private var phone: kotlin.String? = null
    ) {
        fun contactMessage(contactMessage: kotlin.String) = apply { this.contactMessage = contactMessage }
        fun name(name: kotlin.String) = apply { this.name = name }
        fun address(address: TraderAddress) = apply { this.address = address }
        fun rightToWithdrawMessage(rightToWithdrawMessage: kotlin.String) = apply { this.rightToWithdrawMessage = rightToWithdrawMessage }
        fun email(email: kotlin.String) = apply { this.email = email }
        fun phone(phone: kotlin.String) = apply { this.phone = phone }

        fun build(): TraderDetailsInner {
            // Check required params
            validateNullity()
            return TraderDetailsInner(
                contactMessage = contactMessage!!,
                name = name,
                address = address,
                rightToWithdrawMessage = rightToWithdrawMessage,
                email = email,
                phone = phone
            )
        }

        private fun validateNullity() {
            if (contactMessage == null) {
                throw NullPointerException("Required parameter contactMessage is missing")
            }
        }
    }
}

