package com.chs.yourbookwiki

import androidx.compose.runtime.*
import com.chs.yourbookwiki.book.presnetation.book_list.BookListScreenRoot
import com.chs.yourbookwiki.book.presnetation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookClick = {

        }
    )
}