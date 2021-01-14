package com.blank.setanapps

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkPeriodic(context: Context, parameters: WorkerParameters) :
    Worker(context, parameters) {
    override fun doWork(): Result = try {
        SetanUtils.playNangis()
        Result.success()
    } catch (e: Exception) {
        Result.failure()
    }
}