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