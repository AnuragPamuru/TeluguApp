package com.example.teluguapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.Button


class LessonActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
    }

    fun playSound(v : View){
        val mediaPlayer = MediaPlayer.create(this, R.raw.a);
        mediaPlayer.start()
    }
}
