package com.chs.yourbookwiki

import android.app.Application
import com.chs.yourbookwiki.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookWikiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookWikiApplication)
        }
    }
}