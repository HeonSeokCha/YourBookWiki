package com.chs.yourbookwiki.core.presentation

import cmp_book.composeapp.generated.resources.Res
import cmp_book.composeapp.generated.resources.error_disk_full
import cmp_book.composeapp.generated.resources.error_no_internet
import cmp_book.composeapp.generated.resources.error_request_time_out
import cmp_book.composeapp.generated.resources.error_serialization
import cmp_book.composeapp.generated.resources.error_too_many_request
import cmp_book.composeapp.generated.resources.error_unknown
import com.chs.yourbookwiki.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes =  when(this) {
        DataError.LOCAL.DISK_FULL -> Res.string.error_disk_full
        DataError.LOCAL.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_time_out
        DataError.Remote.TOO_MANY_REQUEST -> Res.string.error_too_many_request
        DataError.Remote.NO_CONNECTION -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}