package com.example.videogamebacklog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SearchGames : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_games)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = "HELLO"
        }
    }
}