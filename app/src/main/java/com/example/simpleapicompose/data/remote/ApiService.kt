package com.example.simpleapicompose.data.remote

import com.example.simpleapicompose.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPostsBoris(): List<Post>
}