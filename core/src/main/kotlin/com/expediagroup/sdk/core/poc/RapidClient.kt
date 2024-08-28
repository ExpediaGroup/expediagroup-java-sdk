package com.expediagroup.sdk.core.poc

import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.core.poc.client.ExpediaGroupServiceClient
import com.expediagroup.sdk.core.poc.client.JsonClientBuilder
import com.expediagroup.sdk.core.poc.constant.HTTP_TRANSPORT
import com.expediagroup.sdk.core.poc.constant.JSON_FACTORY
import com.expediagroup.sdk.core.poc.datastore.ConfigurationsStore
import com.expediagroup.sdk.core.poc.http.ExpediaGroupJsonRequest
import com.expediagroup.sdk.core.poc.http.ExpediaGroupRequestInitializer
import com.expediagroup.sdk.core.poc.model.Configuration
import com.expediagroup.sdk.rapid.models.Property
import com.expediagroup.sdk.rapid.operations.GetAvailabilityOperation
import com.expediagroup.sdk.rapid.operations.GetAvailabilityOperationParams
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.UriTemplate
import com.google.api.client.http.json.JsonHttpContent
import java.math.BigDecimal
import java.time.LocalDate
import java.util.concurrent.CompletableFuture
import kotlin.time.measureTime

class RapidClient(
    id: String? = null,
    configuration: Configuration? = null,
    initializer: ExpediaGroupRequestInitializer,
    httpTransport: HttpTransport = HTTP_TRANSPORT,
) {
    private val client: ExpediaGroupServiceClient
    private val serviceClientId: String

    fun expediaGroupServiceClient(): ExpediaGroupServiceClient {
        return client
    }

    init {
        serviceClientId = if (id.isNullOrBlank()) {
            configuration!!.serviceClientId
        } else {
            id
        }
        configuration?.withServiceClientId(serviceClientId)?.publish()

        client = ExpediaGroupServiceClient(
            builder = ConfigurationsStore.INSTANCE.load(serviceClientId).let { config: Configuration ->
                return@let JsonClientBuilder(
                    appName = this.javaClass.simpleName,
                    configuration = config,
                    serviceClientId = serviceClientId,
                    initializer = initializer,
                    transport = httpTransport,
                )
            },
            serviceClientId = serviceClientId
        ).also { it.publish() }
    }

    fun execute(operation: Operation<*>): List<Property> {
        val responseTypeReference = jacksonTypeRef<List<Property>>()

        return ExpediaGroupJsonRequest.fromOperation<List<Property>>(
            operation = operation,
            responseTypeReference = responseTypeReference,
            client = this
        ).execute()
    }

    class Builder private constructor() {
        private var serviceClientId: String? = null
        private var configuration: Configuration? = null
        private var initializer: ExpediaGroupRequestInitializer = ExpediaGroupRequestInitializer(mutableListOf())
        private var httpTransport: HttpTransport? = HTTP_TRANSPORT

        companion object {
            fun newBuilder(): Builder {
                return Builder()
            }
        }

        fun addInitializer(initializer: HttpRequestInitializer): Builder {
            this.initializer = this.initializer.withInitializer(initializer)
            return this
        }

        fun setServiceClientId(serviceClientId: String): Builder {
            if (serviceClientId.isBlank()) {
                throw IllegalArgumentException("Service client ID cannot be blank")
            }

            this.serviceClientId = serviceClientId
            return this
        }

        fun setConfiguration(configuration: Configuration): Builder {
            this.configuration = configuration
            return this
        }


        fun setHttpTransport(httpTransport: HttpTransport): Builder {
            this.httpTransport = httpTransport
            return this
        }

        fun build(): RapidClient {
            return RapidClient(
                id = this.serviceClientId,
                configuration = this.configuration,
                initializer = this.initializer,
                httpTransport = this.httpTransport!!
            )
        }
    }
}

fun main() {
    var params = GetAvailabilityOperationParams.builder()
        .customerIp("0.0.0.0")
        .checkin(LocalDate.now().plusDays(14).toString())
        .checkout(LocalDate.now().plusDays(15).toString())
        .currency("USD")
        .countryCode("US")
        .language("en-US")
        .occupancy(mutableListOf("2"))
        .propertyId(mutableListOf("11775754"))
        .salesChannel("website")
        .salesEnvironment("hotel_only")
        .ratePlanCount(BigDecimal.ONE)
        .build()

    var operation = GetAvailabilityOperation(params)

    val client = RapidClient.Builder.newBuilder()
        .setConfiguration(
            Configuration(
                baseUrl = "url",
                key = "key",
                secret = "secret"
            )
        ).build()

    val request = ExpediaGroupJsonRequest.fromOperation<List<Property>>(
        operation = operation as Operation<*>,
        responseTypeReference = jacksonTypeRef<List<Property>>(),
        client = client
    )
//
//    val single = measureTime {
//        for (i in 1..100) {
//            println(request.execute())
//        }
//    }

    val executionTime = measureTime {
        var executions = mutableListOf<CompletableFuture<List<Property>>>()
        for (i in 1..1000) {
            executions.add(request.executeAsync())
        }

        var running = true
        while (running) {
            running = false
            for (f in executions) {
                running = running.or(f.isDone.not())
            }
        }
    }
//    println("Single execution time: $single")
    println("Execution time: $executionTime")
}
