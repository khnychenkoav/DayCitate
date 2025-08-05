package com.example.daycitate.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daycitate.data.QuoteDao

class FavoritesViewModelFactory(
    private val quoteDao: QuoteDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesViewModel(quoteDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}