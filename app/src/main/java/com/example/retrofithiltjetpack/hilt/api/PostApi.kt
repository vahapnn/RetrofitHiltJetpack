package com.example.retrofithiltjetpack.hilt.api

import com.example.retrofithiltjetpack.hilt.model.Post
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts():List<Post>
}