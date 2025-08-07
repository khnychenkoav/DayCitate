package com.example.daycitate.ui.new_quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daycitate.data.QuoteDao

class NewQuoteViewModelFactory(private val dao: QuoteDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        modelClass.getConstructor(QuoteDao::class.java).newInstance(dao)
}