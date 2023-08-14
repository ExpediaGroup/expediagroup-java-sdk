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

import com.expediagroup.openworld.sdk.rapid.models.CardOption
import com.expediagroup.openworld.sdk.rapid.models.CreditCardMerchant

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
 * 
 * @param cardOptions 
 * @param merchant 
 * @param name Display name of payment option.
 */
data class CreditCard(
    @JsonProperty("card_options")

    
    
    
    
    @field:Valid
    val cardOptions: kotlin.collections.List<CardOption>? = null,

    @JsonProperty("merchant")

    
    
    
    
    @field:Valid
    val merchant: CreditCardMerchant? = null,

    /* Display name of payment option. */
@JsonProperty("name")

    
    
    
    
    @field:Valid
    val name: kotlin.String? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var cardOptions: kotlin.collections.List<CardOption>? = null,
        private var merchant: CreditCardMerchant? = null,
        private var name: kotlin.String? = null
    ) {
        fun cardOptions(cardOptions: kotlin.collections.List<CardOption>) = apply { this.cardOptions = cardOptions }
        fun merchant(merchant: CreditCardMerchant) = apply { this.merchant = merchant }
        fun name(name: kotlin.String) = apply { this.name = name }

        fun build(): CreditCard {
            return CreditCard(
                cardOptions = cardOptions,
                merchant = merchant,
                name = name
            )
        }

    }
}

