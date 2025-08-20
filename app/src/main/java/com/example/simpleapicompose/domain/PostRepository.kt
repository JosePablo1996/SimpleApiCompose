package com.example.simpleapicompose.domain

import com.example.simpleapicompose.data.model.Post
import com.example.simpleapicompose.data.remote.RetrofitInstance

class PostRepository {
    // La firma de la función ya es correcta para devolver una lista.
    // El error que viste antes era causado por la firma del método en ApiService.kt
    // que fue corregida previamente.
    suspend fun fetchPosts(): List<Post> = RetrofitInstance.api.getPostsBoris()
}