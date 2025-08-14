package com.example.daycitate.ui.new_quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daycitate.data.QuoteDao
import com.example.daycitate.data.QuoteRepository

class NewQuoteViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewQuoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewQuoteViewModel(quoteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}