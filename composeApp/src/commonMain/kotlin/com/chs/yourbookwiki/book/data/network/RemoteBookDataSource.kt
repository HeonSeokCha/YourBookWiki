package com.chs.yourbookwiki.book.data.network

import com.chs.yourbookwiki.book.data.dto.SearchResponseDto
import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.Result

interface RemoteBookDataSource {

    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null,
    ): Result<SearchResponseDto, DataError.Remote>
}