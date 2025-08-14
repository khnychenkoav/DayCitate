package com.example.daycitate.data

import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getRandomQuote(): Quote?
    suspend fun saveQuoteToFavorites(quote: FavoriteQuoteEntity)
    fun getFavoriteQuotesStream(): Flow<List<FavoriteQuoteEntity>>
    suspend fun deleteQuoteFromFavorites(quoteId: Int)
}