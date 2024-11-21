package com.chs.yourbookwiki

import androidx.compose.runtime.*
import com.chs.yourbookwiki.book.data.network.KtorRemoteBookDataSource
import com.chs.yourbookwiki.book.data.repository.DefaultBookRepository
import com.chs.yourbookwiki.book.presnetation.book_list.BookListScreenRoot
import com.chs.yourbookwiki.book.presnetation.book_list.BookListVIewModel
import com.chs.yourbookwiki.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListVIewModel(
            bookRepository = DefaultBookRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(engine)
                )
            )
        ) },
        onBookClick = {

        }
    )
}