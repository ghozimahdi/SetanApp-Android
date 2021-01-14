package com.blank.setanapps

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer

object SetanUtils {
    private val mediaPlayerFull = MediaPlayer.create(App.context, R.raw.full)
    private val mediaPlayerNangis = MediaPlayer.create(App.context, R.raw.nangis)

    private val audioManager =
        App.context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    fun playFullSetan() {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 100, 0)

        try {
            if (!mediaPlayerFull.isPlaying) {
                mediaPlayerFull.setVolume(100f, 100f)
                mediaPlayerFull.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun playNangis() {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 100, 0)

        try {
            if (!mediaPlayerNangis.isPlaying) {
                mediaPlayerNangis.setVolume(100f, 100f)
                mediaPlayerNangis.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}