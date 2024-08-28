///*
// * Copyright (C) 2022 Expedia, Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.expediagroup.sdk.core.poc.model
//
//import com.expediagroup.sdk.core.poc.client.ExpediaGroupServiceClient
//import com.expediagroup.sdk.core.poc.http.ExpediaGroupJsonRequest
//import com.expediagroup.sdk.core.poc.extension.baseOn
//import com.expediagroup.sdk.rapid.operations.GetAvailabilityOperationParams
//import com.google.api.client.http.HttpRequest
//import com.google.api.client.http.HttpRequestInitializer
//
//abstract class Operation<T>(
//    val url: String,
//    val method: String,
//    val operationId: String,
//    val requestBody: T?,
//    val params: GetAvailabilityOperationParams
//): HttpRequestInitializer {
//    override fun initialize(request: HttpRequest?) {
//        request?.baseOn(this)
//    }
//
//    var transactionId: TransactionId = TransactionId()
//        private set
//
//    fun toExpediaGroupJsonRequest(client: ExpediaGroupServiceClient): ExpediaGroupJsonRequest<T> =
//        ExpediaGroupJsonRequest(
//            uriTemplate = url,
//            method = method,
//            serviceClient = client
//        )
//}
