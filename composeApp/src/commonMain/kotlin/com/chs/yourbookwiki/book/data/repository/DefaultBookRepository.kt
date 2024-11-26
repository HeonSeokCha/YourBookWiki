package com.chs.yourbookwiki.book.data.repository

import androidx.sqlite.SQLiteException
import com.chs.yourbookwiki.book.data.database.FavoriteBookDao
import com.chs.yourbookwiki.book.data.mapper.toBookInfo
import com.chs.yourbookwiki.book.data.mapper.toEntity
import com.chs.yourbookwiki.book.data.network.RemoteBookDataSource
import com.chs.yourbookwiki.book.domain.BookInfo
import com.chs.yourbookwiki.book.domain.BookRepository
import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.EmptyResult
import com.chs.yourbookwiki.core.domain.Result
import com.chs.yourbookwiki.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<BookInfo>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map { it.toBookInfo() }
        }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)

        return if (localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<BookInfo>> {
        return favoriteBookDao.getFavoriteBooks()
            .map { bookEntity ->
                bookEntity.map { it.toBookInfo() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao.getFavoriteBooks()
            .map { bookEntity ->
                bookEntity.any { it.id == id }
            }
    }

    override suspend fun upsertBookInfo(bookInfo: BookInfo): EmptyResult<DataError.LOCAL> {
        return try {
            favoriteBookDao.upsert(bookInfo.toEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.LOCAL.DISK_FULL)
        }
    }

    override suspend fun deleteBookInfo(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}