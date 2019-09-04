package com.example.teluguapp

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        val button = view.findViewById(R.id.alphabet1_lesson) as Button

        button.setOnClickListener{
            val intent = Intent(activity, LessonActivity::class.java)
            intent.action = "alphabet2"
            println(button.id.toString())
            startActivity(intent)
        }

        return view
    }
}
