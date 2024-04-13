package com.example.videogamebacklog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BacklogList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backlog_list)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}