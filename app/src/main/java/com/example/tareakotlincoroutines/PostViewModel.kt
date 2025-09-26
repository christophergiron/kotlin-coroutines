package com.example.tareakotlincoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    fun fetchPosts(onResult: (List<Post>) -> Unit) {
        viewModelScope.launch {
            try {
                val posts = RetrofitClient.api.getPosts()
                onResult(posts)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult(emptyList())
            }
        }
    }
}