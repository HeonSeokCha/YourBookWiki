package com.chs.yourbookwiki.book.presnetation.book_list

import com.chs.yourbookwiki.book.domain.BookInfo

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String) : BookListAction
    data class OnBookClick(val book: BookInfo) : BookListAction
    data class OnTabSelected(val idx: Int) : BookListAction
}