package com.example.daycitate

import android.app.Application
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.daycitate.worker.QuoteUpdateWorker
import java.util.concurrent.TimeUnit

class QuoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        scheduleDailyQuoteUpdate()
    }

    private fun scheduleDailyQuoteUpdate() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val dailyWorkRequest =
            PeriodicWorkRequestBuilder<QuoteUpdateWorker>(1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build()



        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "quote_update_work",
            ExistingPeriodicWorkPolicy.KEEP,
            dailyWorkRequest
        )

    }
}