package com.expediagroup.sdk.core.transport

import com.expediagroup.sdk.core.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.core.exception.client.ExpediaGroupPipelineExecutionException
import com.expediagroup.sdk.core.exception.client.ExpediaGroupTransportException
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import java.util.ServiceLoader
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

class AbstractAsyncRequestExecutorTest {
    @Test
    fun `should load the available AsyncTransport implementation in the classpath if not provided`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockLoader = mockk<ServiceLoader<AsyncTransport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf(mockAsyncTransport).iterator()
        every { ServiceLoader.load(AsyncTransport::class.java) } returns mockLoader

        // When
        val asyncExecutor =
            object : AbstractAsyncRequestExecutor() {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }

        val asyncTransportField = AbstractAsyncRequestExecutor::class.java.getDeclaredField("asyncTransport")
        asyncTransportField.isAccessible = true
        val loadedAsyncTransport = asyncTransportField.get(asyncExecutor)

        // Expect
        assertNotNull(loadedAsyncTransport)
        assertEquals(mockAsyncTransport, loadedAsyncTransport)

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should use provided AsyncTransport if given`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()

        // When
        val executor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }

        val asyncTransportField = AbstractAsyncRequestExecutor::class.java.getDeclaredField("asyncTransport")
        asyncTransportField.isAccessible = true
        val loadedAsyncTransport = asyncTransportField.get(executor)

        // Expect
        assertNotNull(loadedAsyncTransport)
        assertEquals(mockAsyncTransport, loadedAsyncTransport)
    }

    @Test
    fun `should throw an exception if unable to load AsyncTransport`() {
        // Given
        val mockLoader = mockk<ServiceLoader<AsyncTransport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf<AsyncTransport>().iterator()
        every { ServiceLoader.load(AsyncTransport::class.java) } returns mockLoader

        // When & Expect
        assertThrows<ExpediaGroupConfigurationException> {
            object : AbstractAsyncRequestExecutor() {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }
        }

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should apply the execution pipeline`() {
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()

        val asyncExecutor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockExecutionPipeline
            }

        every { mockAsyncTransport.execute(any()) } returns CompletableFuture.completedFuture(mockk<Response>())
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } returns mockk<Request>()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } returns mockk<Response>()

        asyncExecutor.execute(mockk<Request>())

        verify(exactly = 1) { mockExecutionPipeline.startRequestPipeline(any<Request>()) }
        verify(exactly = 1) { mockExecutionPipeline.startResponsePipeline(any<Response>()) }
        verify(exactly = 1) { mockAsyncTransport.execute(any<Request>()) }

        verifyOrder {
            mockExecutionPipeline.startRequestPipeline(any())
            mockAsyncTransport.execute(any())
            mockExecutionPipeline.startResponsePipeline(any())
        }
    }

    @Test
    fun `should dispose the underlying AsyncTransport`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()
        val asyncExecutor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }

        every { mockAsyncTransport.dispose() } just Runs

        // When
        asyncExecutor.dispose()

        // Expect
        verify(exactly = 1) { mockAsyncTransport.dispose() }
    }

    @Test
    fun `should throw ExpediaGroupPipelineExecutionException if the request pipeline fails`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()
        val asyncExecutor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockExecutionPipeline
            }

        every { mockAsyncTransport.execute(any()) } returns CompletableFuture.completedFuture(mockk<Response>())
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } throws RuntimeException()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } returns mockk<Response>()

        // When & Expect
        assertThrows<ExpediaGroupPipelineExecutionException> {
            asyncExecutor.execute(mockk<Request>())
        }
    }

    @Test
    fun `should complete the future exceptionally if the response pipeline fails`() {
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()
        val asyncExecutor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockExecutionPipeline
            }

        every { mockAsyncTransport.execute(any()) } returns CompletableFuture.completedFuture(mockk<Response>())
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } returns mockk<Request>()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } throws RuntimeException()

        val future = asyncExecutor.execute(mockk<Request>())

        val exception =
            assertThrows<CompletionException> {
                future.join()
            }

        assertInstanceOf<ExpediaGroupPipelineExecutionException>(exception.cause)
    }

    @Test
    fun `should complete the future exceptionally if the request execution fails`() {
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()
        val asyncExecutor =
            object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
                override val executionPipeline = mockExecutionPipeline
            }

        val failedFuture = CompletableFuture<Response>()
        failedFuture.completeExceptionally(RuntimeException())

        every { mockAsyncTransport.execute(any()) } returns failedFuture
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } returns mockk<Request>()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } returns mockk<Response>()

        val future = asyncExecutor.execute(mockk<Request>())

        val exception =
            assertThrows<CompletionException> {
                future.join()
            }

        assertInstanceOf<ExpediaGroupTransportException>(exception.cause)
    }
}
