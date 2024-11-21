package com.chs.yourbookwiki.book.domain

import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<BookInfo>, DataError.Remote>
}