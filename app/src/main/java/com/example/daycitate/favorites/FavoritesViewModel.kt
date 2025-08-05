package com.example.daycitate.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.daycitate.data.QuoteDao

class FavoritesViewModel(private val quoteDao: QuoteDao) : ViewModel() {
    val allFavoriteQuotes = quoteDao.getAllQuotes().asLiveData()
}