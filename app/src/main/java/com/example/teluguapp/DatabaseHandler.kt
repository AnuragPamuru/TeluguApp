package com.example.teluguapp

class DatabaseHandler{
    fun searchResults(searchTerm : String):CharIterator{

        val rtn = searchTerm.toCharArray()

        return rtn.iterator()
    }
}