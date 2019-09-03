package com.example.teluguapp

import android.app.Activity
import android.media.MediaPlayer

data class Word(val word: String, val translations: List<String>, val sound: Int, val context: Activity){
    fun playSound() {
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, sound)
        mediaPlayer?.start()
    }
}