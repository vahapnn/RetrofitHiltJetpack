package com.example.retrofithiltjetpack.hilt.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.retrofithiltjetpack.hilt.viewmodel.PostViewModel

@Composable
fun PostScreen(postViewModel: PostViewModel){
    val posts by postViewModel.posts.collectAsState()
    LazyColumn {
        items(posts){post->
            Text(text = post.title)
            Text(text = post.body)
        }
    }
}