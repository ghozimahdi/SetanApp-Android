package com.blank.setanapps

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.io.IOException
import java.util.concurrent.TimeUnit


class MainService : Service() {
    private val TAG = MainService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        try {
            val periodicRequest =
                PeriodicWorkRequestBuilder<WorkPeriodic>(15, TimeUnit.MINUTES, 14, TimeUnit.MINUTES)
                    .build()

            WorkManager.getInstance(this)
                .enqueue(periodicRequest)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}