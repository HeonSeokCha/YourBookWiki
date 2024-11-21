package com.chs.yourbookwiki

import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController {
    App(Darwin.create())
}