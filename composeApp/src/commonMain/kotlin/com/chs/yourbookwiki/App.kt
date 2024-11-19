package com.chs.yourbookwiki

import androidx.compose.runtime.*
import com.chs.yourbookwiki.book.presnetation.book_list.BookListScreenRoot
import com.chs.yourbookwiki.book.presnetation.book_list.BookListVIewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListVIewModel() },
        onBookClick = {

        }
    )
}