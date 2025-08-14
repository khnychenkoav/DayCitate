package com.example.daycitate

import android.content.Context
import com.example.daycitate.data.AppDatabase
import com.example.daycitate.data.QuoteRepository
import com.example.daycitate.data.QuoteRepositoryImpl
import com.example.daycitate.data.RetrofitInstance

object DependencyContainer {
    private var repositoryInstance: QuoteRepository? = null

    private fun createRepository(context: Context): QuoteRepository {
        val apiService = RetrofitInstance.api
        val quoteDao = AppDatabase.getDatabase(context).quoteDao()

        return QuoteRepositoryImpl(apiService, quoteDao)
    }

    fun getRepository(context: Context): QuoteRepository {
        synchronized(this) {
            return repositoryInstance ?: createRepository(context).also {
                repositoryInstance = it
            }
        }
    }

}