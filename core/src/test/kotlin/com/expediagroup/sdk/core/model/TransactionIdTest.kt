package com.expediagroup.sdk.core.model

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import java.util.UUID

class TransactionIdTest {
    private val uuids = listOf(UUID.randomUUID(), UUID.randomUUID())

    @Test
    fun `peek should return a UUID`() {
        mockkStatic(UUID::class) {
            every { UUID.randomUUID() } returnsMany uuids
            val transactionId = TransactionId()
            assert(transactionId.peek() == uuids[0])
            assert(transactionId.peek() == uuids[0])
        }
    }

    @Test
    fun `dequeue should return a UUID and change it`() {
        mockkStatic(UUID::class) {
            every { UUID.randomUUID() } returnsMany uuids
            val transactionId = TransactionId()
            assert(transactionId.dequeue() == uuids[0])
            assert(transactionId.peek() == uuids[1])
        }
    }
}
