package com.chs.yourbookwiki.book.data.mapper

import com.chs.yourbookwiki.book.data.database.BookEntity
import com.chs.yourbookwiki.book.data.dto.SearchedBookDto
import com.chs.yourbookwiki.book.domain.BookInfo

fun SearchedBookDto.toBookInfo(): BookInfo {
    return BookInfo(
        id = this.id.substringAfterLast("/"),
        title = this.title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${this.coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${this.coverAlternativeKey}-L.jpg"
        },
        authors = this.authorNames ?: emptyList(),
        description = null,
        languages = this.languages ?: emptyList(),
        firstPublishYear = this.firstPublishYear.toString(),
        averageRating = this.ratingsAverage,
        ratingCount = this.ratingsCount,
        numPages = this.numPagesMedian,
        numEditions = this.numEditions ?: 0
    )
}

fun BookInfo.toEntity(): BookEntity {
    return BookEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        languages = this.languages,
        authors = this.authors,
        firstPublishYear = this.firstPublishYear,
        ratingsAverage = this.averageRating,
        ratingCount = this.ratingCount,
        numPageMedian = this.numPages,
        numEditions = this.numEditions
    )
}

fun BookEntity.toBookInfo(): BookInfo {
    return BookInfo(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        languages = this.languages,
        authors = this.authors,
        firstPublishYear = this.firstPublishYear,
        averageRating = this.ratingsAverage,
        ratingCount = this.ratingCount,
        numPages = this.numPageMedian,
        numEditions = this.numEditions
    )
}