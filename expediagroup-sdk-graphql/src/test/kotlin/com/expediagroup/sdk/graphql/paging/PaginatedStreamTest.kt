package com.expediagroup.sdk.graphql.paging

import java.util.stream.Collectors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TestPaginatedStream(private val pages: List<List<String?>?>?) : PaginatedStream<String?>() {
    private var pageIndex = 0

    override fun fetchNextPage(): List<String?>? {
        if (pages.isNullOrEmpty()) return null

        return if (pageIndex < pages.size) pages[pageIndex++] else emptyList()
    }
}

class PaginatedStreamTest {

    @Test
    fun `should stream all items across multiple pages`() {
        // Given
        val pages = listOf(
            listOf("item1", "item2"),
            listOf("item3", "item4"),
            listOf("item5")
        )

        val paginatedStream = TestPaginatedStream(pages)

        // When
        val result = paginatedStream.stream()

        // Expect
        assertEquals(listOf("item1", "item2", "item3", "item4", "item5"), result.collect(Collectors.toList()))
    }

    @Test
    fun `should stream items from a single page`() {
        // Given
        val pages = listOf(
            listOf("item1", "item2", "item3")
        )

        val paginatedStream = TestPaginatedStream(pages)

        // When
        val result = paginatedStream.stream()

        // Expect
        assertEquals(listOf("item1", "item2", "item3"), result.collect(Collectors.toList()))
    }

    @Test
    fun `should return an empty stream when there are no items`() {
        // Given
        val pages = emptyList<List<String>>()
        val paginatedStream = TestPaginatedStream(pages)

        // When
        val result = paginatedStream.stream()

        // Expect
        assertTrue(result.collect(Collectors.toList()).isEmpty())
    }

    @Test
    fun `should fetch pages lazily`() {
        // Given
        val pages = listOf(
            listOf("item1", "item2"),
            listOf("item3", "item4")
        )
        val paginatedStream = TestPaginatedStream(pages)

        // When
        val iterator = paginatedStream.stream().iterator()

        // Expect
        assertTrue(iterator.hasNext())
        assertEquals("item1", iterator.next())
        assertEquals("item2", iterator.next())
        assertEquals("item3", iterator.next())
        assertEquals("item4", iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun `should handle null items in pages`() {
        // Given
        val pages = listOf(
            listOf("item1", null, "item2"),
            listOf("item3")
        )
        val paginatedStream = TestPaginatedStream(pages)

        // When
        val result = paginatedStream.stream()

        // Expect
        assertEquals(listOf("item1", "item2", "item3"), result.collect(Collectors.toList()))
    }

    @Test
    fun `should stop the stream on first empty page`() {
        // Given
        val pages = listOf(
            listOf("item1", "item2"),
            null,
            listOf("item3")
        )

        val paginatedStream = TestPaginatedStream(pages)

        // When
        val result = paginatedStream.stream()

        // Expect
        assertEquals(listOf("item1", "item2"), result.collect(Collectors.toList()))
    }
}
