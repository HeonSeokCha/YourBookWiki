package com.chs.yourbookwiki

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform