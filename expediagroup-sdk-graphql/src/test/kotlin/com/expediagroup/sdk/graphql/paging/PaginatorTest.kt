package com.expediagroup.sdk.graphql.paging

import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.graphql.paging.model.PageInfo
import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import testservice.TestQuery

internal class TestPaginatedResponse(
    override val data: TestQuery.Data,
    override val pageInfo: PageInfo,
    override val rawResponse: RawResponse<TestQuery.Data>
) : PaginatedResponse<TestQuery.Data, TestQuery.Data>

internal class TestPaginator(private val availablePages: Int) : Paginator<TestPaginatedResponse>() {
    private var fetchedPages = 0

    override fun hasPagesToFetch(): Boolean {
        return availablePages > 0
    }

    override fun next(): TestPaginatedResponse {
        fetchedPages++
        hasNext = fetchedPages < availablePages

        return TestPaginatedResponse(
            data = TestQuery.Data {},
            pageInfo = PageInfo(
                pageSize = 1,
                hasNext = hasNext()
            ),
            rawResponse = RawResponse(data = TestQuery.Data {}, errors = emptyList())
        )
    }
}

class PaginatorTest {

    @Test
    fun `hasNext should return true if there are available pages for the firs call`() {
        val paginator = TestPaginator(availablePages = 3)
        assertTrue(paginator.hasNext())
    }

    @Test
    fun `hasNext should return false if no pages are available for the firs call`() {
        val paginator = TestPaginator(availablePages = 0)
        assertFalse(paginator.hasNext())
    }

    @Test
    fun `hasNext should return true if there are available pages after initialization`() {
        val paginator = TestPaginator(availablePages = 3)
        assertTrue(paginator.hasNext())
        paginator.next()
        assertTrue(paginator.hasNext())
    }

    @Test
    fun `hasNext should return false if there are no available pages after initialization`() {
        val paginator = TestPaginator(availablePages = 1)
        assertTrue(paginator.hasNext())
        paginator.next()
        assertFalse(paginator.hasNext())
    }
}
