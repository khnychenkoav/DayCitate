package com.example.daycitate.ui.new_quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.daycitate.data.FavoriteQuoteEntity
import com.example.daycitate.data.Quote
import com.example.daycitate.data.QuoteDao
import kotlinx.coroutines.launch

class NewQuoteViewModel(private val dao: QuoteDao) : ViewModel() {

    fun newQuote(quote: FavoriteQuoteEntity) = viewModelScope.launch { dao.insertQuote(quote) }

    fun delete(quote: FavoriteQuoteEntity) = viewModelScope.launch { dao.deleteQuoteByContent(quote.quoteText) }
}