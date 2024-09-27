package com.example.retrofithiltjetpack.hilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithiltjetpack.hilt.api.PostApi
import com.example.retrofithiltjetpack.hilt.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postApi: PostApi) :ViewModel() {
    private val _posts= MutableStateFlow<List<Post>>(emptyList())
    val posts:StateFlow<List<Post>> = _posts
    init {
        fetchPosts()
    }
    private fun fetchPosts(){
        viewModelScope.launch {
            try {
               _posts.value=postApi.getPosts()
            }catch (e:Exception){

            }
        }
    }
}