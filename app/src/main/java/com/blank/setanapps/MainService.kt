package com.blank.setanapps

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.util.Log
import java.io.IOException


class MainService : Service() {
    private val TAG = MainService::class.java.simpleName
    var player: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
        player = MediaPlayer()
        try {
            val afd = assets.openFd("setan.mp3")
            player?.setDataSource(afd.fileDescriptor)
            player?.setVolume(100F, 100F)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        try {
            player!!.prepare()

            //todo please remove this
            val handler = Handler()
            val runnable: Runnable = object : Runnable {
                override fun run() {
                    player!!.start()
                    handler.postDelayed(this, 100000) //repeat time
                }
            }
            runnable.run()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}