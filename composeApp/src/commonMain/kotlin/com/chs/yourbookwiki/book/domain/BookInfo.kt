package com.chs.yourbookwiki.book.domain

data class BookInfo(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val authors: List<String>,
    val languages: List<String>,
    val firstPublishYear: String?,
    val averageRating: Double?,
    val ratingCount: Int?,
    val numPages: Int?,
    val numEditions: Int
)
