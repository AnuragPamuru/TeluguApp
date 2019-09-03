package com.example.teluguapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.BufferedReader
import java.io.InputStreamReader
import androidx.constraintlayout.widget.ConstraintLayout


class LessonActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        setUp(R.raw.alphabet1)
    }

    fun setUp(setUpFile: Int){
        //read all data from file
        val setUpData = resources.openRawResource(setUpFile)
        val reader = BufferedReader(InputStreamReader(setUpData, "Unicode"))


        val list = mutableListOf<Word>()

        for(i in reader.lineSequence()){
            //use each line to set up words

            //read the letters, meaning, and sound path
            val data = i.split("\\t")

            val translations = data[1].split(",")
            val word = Word(data[0], translations, data[2].toInt(),this)

            val myButton = Button(this)
            myButton.text = word.word
            myButton.setOnClickListener { word.playSound() }
            val ll = findViewById<ConstraintLayout>(R.id.activity_lesson)
            val lp = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
            ll.addView(myButton, lp)
        }

        //testing - feed those words into buttons


    }
}
