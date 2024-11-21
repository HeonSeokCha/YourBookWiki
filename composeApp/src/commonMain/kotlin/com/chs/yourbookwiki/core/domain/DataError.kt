package com.chs.yourbookwiki.core.domain

sealed interface DataError: Error {
    enum class Remote : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUEST,
        NO_CONNECTION,
        SERVER,
        SERIALIZATION,
        UNKNOWN
    }

    enum class LOCAL : DataError {
        DISK_FULL,
        UNKNOWN
    }
}