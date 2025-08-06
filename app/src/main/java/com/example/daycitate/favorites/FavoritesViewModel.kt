package com.example.daycitate.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.data.QuoteDao
import kotlinx.coroutines.launch

class FavoritesViewModel(private val quoteDao: QuoteDao) : ViewModel() {
    val allFavoriteQuotes = quoteDao.getAllQuotes().asLiveData()

    fun delete(quote: FavoriteQuoteEntity) {
        viewModelScope.launch {
            quoteDao.deleteQuoteById(quote.id)
        }

    }
}