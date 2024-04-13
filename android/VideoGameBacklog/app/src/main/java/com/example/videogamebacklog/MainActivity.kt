package com.example.videogamebacklog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openBacklog(view: View) {
        var intent = Intent(this, BacklogList::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Backlog")
        }
        startActivity(intent)
    }

    fun openSearch(view: View) {
        var intent = Intent(this, BacklogList::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Search")
        }
        startActivity(intent)
    }
}