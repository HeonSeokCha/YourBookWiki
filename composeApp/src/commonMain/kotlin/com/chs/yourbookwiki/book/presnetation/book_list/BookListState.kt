package com.chs.yourbookwiki.book.presnetation.book_list

import com.chs.yourbookwiki.book.domain.BookInfo
import com.chs.yourbookwiki.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<BookInfo> = emptyList(),
    val favoritesBooks: List<BookInfo> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIdx: Int = 0,
    val errorMessage: UiText? = null
)
