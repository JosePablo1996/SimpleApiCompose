package com.example.simpleapicompose.data.remote

import com.example.simpleapicompose.data.model.Post
import retrofit2.http.GET

interface ApiService {
    // Se ha corregido la firma para esperar una lista de posts
    // ya que el endpoint /posts de jsonplaceholder.typicode.com retorna un array.
    @GET("posts")
    suspend fun getPostsBoris(): List<Post>
}