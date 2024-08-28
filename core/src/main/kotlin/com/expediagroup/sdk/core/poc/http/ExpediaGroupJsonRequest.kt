package com.expediagroup.sdk.core.poc.http

import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.core.poc.RapidClient
import com.expediagroup.sdk.core.poc.client.ExpediaGroupServiceClient
import com.expediagroup.sdk.core.poc.constant.JACKSON_MAPPER
import com.expediagroup.sdk.core.poc.constant.JSON_FACTORY
import com.expediagroup.sdk.core.poc.model.Nothing
import com.fasterxml.jackson.core.type.TypeReference
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest
import com.google.api.client.http.*
import com.google.api.client.http.json.JsonHttpContent
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.Future

class ExpediaGroupJsonRequest<T>(
    serviceClient: ExpediaGroupServiceClient,
    method: String,
    uriTemplate: String,
    content: HttpContent? = null,
    headers: Map<String, Any> = emptyMap(),
    private val executor: Executor? = null,
    val responseTypeReference: TypeReference<*>,
) : AbstractGoogleJsonClientRequest<T>(
    serviceClient.client,
    method,
    uriTemplate,
    content,
    Any::class.java as Class<T>
) {
    init {
        headers.forEach { header, value ->
            requestHeaders.put(header, value)
        }
    }

    override fun execute(): T {
        val response = buildHttpRequest().execute()

        if (response.content == null) {
            return Nothing as T
        }

        val content = response.content.readAllBytes()
        return JACKSON_MAPPER.readValue(content, responseTypeReference) as T
    }

    fun executeAsync(): CompletableFuture<T> = executeCompletableFuture()

    fun executeCompletableFuture(): CompletableFuture<T> =
        CompletableFuture<T>().apply {
            executor ?: defaultExecutor().let {
                it.execute {
                    complete(execute())
                }
            }
        }

    fun executeFuture(): Future<HttpResponse> =
        abstractGoogleClient.requestFactory.buildRequest(
            requestMethod,
            GenericUrl(uriTemplate),
            httpContent
        ).let {
            executor?.let { exec ->
                it.executeAsync(exec)
            } ?: it.executeAsync()
        }

    companion object {
        inline fun <reified T> fromOperation(
            operation: Operation<*>,
            responseTypeReference: TypeReference<*>,
            client: RapidClient,
            executor: Executor? = null
        ): ExpediaGroupJsonRequest<T> {
            var content: JsonHttpContent? = null
            if (operation.requestBody != null) {
                content = JsonHttpContent(JSON_FACTORY, operation.requestBody)
            }

            var params = emptyMap<String, Any>()
            var headers = mapOf<String, Any>(
                "Accept" to "application/json",
                "Content-Type" to "application/json"
            )

            if (operation.params != null) {
                operation.params.getQueryParams()?.let {
                    params = params.plus(it)
                }
                operation.params.getQueryParams()?.let {
                    params = params.plus(it)
                }
                operation.params.getHeaders()?.let {
                    headers = headers.plus(it)
                }
            }

            val url = UriTemplate.expand(operation.url, params, true)

            return ExpediaGroupJsonRequest(
                serviceClient = client.expediaGroupServiceClient(),
                method = operation.method,
                uriTemplate = url,
                content = content,
                executor = executor,
                headers = headers,
                responseTypeReference = responseTypeReference
            )
        }
    }
}
