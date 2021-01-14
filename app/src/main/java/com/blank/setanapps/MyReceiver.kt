package com.blank.setanapps

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("RECEIVER-SETAN", "START")
        val svc = Intent(context, MainService::class.java)
        context.startService(svc)
    }
}