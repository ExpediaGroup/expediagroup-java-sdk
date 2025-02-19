package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract class representing a REST client.
 *
 * This class provides a base implementation for a REST client that uses a RestExecutor
 * to perform HTTP requests. It implements the Disposable interface to ensure that
 * resources are properly released when the client is no longer needed.
 */
abstract class RestClient : Disposable {
    /**
     * The RestExecutor used to execute REST operations.
     */
    protected abstract val restExecutor: RestExecutor

    /**
     * Disposes of the resources used by the RestExecutor.
     *
     * This method is called to release any resources held by the RestExecutor
     * when the RestClient is no longer needed.
     */
    override fun dispose() {
        restExecutor.dispose()
    }
}
