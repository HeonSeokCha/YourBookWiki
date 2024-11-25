package com.chs.yourbookwiki.book.data.network

import com.chs.yourbookwiki.book.data.dto.BookWorkDto
import com.chs.yourbookwiki.book.data.dto.SearchResponseDto
import com.chs.yourbookwiki.core.data.safeCall
import com.chs.yourbookwiki.core.domain.DataError
import com.chs.yourbookwiki.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL: String = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?,
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall<SearchResponseDto> {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,language,cover_i,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count")
            }
        }
    }

    override suspend fun getBookDetails(bookWordId: String): Result<BookWorkDto, DataError.Remote> {
        return safeCall<BookWorkDto> {
            httpClient.get(
                urlString = "$BASE_URL/works/$bookWordId.json"
            ) {

            }
        }
    }
}