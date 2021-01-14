package com.blank.setanapps

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            val periodicRequest =
                PeriodicWorkRequestBuilder<WorkPeriodic>(15, TimeUnit.MINUTES, 14, TimeUnit.MINUTES)
                    .build()

            WorkManager.getInstance(this)
                .enqueue(periodicRequest)

            val alarmReceiver = AlarmReceiver()
            if (!alarmReceiver.isAlarmOn(this)) {
                alarmReceiver.setRepeatingAlarm(this)
            }

            val intent = Intent()
            intent.component = ComponentName(
                "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity"
            )
            startActivity(intent)
        }

        btnHide.setOnClickListener {
            hideApp()
        }
    }

    private fun hideApp() {
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}

