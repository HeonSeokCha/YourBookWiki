package com.chs.yourbookwiki.book.data.repository

import com.chs.yourbookwiki.book.data.mapper.toBookInfo
import com.chs.yourbookwiki.book.data.network.RemoteBookDataSource
import com.chs.yourbookwiki.book.domain.BookInfo
import com.chs.yourbookwiki.book.domain.BookRepository
import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.Result
import com.chs.yourbookwiki.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<BookInfo>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map { it.toBookInfo() }
        }
    }
}