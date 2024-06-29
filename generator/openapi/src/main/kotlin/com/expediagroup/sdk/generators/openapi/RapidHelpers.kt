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
package com.expediagroup.sdk.generators.openapi

import com.samskivert.mustache.Mustache
import org.openapitools.codegen.CodegenOperation

val linkableOperations =
    setOf(
        "getReservation",
        "getReservationByItineraryId",
        "putCompletePaymentSession",
        "changeRoomDetails",
        "commitChange",
        "getAdditionalAvailability",
        "getPaymentOptions",
        "priceCheck",
        "getPropertyContent"
    )

val rapidHelpers = mapOf(
    "isLinkable" to {
        Mustache.Lambda { fragment, writer ->
            val operation = fragment.context() as CodegenOperation
            if (linkableOperations.contains(operation.operationId)) {
                fragment.execute(writer)
            }
        }
    },
    "fromLink" to {
        Mustache.Lambda { fragment, writer ->
            val operation = fragment.context() as CodegenOperation
            if (!linkableOperations.contains(operation.operationId)) return@Lambda
            val pathComponents = operation.path.split("/").filter { it.isNotBlank() }
            val pathParamsWithIndex = operation.pathParams.map { it to pathComponents.indexOf("{${it.baseName}}") }

            // val context = operation.pathParams.associate { "${it.paramName}Index" to pathComponents.indexOf(it.paramName) }
            val context = mapOf("pathParamsWithIndex" to pathParamsWithIndex)
            fragment.execute(context, writer)
        }
    }
)
