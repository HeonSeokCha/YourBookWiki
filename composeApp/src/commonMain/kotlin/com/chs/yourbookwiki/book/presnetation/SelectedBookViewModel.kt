package com.chs.yourbookwiki.book.presnetation

import androidx.lifecycle.ViewModel
import com.chs.yourbookwiki.book.domain.BookInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel : ViewModel(){
    private val _selectedBook = MutableStateFlow<BookInfo?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: BookInfo?) {
        _selectedBook.value = book
    }
}