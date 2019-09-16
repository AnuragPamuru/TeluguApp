package com.example.teluguapp

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout


class SearchFragment : Fragment() {

    lateinit var searchString : String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchButton = activity?.findViewById(R.id.search_button) as ImageButton
        searchButton.setOnClickListener{runSearchEngine()}
    }

    private fun runSearchEngine() {
        val editText = activity?.findViewById(R.id.searchBar) as EditText
        searchString = editText.text.toString()

        val searchResults = DatabaseHandler().searchResults(searchString)

        val buttons = mutableListOf<Button>()

        //use each line to set up words
        for(i in searchResults){

            buttons.add(Button(context))


            val ll = activity?.findViewById(R.id.search_results_wrapper) as LinearLayout
            val lp = LinearLayout.LayoutParams(300,300)
            lp.topMargin = 10
            lp.bottomMargin = 10
            ll.addView(buttons[buttons.size - 1], lp)
        }
    }
}
