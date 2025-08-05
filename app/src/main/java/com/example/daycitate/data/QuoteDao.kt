package com.example.daycitate.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: FavoriteQuoteEntity)

    @Query("SELECT * FROM favorite_quotes")
    fun getAllQuotes(): List<FavoriteQuoteEntity>

    @Query("DELETE FROM favorite_quotes WHERE id = :quoteId")
    suspend fun deleteQuoteById(quoteId: Int)

}