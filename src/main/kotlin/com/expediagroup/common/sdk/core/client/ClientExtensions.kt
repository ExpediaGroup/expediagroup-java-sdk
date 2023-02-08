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
package com.expediagroup.common.sdk.core.client

import com.expediagroup.common.sdk.core.constant.provider.ExceptionMessageProvider.getMissingRequiredConfigurationMessage
import com.expediagroup.common.sdk.core.model.exception.BaseException
import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.model.exception.client.OpenWorldConfigurationException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldAuthException
import com.expediagroup.rapid.sdk.core.client.RapidClient
import com.expediagroup.rapid.sdk.core.model.exception.client.RapidConfigurationException
import com.expediagroup.rapid.sdk.core.model.exception.service.RapidAuthException

/**
 *  Fire an authentication exception for the given client type.
 *
 *  @param message The error message.
 *  @param cause The cause of the error.
 */
internal inline fun <reified C : Client> C.fireAuthIssue(message: String, cause: Throwable? = null): Nothing = when (C::class) {
    OpenWorldClient::class -> throw OpenWorldAuthException(message, cause)
    RapidClient::class -> throw RapidAuthException(message, cause)
    else -> throw BaseException("Unknown client type: ${C::class}")
}

/**
 * Fire a configuration exception for the given client type.
 *
 * @param message The error message.
 * @param cause The cause of the error.
 */
internal inline fun <reified C : Client> C.fireConfigurationIssue(message: String, cause: Throwable? = null): Nothing = when (C::class) {
    OpenWorldClient::class -> throw OpenWorldConfigurationException(message, cause)
    RapidClient::class -> throw RapidConfigurationException(message, cause)
    else -> throw BaseException("Unknown client type: ${C::class}")
}

/**
 * Fire a configuration exception for the given client type.
 *
 * @param configurationKey The configuration key that is missing.
 * @param cause The cause of the error.
 */
internal inline fun <reified C : Client> C.fireMissingConfigurationIssue(configurationKey: String, cause: Throwable? = null): Nothing =
    fireConfigurationIssue(getMissingRequiredConfigurationMessage(configurationKey), cause)
