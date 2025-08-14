package com.example.daycitate.data

import kotlinx.coroutines.flow.Flow

class QuoteRepositoryImpl(private val api: QuoteApiService, private val dao: QuoteDao): QuoteRepository {
    override suspend fun getRandomQuote(): Quote? {
        return api.getRandomQuote()
    }

    override suspend fun saveQuoteToFavorites(quote: FavoriteQuoteEntity) {
        dao.insertQuote(quote)
    }

    override fun getFavoriteQuotesStream(): Flow<List<FavoriteQuoteEntity>> {
        return dao.getAllQuotes()
    }

    override suspend fun deleteQuoteFromFavorites(quoteId: Int) {
        dao.deleteQuoteById(quoteId)
    }
}