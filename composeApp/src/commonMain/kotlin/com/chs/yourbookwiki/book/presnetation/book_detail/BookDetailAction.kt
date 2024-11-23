package com.chs.yourbookwiki.book.presnetation.book_detail

import com.chs.yourbookwiki.book.domain.BookInfo

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnBookClick : BookDetailAction
    data object OnFavoriteClick : BookDetailAction
    data class OnSelectedBookChange(val book: BookInfo) : BookDetailAction
}