package com.example.daycitate.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daycitate.data.QuoteDao

class QuoteViewModelFactory(
    private val quoteDao: QuoteDao
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuoteViewModel(quoteDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}