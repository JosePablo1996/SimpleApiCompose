package com.example.simpleapicompose.domain

import com.example.simpleapicompose.data.model.Post
import com.example.simpleapicompose.data.remote.RetrofitInstance

class PostRepository {
    suspend fun fetchPosts(): List<Post> = RetrofitInstance.api.getPostsBoris()
}