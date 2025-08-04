package com.example.daycitate.data

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote")
    val quoteText: String,

    @SerializedName("author")
    val authorName: String,
)