package com.example.teluguapp

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val toggle = findViewById<ImageButton>(R.id.toggleButton)
        toggle.setImageResource(R.drawable.ic_invert_b)
        toggle.setBackgroundColor(Color.WHITE)
        toggle.setOnClickListener{toggleModeW()}
    }

    fun toggleModeW(){
        val toggle = findViewById<ImageButton>(R.id.toggleButton)
        toggle.setImageResource(R.drawable.ic_invert_w)
        toggle.setBackgroundColor(Color.BLACK)
        toggle.setOnClickListener{toggleModeB()}


    }

    fun toggleModeB(){
        val toggle = findViewById<ImageButton>(R.id.toggleButton)
        toggle.setImageResource(R.drawable.ic_invert_b)
        toggle.setBackgroundColor(Color.WHITE)
        toggle.setOnClickListener{toggleModeW()}
    }

}
