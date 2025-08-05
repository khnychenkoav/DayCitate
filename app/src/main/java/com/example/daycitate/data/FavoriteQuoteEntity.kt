package com.example.daycitate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_quotes")
data class FavoriteQuoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val quoteText: String,
    val authorName: String,
)