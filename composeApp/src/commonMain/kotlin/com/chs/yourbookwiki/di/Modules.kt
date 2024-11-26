package com.chs.yourbookwiki.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.chs.yourbookwiki.book.data.database.DatabaseFactory
import com.chs.yourbookwiki.book.data.database.FavoriteBookDatabase
import com.chs.yourbookwiki.book.data.network.KtorRemoteBookDataSource
import com.chs.yourbookwiki.book.data.network.RemoteBookDataSource
import com.chs.yourbookwiki.book.data.repository.DefaultBookRepository
import com.chs.yourbookwiki.book.domain.BookRepository
import com.chs.yourbookwiki.book.presnetation.SelectedBookViewModel
import com.chs.yourbookwiki.book.presnetation.book_detail.BookDetailViewModel
import com.chs.yourbookwiki.book.presnetation.book_list.BookListViewModel
import com.chs.yourbookwiki.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)
}