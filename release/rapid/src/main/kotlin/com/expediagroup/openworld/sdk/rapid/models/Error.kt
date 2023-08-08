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

import com.expediagroup.openworld.sdk.rapid.models.ErrorIndividual
import com.expediagroup.openworld.sdk.rapid.models.Field

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
 * The overall class of error that occured.
 * @param type The error type.
 * @param message A human readable message giving details about this error.
 * @param fields Details about the specific fields that had an error.
 * @param errors An array of all the actual errors that occured.
 */
data class Error(
    /* The error type. */
@JsonProperty("type")

    
    
    
    
    @field:Valid
    val type: kotlin.String? = null,

    /* A human readable message giving details about this error. */
@JsonProperty("message")

    
    
    
    
    @field:Valid
    val message: kotlin.String? = null,

    /* Details about the specific fields that had an error. */
@JsonProperty("fields")

    
    
    
    
    @field:Valid
    val fields: kotlin.collections.List<Field>? = null,

    /* An array of all the actual errors that occured. */
@JsonProperty("errors")

    
    
    
    
    @field:Valid
    val errors: kotlin.collections.List<ErrorIndividual>? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var type: kotlin.String? = null,
        private var message: kotlin.String? = null,
        private var fields: kotlin.collections.List<Field>? = null,
        private var errors: kotlin.collections.List<ErrorIndividual>? = null
    ) {
        fun type(type: kotlin.String) = apply { this.type = type }
        fun message(message: kotlin.String) = apply { this.message = message }
        fun fields(fields: kotlin.collections.List<Field>) = apply { this.fields = fields }
        fun errors(errors: kotlin.collections.List<ErrorIndividual>) = apply { this.errors = errors }

        fun build(): Error {
            return Error(
                type = type,
                message = message,
                fields = fields,
                errors = errors
            )
        }

    }
}

