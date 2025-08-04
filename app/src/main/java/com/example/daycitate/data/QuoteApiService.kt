package com.example.daycitate.data

import retrofit2.http.GET

interface QuoteApiService {

    @GET("quotes/random")
    suspend fun getRandomQuote(): Quote?
}