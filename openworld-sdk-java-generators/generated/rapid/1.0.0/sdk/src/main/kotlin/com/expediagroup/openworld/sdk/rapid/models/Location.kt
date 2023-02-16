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

 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.expediagroup.openworld.sdk.rapid.models

import com.expediagroup.openworld.sdk.rapid.models.Coordinates

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * The property's location information.
 * @param coordinates 
 */
data class Location(
    @JsonProperty("coordinates")

    
    
    
    
    @field:Valid
    val coordinates: Coordinates? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var coordinates: Coordinates? = null
    ) {
        fun coordinates(coordinates: Coordinates) = apply { this.coordinates = coordinates }

        fun build(): Location {
            return Location(
                coordinates = coordinates
            )
        }

    }
}

