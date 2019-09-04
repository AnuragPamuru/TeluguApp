package com.example.teluguapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import java.io.BufferedReader
import java.io.InputStreamReader


class LessonActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        setUp(resources.getIdentifier(intent.action, "raw", packageName))
    }

    private fun setUp(setUpFile: Int){
        //read all data from file
        val setUpData = resources.openRawResource(setUpFile)
        val reader = BufferedReader(InputStreamReader(setUpData, "Unicode"))

        val buttons = mutableListOf<Button>()

        //use each line to set up words
        for(i in reader.lineSequence()){

            //read the letters, meaning, and sound path
            val data = i.split(" ")
            val translations = mutableListOf<String>()

            if(data[1].contains(",")){
                for (j in data[1].split(",")){
                    translations.add(j)
                }
            } else{
                translations.add(data[1])
            }

            val word = Word(data[0], translations, resources.getIdentifier(data[2], "raw", packageName),this)


            buttons.add(Button(this))

            buttons[buttons.size - 1].textSize = 60F
            buttons[buttons.size - 1].text = word.word
            buttons[buttons.size - 1].setOnClickListener { word.playSound() }
            val ll = findViewById<LinearLayout>(R.id.words_wrapper)
            val lp = LinearLayout.LayoutParams(300,300)
            lp.topMargin = 10
            lp.bottomMargin = 10
            ll.addView(buttons[buttons.size - 1], lp)
        }
    }
}
