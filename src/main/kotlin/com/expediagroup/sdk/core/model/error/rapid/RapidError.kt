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
package com.expediagroup.sdk.core.model.error.rapid

/**
 * The object used to describe an error, containing both human-readable and in machine-readable information.
 *
 * @property type The type of error.
 * @property message A human-readable message giving details about this error.
 * @property fields Details about the specific fields that had an error.
 * @property errors Details about the specific errors.
 */
data class RapidError(
    val type: String? = null,
    val message: String? = null,
    val fields: List<Field>? = null,
    val errors: List<ErrorIndividual>? = null
)
