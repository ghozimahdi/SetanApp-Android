package com.blank.setanapps

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import java.io.IOException


class MainService : Service() {
    private val TAG = MainService::class.java.simpleName
    var player: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("service", "onCreate")
        player = MediaPlayer()
        try {
            var afd = assets.openFd("setan.mp3")
            player?.setDataSource(afd.fileDescriptor)
            player?.isLooping = true
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("service", "onStartCommand")
        try {
            player!!.prepare()
            player!!.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}