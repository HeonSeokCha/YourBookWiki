package com.chs.yourbookwiki

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.createBitmap
import com.chs.yourbookwiki.book.domain.BookInfo
import com.chs.yourbookwiki.book.presnetation.book_list.BookListScreen
import com.chs.yourbookwiki.book.presnetation.book_list.BookListState
import com.chs.yourbookwiki.book.presnetation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "Kotlin",
            onImeSearch = { },
            onSearchQueryChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private val books = (1 .. 100).map {
    BookInfo(
        id = it.toString(),
        title = "BOOKS${it}",
        imageUrl = "https://text.com",
        authors = listOf("HyeonSeok"),
        description = "Desc $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.567812,
        ratingCount = 5,
        numPages = 100,
        numEditions = 7
    )
}

@Preview
@Composable
private fun BookListScreenPreView() {
    BookListScreen(
        state = BookListState(
            searchResults = books
        ), onAction = {}
    )
}