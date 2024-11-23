package com.chs.yourbookwiki.book.presnetation.book_detail

import com.chs.yourbookwiki.book.domain.BookInfo

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val bookInfo: BookInfo? = null,
)
