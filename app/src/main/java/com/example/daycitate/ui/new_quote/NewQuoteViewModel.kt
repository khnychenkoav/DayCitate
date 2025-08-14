package com.example.daycitate.ui.new_quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.data.QuoteRepository
import kotlinx.coroutines.launch

class NewQuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun newQuote(quote: FavoriteQuoteEntity) = viewModelScope.launch { quoteRepository.saveQuoteToFavorites(quote) }

    fun delete(quote: FavoriteQuoteEntity) = viewModelScope.launch { quoteRepository.deleteQuoteFromFavorites(quote.id) }
}