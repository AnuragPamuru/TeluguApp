package com.example.teluguapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = findViewById<ImageButton>(R.id.imageButton)
        settings.setOnClickListener{openSettings()}
        settings.setBackgroundColor(Color.WHITE)
    }

    fun openSettings(){
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }
}
