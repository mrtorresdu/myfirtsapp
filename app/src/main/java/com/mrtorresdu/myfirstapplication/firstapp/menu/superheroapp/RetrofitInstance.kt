package com.mrtorresdu.myfirstapplication.firstapp.menu.superheroapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val ACCESS_TOKEN = "54ae1c6301d8d58a0c8670318aa0131d"
    private const val BASE_URL = "https://superheroapi.com/api/$ACCESS_TOKEN/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:SuperHeroApiService by lazy {
        retrofit.create(SuperHeroApiService::class.java)
    }
}