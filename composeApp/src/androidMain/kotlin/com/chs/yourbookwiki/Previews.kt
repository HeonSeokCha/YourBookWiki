package com.chs.yourbookwiki

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
            searchQuery = "",
            onImeSearch = { },
            onSearchQueryChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}