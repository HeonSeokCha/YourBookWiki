package com.chs.yourbookwiki.book.domain

import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.EmptyResult
import com.chs.yourbookwiki.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<BookInfo>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<BookInfo>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun upsertBookInfo(bookInfo: BookInfo): EmptyResult<DataError.LOCAL>
    suspend fun deleteBookInfo(id: String)
}