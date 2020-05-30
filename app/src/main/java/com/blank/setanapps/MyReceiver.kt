package com.blank.setanapps

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val svc = Intent(context, MainService::class.java)
        context?.startService(svc)
    }
}