package com.blank.setanapps

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val svc = Intent(context, MainService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(intent)
        } else {
            context?.startService(svc)
        }
    }
}