package com.chs.yourbookwiki.di

import com.chs.yourbookwiki.book.data.database.DatabaseFactory
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { OkHttp.create() }
        single { DatabaseFactory(androidApplication()) }
    }
