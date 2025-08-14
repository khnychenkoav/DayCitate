package com.example.daycitate.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.data.QuoteRepository
import kotlinx.coroutines.launch

class FavoritesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    val allFavoriteQuotes = quoteRepository.getFavoriteQuotesStream().asLiveData()

    fun delete(quote: FavoriteQuoteEntity) {
        viewModelScope.launch {
            quoteRepository.deleteQuoteFromFavorites(quote.id)
        }

    }
}