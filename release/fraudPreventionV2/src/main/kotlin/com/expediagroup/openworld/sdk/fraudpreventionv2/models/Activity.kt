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
 * Provides essential details about a specific activity.
 * @param type This field provides a categorization of the different types of activities available within the activity product. It is designed to accommodate the preferences of the API consumer, allowing them to assign a descriptive label or keyword that accurately represents the nature of each activity. Here are some suggested values for this field: | Adventures: This category includes activities such as hiking, zip-lining, rock climbing, bungee jumping, and other adventurous pursuits. | Air, Balloon & Helicopter Tours: This category offers activities like hot air balloon rides, helicopter tours, and aerial sightseeing experiences. | Cruises & Water Tours: This includes options such as boat cruises, yacht tours, river rafting, snorkeling, and diving expeditions. | Nightlife: This category encompasses activities like clubbing, pub crawls, live music events, and cultural performances. These activities predominantly occur during the evening or nighttime.
 * @param description This field within the trip information provides additional details or a brief explanation about the specific trip or activity being described
 */
data class Activity(
    /* This field provides a categorization of the different types of activities available within the activity product. It is designed to accommodate the preferences of the API consumer, allowing them to assign a descriptive label or keyword that accurately represents the nature of each activity. Here are some suggested values for this field: | Adventures: This category includes activities such as hiking, zip-lining, rock climbing, bungee jumping, and other adventurous pursuits. | Air, Balloon & Helicopter Tours: This category offers activities like hot air balloon rides, helicopter tours, and aerial sightseeing experiences. | Cruises & Water Tours: This includes options such as boat cruises, yacht tours, river rafting, snorkeling, and diving expeditions. | Nightlife: This category encompasses activities like clubbing, pub crawls, live music events, and cultural performances. These activities predominantly occur during the evening or nighttime. */
@JsonProperty("type")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val type: kotlin.String,

    /* This field within the trip information provides additional details or a brief explanation about the specific trip or activity being described */
@JsonProperty("description")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val description: kotlin.String
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var type: kotlin.String? = null,
        private var description: kotlin.String? = null
    ) {
        fun type(type: kotlin.String) = apply { this.type = type }
        fun description(description: kotlin.String) = apply { this.description = description }

        fun build(): Activity {
            // Check required params
            validateNullity()
            return Activity(
                type = type!!,
                description = description!!
            )
        }

        private fun validateNullity() {
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
            if (description == null) {
                throw NullPointerException("Required parameter description is missing")
            }
        }
    }
}

