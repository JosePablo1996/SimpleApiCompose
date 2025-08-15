package com.example.simpleapicompose.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Creamos una instancia de Moshi con el adaptador para Kotlin
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Configuramos Retrofit con la URL base y el convertidor de Moshi
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            // Pasamos la instancia de Moshi configurada
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }
}
