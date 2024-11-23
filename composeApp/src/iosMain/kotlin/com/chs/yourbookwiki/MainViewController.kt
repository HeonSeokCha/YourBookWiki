package com.chs.yourbookwiki

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.chs.yourbookwiki.di.initKoin
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin( )
    }
) {
    App()
}