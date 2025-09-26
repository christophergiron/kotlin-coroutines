package com.example.tareakotlincoroutines

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        setContentView(textView)

        viewModel.fetchPosts { posts ->
            runOnUiThread {
                textView.text = posts.take(5).joinToString("\n\n") {
                    "ID: ${it.id}\nTitle: ${it.title}"
                }
            }
        }
    }
}