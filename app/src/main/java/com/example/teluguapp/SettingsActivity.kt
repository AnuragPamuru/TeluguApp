package com.example.teluguapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val toggle = findViewById<ImageButton>(R.id.toggleButton)
        toggle.setOnClickListener{toggle.setImageResource(R.drawable.ic_invert_w)}
    }

    fun toggleMode(){

    }
}
