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
package com.expediagroup.openworld.sdk.core.model.exception.rapid

import com.expediagroup.openworld.sdk.core.model.error.rapid.RapidError
import com.expediagroup.openworld.sdk.core.model.exception.OpenWorldException
import io.ktor.http.HttpStatusCode

/**
 *  An exception that is thrown when a Rapid service error occurs.
 *
 *  @property errorCode The HTTP status code of the error.
 *  @property error The error details.
 */
class RapidServiceException(
    val errorCode: HttpStatusCode,
    val error: RapidError
) : OpenWorldException("[${errorCode.value}] $error")
