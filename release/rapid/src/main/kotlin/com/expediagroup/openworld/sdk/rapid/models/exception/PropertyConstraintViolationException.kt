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


package com.expediagroup.openworld.sdk.rapid.models.exception

import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldClientException

/**
 * An exception to be thrown when a constraint on some property has been violated.
 *
 * @property message The detail message.
 * @property constraintViolations A list of the constraint violations that occurred
 */
class PropertyConstraintViolationException(
    message: String,
    val constraintViolations: List<PropertyConstraintViolation>
) : OpenWorldClientException("$message ${constraintViolations.joinToString(separator = ",\n\t- ", prefix = "[\n\t- ", postfix = "\n]")}")
