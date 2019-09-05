package com.example.teluguapp

import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.LinearLayout
import java.io.BufferedReader
import java.io.InputStreamReader


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLessons(resources.getIdentifier("lessons", "raw", "com.example.teluguapp"))
    }

    private fun setUpLessons(setupFile: Int){
        //read all data from file
        val setUpData = resources.openRawResource(setupFile)
        val reader = BufferedReader(InputStreamReader(setUpData, "Unicode"))

        val buttons = mutableListOf<Button>()

        //use each line to set up words
        for(i in reader.lineSequence()){
            buttons.add(Button(context))
            buttons[buttons.lastIndex].text = createTitle(i)
            println(createTitle(i))
            buttons[buttons.lastIndex].setBackgroundResource(resources.getIdentifier("round_buttons","drawable", "com.example.teluguapp"))
            buttons[buttons.lastIndex].setOnClickListener {
                val intent = Intent(activity, LessonActivity::class.java)
                intent.action = i
                startActivity(intent)
            }
            val ll = view?.findViewById(R.id.lessons_wrapper) as LinearLayout
            val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            lp.topMargin = 10
            lp.bottomMargin = 10
            ll.addView(buttons[buttons.lastIndex], lp)
        }

//        buttons.add(Button(context))
//        buttons[buttons.lastIndex].text = createTitle(reader.lineSequence().first())
//        println(createTitle(reader.lineSequence().first()))
//        buttons[buttons.lastIndex].setBackgroundResource(resources.getIdentifier("round_buttons","drawable", "com.example.teluguapp"))
//        buttons[buttons.lastIndex].setOnClickListener {
//            val intent = Intent(activity, LessonActivity::class.java)
//            intent.action = reader.lineSequence().first()
//            startActivity(intent)
//        }
//        val ll = view?.findViewById(R.id.lessons_wrapper) as LinearLayout
//        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
//        lp.topMargin = 10
//        lp.bottomMargin = 10
//        ll.addView(buttons[buttons.lastIndex], lp)
    }

    fun createTitle(title: String): String{
        var rtn = title

        if(title.toCharArray()[title.lastIndex].isDigit()){
            rtn = title.substring(0,title.lastIndex) + " " + title.substring(title.lastIndex)
        }
        return rtn.capitalize()
    }
}
