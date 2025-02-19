package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.rest.extension.parseRequest
import com.expediagroup.sdk.rest.extension.toRestResponse
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseTrait
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL
import com.expediagroup.sdk.core.http.Response as SDKCoreResponse

/**
 * RestExecutor is responsible for executing REST operations.
 *
 * @property mapper The ObjectMapper used for JSON serialization and deserialization.
 * @property requestExecutor The underlying request executor used to perform HTTP requests.
 * @property serverUrl The base URL of the server to which requests are sent.
 */
class RestExecutor(
    private val mapper: ObjectMapper,
    private val requestExecutor: AbstractRequestExecutor,
    private val serverUrl: String
) : Disposable by requestExecutor {
    /**
     * Executes an operation that does not expect a response body.
     *
     * @param operation The operation to be executed.
     * @return A Response object containing the result of the operation.
     */
    fun execute(operation: OperationNoResponseBodyTrait): Response<Nothing?> =
        execute(operation) { response ->
            response.toRestResponse(operation)
        }

    /**
     * Executes an operation that expects a response body of type T.
     *
     * @param T The type of the response body.
     * @param operation The operation to be executed.
     * @return A Response object containing the result of the operation.
     */
    fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): Response<T> =
        execute(operation) { response ->
            response.toRestResponse(operation, mapper)
        }

    /**
     * Executes an operation and transforms the response using the provided transform function.
     *
     * @param T The type of the response body.
     * @param operation The operation to be executed.
     * @param transform The function to transform the SDKCoreResponse to a Response object.
     * @return A Response object containing the result of the operation.
     */
    private fun <T> execute(
        operation: OperationResponseTrait,
        transform: (SDKCoreResponse) -> Response<T>
    ): Response<T> =
        operation.getRequestInfo().parseRequest(URL(serverUrl), mapper).let(
            requestExecutor::execute
        ).let(transform)
}
